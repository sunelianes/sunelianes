package no.uib.inf101.sem2.minesweeper.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import no.uib.inf101.sem2.minesweeper.model.GameState;
import no.uib.inf101.sem2.minesweeper.utils.ClickSquareException;
import no.uib.inf101.sem2.minesweeper.view.MineSweeperView;

public class MineSweeperControllerMouse implements MouseListener {

  private ControllableMineSweeperModel model;
  private MineSweeperView view;

  // Constructor
  public MineSweeperControllerMouse(ControllableMineSweeperModel model, MineSweeperView view) {
    this.model = model;
    this.view = view;
    view.setFocusable(true);
    view.addMouseListener(this);
  }

  @Override
  public void mousePressed(MouseEvent e) {
    try {
      if (model.getGameState() == GameState.ACTIVE_GAME) {
        // left click
        if (e.getButton() == 1) {
          model.openHiddenSquare(e.getX(), e.getY(), view.getWidth(), view.getHeight());
        } 
        // right click
        else if (e.getButton() == 3) {
          model.setFlag(e.getX(), e.getY(), view.getWidth(), view.getHeight());
        }
      }
      if (model.getGameState() == GameState.START_GAME) {
          if (e.getButton() == 1) {
            model.setGameState(GameState.ACTIVE_GAME);
          }
      }
      view.repaint(); 
    } catch (ClickSquareException exception) {
      System.out.println(exception);
    }  
  }

  @Override
  public void mouseClicked(MouseEvent e) {} // Ignore

  @Override
  public void mouseReleased(MouseEvent e) {} // Ignore

  @Override
  public void mouseEntered(MouseEvent e) {} // Ignore

  @Override
  public void mouseExited(MouseEvent e) {} // Ignore
  
}
