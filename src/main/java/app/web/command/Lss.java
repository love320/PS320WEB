package app.web.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import app.web.SocketData;
import app.web.utils.IPortBean;

public class Lss {
	
	private String code = "lss";
	
	private SocketData sd ;
	
	public Lss(SocketData sd){
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
	
	//Z2-1373781622495-8585@172.16.209.12:8585-2#false#2013-07-14 02:00:22
	public IPortBean stringToIP(String row){
		String[] rows = row.split("#");
		if(rows.length < 1) return null;
		
		String[] keyipss = rows[0].split("-");
		if(keyipss.length != 4) return null;
		
		String[]  ipss = keyipss[2].split("@");
		if(ipss.length != 2) return null;
		
		String[] ipstr = ipss[1].split(":");
		if(ipstr.length != 2) return null;
		
		String key = rows[0];
		Integer proxy = Integer.parseInt(ipss[0]);
		String ip = ipstr[0];
		Integer port =Integer.parseInt(ipstr[1]);
		
		IPortBean bean = new IPortBean(proxy,ip,port,1);
		bean.setKey(rows[0]);//键值
		bean.setType(Integer.valueOf(keyipss[3]));
		bean.setStatus(Boolean.valueOf(rows[1]).booleanValue());
		bean.setTime(new Date(Long.valueOf(keyipss[1])));
		
		return bean;
	}
	

}
