package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class RootController {

    @GetMapping("/")
    public String handler() {
        return "Spring ok!";
    }

    @GetMapping("/message")
    public ResponseEntity<Message> handlerMessage(
            @RequestParam(defaultValue = "Olá!", required = false) String msg
    ) {
        return ResponseEntity.ok(new Message(msg));
    }

    @GetMapping("/message2")
    public ResponseEntity<Map<String, Message>> handlerMessage2(
            @RequestParam(defaultValue = "Olá!", required = false) String msg
    ) {
        return ResponseEntity.ok(Collections.singletonMap("data", new Message(msg)));
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, List<String>>> handleList() {
        List<String> stringList = IntStream.range(0, 10)
                .mapToObj(i -> "Number " + i)
                .collect(Collectors.toList());
        return ResponseEntity.ok(Collections.singletonMap("list", stringList));
    }

}
