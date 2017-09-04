import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MainClass extends JFrame {
	
	
	private JButton button1;
	private JTextArea textarea1;
	int buttonClicked;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass();
	}
	
	public MainClass() {
		this.setSize(400, 400);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		
		this.setLocation(xPos, yPos);
		
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("First Frame");
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("New Label 1");
		label1.setToolTipText("This is a tool tip");
		panel1.add(label1);
		
		button1 = new JButton("New Button");
		
		ListenForButton lForButton = new ListenForButton();
		
		button1.addActionListener(lForButton);
		
		panel1.add(button1);
		
		textarea1 = new JTextArea(15,20);
		textarea1.setText("Hello text area");
		panel1.add(textarea1);
		this.add(panel1);
		
		this.setVisible(true);
	}

	
	private class ListenForButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == button1){
				buttonClicked++;
				textarea1.append("Button Clicked" + buttonClicked);
			}
		}
		
	}
}


