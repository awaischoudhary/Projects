package awaisfinalgame;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Powerup {

	// x and y positions
	double x;
	static double y;

	double speed = 0;

	double dx = 0;

	// get the banana image
	String imageName = "images/powerup.png";
	Image image = new Image(imageName, 60, 60, false, false);

	// set canvas and graphics context
	GraphicsContext gc;
	@FXML
	Canvas gameCanvas;

	public Powerup(GraphicsContext gc, Canvas gameCanvas) {
		this.gc = gc;
		this.gameCanvas = gameCanvas;
		randomPowerup();
	}

	public Powerup(String imageName, GraphicsContext gc, Canvas gameCanvas) {
		this.imageName = imageName;
		this.gc = gc;
		this.gameCanvas = gameCanvas;
		randomPowerup();
	}
	
    // pass whatever objects you want to manipulate for the powerup (e.g. player)
	public abstract void applyPowerup(ArrayList<Laser> laserList, ArrayList<Missile> missileList);
// 	public abstract void applyPowerup(ArrayList<Laser> laserList, ArrayList<Missile> missileList, Player player);

	public void randomPowerup() {
		this.x = 1100;
		this.y = 100;
	}

	public void move() {
		if (Player.score % 100 == 0 && Player.score > 1) {
			this.speed = 2;
			this.y = 100;
		}
		this.dx = -this.speed;	
		this.x += this.dx;
		
		if (this.x < -this.image.getWidth()) {
			this.x = 1100;
			this.speed = 0;
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