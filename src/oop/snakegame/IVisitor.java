package oop.snakegame;

interface IVisitor {
    void visit(Wall wall);
    void visit(SizeBonus bonus);
    void visit(SnakeBlock block);
}
