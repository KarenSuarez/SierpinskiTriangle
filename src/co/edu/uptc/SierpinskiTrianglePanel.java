package co.edu.uptc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SierpinskiTrianglePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int level = 0;

	public SierpinskiTrianglePanel() {
		setSize(new Dimension(800, 800));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int[] x = { getWidth() / 2, 10, getWidth() - 10 };
		int[] y = { 10, getHeight() - 10, getHeight() - 10 };
		drawSierpinskiTriangle(g, x, y, this.level);
	}

	public void setLevel(int level) {
		this.level = level;
		repaint();
	}

	private void drawSierpinskiTriangle(Graphics g, int[] x, int[] y, int level) {
	    if (level == 0) {
	        fillPolygon(g, x, y, Color.BLACK);
	    } else {
	        int[] x1 = {x[0], getMidpoint(x[0], x[1]), getMidpoint(x[0], x[2])};
	        int[] y1 = {y[0], getMidpoint(y[0], y[1]), getMidpoint(y[0], y[2])};
	        int[] x2 = {getMidpoint(x[0], x[1]), x[1], getMidpoint(x[1], x[2])};
	        int[] y2 = {getMidpoint(y[0], y[1]), y[1], getMidpoint(y[1], y[2])};
	        int[] x3 = {getMidpoint(x[0], x[2]), getMidpoint(x[1], x[2]), x[2]};
	        int[] y3 = {getMidpoint(y[0], y[2]), getMidpoint(y[1], y[2]), y[2]};
	        drawSierpinskiTriangle(g, x1, y1, level - 1);
	        drawSierpinskiTriangle(g, x2, y2, level - 1);
	        drawSierpinskiTriangle(g, x3, y3, level - 1);
	    }
	}

	private void fillPolygon(Graphics g, int[] x, int[] y, Color color) {
		g.setColor(color);
		g.fillPolygon(x, y, 3);
	}

	private int getMidpoint(int point1, int point2) {
		return (point1 + point2) / 2;
	}
}