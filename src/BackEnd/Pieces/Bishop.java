package BackEnd.Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Bishop extends ChessPiece {

    public Bishop(ChessPiece.PieceColor color, int xLocation, int yLocation) {
        this.pieceColor = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;

        if (color == ChessPiece.PieceColor.white) {
            img = new ImageIcon("img/White_bishop.png");
        } else if (color == ChessPiece.PieceColor.black) {
            img = new ImageIcon("img/Black_bishop.png");
        }
    }


    private void validation(
            String dir, int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList) {
        if ((x > 7 || y > 7) || (x < 0 || y < 0)) {
            return;
        }
        for (ChessPiece liveChessPiece : liveChessPieceList) {
            if (x == liveChessPiece.xLocation && y == liveChessPiece.yLocation) {
                if (liveChessPiece.getPieceColor() != this.pieceColor) {
                    labels[y][x].setBackground(Color.red);

                    return;
                } else if (liveChessPiece.getPieceColor() == this.pieceColor) {
                    return;
                }
            }
        }
        if (labels[y][x].getIcon() == null) {
            labels[y][x].setBackground(Color.green);
        }
        if (dir.equals("NorthWest")) {
            validation("NorthWest", --x, --y, labels, liveChessPieceList);
        }
        if (dir.equals("SouthEast")) {
            validation("SouthEast", ++x, ++y, labels, liveChessPieceList);
        }
        if (dir.equals("SouthWest")) {
            validation("SouthWest", --x, ++y, labels, liveChessPieceList);
        }
        if (dir.equals("NorthEast")) {
            validation("NorthEast", ++x, --y, labels, liveChessPieceList);
        }
    }

    @Override
    public void validMoveColor(
            int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList) {
        validation("NorthWest", --x, --y, labels, liveChessPieceList);
        y = yLocation;
        x = xLocation;
        validation("SouthEast", ++x, ++y, labels, liveChessPieceList);
        y = yLocation;
        x = xLocation;
        validation("SouthWest", --x, ++y, labels, liveChessPieceList);
        y = yLocation;
        x = xLocation;
        validation("NorthEast", ++x, --y, labels, liveChessPieceList);
    }
}
