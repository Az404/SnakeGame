package oop.snakegame;

import javafx.scene.input.KeyCode;

import java.util.HashMap;

class KeyboardPlayerController extends PlayerController {

    private HashMap<KeyCode, Direction> keyMap = new HashMap<>();

    KeyboardPlayerController(Player player) {
        super(player);
    }

    void handleKey(KeyCode key){
        if (keyMap.containsKey(key))
            setHeadDirection(keyMap.get(key));
    }

    void setKeyMap(HashMap<KeyCode, Direction> keyMap){
        this.keyMap = keyMap;
    }
}
