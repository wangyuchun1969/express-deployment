package com.mquick.server.websocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class PingPongSocket extends WebSocketServlet {
	private static final long serialVersionUID = 1L;
	private final Set<PingWebSocket> connectedClients = new CopyOnWriteArraySet<PingWebSocket>();

	/**
	 * Doing the upgrade of the http request
	 */
	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request,
			String protocol) {
		return new PingWebSocket();
	}

	/**
	 * Here happens the _real_ communication, outside of vanilla HTTP...
	 */
	private class PingWebSocket implements WebSocket, WebSocket.OnTextMessage {
		private Connection connection;
		
		@Override
		public void onMessage(String data) {
			// ping it back...
			try {
				connection.sendMessage("You said: " + data);
				DashboardSocket.BoardcastAboutTerminal("terminal show:" + data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onClose(int arg0, String arg1) {
			connectedClients.remove(this);
			DashboardSocket.BoardcastAboutTerminal("terminal leave");
		}

		@Override
		public void onOpen(Connection connection) {
			this.connection = connection;
			DashboardSocket.BoardcastAboutTerminal("terminal in:" + connectedClients.size());
			try {
				connection.sendMessage("Hello");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}