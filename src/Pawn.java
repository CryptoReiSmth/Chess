public class Pawn extends ChessPiece {
    public Pawn (String color){
        super(color);
    }

    public String getColor(){
        return color;
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (checkPos(toLine) && checkPos(toColumn)){  //target position is correct
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)){  //target position is empty, or is occupied opponent's piece
                if (column == toColumn){ //just move

                    int start = 1, move = 1;
                    if (color.equals("Black")) {
                        start = 6;
                        move = -1;
                    }
                    if (line + move == toLine) {
                        if (chessBoard.board[toLine][toColumn] == null) return true;
                        else return false;
                    }
                    if ((line == start) && (line + 2*move == toLine)) {
                        if ((chessBoard.board[toLine][toColumn] == null) && (chessBoard.board[line + move][column] == null)) return true;
                        else return false;
                    }
                    else return false;
                }
                else{ //eat

                    if ((Math.abs(column - toColumn) == 1  && Math.abs(line - toLine) == 1) && chessBoard.board[toLine][toColumn] != null) {
                        if (!chessBoard.board[toLine][toColumn].getColor().equals(color)) return true;
                        else return false;
                    } else return false;
                }
            }
            else return false;
        }
        else return false;
    }
    public String getSymbol(){
        return "P";
    }
    public boolean checkPos(int pos) {   // check that our position is correct
        if (pos >= 0 && pos <= 7) return true;
        else return false;
    }
}