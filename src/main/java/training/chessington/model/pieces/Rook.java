package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();

        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        for (int[] dir : directions) {
            int row = from.getRow();
            int col = from.getCol();

            while (true) {
                row += dir[0];
                col += dir[1];
                Coordinates target = new Coordinates(row, col);

                if (!board.isWithinBounds(target)) break;

                Piece pieceAtTarget = board.get(target);
                if (pieceAtTarget == null) {
                    moves.add(new Move(from, target));
                } else {
                    if (pieceAtTarget.getColour() != this.colour) {
                        moves.add(new Move(from, target));
                    }
                    break;
                }
            }
        }

    return moves;
}

}
