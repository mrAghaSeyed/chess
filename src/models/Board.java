package models;

public class Board {
    private Validator validator;
    private Piece[][] pieces = new Piece[8][8];
    private String[] initialOrder = {
            "ROCK",
            "KNIGHT",
            "BISHOP",
            "QUEEN",
            "KING",
            "BISHOP",
            "KNIGHT",
            "ROCK"
    };
    public Board(Player player1, Player player2, Validator validator){
        this.validator = validator;
        for(int i = 0; i < 8; i++){
            pieces[1][i] = new Pawn(player1, 1, i, validator,+1);
            pieces[6][i] = new Pawn(player2, 6, i, validator,-1);
            if(initialOrder[i].equals("ROCK")){
                pieces[0][i] = new Rock(player1, 0, i, validator);
                pieces[7][i] = new Rock(player2, 7, i, validator);
            }
            if(initialOrder[i].equals("KNIGHT")){
                pieces[0][i] = new Knight(player1, 0, i, validator);
                player1.setKing(pieces[0][i]);
                pieces[7][i] = new Knight(player2, 7, i, validator);
                player2.setKing(pieces[7][i]);
            }
            if(initialOrder[i].equals("BISHOP")){
                pieces[0][i] = new Bishop(player1, 0, i, validator);
                pieces[7][i] = new Bishop(player2, 7, i, validator);
            }
            if(initialOrder[i].equals("QUEEN")){
                pieces[0][i] = new Queen(player1, 0, i,validator);
                pieces[7][i] = new Queen(player2, 7, i, validator);
            }
            if(initialOrder[i].equals("KING")){
                pieces[0][i] = new King(player1, 0, i, validator);
                pieces[7][i] = new King(player2, 7, i, validator);
            }
        }
    }

    public void setValidator(Validator validator){
        this.validator = validator;
    }

    public void setPiece(int x, int y, Piece piece) {
        pieces[x][y] = piece;
    }

    public Piece getPiece(int x, int y) {
        return pieces[x][y];
    }

    public void promotion(int x, int y, String newType){
        pieces[x][y].setType(newType);
    }
}
