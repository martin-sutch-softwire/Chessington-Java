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

        // Check horizontal moves
        for (int col = 0; col < 8; col++) {
            if (col != from.getCol()) {
                Coordinates target = new Coordinates(from.getRow(), col);
                if (board.isWithinBounds(target)) {
                        moves.add(new Move(from, target));
                }
            }
        }

        // Check vertical moves
        for (int row = 0; row < 8; row++) {
            if (row != from.getRow()) {
                Coordinates target = new Coordinates(row, from.getCol());
                if (board.isWithinBounds(target)) {
                        moves.add(new Move(from, target));
                }
            }
        }

        return moves;
    }
}
