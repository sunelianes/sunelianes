package no.uib.inf101.sem2.minesweeper.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import no.uib.inf101.sem2.minesweeper.model.GameState;
import no.uib.inf101.sem2.minesweeper.view.MineSweeperView;

public class MineSweeperControllerKeyboard implements KeyListener {
  private ControllableMineSweeperModel model;
  private MineSweeperView view;
  
  public MineSweeperControllerKeyboard(ControllableMineSweeperModel model, MineSweeperView view) {
    this.model = model;
    this.view = view;
    view.setFocusable(true);
    view.addKeyListener(this);
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    if (model.getGameState() == GameState.ACTIVE_GAME) {
      // P is pressed
      if (e.getKeyCode() == KeyEvent.VK_P) {
        model.setGameState(GameState.PAUSE_GAME);
      }
    }
    else if (model.getGameState() == GameState.PAUSE_GAME) {
      // P is pressed
      if (e.getKeyCode() == KeyEvent.VK_P) {
        model.setGameState(GameState.ACTIVE_GAME);
      }
    }
    view.repaint();
  } 
  
  @Override
  public void keyTyped(KeyEvent e) {} // Ignore
  
  @Override
  public void keyReleased(KeyEvent e) {} // Ignore
  
}
