package game.arena.objects;

import game.arena.GameMap;
import game.arena.attributes.Blaster;
import game.arena.attributes.Gun;
import game.util.Direction;
import game.util.Weapon;

import java.awt.*;

public final class Player extends APersonage {

    private int weapon = Weapon.BLUSTER;
    private Gun gun = new Blaster();

    public Player(int startX, int startY, Color c) {
        super(startX, startY, c);
    }

    public void shoot() {
        this.gun.shoot(currX, currY, this.direct);
    }

    public void paint(Graphics g) {
        // body
        g.setColor(color);
        g.fillOval(
                currY * GameMap.SIZE_FIELD + 2,
                currX * GameMap.SIZE_FIELD + 2,
                GameMap.SIZE_FIELD - 3,
                GameMap.SIZE_FIELD - 3
        );
        g.setColor(Color.BLACK);

        // pushka
        switch (this.direct) {
            case Direction.UP:
                g.drawLine(currY * GameMap.SIZE_FIELD + 10 + 1,
                        currX * GameMap.SIZE_FIELD + 10 + 1,
                        currY * GameMap.SIZE_FIELD + 10 + 1,
                        currX * GameMap.SIZE_FIELD + 0 + 1);
                break;
            case Direction.LEFT:
                g.drawLine(currY * GameMap.SIZE_FIELD + 10 + 1,
                        currX * GameMap.SIZE_FIELD + 10 + 1,
                        currY * GameMap.SIZE_FIELD + 0 + 1,
                        currX * GameMap.SIZE_FIELD + 10 + 1);
                break;
            case Direction.DOWN:
                g.drawLine(currY * GameMap.SIZE_FIELD + 10 + 1,
                           currX * GameMap.SIZE_FIELD + 10 + 1,
                           currY * GameMap.SIZE_FIELD + 10 + 1,
                           currX * GameMap.SIZE_FIELD + 20 + 1);
                break;
            case Direction.RIGHT:
                g.drawLine(currY * GameMap.SIZE_FIELD + 10 + 1,
                        currX * GameMap.SIZE_FIELD + 10 + 1,
                        currY * GameMap.SIZE_FIELD + 20 + 1,
                        currX * GameMap.SIZE_FIELD + 10 + 1);
                break;
        }
    }
}
