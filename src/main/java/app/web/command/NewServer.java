package app.web.command;

import app.web.SocketData;

public class NewServer {
	
	private String code = "new";
	
	private SocketData sd ;
	
	public NewServer(SocketData sd){
		this.sd = sd;
	}
	
	public boolean action(){
		return true;
	}
	
	public boolean newServer(Integer type,Integer proxy,String ip,Integer port){
		String cmd = type+"@"+proxy+"@"+ip+":"+port;
		sd.send(code+" "+cmd);
		return true;
	}
	

}
