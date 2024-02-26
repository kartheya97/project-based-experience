package com.example.webapplication.todoapplication.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {

	private Logger log = LoggerFactory.getLogger(WelcomeController.class);
	
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String gotToWelcomePage(ModelMap model) {
		model.put("username", getLoggedInUsername());
		return "welcome";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext()
				                                             .getAuthentication();
		return authentication.getName();
	}


}
