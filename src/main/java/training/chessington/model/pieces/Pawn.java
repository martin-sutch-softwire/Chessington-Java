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

        Coordinates oneAhead = from.plus(direction, 0);
        Coordinates twoAhead = from.plus(direction * 2, 0);

        boolean isStartingRow = (direction == 1 && from.getRow() == 1) || (direction == -1 && from.getRow() == 6);
        boolean isSpaceOneAhead = (direction == 1 && from.getRow() < 7) || (direction == -1 && from.getRow() > 0);

        if (isSpaceOneAhead) {
            boolean isEmptyOneAhead = board.get(oneAhead) == null || false;
            boolean isEmptyTwoAhead = board.get(twoAhead) == null || false;
            
            if (isEmptyOneAhead && isSpaceOneAhead) {
                moves.add(new Move(from, oneAhead));
            }
            
            if (isEmptyTwoAhead && isStartingRow) {
                moves.add(new Move(from, twoAhead));
            };
        }; 

        return moves;
    }
}