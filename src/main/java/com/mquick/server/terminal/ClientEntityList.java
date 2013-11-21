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
	
	public static Connection findConnection(ClientEntity terminal) {
		// TODO: 这是一个笨办法。
		for(Connection c:hlist.keySet()) {
			if( hlist.get(c).getMaigcCode() == terminal.getMaigcCode() )
			return c;
		}
		
/*		
		for(ClientEntity c:hlist.keySet() ) {
			// System.out.println("finding: " + c.getMaigcCode() + ":" + terminal.getMaigcCode());
			if( c.getMaigcCode() == terminal.getMaigcCode() )
				return hlist.get(c);
		}
*/		
		return null;
	}
}
