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
    private final static int cellSize = 15;
    private final static HashMap<KeyCode, Direction> keyMap = new HashMap<KeyCode, Direction>(){{
        put(KeyCode.LEFT, Direction.Left);
        put(KeyCode.RIGHT, Direction.Right);
        put(KeyCode.UP, Direction.Up);
        put(KeyCode.DOWN, Direction.Down);
    }};

    private Game game;
    private GraphicsContext gc;
    private Timer timer = new Timer();

    @Override
    public void start(Stage primaryStage) throws Exception{
        game = new Game();
        game.loadLevel(LevelCreator.create(levelFileName));

        Field field = game.getLevel().getField();
        setUpStage(primaryStage, field.getWidth()*cellSize, field.getHeight() * cellSize);

        scheduleGameTimer();
    }

    private void setUpStage(Stage primaryStage, int width, int height){
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            if (keyMap.containsKey(event.getCode())){
                game.setSnakeDirection(keyMap.get(event.getCode()));
            }
        });
        primaryStage.setTitle("Змейка");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void scheduleGameTimer(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                game.tick();
                Platform.runLater(() -> repaint());
                if (game.getState() == GameState.Loss)
                    timer.cancel();
            }
        }, 0, tickTime);
    }

    private void repaint(){
        Canvas canvas = gc.getCanvas();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (game.getState() == GameState.Loss){
            gc.setFill(Color.RED);
            gc.setFont(Font.font(40));
            gc.fillText("Game Over", 0, canvas.getHeight() / 2);
            return;
        }

        Level level = game.getLevel();

        for (SnakeBlock block: level.getSnake()) {
            fillCell(block.getLocation().getX(), block.getLocation().getY(), Color.BLUE);
        }

        Field field = level.getField();
        for (int x = 0; x < field.getWidth(); x++)
            for(int y = 0; y < field.getHeight(); y++){
                if (field.getCell(x, y) == CellType.Wall)
                    fillCell(x, y, Color.GRAY);
            }

        for(Bonus bonus: level.getBonuses()){
            fillCell(bonus.getLocation().getX(), bonus.getLocation().getY(), Color.GREEN);
        }
    }

    private void fillCell(int x, int y, Paint p){
        gc.setStroke(Color.BLACK);
        gc.setFill(p);
        gc.strokeRect(x * cellSize, y * cellSize, cellSize, cellSize);
        gc.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
    }
}
