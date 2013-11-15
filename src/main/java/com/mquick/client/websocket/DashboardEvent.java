package com.mquick.client.websocket;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DashboardEvent extends GwtEvent<DashboardEvent.DashboardEventHandler> {

	public interface DashboardEventHandler extends EventHandler {
		public void onAlive();
		public void onDie();
		public void onMesage(String message);
	}

	public static Type<DashboardEventHandler> type = new Type<DashboardEventHandler>();
	
	private boolean alive;
	private String message;
	
	public DashboardEvent(boolean alive) {
		this.alive = alive;
		message = null;
	}
	
	public DashboardEvent(String message) {
		this.alive = true;
		this.message = message;
	}
	
	@Override
	public Type<DashboardEventHandler> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(DashboardEventHandler handler) {
		if( message != null )
			handler.onMesage(message);
		else if( alive)
			handler.onAlive();
		else
			handler.onDie();
	}
}
