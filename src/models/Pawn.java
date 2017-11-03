package models;

public class Pawn extends Piece{

    private int d;

    public Pawn(Player player, int x, int y, Validator validator, int d) {
        super(player, "PAWN", x, y, validator);
        this.d = d;
    }

    public boolean canMove(int x, int y){
        if(d * (x - this.x) < 1) return false;
        if(Math.abs(this.x - x) > 1 && moved) return false;
        if(Math.abs(this.x - x) > 2) return false;
        if(Math.abs(this.y - y) > 1) return false;
        if(this.y == y && !validator.empty(x, y)) return false;
        return true;
    }
}
