package game.gui;

import game.arena.GameMap;
import game.arena.objects.Monster;
import game.arena.objects.Player;
import game.util.Coord;
import game.util.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyPanel extends JPanel implements KeyListener {

    Player player = new Player(0, 0, Color.BLUE);
    Monster monster = new Monster(0, 10, Color.RED);
    GameMap map = new GameMap(player, monster);
    public boolean gameOver = false;

    MyPanel() {
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (monster.currX == player.currX && monster.currY == player.currY) {
                    System.out.println("GAME OVER!!!");
                    gameOver = true;
                }
                Coord tmp = monster.getNextStep();
                monster.moveXY(  tmp  );

                repaint();
            }
        };
        Timer timer = new Timer(200, actionListener);
        timer.start();
    }

    public void keyPressed(KeyEvent keyEvent) {
        if(gameOver) return;
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if ( map.isFreeXY(player.getCurrY()-1, player.getCurrX())) player.move(Direction.LEFT);
                break;
            case KeyEvent.VK_UP:
                if ( map.isFreeXY(player.getCurrY(), player.getCurrX()-1)) player.move(Direction.UP);
                break;
            case KeyEvent.VK_RIGHT:
                if ( map.isFreeXY(player.getCurrY()+1, player.getCurrX())) player.move(Direction.RIGHT); //*
                break;
            case KeyEvent.VK_DOWN:
                if ( map.isFreeXY(player.getCurrY(), player.getCurrX()+1) ) player.move(Direction.DOWN);
                break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent keyEvent) {}
    public void keyTyped(KeyEvent keyEvent) {}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        map.paint(g);
        if ( gameOver ) g.drawString("GAME OVER", 20, 20);
    }
}