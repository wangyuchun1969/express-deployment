package com.mquick.client.application.home;

import com.gwtplatform.mvp.client.UiHandlers;
import com.mquick.shared.ClientEntity;

public interface DashboardUiHandlers extends UiHandlers {
	public void beep();
	public void pushTerminal(int index, ClientEntity object, String value);
}
