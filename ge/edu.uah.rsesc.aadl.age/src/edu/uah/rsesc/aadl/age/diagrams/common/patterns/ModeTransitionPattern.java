/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.diagrams.common.patterns;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.internal.datatypes.impl.LocationImpl;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.PrecisionPoint;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.algorithms.styles.StylesFactory;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.CurvedConnection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.ILayoutService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.graphiti.ui.internal.services.IGefService;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.TriggerPort;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.dialogs.ElementSelectionDialog;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.AnchorService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ConnectionService;
import edu.uah.rsesc.aadl.age.services.DiagramModificationService;
import edu.uah.rsesc.aadl.age.services.NamingService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.StyleService;
import edu.uah.rsesc.aadl.age.services.UserInputService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;

public class ModeTransitionPattern extends AgeConnectionPattern {
	private final StyleService styleService;
	private final AnchorService anchorService;
	private final NamingService namingService;
	private final ConnectionService connectionService;
	private final ShapeService shapeService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final UserInputService userInputService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public ModeTransitionPattern(final VisibilityService visibilityHelper, final StyleService styleUtil, final AnchorService anchorUtil, final NamingService namingService,
			final ConnectionService connectionHelper, final ShapeService shapeHelper, AadlModificationService aadlModService, final DiagramModificationService diagramModService,
			final UserInputService userInputService, final BusinessObjectResolutionService bor) {
		super(visibilityHelper);
		this.styleService = styleUtil;
		this.anchorService = anchorUtil;
		this.namingService = namingService;
		this.connectionService = connectionHelper;
		this.shapeService = shapeHelper;
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.userInputService = userInputService;
		this.bor = bor;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof ModeTransition;
	}

