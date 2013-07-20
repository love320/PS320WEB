package app.web.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.web.SocketData;

@Component
public class Command {
	
	@Autowired
	private SocketData sd ;
	
	public List lss(){
		Lss lss = new Lss(sd);
		return lss.action();
	}
	
	public List ls(){
		Ls ls = new Ls(sd);
		return ls.action();
	}
	
	// 1@9999@113.243.142.23:9999
	public boolean newServer(Integer type,Integer proxy,String ip,Integer port){
		NewServer newServer = new NewServer(sd);
		newServer.newServer(type, proxy, ip, port);
		return true;
	}
	
	public boolean kill(String key){
		Kill kill = new Kill(sd);
		kill.action(key);
		return true;
	}
	
	public boolean st(){
		St ls = new St(sd);
		return ls.action();
	}
	
	
}
