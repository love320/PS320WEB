package app.web.command;

import app.web.SocketData;

public class Kill {
	
	private String code = "kill";
	
	private SocketData sd ;
	
	public Kill(SocketData sd){
		this.sd = sd;
	}
	
	public boolean action(String key){
		sd.send(code+" "+key);
		return true;
	}
	

}
