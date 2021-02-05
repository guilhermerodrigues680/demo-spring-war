package com.example.demo;

//import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter @NoArgsConstructor
//@JsonRootName(value = "message")
public class Message {

    private String message;
    private List<Character> characterList;

    public Message(String message) {
        this.message = message;
        this.characterList = message.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

}
