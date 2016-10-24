package oop.snakegame;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

class KeyboardPlayerController extends PlayerController implements EventHandler<KeyEvent> {

    private HashMap<KeyCode, PlayerAction> keyMap = new HashMap<>();

    KeyboardPlayerController(Player player) {
        super(player);
    }

    void setKeyMap(HashMap<KeyCode, PlayerAction> keyMap){
        this.keyMap = keyMap;
    }

    @Override
    public void handle(KeyEvent event) {
        KeyCode key = event.getCode();
        if (keyMap.containsKey(key))
            keyMap.get(key).action(this);
    }
}
