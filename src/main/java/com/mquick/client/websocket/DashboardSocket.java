package com.mquick.client.websocket;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.sksamuel.gwt.websockets.Websocket;
import com.sksamuel.gwt.websockets.WebsocketListener;

public class DashboardSocket extends Websocket {
	
	EventBus eventbus;
	
	@Inject
	public DashboardSocket(EventBus eventBus) {
		super("ws://" + Window.Location.getHost() + Window.Location.getPath() + "talk/dashboard");

		this.eventbus = eventBus;

		addListener(new WebsocketListener() {

			@Override
			public void onClose() {
				eventbus.fireEvent(new DashboardEvent(false));
				// keep it online
				open();
			}

			@Override
			public void onMessage(String msg) {
				if( msg.startsWith("DASHBOARD:"))
					eventbus.fireEvent(new DashboardEvent(msg.substring(10)));
				else if( msg.startsWith("TERMINAL:"))
					eventbus.fireEvent(new TerminalEvent(msg.substring(9)));
			}

			@Override
			public void onOpen() {
				eventbus.fireEvent(new DashboardEvent(true));
			}
		});
		open();
	}

}
