package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		//FIXME
		
		this.setX(FOOD_SIZE + (1 - 2 * FOOD_SIZE) * Math.random());
		this.setY(FOOD_SIZE + (1 - 2 * FOOD_SIZE) * Math.random());
		
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(Color.red);
		StdDraw.filledCircle(getX(), getY(), FOOD_SIZE);
		}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	
}