	/**
	 * Overridden to create a curved connection for the mode transition
	 */
	@Override
	protected Connection createConnection(final Diagram diagram) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		return peCreateService.createCurvedConnection(new double[] {0.0, 0.0}, getDiagram());
	}	

	public static void updateControlPoints(final Connection connection) {
		if(connection instanceof CurvedConnection) {
			final CurvedConnection cc = (CurvedConnection)connection;
			final ILayoutService layoutService = Graphiti.getLayoutService();			

			// Decide a sign for the control point
			final ILocation startLocation = layoutService.getLocationRelativeToDiagram(connection.getStart());
			final ILocation endLocation = layoutService.getLocationRelativeToDiagram(connection.getEnd());
			final int sign = (startLocation.getX() - endLocation.getX()) > 0 ? -1 : 1; 
			
			final int magnitude = 30;

			// Determine a reasonable control point
			int y = sign * magnitude;
			boolean unique = false;
			while(!unique) {
				unique = true;
				for(final Connection tempConnection : connection.getParent().getConnections()) {
					if(tempConnection != connection) {
						if(tempConnection instanceof CurvedConnection) {
							final CurvedConnection tempCC = (CurvedConnection)tempConnection;
							if(connection.getStart() == tempCC.getStart() && connection.getEnd() == tempCC.getEnd()) {
								if(tempCC.getControlPoints().get(0).getY() == y) {
									unique = false;
									y += sign * magnitude;
									break;
								}
							}
						}
					}
				}
			}
			
			// Set the control point
			cc.getControlPoints().clear();
			final PrecisionPoint pp = StylesFactory.eINSTANCE.createPrecisionPoint();
			pp.setX(1.0);
			pp.setY(y);
			cc.getControlPoints().add(pp);
		}
	}
	
	@Override
	protected void createDecorators(final Connection connection) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Before removing all the decorators, get position of the label(if one exists)
		int labelX = 0;
		int labelY = 0;
		for(final ConnectionDecorator d : connection.getConnectionDecorators()) {
			if(d.getGraphicsAlgorithm() instanceof Text) {
				final Text text = (Text)d.getGraphicsAlgorithm();
				labelX = text.getX();
				labelY = text.getY();
			}
		}
		
		connection.getConnectionDecorators().clear();
		
		// Create the arrow
        final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(connection, false, 1.0, true);    
        createArrow(arrowConnectionDecorator, styleService.getDecoratorStyle());
        
		// Create Label
        final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(connection);
        final IGaService gaService = Graphiti.getGaService();
		final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);
		final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
		text.setStyle(styleService.getLabelStyle());
 		gaService.setLocation(text, labelX, labelY);
	    text.setValue(mt.getName());
	    getFeatureProvider().link(textDecorator, new AadlElementWrapper(mt));
	}
	
	@Override
	protected void createGraphicsAlgorithm(final Connection connection) {
		updateControlPoints(connection);
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = styleService.getDecoratorStyle();
		polyline.setStyle(style);
	}
	
	private void createTriggerGraphicsAlgorithm(final Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = styleService.getModeTransitionTrigger();
		polyline.setStyle(style);
	}
	
	private GraphicsAlgorithm createArrow(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] {
	    		-6, 4, 
	    		2, 0, 
	    		-6, -4});
	    ga.setStyle(style);
	    return ga;
	}	
	
	private static ContainerShape getModeContainer(final Connection connection) {
		return getStartModeShape(connection).getContainer();
	}

	// CLEAN-UP: Dependent on behavior of ModePattern to determine how many levels to go up
	private static ContainerShape getStartModeShape(final Connection connection) {
		return ((Shape)connection.getStart().getParent()).getContainer();
	}
	
	// Assume freeform and no bendpoints
	private static ILocation getConnectionMidpoint(final Connection connection, final double d) {
		final ILayoutService layoutService = Graphiti.getLayoutService();
		
		final IGefService gefService = GraphitiUiInternal.getGefService();
		// Should be end point?
		final Shape startShape = (Shape)connection.getStart().getParent();
		final Shape endShape = (Shape)connection.getEnd().getParent();
		final ILocation startShapeLocation = layoutService.getLocationRelativeToDiagram(startShape);
		final ILocation endShapeLocation = layoutService.getLocationRelativeToDiagram(endShape);
		
		final GraphicsAlgorithm startShapeGa = startShape.getGraphicsAlgorithm();
		final GraphicsAlgorithm endShapeGa = endShape.getGraphicsAlgorithm();
		
		final Rectangle startShapeRect = new Rectangle(startShapeLocation.getX(), startShapeLocation.getY(), startShapeGa.getWidth(), startShapeGa.getHeight());
		final Rectangle endShapeRect = new Rectangle(endShapeLocation.getX(), endShapeLocation.getY(), endShapeGa.getWidth(), endShapeGa.getHeight());
		
		// TODO: Look for layout helpers
		if(connection instanceof CurvedConnection) {			
			final Point startPoint = gefService.getChopboxLocationOnBox(new Point(endShapeLocation.getX(), endShapeLocation.getY()), startShapeRect);
			final Point endPoint = gefService.getChopboxLocationOnBox(new Point(startShapeLocation.getX(), startShapeLocation.getY()), endShapeRect);
			
			// Code example: y is handled differently than x....
			final Point endPointRel = new Point(endPoint.x-startPoint.x, endPoint.y-startPoint.y);			
			
			final CurvedConnection cc = (CurvedConnection)connection;
			
			// Calculate the transformed control point
			// Algorithm copied from org.eclipse.graphiti.ui.internal.parts.CurvedConnectionEditPart.BezierRouter to duplicate control point transformation
			double gradient = endPointRel.y / -endPointRel.x;
			double ortho_gradient = -Math.pow(gradient, -1);
			double orthovector_x = 1;
			double orthovector_y = ortho_gradient;
			double factor_to_length = 1 / Math.sqrt((Math.pow(orthovector_y, 2) + Math.pow(orthovector_x, 2)));
			final PrecisionPoint cp = cc.getControlPoints().get(0);			
			double orthovector_x_cp = factor_to_length * orthovector_x * cp.getY();
			double orthovector_y_cp = factor_to_length * orthovector_y * cp.getY();
			if (Double.isNaN(orthovector_x_cp)) {
				orthovector_x_cp = 0;
			}
			if (Double.isNaN(orthovector_y_cp)) {
				orthovector_y_cp = 1 * cp.getY();
			}

			final double cpX = startPoint.x + (endPointRel.x * cp.getX() - orthovector_x_cp);
			final double cpY = startPoint.y + ((endPointRel.y * cp.getX()) + orthovector_y_cp);
			
			// Calculate the midpoint
			final double ax = (startPoint.x + cpX) / 2;
			final double ay = (startPoint.y + cpY) / 2;
			final double bx = (cpX + endPoint.x) / 2;
			final double by = (cpY + endPoint.y) / 2;
			final double mx = (ax + bx)/2;
			final double my = (ay + by)/2;		      
			final int x = (int)mx;
			final int y = (int)my;
						
			return new LocationImpl(x, y);			
		}
		
		final ILocation startLoc = layoutService.getLocationRelativeToDiagram(connection.getStart());
		final ILocation endLoc = layoutService.getLocationRelativeToDiagram(connection.getEnd());
		
		// TODO: Replace with something that works in all cases. The layout service works for freestyle but has an offset(of 25) for some reason
		// Need a method that will work with CurvedConnections
		return new LocationImpl((int)(startLoc.getX() + (endLoc.getX() - startLoc.getX()) * d), (int)(startLoc.getY() + (endLoc.getY() - startLoc.getY()) * d));
	}
	
	// CLEAN-UP: Should be private and not static. Develop another way for ModePattern to trigger updating of the anchors without causing issues
	static void updateAnchors(final Connection connection, final ModeTransition mt, final AnchorService anchorUtil) {
		final ILayoutService layoutService = Graphiti.getLayoutService();
		final ContainerShape modeShape = getStartModeShape(connection);
		final ILocation modeLocation = layoutService.getLocationRelativeToDiagram(modeShape);
		final ILocation l = getConnectionMidpoint(connection, 0.5);
		anchorUtil.createOrUpdateFixPointAnchor(modeShape, getTransitionAnchorName(mt), l.getX() - modeLocation.getX(), l.getY() - modeLocation.getY());
	}
	
	private void updateTriggers(final Connection connection, final ModeTransition mt) {	
		updateAnchors(connection, mt, anchorService);

		final ContainerShape modeShape = getStartModeShape(connection);
		final Anchor anchor = anchorService.getAnchorByName(modeShape, getTransitionAnchorName(mt));
		for(final ModeTransitionTrigger trigger : mt.getOwnedTriggers()) {
			final ContainerShape modeTransitionContainer = getModeContainer(connection);	
			// TODO: Use same anchor for all triggers for hte transition...
			final Anchor eventSourceAnchor = getAnchorForModeTransitionTrigger(trigger, modeTransitionContainer, modeShape, getFeatureProvider());
			
			if(eventSourceAnchor != null) {
				final IPeCreateService peCreateService = Graphiti.getPeCreateService();
				final Connection triggerConnection = peCreateService.createFreeFormConnection(getDiagram());
				triggerConnection.setStart(eventSourceAnchor);
				triggerConnection.setEnd(anchor);
				createTriggerGraphicsAlgorithm(triggerConnection);
			}
		}
	}
	
	/**
	 * Builds a unique name for the anchor that will be used for the end of the trigger connection that connects it to the transition connection.
	 * @param trigger
	 * @return
	 */
	private static String getTransitionAnchorName(final ModeTransition mt) {
		return mt.getName();
	}

	@Override
	protected Anchor[] getAnchors(final Connection connection) {
		final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(connection);
		final ContainerShape ownerShape = connectionService.getOwnerShape(connection);
		return (ownerShape == null) ? null : connectionService.getAnchors(ownerShape, mt);		
	}
	
	@Override
	protected void onAfterRefresh(final Connection connection) {
		final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(connection);
		updateTriggers(connection, mt);
	}
	
	/**
	 * Returns the anchor for the feature references by a mode transition trigger
	 * @param trigger
	 * @param ownerShape the shape corresponding to the owner of the mode and mode transition. Should be a representation of Component Classifier.
	 * @param fp
	 * @return
	 */
	public Anchor getAnchorForModeTransitionTrigger(final ModeTransitionTrigger trigger, final ContainerShape ownerShape, final ContainerShape modeShape, final IFeatureProvider fp) {
		if(trigger instanceof TriggerPort) {
			final TriggerPort tp = (TriggerPort)trigger;
			final ContainerShape portShapeOwner = tp.getContext() == null ? ownerShape : (ContainerShape)shapeService.getChildShapeByElementQualifiedName(ownerShape, tp.getContext());
			final ContainerShape portShape = (portShapeOwner == null || tp.getPort() == null) ? null : (ContainerShape)shapeService.getChildShapeByElementQualifiedName(portShapeOwner, tp.getPort());
			if(portShape == null) {
				return null;
			}
			
			// Get appropriate anchor depending on whether the port belongs to the component classifier or a subcomponent
			return anchorService.getAnchorByName(portShape, shapeService.doesShapeContain(portShape.getContainer(), modeShape) ? FeaturePattern.innerConnectorAnchorName : FeaturePattern.outerConnectorAnchorName);
		} else {
			// Unhandled case
			return null;
		}
	}
	
	@Override
	public String getCreateName() {
		return "Mode Transition";
	}
	
	@Override
	public boolean canStartConnection(final ICreateConnectionContext context) {
		if(!(context.getSourcePictogramElement() instanceof Shape)) {
			return false;
		}
		final Shape shape = (Shape)context.getSourcePictogramElement();
		return getMode(shape) != null && getComponentClassifier(shape) != null;
    }
	
	private ComponentClassifier getComponentClassifier(final Shape modeShape) {
		return shapeService.getClosestBusinessObjectOfType(modeShape, ComponentClassifier.class);
	}

	private Mode getMode(final PictogramElement pe) {
		if(pe == null) {
			return null;
		}
		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		if(bo instanceof Mode) {
			return (Mode)bo;
		}
		
		return null;
	}
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context) {
		return getMode(context.getTargetPictogramElement()) != null;
	}
	
	@Override
	public Connection create(final ICreateConnectionContext context) {
		// Get the Component Implementation
		final ComponentClassifier cc = getComponentClassifier((Shape)context.getSourcePictogramElement());
		
		// Determine the name for the new mode transition
		final String newElementName = namingService.buildUniqueIdentifier(cc, "newTransition");
		
		// TODO: Only include ports?
		// TODO: Include all relevant ports, subcomponent, feature group, or subprogram call
		final List<Port> ports = new ArrayList<Port>();
		for(final Feature f : cc.getAllFeatures()) {
			if(f instanceof Port) {
				ports.add((Port)f);
			}
		}
		final ElementSelectionDialog triggerSelectionDlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select Trigger Ports", "Select mode transition triggers", ports);
		triggerSelectionDlg.setMultipleSelection(true);
		if(triggerSelectionDlg.open() == Dialog.CANCEL) {
			return null;
		}
		

		final NamedElement[] triggerPorts = triggerSelectionDlg.getSelectedNamedElements();
		if(triggerPorts.length == 0) {
			return null;
		}
		
		// Make the modification
		aadlModService.modify(cc, new AbstractModifier<ComponentClassifier, ModeTransition>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public ModeTransition modify(final Resource resource, final ComponentClassifier cc) {
				final ModeTransition newModeTransition = cc.createOwnedModeTransition();
				
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			if(cc instanceof ComponentImplementation) {
	 				diagramMod.markDiagramsOfDerivativeComponentImplementationsAsDirty((ComponentImplementation)cc);
	 			}
			
				// Set the name
	 			newModeTransition.setName(newElementName);
	 			
	 			// Set the source and destination
	 			newModeTransition.setSource(getMode(context.getSourcePictogramElement()));
	 			newModeTransition.setDestination(getMode(context.getTargetPictogramElement()));
	 			
	 			final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
	 			for(NamedElement triggerPort : triggerPorts) {
	 				final TriggerPort newTrigger = (TriggerPort)newModeTransition.createOwnedTrigger(p.getTriggerPort());
	 				newTrigger.setPort((Port)triggerPort);
	 				// TODO: Set context as appropriate
	 			}

				return newModeTransition;
			}
			
			@Override
			public void beforeCommit(final Resource resource, final ComponentClassifier cc, final ModeTransition newModeTransition) {
				diagramMod.commit();
			}
		});

		return null;
	}
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(!(bo instanceof ModeTransition)) {
			return false;
		}
		
		final ModeTransition mt = (ModeTransition)bo;
		final Connection connection = (Connection)context.getPictogramElement();
		if(connection.getStart() == null) {
			return false; 
		}
		
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return false;
		}
		
		final ComponentClassifier cc = getComponentClassifier((Shape)startContainer);
		return mt.getContainingClassifier() == cc;
	}
	
	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}

		// Make the modification
		final Connection connection = (Connection)context.getPictogramElement();
		final ModeTransition mt = (ModeTransition)bor.getBusinessObjectForPictogramElement(connection);
		aadlModService.modify(mt, new AbstractModifier<ModeTransition, Object>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Object modify(final Resource resource, final ModeTransition mt) {
				// Start the diagram modification
	 			diagramMod = diagramModService.startModification();	 			
	 			
	 			final AnchorContainer startContainer = connection.getStart().getParent();
	 			if(startContainer instanceof Shape) {
	 				final ComponentClassifier cc = getComponentClassifier((Shape)startContainer);
	 				if(cc instanceof ComponentImplementation) {
	 					diagramMod.markDiagramsOfDerivativeComponentImplementationsAsDirty((ComponentImplementation)cc);
	 				}
	 			}	 			
	 			
	 			EcoreUtil.remove(mt);
				
				return null;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final ModeTransition mt, final Object modificationResult) {
				diagramMod.commit();
			}

		});	
		
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}
}
