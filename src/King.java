public class King extends ChessPiece {
    public King (String color){
        super(color);
    }

    public String getColor(){
        return color;
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (checkPos(toLine) && checkPos(toColumn)){ //target position is correct
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)){ //target position is empty, or is occupied opponent's piece
                if (isUnderAttack(chessBoard, toLine, toColumn)) return false; //The king will be eaten if move
                if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) return false;
                else return true;
            }
            else return false;
        }
        else return false;
    }
    public String getSymbol(){
        return "K";
    }
    public boolean checkPos(int pos) {   // check that our position is correct
        if (pos >= 0 && pos <= 7) return true;
        else return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {  // Check if [i][j] is occupied opponent's piece and this piece can attack the king
                        return true;
                    }
                }
            }
        }
        return false;
    }

}