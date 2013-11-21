package com.mquick.shared;

import com.gwtplatform.dispatch.shared.UnsecuredActionImpl;

public class PushTerminalAction extends UnsecuredActionImpl<PushTermialResult> {

	public PushTerminalAction(ClientEntity object) {
		this.client = object;
	}
	
	public PushTerminalAction(){}
	
	public ClientEntity client;
}
