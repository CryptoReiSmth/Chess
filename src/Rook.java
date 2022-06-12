public class Rook extends ChessPiece {
    public Rook (String color){
        super(color);
    }

    public String getColor(){
        return color;
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (checkPos(toLine) && checkPos(toColumn)){ //target position is correct
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)){ //target position is empty, or is occupied opponent's piece
                if (line == toLine || column == toColumn) return true;
                else return false;
            }
            else return false;
        }
        else return false;
    }
    public String getSymbol(){
        return "R";
    }
    public boolean checkPos(int pos) {   // check that our position is correct
        if (pos >= 0 && pos <= 7) return true;
        else return false;
    }
}