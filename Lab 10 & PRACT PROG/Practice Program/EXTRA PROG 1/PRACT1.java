//Lab Program-1

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * <applet code="PRACT1" width="1200" height="600"></applet>
 * 
 */

public class PRACT1 extends Frame implements MouseListener,MouseMotionListener{
	String msg = "";
	int x = 0,y = 0;
	public PRACT1(){
		addMouseListener(this);
		addMouseMotionListener(this);
		this.setBackground(Color.BLACK);
		addWindowListener(new MyWindow());
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		msg="mouse clicked "+e.getClickCount()+" times";
		setForeground(Color.ORANGE);
		repaint();
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		x = getWidth()/2;
		y = getHeight()/2;
		setForeground(Color.YELLOW);
		msg = "mouse entered";
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		x = 100;
		y = 100;
		setForeground(Color.GREEN);
		msg = "mouse exited";
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		msg = "Pressed at "+x+" "+y;
		setForeground(Color.BLUE);
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		setForeground(Color.RED);
		msg = "x = "+x+"y = "+y;
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString(msg,x,y);
	}
	public static void main(String[] args) {
		PRACT1 s = new PRACT1();
		s.setSize(300, 300);
		s.setVisible(true);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		msg = "Mouse Released "+x+" "+y;
		setForeground(Color.CYAN);
		repaint();
	}
	
}

class MyWindow extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		System.exit(0);
	}
}
