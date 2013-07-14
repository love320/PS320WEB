package app.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.web.command.Command;

@Controller
public class Manage {
	
	@Autowired
	private Command cmd;
	
	@RequestMapping("/homepage")
	public String homepage(Model model){
		model.addAttribute("pagetype", "homepage");
		return "homepage";
	}
	
	@RequestMapping("/server")
	public String pageServerSocket(Model model){
		List list = cmd.lss();
		model.addAttribute("list", list == null ? new ArrayList() :list);
		model.addAttribute("pagetype", "server");
		return "server";
	}
	
	@RequestMapping("/connection")
	public String pageConnection(Model model){
		List list = cmd.ls();
		model.addAttribute("list", list == null ? new ArrayList() :list);
		model.addAttribute("pagetype", "connection");
		return "connection";
	}
	
	@RequestMapping("/newserver")
	public ModelAndView newServer(Model model,Integer type,Integer proxy,String ip,Integer port){
		cmd.newServer(type, proxy, ip, port);
		return new ModelAndView("redirect:/server.do");
	}
	
	@RequestMapping("/kill")
	public ModelAndView kill(Model model,String key){
		cmd.kill(key);
		return new ModelAndView("redirect:/server.do");
	}
	
		
}
