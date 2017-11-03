package models;

public class Player{
    private String name;
    private Piece king;
    private Board board;
    private Validator validator;

    public Player(String name, Validator validator){
        this.name = name;
        this.validator = validator;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece getKing() {
        return king;
    }

    public void setKing(Piece king) {
        this.king = king;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean move(int x1, int y1, int x2, int y2){
        if(board.getPiece(x1, y1) == null) return false;
        if(board.getPiece(x1, y1).getPlayer() != this) return false;
        if(validator.teamKilling(x1, y1, x2, y2)) return false;
        if(board.getPiece(x1, y1).canMove(x2, y2)){
            board.getPiece(x1, y1).move(x2, y2);
            board.setPiece(x2, y2, board.getPiece(x1, y1));
            board.setPiece(x1, y1, null);
            return true;
        }
        return false;
    }
}
