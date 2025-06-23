package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();

        int direction = colour == PlayerColour.BLACK ? 1 : -1 ;
        int startRow = colour == PlayerColour.BLACK ? 1 : 6;

        Coordinates oneAhead = from.plus(direction, 0);
        Coordinates twoAhead = from.plus(direction * 2, 0);

        if (board.isWithinBounds(oneAhead) && board.get(oneAhead) == null) {
            moves.add(new Move(from, oneAhead));

            if (from.getRow() == startRow && board.isWithinBounds(twoAhead) && board.get(twoAhead) == null) {
                moves.add(new Move(from, twoAhead));
            }
        }

        return moves;
    }
}