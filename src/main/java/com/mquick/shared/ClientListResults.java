package com.mquick.shared;

import java.util.List;

import com.gwtplatform.dispatch.shared.MultipleResult;

public class ClientListResults extends MultipleResult<ClientEntity> {

	private static final long serialVersionUID = 7619217490755495617L;
	
	// NOTE: do not remove this, it is used to serialize
	protected ClientListResults() {}
	
	public ClientListResults(List<ClientEntity> clients) {
		super(clients);
	}
}
