package com.mquick.server.terminal;

import java.io.IOException;

import org.eclipse.jetty.websocket.WebSocket.Connection;

import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import com.mquick.shared.PushTermialResult;
import com.mquick.shared.PushTerminalAction;

public class PushTerminalImpl implements
		ActionHandler<PushTerminalAction, PushTermialResult> {

	@Override
	public PushTermialResult execute(PushTerminalAction arg0,
			ExecutionContext arg1) throws ActionException {

		if (arg0 == null)
			System.out.println("null value of arg?");

		else {
			// TODO: find connection and push message to it!
			Connection connection = ClientEntityList
					.findConnection(arg0.client);

			if (connection != null) {
				try {
					connection.sendMessage("Please connection to me!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else
				System.out.println("We get connection failed");
		}
		return new PushTermialResult("Yes!");
	}

	@Override
	public Class<PushTerminalAction> getActionType() {
		return PushTerminalAction.class;
	}

	@Override
	public void undo(PushTerminalAction arg0, PushTermialResult arg1,
			ExecutionContext arg2) throws ActionException {
		// no undo
	}

}
