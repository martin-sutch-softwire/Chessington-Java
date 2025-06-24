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

        //Check moves to right
        for (int col = from.getCol() + 1; col < 8; col++) {
            Coordinates target = new Coordinates(from.getRow(), col);
            if (board.isWithinBounds(target)) {
                Piece pieceAtTarget = board.get(target);
                if (pieceAtTarget == null) {
                    moves.add(new Move(from, target));
                } else {
                    if (pieceAtTarget.getColour() != this.colour) {
                        moves.add(new Move(from, target));
                    }
                    break;
                }
            } else {
                break;
            }
        }

        // Check moves to left
        for (int col = from.getCol() - 1; col >= 0; col--) {
            Coordinates target = new Coordinates(from.getRow(), col);
            if (board.isWithinBounds(target)) {
                Piece pieceAtTarget = board.get(target);
                if (pieceAtTarget == null) {
                    moves.add(new Move(from, target));
                } else {
                    if (pieceAtTarget.getColour() != this.colour) {
                        moves.add(new Move(from, target));
                    }
                    break;
                }
            } else {
                break;
            }
        }

        // Check moves downwards
        for (int row = from.getRow() + 1; row < 8; row++) {
            Coordinates target = new Coordinates(row, from.getCol());
            if (board.isWithinBounds(target)) {
                Piece pieceAtTarget = board.get(target);
                if (pieceAtTarget == null) {
                    moves.add(new Move(from, target));
                } else {
                    if (pieceAtTarget.getColour() != this.colour) {
                        moves.add(new Move(from, target));
                    }
                    break;
                }
            } else {
                break;
            }
        }

        // Check moves upwards
        for (int row = from.getRow() - 1; row >= 0; row--) {
            Coordinates target = new Coordinates(row, from.getCol());
            if (board.isWithinBounds(target)) {
                Piece pieceAtTarget = board.get(target);
                if (pieceAtTarget == null) {
                    moves.add(new Move(from, target));
                } else {
                    if (pieceAtTarget.getColour() != this.colour) {
                        moves.add(new Move(from, target));
                    }
                    break;
                }
            } else {
                break;
            }
        }

        return moves;
    }
}
