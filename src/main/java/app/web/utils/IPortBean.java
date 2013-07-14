package app.web.utils;

import java.util.Date;

public class IPortBean {
	
	private String ip = "127.0.0.1"; //目标ip
	private Integer port = 22;//目标端口
	private Integer proxy = 22;//服务端口
	private Integer type = 1;// 1.普通代理 2.逆向代理
	
	private String key;
	private Date time;
	private boolean status = false;
	
	public static IPortBean reverseProxy(Integer proxy,String ip,Integer port ){
		return new IPortBean(proxy, ip, port,2);
	}
	
	public static IPortBean proxy(Integer proxy,String ip,Integer port ){
		return new IPortBean(proxy, ip, port,1);
	}

	public IPortBean(Integer proxy,String ip,Integer port , Integer type ){
		this.ip= ip;
		this.port =port;
		this.proxy = proxy;
		this.type = type;
	}
	
	public IPortBean(Integer proxy,String ip,Integer port ){
		this.ip= ip;
		this.port =port;
		this.proxy = proxy;
	}
	
	public IPortBean(String ip,Integer port ){
		this.ip= ip;
		this.port =port;
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

	public Integer getProxy() {
		return proxy;
	}

	public void setProxy(Integer proxy) {
		this.proxy = proxy;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
