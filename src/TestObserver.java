import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestObserver extends JPanel{
	
	private Ball b;
	private Paddle p;
	private GameObservable go;
	private GameControl gc;
	private PaddleKey pk;
	private Boolean play;
	public  Boolean getPlay() {
		return play;
	}

	public void setPlay(Boolean play) {
		this.play = play;
	}

	private BrickList bl;
	private ActionClass ac;
	
	public TestObserver(){
		b = new Ball(120, 10, -5, -5, Color.blue);
		bl = new BrickList();
		p = new Paddle(300, 500);
		go = new GameObservable();
		gc = new GameControl(b, p, bl, go);
		pk = new PaddleKey(p);
		ac = new ActionClass(gc, this);
		this.play = true;
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		b.draw(g);
		p.draw(g);
		bl.draw(g);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestObserver to = new TestObserver();
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
//				to.addKeyListener(to);
				
				JFrame jf = new JFrame();
				jf.setSize(600,600);
				jf.setTitle("Animation");
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setFocusable(true);
				jf.add(to);
				to.addKeyListener(to.pk);
				to.requestFocusInWindow();
				to.setFocusable(true);
				to.setFocusTraversalKeysEnabled(false);
				JButton start = new JButton("Start");
				start.setFocusable(false);
				start.addActionListener(to.ac);
				start.setActionCommand("Start");
				JButton pause = new JButton("Pause");
				pause.setFocusable(false);
				pause.addActionListener(to.ac);
				pause.setActionCommand("Pause");
				JButton undo = new JButton("Undo");
				undo.setFocusable(false);
				undo.addActionListener(to.ac);
				undo.setActionCommand("Undo");
				JButton replay = new JButton("Replay");
				replay.setFocusable(false);
				replay.addActionListener(to.ac);
				replay.setActionCommand("Replay");
				to.add(start);
				to.add(pause);
				to.add(undo);
				to.add(replay);
			}
			
		});
		
		
		
		new Thread(){
			public void run(){
				while(to.play){
					to.go.frameChanged();
					to.repaint();
					try {
						java.lang.Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
	}

//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("Hello");
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}

}
