package awaisfinalgame;

import java.util.Timer;
import java.util.TimerTask;

public class SpeedPowerupTask extends TimerTask{

	int secondsPowerup = 0;
	
	double changingSpeed = 0.6;
	
	static String stillSpeedImage = "images/playerStillSpeed.png";
	static String movingPlayerSpeed = "images/playerMovingSpeed1.png";
	static String movingPlayerSpeed2 = "images/playerMovingSpeed2.png";
	
    Timer timer;

	public SpeedPowerupTask(Timer t) {
		this.timer = t;
    
	}
    
	public void run() {		
		
		if (secondsPowerup == 0) {
			slowDownSpeed();			
			setPlayerBlue();
			secondsPowerup += 1;
		} 

		else if (secondsPowerup == 10) {
			resetSpeed();
			Player.setPlayerNormal();
			secondsPowerup = 0;
			timer.cancel();
		} 
		else {
			secondsPowerup++;
			
		}
	}
	
	public void setPlayerBlue() {
		Player.stillPlayerImage = stillSpeedImage;
		Player.movingPlayerImage1 = movingPlayerSpeed;
		Player.movingPlayerImage2 = movingPlayerSpeed2;
	}
	
	
	public void slowDownSpeed() {
		Coin.speed -= changingSpeed;
		Missile.speed -= changingSpeed;
		Laser.speed -= changingSpeed;
	}
	
	public void resetSpeed() {
		Coin.speed -= changingSpeed;
		Missile.speed -= changingSpeed;
		Laser.speed -= changingSpeed;
	}
}