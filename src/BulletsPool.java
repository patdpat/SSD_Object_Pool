import java.util.Stack;

public class BulletsPool {

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
            return instance;
        } else {
            return instance;
        }
    }

    public Bullet getAvailableBulletWithDirection(int x, int y, int dx, int dy) {
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

    public void collectBullet(Bullet bullet) {
        bullets.push(bullet);
    }

}
