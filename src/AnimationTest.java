import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
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
	static List<BrickBreak> bbl = new ArrayList<BrickBreak>();
	List<Brick> brickList = new ArrayList<Brick>();
	static Iterator<Move> li;
	static Iterator<BrickBreak> libb;
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
		for (Brick b : brickList){
			b.draw(g);
		}
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
//				li = al.listIterator();
				AnimationTest at = new AnimationTest();
				at.spawnbricks();
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
						BrickBreak undoBrick = bbl.get(at.runningTime - 1);
						undoBrick.undo();
						undoMove.undo();
						at.repaint();
						at.runningTime--;
						System.out.println(al.size());
						System.out.println(bbl.size());
					}
					
				});
				JButton replay = new JButton("Replay");
				replay.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						li = al.iterator();
						libb = bbl.iterator();
						while(libb.hasNext()){
							BrickBreak replayBrick = libb.next();
							replayBrick.undo();
						}
						libb = bbl.iterator();
						at.repaint();
						new Thread(){
							public void run(){
								while (li.hasNext() && libb.hasNext()){
									Move replayMove = (Move) li.next();
									BrickBreak replayBrick = libb.next();
//									System.out.println(replayMove.initX + " " +replayMove.initY);
//									replayMove.execute();
//									at.repaint();
									replayMove.undo();
									replayBrick.execute();
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
		Rectangle ballCollider = new Rectangle(b.getX(), b.getY(), 20, 20);
		Brick delBrick = brickList.get(0);
		Boolean hit = false;
		int posi = 0;
		for(Brick br : brickList){
			if(ballCollider.intersects(br.collider)){
				hit = true;
				delBrick = br;
				posi = brickList.indexOf(br);
			}
		}
		
		if (hit){
			BrickBreak bb = new BrickBreak(brickList, delBrick, posi, true);
			bb.execute();
			bbl.add(bb);
		}else{
			BrickBreak bb = new BrickBreak(brickList, delBrick, posi, false);
			bb.execute();
			bbl.add(bb);
		}
		
//		for (int i = 0; i < brickList.size(); i++){
//			Brick delBrick = brickList.get(i);
//			if(ballCollider.intersects(delBrick.collider)){
//				System.out.println("Intersect");
//				BrickBreak bb = new BrickBreak(brickList, delBrick, i, true);
//				bb.execute();
//				bbl.add(bb);
//			}
//		}
		
//		BrickBreak bb = new BrickBreak(brickList, delBrick, posi);
//		bb.execute();
//		bbl.add(bb);
		
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
	
	public void spawnbricks(){
		for(int x = 0; x < 16; x++){
			for(int y = 2; y < 8; y++ ){
				brickList.add(new Brick(x * 40, y*30));
			}
		}
	}

}
