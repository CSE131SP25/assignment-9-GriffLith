package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	private int score = 0;
	private long startTime;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		//FIXME - construct new Snake and Food objects
		snake = new Snake();
		food = new Food();
	}
	
	public void play() {
	    
	    startTime = System.currentTimeMillis();

	    while (snake.isInbounds() && !snake.isGameOver()) {
	        int dir = getKeypress();
	        snake.changeDirection(dir);
	        snake.move();

	        if (snake.eatFood(food)) {
	            food = new Food();
	            score++;
	        }

	        updateDrawing();
	        StdDraw.show();
	        StdDraw.pause(50);
	    }

	    long endTime = System.currentTimeMillis();
	    double secondsSurvived = (endTime - startTime) / 1000.0;
	    showGameOverScreen(secondsSurvived, snake.getLength());
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	
	private void updateDrawing() {
		//FIXME
		StdDraw.clear(Color.BLACK);
		snake.draw();
		food.draw();
		StdDraw.pause(5);
		
		StdDraw.setPenColor(Color.WHITE);
	    StdDraw.text(0.9, 0.95, "Score: " + this.score);
	    
	    StdDraw.show();
	
	}
	private void showGameOverScreen(double duration, int length) {
	    StdDraw.clear(Color.BLACK);

	    StdDraw.setPenColor(Color.GRAY);
	    StdDraw.filledRectangle(0.5, 0.5, 0.2, 0.3);
	    StdDraw.filledCircle(0.5, 0.8, 0.2); 

	    
	    StdDraw.setPenColor(Color.WHITE);
	    StdDraw.text(0.5, 0.85, "R.I.P.");
	    StdDraw.text(0.5, 0.75, "You lasted:");
	    StdDraw.text(0.5, 0.70, String.format("%.1f seconds", duration));
	    StdDraw.text(0.5, 0.60, "Snake size: " + length);
	    StdDraw.text(0.5, 0.45, "Press R to restart");

	    StdDraw.show();
	    while (true) {
	        if (StdDraw.isKeyPressed(KeyEvent.VK_R)) {
	            Game g = new Game();
	            g.play();
	            break;
	        }
	        StdDraw.pause(100);
	    }}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}