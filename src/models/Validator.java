package models;

public class Validator {
    private Board board;

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean teamKilling(int x1, int y1, int x2, int y2){
        if(empty(x2, y2)) return false;
        return board.getPiece(x1, y1).getPlayer() == board.getPiece(x2, y2).getPlayer();
    }
    public boolean empty(int x, int y){
        if(board.getPiece(x, y) == null) return true;
        return false;
    }

    public boolean underAttack(int x, int y){
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                if(board.getPiece(i, j).canMove(i, j)) return true;
        return false;
    }

    public boolean diagonal(int x1, int y1, int x2, int y2){
        if(Math.abs(x1 - x2) != Math.abs(y1 - y2)) return false;
        int dx = Math.abs(x2 - x1) / (x2 - x1);
        int dy = Math.abs(y2 - y1) / (y2 - y1);
        for(int x = x1 + dx, y = y1 + dy; x != x2; x += dx, y += dy){
            if(empty(x, y)) return false;
        }
        return true;
    }
    public boolean horizontal(int x1, int y1, int x2, int y2){
        if(y1 != y2) return false;
        int d = Math.abs(x2 - x1) / (x2 - x1);
        for(int x = x1 + d; x != x2; x += d){
            if(empty(x, y1)) return false;
        }
        return true;
    }
    public boolean vertical(int x1, int y1, int x2, int y2){
        if(x1 != x2) return false;
        int d = Math.abs(y2 - y1) / (y2 - y1);
        for(int y = y1 + d; y != y2; y += d){
            if(empty(x1, y)) return false;
        }
        return true;
    }
}
