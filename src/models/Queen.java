package models;

public class Queen extends Piece {

    public Queen(Player player, int x, int y, Validator validator){
        super(player, "QUEEN", x, y, validator);
    }
    public boolean canMove(int x, int y){
        if(validator.diagonal(this.x, this.y, x, y)) return true;
        if(validator.horizontal(this.x, this.y, x, y)) return true;
        if(validator.vertical(this.x, this.y, x, y)) return true;
        return false;
    }
}
