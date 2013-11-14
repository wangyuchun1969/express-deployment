package com.mquick.client.gin;

import javax.inject.Inject;

import com.google.gwt.user.client.Window;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.sksamuel.gwt.websockets.Websocket;
import com.sksamuel.gwt.websockets.WebsocketListener;


public class BootstrapperImpl implements Bootstrapper {

	private Websocket socket = new Websocket("ws://" + Window.Location.getHost() + "/talk/tome");
	
	private final PlaceManager placeManager;
	
    @Inject
	public BootstrapperImpl(PlaceManager placeManager) {
    	this.placeManager = placeManager;
	}

    @Override
    public void onBootstrap() {
    	socket.addListener(new WebsocketListener() {

    	    @Override
    	    public void onClose() {
    	        // do something on close
    	    }

    	    @Override
    	    public void onMessage(String msg) {
    	        Window.alert("Server say:" + msg);
    	    }

    	    @Override
    	    public void onOpen() {
    	        socket.send("hello!");
    	    }
    	});    	
    	socket.open();
    	
    	placeManager.revealCurrentPlace();
    }
	
}
