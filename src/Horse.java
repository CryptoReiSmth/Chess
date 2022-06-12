public class Horse extends ChessPiece {
    public Horse(String color){
        super(color);
    }

    public String getColor(){
        return color;
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (checkPos(toLine) && checkPos(toColumn)){ //target position is correct
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)){ //target position is empty, or is occupied opponent's piece
                if ((Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1)  || (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2)){
                    return true;
                }
                else return false;
            }
            else return false;
        }
        else return false;
    }
    public String getSymbol(){
        return "H";
    }
    public boolean checkPos(int pos) {   // check that our position is correct
        if (pos >= 0 && pos <= 7) return true;
        else return false;
    }
}