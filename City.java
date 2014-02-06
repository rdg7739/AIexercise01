package travlingSalesman;

public class City {
	
	private boolean isVisited;
	private double xPosition;
	private double yPosition;
	
	public City(double xPosition, double yPosition, boolean isVisited){
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.isVisited = isVisited;
	}
	
	public boolean getIsVisited(){
		return isVisited;
	}
	
	public double getCityX(){
		return xPosition;
	}
	
	public double getCityY(){
		return yPosition;
	}
	
	public void setIsVisited(boolean visited){
		isVisited = visited;
	}
	
	public void setCityX(double newX){
		xPosition = newX;
	}
	
	public void setCityY(double newY){
		yPosition = newY;
	}
}
