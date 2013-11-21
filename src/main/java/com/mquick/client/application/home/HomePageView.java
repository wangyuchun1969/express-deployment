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

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.mquick.shared.ClientEntity;

public class HomePageView extends ViewWithUiHandlers<DashboardUiHandlers> implements HomePagePresenter.MyView {
	public interface Binder extends UiBinder<Widget, HomePageView> {
	}

	@UiField(provided = true)
	CellTable<ClientEntity> expressportals;
	
	private final ListDataProvider<ClientEntity> dataProvider;
	
	@Inject
	public HomePageView(Binder uiBinder, ListDataProvider<ClientEntity> dataProvider) {
		this.dataProvider = dataProvider;
		expressportals = new CellTable<ClientEntity>();
		this.dataProvider.addDataDisplay(expressportals);
		initCellTable();
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
	
    private void initCellTable() {
        TextColumn<ClientEntity> id_Column = new TextColumn<ClientEntity>() {
            @Override
            public String getValue(ClientEntity object) {
            	if( object == null)
            		return " ";
                return object.getId()+"";
            }
        };
        expressportals.addColumn(id_Column, "ID");

        TextColumn<ClientEntity> name_Column = new TextColumn<ClientEntity>() {
            @Override
            public String getValue(ClientEntity object) {
            	if( object == null)
            		return " ";
                return object.getName();
            }
        };
        expressportals.addColumn(name_Column, "NAME");
    
        ButtonCell buttonCell = new ButtonCell();

        Column<ClientEntity, String> action_Column = new Column<ClientEntity, String>(buttonCell) {
          @Override
          public String getValue(ClientEntity object) {
            // The value to display in the button.
            return "unimpl"; //object.getName();
          }
        };
        
        action_Column.setFieldUpdater(new FieldUpdater<ClientEntity, String>(){

			@Override
			public void update(int index, ClientEntity object, String value) {
				Window.alert("You click me?");
			}});
        
        expressportals.addColumn(action_Column, "ACTION");        
        
    }

	@Override
	public void setClientsData(List<ClientEntity> data) {
        dataProvider.getList().clear();
        dataProvider.getList().addAll(data);
        dataProvider.refresh();
	}
}
