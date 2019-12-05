import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    private boolean running;

    private Window window;
    private Handler handler;

    private int WIDTH;
    private int HEIGHT;

    //for small debug screen
    private boolean smallScreen;

    //constructor

    //small screen
    public Game() {
        WIDTH = 800;
        HEIGHT = (WIDTH / 12) * 9;
        handler = new Handler();
        Random r = new Random();
        window = new Window(WIDTH, HEIGHT, "MyFirstGame", this);
        GameObject.assignStaticVars(new int[]{window.getWIDTH(), window.getHEIGHT()});

        for (int i = 0; i < 10; i++) {
            int w = r.nextInt(WIDTH);
            int h = r.nextInt(HEIGHT);
            handler.addObject(new Player());
            handler.addObject(new Drunkard(new ObjCoordinates(w, h)));
//            handler.addObject(new Player(10, 14));
//            handler.addObject(new Player(60, 32));
        }
        smallScreen = true;
    }


    //fullscreen
    public Game(boolean fullScreen) {
        handler = new Handler();
        Random r = new Random();
        window = new Window("MyFirstGame", this);
        GameObject.assignStaticVars(new int[]{window.getWIDTH(), window.getHEIGHT()});

        WIDTH = window.getWIDTH();
        HEIGHT = window.getHEIGHT();

        for (int i = 0; i < 20; i++) {
            int w = r.nextInt(WIDTH);
            int h = r.nextInt(HEIGHT);
            handler.addObject(new Player(new ObjCoordinates(w, h)));
//            handler.addObject(new Player(10, 14));
//            handler.addObject(new Player(60, 32));
        }
    }

    //methods

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            System.out.println("Impossible to stop");
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if ((System.currentTimeMillis() - timer) > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);

        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }//end of render() method

    //getters

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public Window getWindow() {
        return window;
    }
}//end of class
