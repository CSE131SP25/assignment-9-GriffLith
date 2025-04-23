package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		//FIXME
		this.setX(x);
		this.setY(y);
		this.size = size;
		this.color = ColorUtils.solidColor();
		
		//See ColorUtils for some color options (or choose your own)
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(getX(), getY(), size);
	}

	public  double getX() {
		return x;
	}
	
	public String getXs() {
		return null;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}}