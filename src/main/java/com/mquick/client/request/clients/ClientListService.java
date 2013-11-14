package com.mquick.client.request.clients;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.Service;
import com.mquick.server.terminal.ClientListImpl;
import com.mquick.shared.ClientEntity;

@Service(value = ClientListImpl.class)
public interface ClientListService extends RequestContext {
	public Request<List<ClientEntity>> list();
}
