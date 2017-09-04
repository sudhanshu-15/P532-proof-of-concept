import javax.swing.JLabel;

public class TimeDisplay extends JLabel{
	
	private String text;
	
	public TimeDisplay(){
		text = "00:00";
		this.setText(text);
	}
	
	public void update(int runningTime){
		if (runningTime % 1000 == 0 ) {
			int currTime = runningTime/1000;
			int gameMin = currTime / 60;
			int gameSec = currTime % 60;
			String minText = (gameMin < 10 ? "0" : "") + gameMin;
			String secText = (gameSec < 10 ? "0" : "") + gameSec;
			text = minText + ":" + secText;
			this.setText(text);
		}
	}

}
