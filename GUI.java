package travlingSalesman;

import java.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
	
	private ArrayList<Line2D> list;
	
	GUI(ArrayList<Line2D> list){
		this.list = list;
		setSize(500, 700);
		setBackground(Color.WHITE);
		this.add(new second());
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public class second extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			Graphics2D g2 = (Graphics2D) g;
			//Line2D line = new Line2D.Double(0, 30, 600, 40);
			
			for(int i = 0; i < list.size(); i++){
				double x1, x2, y1, y2;
				x1 = list.get(i).getX1()/5+300;//*20+600;
				x2 = list.get(i).getX2()/5+300;//*20+600;
				y1 = list.get(i).getY1()/5+300;//*20+300;
				y2 = list.get(i).getY2()/5+300;//*20+300;
				Line2D line = new Line2D.Double(x1, y1, x2, y2);
				Rectangle2D rec = new Rectangle2D.Double(x2, y2, 5, 5);
				g2.draw(line);
				g2.draw(rec);
			}
		}
	}
	
}
