package awaisfinalgame;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Laser {

	static int numLasers = 3;
	 
	// x and y positions
	 double x;
	 double y;
	
	static double speed = 2.1;
	
	double dx= 0;
	
	// get the banana image 
	String imageName = "images/laser.png";
	Image image = new Image(imageName, 45, 140, false, false);
	
	// set canvas and graphics context
	GraphicsContext gc;
	@FXML
	Canvas gameCanvas;

	// banana constructors
	public Laser(GraphicsContext gc, Canvas gameCanvas) {
		this.gc = gc;
		this.gameCanvas = gameCanvas;
	}

	// banana constructors
	public Laser(String imageName, GraphicsContext gc, Canvas gameCanvas) {
		this.imageName = imageName;
		this.gc = gc;
		this.gameCanvas = gameCanvas;
	}
	
	public Laser(GraphicsContext gc, Canvas gameCanvas, int laserIndex) {
		this.gc = gc;
		this.gameCanvas = gameCanvas;
		randomLaser(laserIndex);
	}

	public void randomLaser(int laserIndex) {
		this.x = 1000+300*laserIndex;
		this.y = (int)(Math.random()*(400-this.image.getHeight()));
	}
	
	public void move() {
		
		this.dx = -this.speed;	
		this.x += this.dx;
		
		
		
		if (this.x < 0-image.getWidth()) {
			randomLaser(0);
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
