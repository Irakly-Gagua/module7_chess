class King extends ChessPiece {
    King(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "K";
    }

    public boolean canMoveToPosition(ChessBoard board,
                                     int line, int column,
                                     int toLine, int toColumn) {
        if (board.isBadPosition(line, column) ||
                board.isBadPosition(toLine, toColumn))
            return false;

        if (line == toLine && column == toColumn) return false;

        if ((line - toLine) * (line - toLine) > 1 ||
                (column - toColumn) * (column - toColumn) > 1)
            return false;

        if (board.board[toLine][toColumn] == null)
            return true;

        return !board.board[toLine][toColumn].getColor().equals(color);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (board.board[i][j] == null) continue;
                if (board.board[i][j].getColor().equals(color)) continue;
                if (board.board[i][j].getSymbol().equals("P")) {
                    if (i == line + 1 && (j - column) * (j - column) == 1) {
                        if (color.equals("White")) return true;
                        else continue;
                    }

                    if (i == line - 1 && (j - column) * (j - column) == 1) {
                        if (color.equals("Black")) return true;
                        else continue;
                    }

                    continue;
                }
                if(board.board[i][j].canMoveToPosition(board, i, j, line, column))
                    return true;
            }
        }

        return false;
    }
}