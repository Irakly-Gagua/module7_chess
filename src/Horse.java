class Horse extends ChessPiece {
    Horse(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "H";
    }

    public boolean canMoveToPosition(ChessBoard board,
                                     int line, int column,
                                     int toLine, int toColumn) {
        if (board.isBadPosition(line, column) ||
                board.isBadPosition(toLine, toColumn))
            return false;

        if ((line - toLine) * (line - toLine) +
                (column - toColumn) * (column - toColumn) != 5)
            return false;

        if (board.board[toLine][toColumn] == null)
            return true;

        return !board.board[toLine][toColumn].getColor().equals(color);
    }
}