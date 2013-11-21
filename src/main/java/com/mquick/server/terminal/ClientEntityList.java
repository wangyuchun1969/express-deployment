package com.mquick.server.terminal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jetty.websocket.WebSocket.Connection;

import com.mquick.shared.ClientEntity;

public class ClientEntityList {
	public static HashMap<Connection, ClientEntity> hlist = new HashMap<Connection, ClientEntity>();
	
	public static List<ClientEntity> getList() {
		return new ArrayList<ClientEntity>(hlist.values());
	}
}
