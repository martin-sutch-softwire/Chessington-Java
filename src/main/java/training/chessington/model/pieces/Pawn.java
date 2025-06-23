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

        Coordinates moveOne = from.plus(direction, 0);
        Coordinates moveTwo = from.plus(direction * 2, 0);

        boolean emptyOneAhead = board.get(moveOne) == null;
        boolean emptyTwoAhead = board.get(moveTwo) == null;

        if (emptyOneAhead) {
            moves.add(new Move(from, moveOne));
        }

        if (emptyTwoAhead) {
            if (direction == 1 && from.getRow() == 1) {
                moves.add(new Move(from, moveTwo));
            };
            
            if (direction == -1 && from.getRow() == 6) {
                moves.add(new Move(from, moveTwo));
            };
        };

        return moves;
    }
}