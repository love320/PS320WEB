package app.web;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketData {
	
	private String ip;
	private Integer port;
	
	public static Socket socket = null;
	
	public SocketData(){}
	
	public SocketData(String ip,Integer port){
		this.ip = ip;
		this.port = port;
	}
	
	public boolean isClosed(){
		if(socket == null || socket.isClosed()){
			return newSocket();
		}
		return false;
	}
	
	public boolean newSocket(){
		try {
			socket = new Socket(ip,port);
			socket.setSoTimeout(3000);
			return false;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public synchronized String send(String cmd){
		if(isClosed()) return null;
		if(!write(cmd)) return null;//发命令
		return read();//获取信息
	}
	
	public boolean write(String cmd){
		try {
			DataOutputStream out =new DataOutputStream(socket.getOutputStream());
			out.write(cmd.getBytes());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		socket = null;//设置为空，重新连接
		return false;
	}
	
	public String read(){
		try {
			InputStream in =socket.getInputStream();
			byte[] buffer = new byte[1024];   
			int temp = 0;   
			temp = in.read(buffer);
			if(temp==-1) return null;
			String msg =new String(buffer,0,temp);
			return msg;
		} catch (IOException e) {
			e.printStackTrace();
		}
		socket = null;//设置为空，重新连接
		return null;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	
	
	

}
