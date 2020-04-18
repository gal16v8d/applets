package co.com.gsdd.applets.clock;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Calendar;

public class ClockApplet extends Applet implements Runnable {

    private static final long serialVersionUID = 813761482249738185L;
    private Thread thread;
    private boolean active;

    @Override
    public void run() {
        while (active) {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void init() {
        thread = new Thread(this);
    }

    @Override
    public void start() {
        active = true;
        thread.start();
    }

    @Override
    public void stop() {
        active = false;
    }

    @Override
    public void paint(Graphics g) {
        Calendar c = Calendar.getInstance();
        g.drawString(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND), 10, 10);
    }

}
