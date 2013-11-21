package com.mquick.server.terminal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jetty.websocket.WebSocket.Connection;

import com.mquick.shared.ClientEntity;

public class ClientEntityList {
	public static HashMap<ClientEntity, Connection> hlist = new HashMap<ClientEntity, Connection>();
	
	public static List<ClientEntity> getList() {
		return new ArrayList<ClientEntity>(hlist.keySet());
	}
	
	public static Connection findConnection(ClientEntity terminal) {
		// TODO: 这是一个笨办法。
		
		for(ClientEntity c:hlist.keySet() ) {
			// System.out.println("finding: " + c.getMaigcCode() + ":" + terminal.getMaigcCode());
			if( c.getMaigcCode() == terminal.getMaigcCode() )
				return hlist.get(c);
		}
		
		return null;
	}
}
