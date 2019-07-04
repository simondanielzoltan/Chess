package PiecesTest;

import BackEnd.Board;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RookTest {
    @Test
    void validMoveColorTest() {
        Board board = new Board();
        board.setupBoardColor();
        board.fillLiveChessList();
        board.setChosenPiece(board.whiteRook0);
        board.whitePawn0.setxLocation(-1);
        board.whitePawn0.setyLocation(-1);
        board.labels[6][0].setIcon(null);

        board.whiteRook0.validMoveColor(board.getChosenPiece().getxLocation(), board.getChosenPiece().getyLocation(),
                board.labels, board.liveChessPieceList);

        Color resultColor = Color.green;

        assertEquals(resultColor, board.labels[6][0].getBackground());
        assertEquals(resultColor, board.labels[5][0].getBackground());
        assertEquals(resultColor, board.labels[4][0].getBackground());
        assertEquals(resultColor, board.labels[3][0].getBackground());
        assertEquals(resultColor, board.labels[2][0].getBackground());
        assertNotEquals(resultColor, board.labels[1][0].getBackground());
        assertNotEquals(resultColor, board.labels[0][0].getBackground());


    }
}
