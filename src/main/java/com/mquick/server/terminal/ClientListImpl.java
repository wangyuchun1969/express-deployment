package com.mquick.server.terminal;

import java.util.List;
import java.util.Vector;

import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import com.mquick.shared.ClientEntity;
import com.mquick.shared.ClientListAction;
import com.mquick.shared.ClientListResults;

public class ClientListImpl implements ActionHandler<ClientListAction, ClientListResults> {
	
	@Override
	public ClientListResults execute(ClientListAction arg0,
			ExecutionContext arg1) throws ActionException {
		System.out.println("service load clients");
	
		List<ClientEntity> clients = new Vector<ClientEntity>();
		
		ClientEntity c = new ClientEntity();
		c.setId(0);
		c.setName("hello");
		
		clients.add(c);
		ClientListResults r = new ClientListResults(clients);
		return r;
	}

	@Override
	public Class<ClientListAction> getActionType() {
		return ClientListAction.class;
	}

	@Override
	public void undo(ClientListAction arg0, ClientListResults arg1,
			ExecutionContext arg2) throws ActionException {
		// no undo
	}

}
