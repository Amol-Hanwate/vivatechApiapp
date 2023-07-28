package com.vivatechApiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vivatechApiapp.entiry.User;
import com.vivatechApiapp.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;

//    http://localhost:8080/vivatech/showLoginPage
    
    @RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "login/login";
	}
    
//  http://localhost:8080/vivatech/showReg
    @RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}
//  http://localhost:8080/vivatech/saveReg
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";
	}
//  http://localhost:8080/vivatech/verifyLogin

	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId,@RequestParam("password") String password, ModelMap modelMap ) {
		User user = userRepo.findByEmail(emailId);
		if(user!=null) {
		if(user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
			return "findUser";
		}else {
			modelMap.addAttribute("error", "Invalid Username/Password");
			return "login/login";
		}	
		}else {
			modelMap.addAttribute("error", "Invalid Username/Password");
			return "login/login";
		}
		
		}
}    
