class Bishop extends ChessPiece {
    Bishop(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "B";
    }

    public boolean canMoveToPosition(ChessBoard board,
                                     int line, int column,
                                     int toLine, int toColumn) {
        if (board.isBadPosition(line, column) ||
                board.isBadPosition(toLine, toColumn) ||
                column == toColumn || line == toLine)
            return false;

        if (line + column != toLine + toColumn &&
                line - column != toLine - toColumn)
            return false;

        if (!board.isPathFree(line, column, toLine, toColumn))
            return false;

        if (board.board[toLine][toColumn] == null)
            return true;

        return !board.board[toLine][toColumn].getColor().equals(color);
    }
}