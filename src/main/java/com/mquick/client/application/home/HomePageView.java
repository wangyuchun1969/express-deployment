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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class HomePageView extends ViewWithUiHandlers<DashboardUiHandlers> implements HomePagePresenter.MyView {
	public interface Binder extends UiBinder<Widget, HomePageView> {
	}

	@Inject
	public HomePageView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	HTMLPanel pingpong;

	@Override
	public void onAlive() {
		pingpong.getElement().getStyle().setColor("red");
	}

	@UiHandler("beep")
	public void onBeepPress(ClickEvent event) {
		getUiHandlers().beep();
	}

	@Override
	public void onDie() {
		pingpong.getElement().getStyle().setColor("blue");
	}

	@Override
	public void onMessage(String message) {
		pingpong.getElement().setInnerHTML(message);
	}

	// Show total count of terminal alive.
	@UiField
	HTMLPanel terminal;

	@Override
	public void ShowTerminalCount(String message) {
		terminal.getElement().setInnerHTML(message);
	}
}
