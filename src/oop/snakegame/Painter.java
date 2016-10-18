package oop.snakegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.HashMap;

class Painter implements IVisitor {

    final static int cellSize = 15;
    private final HashMap<Integer, Paint> idToColor;
    private GraphicsContext gc;

    Painter(GraphicsContext gc, HashMap<Integer, Paint> idToColor){
        this.gc = gc;
        this.idToColor = idToColor;

    }

    @Override
    public void visit(Wall wall){
        fillCell(wall.location, Color.GRAY);
    }

    @Override
    public void visit(SizeBonus bonus){
        fillCell(bonus.location, Color.GREEN);
    }

    @Override
    public void visit(SnakeBlock snakeBlock){
        fillCell(snakeBlock.location, idToColor.get(snakeBlock.id));
    }

    private void fillCell(Location location, Paint p) {
        gc.setStroke(Color.BLACK);
        gc.setFill(p);
        gc.strokeRect(location.x * cellSize, location.y * cellSize, cellSize, cellSize);
        gc.fillRect(location.x * cellSize, location.y * cellSize, cellSize, cellSize);
    }
}
