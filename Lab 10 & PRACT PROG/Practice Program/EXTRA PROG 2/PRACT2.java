// LAB PRACT2

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
 * <applet code="PRACT2" width="1200" height="600"></applet>
 * 
 */

public class PRACT2 extends Applet implements MouseListener,MouseMotionListener {
		String msg="";
		int x=50;
		int y=50;
	public PRACT2(){
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		msg="(x="+x+",y="+y+")";
		setForeground(Color.RED);
		repaint();
	}
	public void init() {
		setBackground(Color.BLACK);
	}
	public void start() {
		msg="Started";
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		msg="Mouse Clicked "+e.getClickCount()+" times";
		setForeground(Color.ORANGE);
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		msg = "Pressed At "+x+" "+y;
		setForeground(Color.BLUE);
		repaint();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		msg = "Released At "+x+" "+y;
		setForeground(Color.CYAN);
		repaint();
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		x=100;
		y=100;
		msg="Mouse Enterred";
		setForeground(Color.YELLOW);
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		x=100;
		y=100;
		setForeground(Color.GREEN);
		msg="Mouse Exited";
		repaint();
	}
	public void paint(Graphics g) {
		g.drawString(msg, x, y);
	}
}

