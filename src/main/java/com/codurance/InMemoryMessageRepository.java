package com.codurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryMessageRepository {
    private final Map<String, List<String>> messagesByUsername = new HashMap<>();

    public boolean isEmpty() {
        return messagesByUsername.isEmpty();
    }

    public void postMessageByUsername(String username, String message) {
        List<String> messagesByUsername = getMessagesByUsername(username);

        if (messagesByUsername == null) {
            messagesByUsername = new ArrayList<>();
        }

        messagesByUsername.add(message);
        this.messagesByUsername.put(username, messagesByUsername);
    }

    public List<String> getMessagesByUsername(String username) {
        return messagesByUsername.get(username);
    }
}
