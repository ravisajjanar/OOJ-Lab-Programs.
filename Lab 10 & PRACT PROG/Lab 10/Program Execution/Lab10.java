import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Lab10 extends Frame implements ActionListener{
	TextField t1,t2;
	String msg="";
	Button btn;
	Lab10(){
		Label l1 = new Label("First Number: ",Label.RIGHT);
		t1 = new TextField(10);
		Label l2 = new Label("Second Number: ",Label.RIGHT);
		
		t2 = new TextField(10);
		btn = new Button("Submit");
		//Label l = new Label("Updates:");
		l1.setBackground(Color.YELLOW);
		l2.setBackground(Color.YELLOW);
		//this.setResizable(false);
		this.add(l1);
		this.add(t1);
		this.add(l2);
		this.add(t2);
		//the following command will make sure that the input char is not visible to the user 
		//(it has been added just to demonstrate). Can be used for passwords.
		//t1.setEchoChar('*');
		//t2.setEchoChar('#');
		this.add(btn,BorderLayout.CENTER);
		this.setVisible(true);
		this.setSize(600, 300);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		//t1.addActionListener(this);
		btn.addActionListener(this);
		addWindowListener(new MyWindow());
		setBackground(Color.YELLOW);
		//System.out.println(BorderLayout.CENTER);
	}
	@Override
	public Insets getInsets() {
		return new Insets(50,10,10,20);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		String st1 = t1.getText();
		String st2 = t2.getText();
		double n1,n2;
		n1 = 0.0;
		n2 = 0.0;
		if(st1.equals("")||st2.equals("")) {

			msg="You cannot leave the text elements blank";
		}else{
			try {
				n1 = Double.parseDouble(st1);
				n2 = Double.parseDouble(st2);
				try {
					double res = n1/n2;
					msg = "Result of division: "+res;
				}catch(ArithmeticException e1) {
					msg = e1.toString();
				}
			}catch(NumberFormatException e2) {
				msg = "Enter only numbers and not other things";
			}
		}
		new MyDialog(this,"Result Dialog",false,msg,n1,n2);
	}
	public static void main(String[] args) {
		new Lab10();
	}
}

class MyDialog extends Dialog implements ActionListener{

	public MyDialog(Frame owner, String title, boolean modal,String msg, double n1, double n2) {
		super(owner, title, modal);
		this.setVisible(true);
		this.setSize(300, 400);
		this.setLayout(new FlowLayout());
		//System.out.println(owner);
		Label l1 = new Label("          Updates on the result:          ");
		//l1.setSize(300, 20);
		this.add(l1);
		this.add(new Label("First Number: "+n1));
		this.add(new Label("Second Number: "+n2));
		this.add(new Label(msg));
		
		Button b = new Button("Close");
		this.add(b);
		b.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		
	}
	
	
}

class MyWindow extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}