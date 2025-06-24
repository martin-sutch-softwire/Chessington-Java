package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

            if (from.getRow() == startRow && board.get(twoAhead) == null) {
                moves.add(new Move(from, twoAhead));
            }
        }

        Coordinates leftDiagonal = from.plus(direction, -1);
        Coordinates rightDiagonal = from.plus(direction, 1);

        List<Move> validDiagonals = Stream.of(leftDiagonal, rightDiagonal)
                .filter(board::isWithinBounds)
                .filter(coord -> board.get(coord) != null && board.get(coord).getColour() != colour)
                .map(coord -> new Move(from, coord))
                .toList();

        moves.addAll(validDiagonals);

        return moves;
    }
}