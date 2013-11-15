package com.mquick.server.websocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class DashboardSocket extends WebSocketServlet {

	private static final long serialVersionUID = 2357893930106283048L;

	private Set<DashboardControlSocket> connectedDashboards = new CopyOnWriteArraySet<DashboardControlSocket>();
	
	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request,
			String protocol) {
		return new DashboardControlSocket();
	}

	private class DashboardControlSocket implements WebSocket.OnTextMessage {
		Connection connection;
		
		@Override
		public void onOpen(Connection connection) {
			connectedDashboards.add(this);
			this.connection = connection;
			for( DashboardControlSocket c:connectedDashboards) {
				try {
					c.connection.sendMessage("[Online:" + connectedDashboards.size() + "]");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void onClose(int closeCode, String message) {
			connectedDashboards.remove(this);
			for( DashboardControlSocket c:connectedDashboards) {
				try {
					c.connection.sendMessage("[Online:" + connectedDashboards.size() + "]");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
