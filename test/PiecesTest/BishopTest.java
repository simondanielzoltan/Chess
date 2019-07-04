package PiecesTest;

import BackEnd.Board;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BishopTest {
    @Test
    void validMoveColorTest() {
        Board board = new Board();
        board.setupBoardColor();
        board.fillLiveChessList();
        board.setChosenPiece(board.whiteBishop0);
        board.whitePawn3.setxLocation(-1);
        board.whitePawn3.setyLocation(-1);
        board.labels[6][3].setIcon(null);

        board.whiteBishop0.validMoveColor(board.getChosenPiece().getxLocation(), board.getChosenPiece().getyLocation(),
                board.labels, board.liveChessPieceList);

        Color resultColor = Color.green;

        assertEquals(resultColor, board.labels[6][3].getBackground());
        assertEquals(resultColor, board.labels[5][4].getBackground());
        assertEquals(resultColor, board.labels[4][5].getBackground());


    }
}
