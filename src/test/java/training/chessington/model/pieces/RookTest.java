package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RookTest {
    @Test
    public void rookCanMoveHorizontallyAndVertically() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(
            new Move(coords, coords.plus(0, 1)),
            new Move(coords, coords.plus(0, -1)),
            new Move(coords, coords.plus(1, 0)),
            new Move(coords, coords.plus(-1, 0))
        );
    }
    @Test
    public void rookCannotMoveOffOfBoard() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, -1)));
    }
    @Test
    public void rookCanMoveUntilBoundsInAllDirections() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 3);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
       assertThat(moves).containsExactlyInAnyOrder(
            new Move(coords, coords.plus(0, 1)),
            new Move(coords, coords.plus(0, 2)),
            new Move(coords, coords.plus(0, 3)),
            new Move(coords, coords.plus(0, 4)),
            new Move(coords, coords.plus(1, 0)),
            new Move(coords, coords.plus(2, 0)),
            new Move(coords, coords.plus(3, 0)),
            new Move(coords, coords.plus(4, 0)),
            new Move(coords, coords.plus(-1, 0)),
            new Move(coords, coords.plus(-2, 0)),
            new Move(coords, coords.plus(-3, 0)),
            new Move(coords, coords.plus(0, -1)),
            new Move(coords, coords.plus(0, -2)),
            new Move(coords, coords.plus(0, -3))
        );
    }
    @Test
    public void rookCannotMoveToOccupiedSquareBySameColour() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);
        Piece friendlyPiece = new Rook(PlayerColour.WHITE);
        board.placePiece(coords.plus(0, 1), friendlyPiece);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 1)));
    }
    @Test
    public void rookCannotMovePastOccupiedSquareOfSameColour() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);
        Piece friendlyPiece = new Rook(PlayerColour.WHITE);
        board.placePiece(coords.plus(0, 2), friendlyPiece);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(0, 3)));
    }
}
