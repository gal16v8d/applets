package co.com.gsdd.applets.clock;

import java.applet.Applet;
import java.awt.Graphics;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;

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
		Instant instant = Instant.now();
		LocalTime time = instant.atZone(ZoneOffset.systemDefault()).toLocalTime();
		g.drawString(
				formatTime(time.getHour()) + ":" + formatTime(time.getMinute()) + ":" + formatTime(time.getSecond()),
				10, 10);
	}

	private String formatTime(int time) {
		return String.format("%02d", time);
	}

}
