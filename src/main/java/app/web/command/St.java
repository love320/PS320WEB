package app.web.command;

import app.web.SocketData;

public class St {
	
	private String code = "st";
	
	private SocketData sd ;
	
	public St(SocketData sd){
		this.sd = sd;
	}
	
	public boolean action(){
		String lss = sd.send(code);
		if(lss == null) return false;
		String[] lssrow = lss.split("\r\n");
		return Boolean.valueOf(lssrow[0]).booleanValue();
	}
	
	

}
