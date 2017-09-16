import java.awt.Graphics;
import java.util.ArrayList;

public class BrickList {

	private ArrayList<Brick> brickL;
	
	public ArrayList<Brick> getBrickL() {
		return brickL;
	}

	public void setBrickL(ArrayList<Brick> brickL) {
		this.brickL = brickL;
	}

	public BrickList(){
		brickL = new ArrayList<Brick>();
		for(int x = 0; x < 16; x++){
			for(int y = 2; y < 8; y++ ){
				brickL.add(new Brick(x * 40, y*30));
			}
		}
	}
	
	public void draw(Graphics g){
		for(Brick b : brickL){
			if(!b.isDead()){
				b.draw(g);
			}
		}
	}
	
	public void reset(){
		for(Brick b : brickL){
			b.setDead(false);
		}
	}
	
}
