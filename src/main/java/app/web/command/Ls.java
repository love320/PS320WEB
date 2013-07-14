package app.web.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import app.web.SocketData;
import app.web.utils.IPortBean;

public class Ls {
	
	private String code = "ls";
	
	private SocketData sd ;
	
	public Ls(SocketData sd){
		this.sd = sd;
	}
	
	public List action(){
		String lss = sd.send(code);
		if(lss == null) return null;
		String[] lssrow = lss.split("\r\n");
		return iportlist(lssrow);
	}
	
	public List<IPortBean> iportlist(String[] lssrow){
		List<IPortBean> list = new ArrayList<IPortBean>();
		for(String sing : lssrow){
			IPortBean bean = stringToIP(sing);
			if(bean != null) list.add(bean);
		}
		return list;
	}
	
	//S1-1373785703420-kingdom.love320.com/183.62.141.12:22#false#2013-07-14 03:08:23
	public IPortBean stringToIP(String row){
		System.out.println(row);
		String[] rows = row.split("#");
		if(rows.length < 1) return null;
		
		String[] keyipss = rows[0].split("-");
		if(keyipss.length != 3) return null;
		
		String[] ipstr =keyipss[2].split(":");
		if(ipstr.length != 2) return null;
		
		String key = rows[0];
		String ip = ipstr[0];
		Integer port =Integer.parseInt(ipstr[1]);
		
		IPortBean bean = new IPortBean(null,ip,port,1);
		bean.setKey(rows[0]);//键值
		bean.setStatus(Boolean.valueOf(rows[1]).booleanValue());
		bean.setTime(new Date(Long.valueOf(keyipss[1])));
		
		return bean;
	}
	

}
