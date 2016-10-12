package oop.snakegame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    private final static int tickTime = 500;
    private final static String levelFileName = "level.txt";
    private final static HashMap<KeyCode, Direction> arrowsKeyMap = new HashMap<KeyCode, Direction>() {
        {
            put(KeyCode.LEFT, Direction.Left);
            put(KeyCode.RIGHT, Direction.Right);
            put(KeyCode.UP, Direction.Up);
            put(KeyCode.DOWN, Direction.Down);
        }
    };

    private final static HashMap<KeyCode, Direction> adwsKeyMap = new HashMap<KeyCode, Direction>() {
        {
            put(KeyCode.A, Direction.Left);
            put(KeyCode.D, Direction.Right);
            put(KeyCode.W, Direction.Up);
            put(KeyCode.S, Direction.Down);
        }
    };

    private final static int playersCount = 2;

    private Game game;
    private GraphicsContext gc;
    private Timer timer = new Timer();
    private KeyboardPlayerController[] controllers;
    private Painter painter;

    @Override
    public void start(Stage primaryStage) throws Exception {
        game = new Game(playersCount);
        initControllers();
        game.loadLevel(LevelCreator.create(levelFileName));
        Field field = game.getLevel().field;
        setUpStage(primaryStage, field.width * Painter.cellSize, field.height * Painter.cellSize);
        scheduleGameTimer();
    }

    private void initControllers() {
        controllers = new KeyboardPlayerController[playersCount];
        for (int i = 0; i < playersCount; i++)
            controllers[i] = new KeyboardPlayerController(game.players[i]);
        controllers[0].setKeyMap(adwsKeyMap);
        controllers[1].setKeyMap(arrowsKeyMap);
    }

    private void setUpStage(Stage primaryStage, int width, int height) {
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();
        painter = new Painter(gc);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            for(KeyboardPlayerController controller: controllers)
                controller.handleKey(event.getCode());
        });
        primaryStage.setTitle("Змейка");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void scheduleGameTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                game.tick();
                Platform.runLater(() -> repaint());
                if (game.getState() == GameState.Finished)
                    timer.cancel();
            }
        }, 0, tickTime);
    }

    private void repaint() {
        Canvas canvas = gc.getCanvas();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (game.getState() == GameState.Finished) {
            gc.setFill(Color.RED);
            gc.setFont(Font.font(40));
            gc.fillText("Game Over", 0, canvas.getHeight() / 2);
            return;
        }

        for (Cell cell : game.getLevel()) {
            cell.visit(painter);
        }
    }
}
