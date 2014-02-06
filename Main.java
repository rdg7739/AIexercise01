package travlingSalesman;

import java.awt.geom.Line2D;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

<<<<<<< HEAD
public class Main {
=======
public class readFile {
	
>>>>>>> db94a6ee3fb2f15dfb979b30f116d3b4ca6391b1
	private Traveler traveler;
	private ArrayList<City> cities = new ArrayList<City>();
	private static ArrayList<Line2D> lines = new ArrayList<Line2D>();
	private ArrayList<City> traveled;
	private ArrayList<City> newTraveled;
	private Scanner scanner;
	private FileInputStream inFile;
	private FileWriter outFile;
	private BufferedWriter writer;
	private boolean isGoal;
	private City startCity;
	
<<<<<<< HEAD
	public double findDistance(City city1, City city2){
		return Math.sqrt(
			   Math.pow(city2.getCityX()-city1.getCityX(), 2) + 
			   Math.pow(city2.getCityY()-city1.getCityY(), 2));
=======
	/**
	 * Check to see if all states visited
	 * @return
	 */
	public boolean isGoalState(){
		isGoal = true;
		for(int i = 0; i < cities.size(); i++){
			if(!cities.get(i).getIsVisited()){
				isGoal = false;
				i = cities.size();
			}
		}

		return isGoal;
	}
	
	public int findDistance(City city1, City city2){
		int distance = 0;
		
>>>>>>> db94a6ee3fb2f15dfb979b30f116d3b4ca6391b1
		
	}
	
	/**
	 * read data from the file
	 * @param inFile
	 * @param outFile
	 */
<<<<<<< HEAD
	public Main(FileInputStream inFile, FileWriter outFile){
		double startTime = System.currentTimeMillis();
=======
	public readFile(FileInputStream inFile, FileWriter outFile){
>>>>>>> db94a6ee3fb2f15dfb979b30f116d3b4ca6391b1
		this.inFile = inFile;
		this.outFile = outFile;
		traveler = new Traveler();
		scanner = new Scanner(inFile);
		//reading in each coordinates of the cities and adding it to the ArrayList, cities
		while(scanner.hasNext()){
			City city = new City(scanner.nextDouble(), scanner.nextDouble(), false);
			cities.add(city);
		}
		
		//setting up the start city of the traveler
		startCity = new City(cities.get(0).getCityX(), cities.get(0).getCityY(), true);
		cities.remove(0);
		traveler.setXPosition(startCity.getCityX());
		traveler.setYPosition(startCity.getCityY());
<<<<<<< HEAD
		
		traveled = NearestNeighbor();
=======
>>>>>>> db94a6ee3fb2f15dfb979b30f116d3b4ca6391b1
		
		newTraveled = twoOpt(traveled);
		System.out.println(System.currentTimeMillis() - startTime);
	}
	
	public double printTotalD(){
		double xS,xE, yS,yE;
		double total = 0.0;
		for(int i = 0; i < lines.size()-1; i++){
			xS = lines.get(i).getX1();	yS = lines.get(i).getY1();
			xE = lines.get(i).getX2();	yE = lines.get(i).getY2();
			total += Math.sqrt(Math.pow(xE-xS, 2) + 
					           Math.pow(yE-yS, 2));
			}
		System.out.println(total);
		return total;
	}
	public ArrayList<City> twoOpt(ArrayList<City> cities){
		createLines();
		double first = printTotalD();
		isIntersect();
		double second = printTotalD();
		System.out.println(first-second);
		return cities;
	}
	
	public void replaceLine(int i, int j){
		double l1_xS,l1_xE, l2_xS, l2_xE, l1_yS,l1_yE, l2_yS, l2_yE;
		l1_xS = lines.get(i).getX1();	l1_yS = lines.get(i).getY1();
		l1_xE = lines.get(i).getX2();	l1_yE = lines.get(i).getY2();
		l2_xS = lines.get(j).getX1();	l2_yS = lines.get(j).getY1();
		l2_xE = lines.get(j).getX2();	l2_yE = lines.get(j).getY2();
		if( i < j){
		lines.get(i).setLine(l1_xS, l1_yS, l2_xS, l2_yS);
		lines.get(j).setLine(l1_xE, l1_yE, l2_xE, l2_yE);
		}
		else{
			lines.get(j).setLine(l1_xS, l1_yS, l2_xS, l2_yS);
			lines.get(i).setLine(l1_xE, l1_yE, l2_xE, l2_yE);
				
		}
	}
	public void changeDir(int i, int j){
		Stack<Line2D> stack = new Stack<Line2D>();
		for(int q = i; q <= j; q++){
			stack.push(lines.get(q));
		}
		for(int q = i; q <= j; q++){
			lines.set(q, stack.pop());
		}
		for(int k = i; k <= j; k++){
			double x1 = lines.get(k).getX1();
			double x2 = lines.get(k).getX2();
			double y1 = lines.get(k).getY1();
			double y2 = lines.get(k).getY2();
			lines.get(k).setLine(x2, y2, x1, y1);
		}
	}
	public void isIntersect(){
		for(int i = 2; i < lines.size()-1; i++){
			if(lines.get(0).intersectsLine(lines.get(i))){
				replaceLine(0,i);
				changeDir(1, i-1);
			}// when 2 lines:  foo and hoo changed, then the lines between these two should be change it's direction 
		}
			
		for(int i = 1; i < lines.size()-1; i++){
			for(int j = 0; j < i-1; j++){
				if(lines.get(i).intersectsLine(lines.get(j))){
					replaceLine(i,j);
					changeDir(j+1, i-1);
				}
			}
			for(int k = i+2; k < lines.size(); k++){
				if(lines.get(i).intersectsLine(lines.get(k))){
					replaceLine(i,k);
					changeDir(i+1, k-1);
				}
			}
		}
		
		for(int i = 1; i < lines.size()-2; i++){
			if(lines.get(lines.size()-1).intersectsLine(lines.get(i))){
				replaceLine(lines.size()-1, i);
				changeDir(i+1, lines.size()-2);
			}
		}
	}
	
	public void createLines(){
		for(int i = 0; i < traveled.size()-1; i++){
			Line2D line = new Line2D.Double();
			line.setLine(traveled.get(i).getCityX(), traveled.get(i).getCityY(),traveled.get(i+1).getCityX(), traveled.get(i+1).getCityY());
			lines.add(line);
		}
		Line2D line = new Line2D.Double();
		line.setLine(traveled.get(traveled.size()-1).getCityX(), traveled.get(traveled.size()-1).getCityY(), 
					traveled.get(0).getCityX(), traveled.get(0).getCityY());
		lines.add(line);
		
	
		//return lines;
	}
	
	public void lineToString(){
		System.out.println("lines in List");
		for(int i = 0; i < lines.size(); i++){
			System.out.println(""+lines.get(i).getX1()+" "+lines.get(i).getY1()+" "+
								lines.get(i).getX2()+" "+lines.get(i).getY2());
		}
	}
	
	public ArrayList<City> NearestNeighbor(){
		ArrayList<City> notTraveled = new ArrayList<City>(cities);
		ArrayList<City> traveled = new ArrayList<City>();
		traveled.add(startCity);
		
		while(!notTraveled.isEmpty()){
			City c1 = traveled.get(traveled.size()-1);
			double shortest = findDistance(c1, notTraveled.get(0));
			int index = 0;
			for(int i = 1; i < notTraveled.size(); i++){
				double distance = findDistance(c1, notTraveled.get(i));
				if(shortest > distance){
					shortest = distance;
					index = i;
				}
			}
			notTraveled.get(index).setIsVisited(true);
			traveled.add(notTraveled.get(index));
			notTraveled.remove(index);
		}
		return traveled;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		FileInputStream inFile;
		FileWriter outFile;
		try {
			inFile = new FileInputStream(args[0]);
			outFile = new FileWriter(args[1]);
			readFile file = new readFile(inFile, outFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new GUI(lines);
	}
}


