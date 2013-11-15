package com.mquick.client.websocket;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DashboardEvent extends GwtEvent<DashboardEvent.DashboardEventHandler> {

	public interface DashboardEventHandler extends EventHandler {
		public void onAlive();
		public void onDie();
	}

	public static Type<DashboardEventHandler> type = new Type<DashboardEventHandler>();
	
	private boolean alive;
	
	public DashboardEvent(boolean alive) {
		this.alive = alive;
	}
	
	@Override
	public Type<DashboardEventHandler> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(DashboardEventHandler handler) {
		if( alive)
			handler.onAlive();
		else
			handler.onDie();
	}
}
