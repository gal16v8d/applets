package com.gsdd.applets.hi;

import java.applet.Applet;
import java.awt.Graphics;

public class HiApplet extends Applet {

  private static final long serialVersionUID = -6052770818309679077L;

  @Override
  public void paint(Graphics g) {
    g.drawString("Hi", 100, 100);
    g.drawLine(10, 10, 100, 100);
    g.drawRect(0, 0, 150, 150);
    g.drawOval(100, 100, 100, 100);
  }
}
