import java.util.ArrayList;

public class MacroCommand implements Command {
	
	private ArrayList commands;
	
	public MacroCommand(){
		commands = new ArrayList<Command>();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for (int i = 0; i < commands.size(); i++){
			Command c = (Command) commands.get(i);
			c.execute();
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for (int i = 0; i < commands.size(); i++){
			Command c = (Command) commands.get(i);
			c.undo();
		}
	}
	
	public void add(Command c){
		commands.add(c);
	}
	
	public void remove(Command c){
		int i = commands.indexOf(c);
		commands.remove(i);
	}

}
