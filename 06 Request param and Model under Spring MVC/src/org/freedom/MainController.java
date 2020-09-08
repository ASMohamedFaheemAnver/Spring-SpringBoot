package org.freedom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "hello";
	}
	
	// @RequestMapping("display-name")
	@RequestMapping(value="/display-name")
	public String displayName(@RequestParam("first_name") String firstName, Model model) {
		
		model.addAttribute("first_name", firstName);
		return "display-name";
	}
}  