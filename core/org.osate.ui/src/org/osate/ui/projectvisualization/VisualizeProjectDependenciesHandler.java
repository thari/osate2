package org.osate.ui.projectvisualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.ui.OsateUiPlugin;

public class VisualizeProjectDependenciesHandler extends AbstractHandler {
	/*
	 * Handler is only enabled when the selection is one IWorkingSet or one IProject.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			DependencyVisualizationView view = (DependencyVisualizationView) HandlerUtil.getActiveWorkbenchWindow(event)
					.getActivePage().showView(DependencyVisualizationView.ID);
			Object selection = HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
			if (selection instanceof IWorkingSet) {
				view.setProjectScope((IWorkingSet) selection);
			} else {
				view.setProjectScope((IProject) selection);
			}
		} catch (PartInitException e) {
			Status status = new Status(e.getStatus().getSeverity(), OsateUiPlugin.PLUGIN_ID, e.getLocalizedMessage(),
					e);
			StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
		}
		return null;
	}
}