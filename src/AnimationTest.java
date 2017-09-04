import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class AnimationTest extends JPanel implements ActionListener {
	
	Timer tm = new Timer(30, this);
	int velX = -10, velY = -10;
	static List<Move> al = new ArrayList<Move>();
	static ListIterator li;
	static boolean play = false;
	static int i;
	
	
	private int runningTime = 0;
	
	Ball b = new Ball(120, 10, velX, velY, Color.blue);
//	Ball b1 = new Ball(11, 120, -2, -1, Color.GREEN);
//	TimeDisplay td = new TimeDisplay();
	
//	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		b.draw(g);
////		b1.draw(g);
////		this.add(td);
////		tm.start();
//	}
	
	public void paint(Graphics g){
		super.paint(g);
		b.draw(g);
//		b1.draw(g);
//		this.add(td);
//		tm.start();
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
//				li = al.listIterator();
				AnimationTest at = new AnimationTest();
				JFrame jf = new JFrame();
				jf.setSize(600,600);
				jf.setTitle("Animation");
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JButton start = new JButton("Start");
				start.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						play = !play;
						if(play){
							start.setText("Pause");
							at.tm.start();
						}else{
							start.setText("Start");
							
							at.tm.stop();
						}
					}
					
				});
				JButton undo = new JButton("Undo");
				undo.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Move undoMove = al.get(at.runningTime-1);
						undoMove.undo();
						at.repaint();
						at.runningTime--;
					}
					
				});
				JButton replay = new JButton("Replay");
				replay.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						li = al.listIterator();
						new Thread(){
							public void run(){
								while (li.hasNext()){
									Move replayMove = (Move) li.next();
									System.out.println(replayMove.initX + " " +replayMove.initY);
//									replayMove.execute();
//									at.repaint();
									replayMove.undo();
									try {
										SwingUtilities.invokeAndWait(new Runnable(){
											@Override
											public void run() {
												// TODO Auto-generated method stub
												
												at.repaint();
												try {
													java.lang.Thread.sleep(30, 0);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											}	
										});
									} catch (InvocationTargetException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}.start();
					}
				});
				at.add(start);
				at.add(undo);
				at.add(replay);
				jf.add(at);
			}
			
		});
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		runningTime ++;
//		td.update(runningTime);
		b.checkBounds(this.getWidth() - 20, this.getHeight() - 20);
		Move m = new Move(b);
		m.execute();
		al.add(m);
		
//		b1.checkBounds(this.getWidth() - 20, this.getHeight() - 20);
//		if (b.getX() < 0 || b.getX() > 550){
//			b.setVelX(-b.getVelX());
//		}
//		if (b.getY() < 0 || b.getY() > 559){
//			b.setVelY(-b.getVelY());
//		}
//		if (b1.getX() < 0 || b1.getX() > 550){
//			b1.setVelX(-b1.getVelX());
//		}
//		if (b1.getY() < 0 || b1.getY() > 559){
//			b1.setVelY(-b1.getVelY());
//		}
//		b.setY(b.getY() + b.getVelY());
//		b.setX(b.getX() + b.getVelX());
//		b1.setY(b1.getY() + b1.getVelY());
//		b1.setX(b1.getX() + b1.getVelX());
		repaint();
	}

}
