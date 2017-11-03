package models;

public class Knight extends Piece {

    public Knight(Player player, int x, int y, Validator validator){
        super(player, "KNIGHT", x, y, validator);
    }

    public boolean canMove(int x, int y){
        int a = Math.abs(this.x - x), b = Math.abs(this.y - y);
        if(a > b){
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        if(a == 1 && b == 2) return true;
        return false;
    }
}
