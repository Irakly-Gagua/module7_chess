class Pawn extends ChessPiece {
    Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "P";
    }

    public boolean canMoveToPosition(ChessBoard board,
                                     int line, int column,
                                     int toLine, int toColumn) {
        if (board.isBadPosition(line, column) ||
                board.isBadPosition(toLine, toColumn))
            return false;

        if (column != toColumn) {
            if ((column - toColumn) * (column - toColumn) != 1)
                return false;

            if (board.board[toLine][toColumn] == null)
                return false;

            if (board.board[toLine][toColumn].getColor().equals(color))
                return false;

            if (line == toLine - 1)
                return color.equals("White");

            if (line == toLine + 1)
                return color.equals("Black");
        }

        if (line == 1 && toLine == 3 || toLine == line + 1)
            return color.equals("White");

        if (line == 6 && toLine == 4 || toLine == line - 1)
            return color.equals("Black");

        return false;
    }
}