package no.uib.inf101.sem2;

import javax.swing.JFrame;

import no.uib.inf101.sem2.minesweeper.controller.MineSweeperControllerKeyboard;
import no.uib.inf101.sem2.minesweeper.controller.MineSweeperControllerMouse;
import no.uib.inf101.sem2.minesweeper.model.HiddenBoard;
import no.uib.inf101.sem2.minesweeper.model.MineSweeperBoard;
import no.uib.inf101.sem2.minesweeper.model.MineSweeperModel;
import no.uib.inf101.sem2.minesweeper.view.MineSweeperView;


public class MineSweeperMain {
  public static final String WINDOW_TITLE = "MINESWEEPER by Sune Eriksson Lianes";
  public static void main(String[] args) {
    MineSweeperBoard board = new MineSweeperBoard(16, 16, 30);
    HiddenBoard hiddenBoard = new HiddenBoard(board);
    MineSweeperModel model = new MineSweeperModel(board, hiddenBoard);
    MineSweeperView view = new MineSweeperView(model);
    new MineSweeperControllerMouse(model, view);
    new MineSweeperControllerKeyboard(model, view);

    JFrame frame = new JFrame(WINDOW_TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(view);
    frame.pack();
    frame.setVisible(true);
  }
}
