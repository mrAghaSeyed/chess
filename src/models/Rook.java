package models;

public class Rook extends Piece{

    public Rook(Player player, int x, int y, Validator validator){
        super(player, "ROCK", x, y, validator);
    }
    public boolean canMove(int x, int y){
        if(validator.horizontal(this.x, this.y, x, y)) return true;
        if(validator.vertical(this.x, this.y, x, y)) return true;
        return false;
    }
}
