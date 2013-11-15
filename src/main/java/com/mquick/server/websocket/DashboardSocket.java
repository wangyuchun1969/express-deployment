package com.mquick.server.websocket;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class DashboardSocket extends WebSocketServlet {

	private static final long serialVersionUID = 2357893930106283048L;

	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request,
			String protocol) {
		return new DashboardControlSocket();
	}

	private class DashboardControlSocket implements WebSocket, WebSocket.Connection {

		@Override
		public void onOpen(Connection connection) {
		}

		@Override
		public void onClose(int closeCode, String message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getProtocol() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void sendMessage(String data) throws IOException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sendMessage(byte[] data, int offset, int length)
				throws IOException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void disconnect() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void close() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void close(int closeCode, String message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isOpen() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setMaxIdleTime(int ms) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setMaxTextMessageSize(int size) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setMaxBinaryMessageSize(int size) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getMaxIdleTime() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getMaxTextMessageSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getMaxBinaryMessageSize() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
