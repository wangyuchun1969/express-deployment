package com.mquick.server.websocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class DashboardSocket extends WebSocketServlet {

	private static final long serialVersionUID = 2357893930106283048L;

	private final static Set<DashboardControlSocket> connectedDashboards = new CopyOnWriteArraySet<DashboardControlSocket>();
	
	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request,
			String protocol) {
		return new DashboardControlSocket();
	}

	public void Boardcast(String message) {
		for( DashboardControlSocket c:connectedDashboards) {
			try {
				c.connection.sendMessage("DASHBOARD:"+message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void BoardcastAboutTerminal(String message) {
		for( DashboardControlSocket c:connectedDashboards) {
			try {
				c.connection.sendMessage("TERMINAL:"+message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private class DashboardControlSocket implements WebSocket.OnTextMessage {
		Connection connection;
		
		@Override
		public void onOpen(Connection connection) {
			connectedDashboards.add(this);
			this.connection = connection;
			Boardcast("[Online:" + connectedDashboards.size() + "]");
		}

		@Override
		public void onClose(int closeCode, String message) {
			connectedDashboards.remove(this);
			Boardcast("[Online:" + connectedDashboards.size() + "]");
		}
		
		@Override
		public void onMessage(String data) {
			// Echo
			try {
				connection.sendMessage(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
