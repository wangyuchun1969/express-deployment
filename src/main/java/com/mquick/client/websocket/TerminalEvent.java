package com.mquick.client.websocket;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class TerminalEvent extends GwtEvent<TerminalEvent.TerminalEventHandler> {

	public interface TerminalEventHandler extends EventHandler {
		public void onMessage(String message);
	}

	public static Type<TerminalEventHandler> type = new Type<TerminalEventHandler>();
	
	private String message;
	
	public TerminalEvent(String message) {
		this.message = message;
	}
	
	@Override
	public Type<TerminalEventHandler> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(TerminalEventHandler handler) {
		handler.onMessage(message);
	}
}
