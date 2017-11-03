package models;

public class Bishop extends Piece{

    public Bishop(Player player, int x, int y, Validator validator){
        super(player, "BISHOP", x, y, validator);
    }
    public boolean canMove(int x, int y){
        if(validator.diagonal(this.x, this.y, x, y)) return true;
        return false;
    }
}
