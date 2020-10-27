package org.osate.ge.ba.handlers;

import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.Classifier;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.DiagramCreationUtil;
import org.osate.ge.ba.diagram.diagramType.BehaviorAnnexDiagramType;
import org.osate.ge.ba.util.BehaviorAnnexSelectionUtil;

public class OpenBehaviorAnnexDiagramHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		final BehaviorAnnex diagramContext = BehaviorAnnexHandlerUtil
				.getBehaviorAnnexDiagramContext(activeEditor)
				.orElseThrow(() -> new RuntimeException("diagramContext cannot be null"));
		final Classifier classifier = Objects.requireNonNull(diagramContext.getContainingClassifier(),
				"Classifier cannot be null");
		final String fileName = BehaviorAnnexHandlerUtil.getFilename(classifier);
		DiagramCreationUtil.openOrCreateDiagram(diagramContext, true, false, new BehaviorAnnexDiagramType(),
				fileName);
		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(BehaviorAnnexHandlerUtil
				.getBehaviorAnnexDiagramContext(BehaviorAnnexSelectionUtil.getActiveEditorFromContext(evaluationContext)).isPresent());
	}
}
