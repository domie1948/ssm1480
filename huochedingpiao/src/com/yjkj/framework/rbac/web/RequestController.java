package com.yjkj.framework.rbac.web;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.rbac.about.model.About;
import com.yjkj.framework.rbac.about.service.inte.AboutService;
import com.yjkj.framework.rbac.custom.model.Custom;
import com.yjkj.framework.rbac.custom.service.inte.CustomService;
import com.yjkj.framework.rbac.functionInfo.service.impl.FunctionServiceImpl;
import com.yjkj.framework.rbac.functionInfo.service.inte.FunctionService;
import com.yjkj.framework.rbac.introduce.model.Introduce;
import com.yjkj.framework.rbac.introduce.service.inte.IntroduceService;
import com.yjkj.framework.rbac.notice.model.Notice;
import com.yjkj.framework.rbac.notice.service.inte.NoticeService;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.impl.RoleInfoServiceImpl;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;


@Controller
@RequestMapping("/request")
public class RequestController {

	@Autowired
	private RoleInfoService ris = new RoleInfoServiceImpl();

	@Autowired
	private FunctionService fs = new FunctionServiceImpl();
	
	@Autowired
	private CustomService customService;
	
	@Autowired
	private AboutService aboutService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private IntroduceService introduceService;
	
	@RequestMapping("/login")
	public String login() throws IOException {
		return "jsp/Login";
		
	}
	
	@RequestMapping("/welcome")
	public String welcome(Model model) throws IOException {
		try {
			Introduce introduce = new Introduce();
			Notice notice = new Notice();
			About about = new About();
			introduce.setId("1");
			notice.setId("1");
			about.setId("1");
			model.addAttribute("introduce", this.introduceService.informationLoadOne(introduce));
			model.addAttribute("about", this.aboutService.informationLoadOne(about));
			model.addAttribute("notice", this.noticeService.informationLoadOne(notice));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/foreground/Welcome";
		
	}
	@RequestMapping("/index")
	public String main() {
		return "jsp/iframemain";
	}
	
	@RequestMapping("/passUpdate")
	public String passUpdate(String id,Model model) {
		model.addAttribute("id", id);
		return "jsp/PassUpdate";
	}
	@RequestMapping("/right")
	public String index() {
		return "jsp/index";
	}
	
	@RequestMapping("/top")
	public String top() {
		return "jsp/top";
	}
	@RequestMapping("/sign")
	public String sign() {
		return "jsp/foreground/sign";
	}
	
	@RequestMapping("/updateUserPassword")
	public String updateUserPassword() {
		return "jsp/foreground/Password";
	}
	
	@RequestMapping("/userAdd")
	public String userAdd(Model model){
		try{
		List<RoleInfo> list = this.ris.query();
		model.addAttribute("role", list);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/UserAdd";
	}
	
	@RequestMapping("/functionAdd")
	public String functionAdd(){
		return "jsp/FunctionAdd";
	}
	@RequestMapping("/messageAddFore")
	public String messageAddFore(){
		return "jsp/foreground/MessageAdd";
	}
	@RequestMapping("/roleAdd")
	public String roleAdd(Model model){
		model.addAttribute("function", this.fs.query());
		return "jsp/RoleAdd";
	}
	
	@RequestMapping("/bargainAdd")
	public String bargainAdd(String informationId,Model model,HttpSession session){
		try {
		UserInfo userInfo = new UserInfo();
		userInfo = (UserInfo) session.getAttribute("User");
		Custom custom = new Custom();
		custom.setUser_id(userInfo.getId());
			model.addAttribute("customList",customService.informationLoadAll(custom));
			model.addAttribute("informationId", informationId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/foreground/BargainAdd";
	}
	
	@RequestMapping("/customAdd")
	public String customAdd(){
		return "jsp/foreground/CustomAdd";
	}
	@RequestMapping("/informationAdd")
	public String informationAdd(){
		return "jsp/InformationAdd";
	}
}
