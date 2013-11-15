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
		super("ws://" + Window.Location.getHost() + "/talk/dashboard");

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
				eventbus.fireEvent(new DashboardEvent(true));
			}

			@Override
			public void onOpen() {
				eventbus.fireEvent(new DashboardEvent(true));
			}
		});
		open();
	}

}
