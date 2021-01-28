package awaisfinalgame;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Coin {
	

	static int numCoins = 10;
	 
	double y;
	// x and y positions
	double x;

	
	static double speed = 2;
	
	double dx= 0;
	
	// get the banana image 
	String imageName = "images/coin.png";
	Image image = new Image(imageName, 30, 30, false, false);
	
	// set canvas and graphics context
	GraphicsContext gc;
	@FXML
	Canvas gameCanvas;

	public Coin(GraphicsContext gc, Canvas gameCanvas) {
		this.gc = gc;
		this.gameCanvas = gameCanvas;
	}

	public Coin(String imageName, GraphicsContext gc, Canvas gameCanvas) {
		this.imageName = imageName;
		this.gc = gc;
		this.gameCanvas = gameCanvas;
	}
	
	public Coin(GraphicsContext gc,  Canvas gameCanvas, int coinIndex, int coinY) {
		this.gc = gc;
		this.gameCanvas = gameCanvas;
		randomCoin(coinIndex, coinY);
	}
	
	public void randomCoin(int coinIndex, int coinY) {
		this.x = 1000+20*coinIndex;
		this.y = coinY;
	}
	
	public void move(int coinIndex, int coinY) {
		
		this.dx = -this.speed;	
		this.x += this.dx;
		
		if (this.x < -150) {
			this.x = 1050;
			this.y = coinY;
		}
	
		gc.drawImage(this.image, this.x, this.y);
		
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}


	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public Rectangle2D getBoundary() {
		return new Rectangle2D(this.x, this.y, this.image.getWidth(), this.image.getHeight());
	}
}

