package com.demeboot.websocket;


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class MyWebSocketClient extends WebSocketClient {

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        short httpStatus = serverHandshake.getHttpStatus();
        String httpStatusMessage = serverHandshake.getHttpStatusMessage();
        System.out.println("httpStatus:" + httpStatus + "  httpStatusMessage:" + httpStatusMessage);
    }

    @Override
    public void onMessage(String s) {
        System.out.println("message is :" + s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("client close! status:" + b);
    }

    @Override
    public void onError(Exception e) {
        System.out.println("error:" + e.toString());
    }
}
