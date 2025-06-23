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

        Coordinates up = from.plus(1,0);
        Coordinates down = from.plus(-1,0);
        Coordinates left = from.plus(0,-1);
        Coordinates right = from.plus(0,1);

        moves.add(new Move(from, up));
        moves.add(new Move(from, down));
        moves.add(new Move(from, left));
        moves.add(new Move(from, right));

        return moves;
    }
}
