package com.demo.organisation;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LifeCycleListener implements PhaseListener {

	private static final long serialVersionUID = -5846079219111475262L;

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	public void beforePhase(PhaseEvent event) {
		System.out.println("START PHASE " + event.getPhaseId());
		if (event.getPhaseId().equals(PhaseId.PROCESS_VALIDATIONS)
				&& FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
			System.out.println(
					"Processing ids :" + FacesContext.getCurrentInstance().getPartialViewContext().getExecuteIds());
			System.out.println(
					"Rendering  ids :" + FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds());
		}
	}

	public void afterPhase(PhaseEvent event) {
		System.out.println("END PHASE " + event.getPhaseId());
	}

}
