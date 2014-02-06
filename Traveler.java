package travlingSalesman;

public class Traveler {
	
	private double xPosition;
	private double yPosition;
	
	public Traveler(){
		xPosition = 0;
		yPosition = 0;
	}
	
	public double getXPositition(){
		return xPosition;
	}
	
	public double getYPosition(){
		return yPosition;
	}
	
	public void setXPosition(double newX){
		xPosition = newX;
	}
	
	public void setYPosition(double newY){
		yPosition = newY;
	}
	
}
