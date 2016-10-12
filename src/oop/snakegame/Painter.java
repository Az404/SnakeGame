package oop.snakegame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

class Painter implements IVisitor {

    final static int cellSize = 15;
    private GraphicsContext gc;

    Painter(GraphicsContext gc){
        this.gc = gc;
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
        fillCell(snakeBlock.location, Color.BLUE);
    }

    private void fillCell(Location location, Paint p) {
        gc.setStroke(Color.BLACK);
        gc.setFill(p);
        gc.strokeRect(location.x * cellSize, location.y * cellSize, cellSize, cellSize);
        gc.fillRect(location.x * cellSize, location.y * cellSize, cellSize, cellSize);
    }
}
