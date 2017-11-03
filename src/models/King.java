package models;

public class King extends Piece{

    public King(Player player, int x, int y, Validator validator){
        super(player, "KING", x, y, validator);
    }

    public boolean canMove(int x, int y){
        if(Math.abs(this.x - x) > 1 || Math.abs(this.y - y) > 1) return false;
        if(validator.underAttack(x, y)) return false;
        return true;
    }
}
