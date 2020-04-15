import java.util.Stack;

public class Bullet {

    private int x;
    private int y;

    private int dx;
    private int dy;

    public Bullet(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        int speed = 10;
        x += dx * speed;
        y += dy * speed;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setDxDy(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }


}

class BulletsPool {

    private static BulletsPool instance;
    private static Stack<Bullet> bullets;

    private BulletsPool() {
        bullets = new Stack<>();
        for (int i = 0; i < 10; i++) {
            bullets.push(new Bullet(0, 0, 0, 0));
        }
    }

    public static BulletsPool getInstance() {
        if (instance == null) {
            instance = new BulletsPool();
        }
        return instance;
    }
    public void takeBullet(Bullet bullet) {
        bullets.push(bullet);
    }

    public Bullet getBullet(int x, int y, int dx, int dy) {
        if (bullets.size() == 0) {
            for (int i = 0; i < 10; i++) {
                bullets.push(new Bullet(0, 0, 0, 0));
            }
        }
        Bullet bullet = bullets.pop();
        bullet.setDxDy(dx, dy);
        bullet.setXY(x, y);

        return bullet;
    }



}
