import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import javax.swing.SwingUtilities;

public class ActionClass implements ActionListener {
	
	private GameControl gc;
	private TestObserver to;
	private static int undoCount;
	private Iterator<MacroCommand> mcIterator;
	
	public ActionClass(GameControl gc, TestObserver to){
		this.gc = gc;
		this.to = to;
		this.undoCount = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		int i = gc.getMcArray().size() - 1 - undoCount;
		
		switch(action){
		case "Start":
			System.out.println(action);
			gc.setPlay(true);
//			gc.getObservable().register(gc);
			break;
		case "Pause":
//			gc.getObservable().unregister(gc);
			System.out.println(action);
			gc.setPlay(false);
			break;
		case "Undo":
			System.out.println(action);
			MacroCommand mc = gc.getMcArray().get(i);
			mc.undo();
			undoCount++;
			break;
		case "Replay":
			System.out.println(action);
			mcIterator = gc.getMcArray().iterator();
			gc.reset();
			to.repaint();
			new Thread(){
				public void run(){
					while(mcIterator.hasNext()){
						MacroCommand mcReplay = mcIterator.next();
//						mcReplay.undo();
						try {
							SwingUtilities.invokeAndWait(new Runnable(){

								@Override
								public void run() {
									// TODO Auto-generated method stub
									mcReplay.undo();
									try {
										java.lang.Thread.sleep(30, 0);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								
							});
						} catch (InvocationTargetException | InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}.start();
			
			break;
		}
	}

}
