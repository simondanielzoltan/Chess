import BackEnd.Board;
import BackEnd.Pieces.ChessPiece;
import BackEnd.Pieces.Rook;
import org.junit.jupiter.api.Test;


import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTest {

    @Test
    public void newGameUnitTest() {
        Board board = new Board();
        board.setupIcons();
        int[] resultX = new int[board.liveChessPieceList.size()];
        int[] resultY = new int[board.liveChessPieceList.size()];
        for (int i = 0; i < board.liveChessPieceList.size(); i++) {
            resultX[i] = board.liveChessPieceList.get(i).getxLocation();
            resultY[i] = board.liveChessPieceList.get(i).getyLocation();
        }

        board.liveChessPieceList.get(3).setxLocation(3);
        board.liveChessPieceList.get(3).setyLocation(3);

        board.setupNewGame();

        for (int i = 0; i < board.liveChessPieceList.size(); i++) {
            assertEquals(resultX[i], board.liveChessPieceList.get(i).getxLocation());
            assertEquals(resultY[i], board.liveChessPieceList.get(i).getyLocation());
        }
    }

    @Test
    void executeCastlingUnitTest() {
        Board board = new Board();
        board.setupNewGame();
        board.fillLiveChessList();
        board.setChosenPiece(board.whiteKing);
        board.setBoardLocationX(6);
        JLabel label = new JLabel();
        label.setBackground(Color.orange);
        int resultX = 5;
        int resultY = 7;
        board.executeCastling(label);
        assertEquals(resultX, board.whiteRook1.getxLocation());
        assertEquals(resultY, board.whiteRook1.getyLocation());
    }

    @Test
    void setupBoardTest() {
        Board board = new Board();
        board.setupBoardColor();
        Color resultColor = Color.white;

        assertEquals(resultColor, board.labels[0][0].getBackground());
        assertEquals(resultColor, board.labels[7][7].getBackground());
        assertNotEquals(resultColor, board.labels[0][7].getBackground());
        assertEquals(resultColor, board.labels[3][7].getBackground());
    }
}
