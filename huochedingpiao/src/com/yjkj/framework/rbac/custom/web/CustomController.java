package com.yjkj.framework.rbac.custom.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.custom.model.Custom;
import com.yjkj.framework.rbac.custom.service.inte.CustomService;

@Controller
@RequestMapping("/custom")
public class CustomController {
	
	@Autowired
	private CustomService customService;
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Custom Custom,HttpSession session) {
		try {
		pager = this.customService.informationLoad(pager,Custom,session);
		model.addAttribute("customList", pager);
		model.addAttribute("custom", Custom);
		return "jsp/CustomTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	@RequestMapping("/informationLoadFore")
	public String informationLoadFore(Pager pager,Model model,Custom Custom,HttpSession session) {
		try {
		pager = this.customService.informationLoadFore(pager,Custom,session);
		model.addAttribute("customList", pager);
		return "jsp/foreground/CustomTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Custom Custom,Model model) {
		
		try {
			Custom = this.customService.informationLoadOne(Custom);
			model.addAttribute("custom", Custom);
			return "jsp/Custom";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneFore")
	public String informationLoadOneFore(Custom Custom,Model model) {
		
		try {
			Custom = this.customService.informationLoadOne(Custom);
			model.addAttribute("custom", Custom);
			return "jsp/foreground/Custom";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Custom Custom,Model model) {
		
		try {
			
			this.customService.informationAdd(Custom);
			return "redirect:informationLoadFore";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	@RequestMapping("/informationDelete")
	public String informationDelete(Custom Custom,Model model) {
		
		try {
			this.customService.informationDelete(Custom);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDeleteFore")
	public String informationDeleteFore(Custom Custom,Model model) {
		
		try {
			this.customService.informationDelete(Custom);
			return "redirect:informationLoadFore";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Custom Custom,Model model) {
		
		try {
			this.customService.informationUpade(Custom);
			return "redirect:informationLoadFore";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
