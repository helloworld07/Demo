package com.demeboot.websocket;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.client.WebSocketClient;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("test")
public class DemoController {
    @GetMapping("index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("page")
    public ModelAndView page() {
        return new ModelAndView("websocket");
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message, toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }

    @RequestMapping("/link/{toUserId}")
    @SneakyThrows
    public void get(@PathVariable String toUserId,String message){
        URI uri = new URI("ws://localhost:8082/websocket/"+toUserId);
        MyWebSocketClient myClient = new MyWebSocketClient(uri);
        myClient.connect();
        Thread.sleep(5000);
        myClient.send(message);
        myClient.close();
    }
}
