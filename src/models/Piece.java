package models;

public abstract class Piece{
    private Player player;
    public Validator validator;
    private String type;
    protected boolean moved;
    protected int x;
    protected int y;

    public Piece(Player player, String type, int x, int y, Validator validator){
        moved = false;
        this.type = type;
        this.player = player;
        this.validator = validator;
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y){
        this.x = x;
        this.y = y;
        moved = true;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }
    public Player getPlayer() {
        return this.player;
    }

    public abstract boolean canMove(int x, int y);

}
