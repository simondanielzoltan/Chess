package PiecesTest;

import BackEnd.Board;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class KnightTest {
    @Test
    void validMoveColorTest() {
        Board board = new Board();
        board.setupBoardColor();
        board.fillLiveChessList();
        board.setChosenPiece(board.whiteKnight0);
        board.whiteKnight0.validMoveColor(board.getChosenPiece().getxLocation(), board.getChosenPiece().getyLocation(),
                board.labels, board.liveChessPieceList);

        Color resultColor = Color.green;
        assertEquals(resultColor, board.labels[5][0].getBackground());
        assertEquals(resultColor, board.labels[5][2].getBackground());
        assertNotEquals(resultColor, board.labels[5][1].getBackground());

    }

}
