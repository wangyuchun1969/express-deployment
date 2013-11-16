/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.mquick.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.mquick.client.application.ApplicationPresenter;
import com.mquick.client.place.NameTokens;
import com.mquick.client.websocket.DashboardEvent;
import com.mquick.client.websocket.DashboardSocket;
import com.mquick.client.websocket.TerminalEvent;

public class HomePagePresenter extends
		Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy>
		implements DashboardUiHandlers {
	public interface MyView extends View, HasUiHandlers<DashboardUiHandlers> {
		public void onAlive();
		public void onDie();
		public void onMessage(String message);
		
		public void ShowTerminalCount(String message);
	}

	@ProxyStandard
	@NameToken(NameTokens.home)
	public interface MyProxy extends ProxyPlace<HomePagePresenter> {
	}

	@Inject
	public HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy,
			DashboardSocket socket) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
		getView().setUiHandlers(this);
		this.socket = socket;
		eventBus.addHandler(DashboardEvent.type,
				new DashboardEvent.DashboardEventHandler() {

					@Override
					public void onAlive() {
						getView().onAlive();
					}

					@Override
					public void onDie() {
						getView().onDie();
					}

					@Override
					public void onMessage(String message) {
						getView().onMessage(message);
					}
				});
		
		eventBus.addHandler(TerminalEvent.type, new TerminalEvent.TerminalEventHandler() {
			
			@Override
			public void onMessage(String message) {
				getView().ShowTerminalCount(message);
				// TODO:
				// We should poll more detail from service about terminal.
			}
			
		});
	}

	private DashboardSocket socket;

	@Override
	public void beep() {
		socket.send("click me");
	}
}
