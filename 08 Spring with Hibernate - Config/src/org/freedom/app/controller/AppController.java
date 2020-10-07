package org.freedom.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "hello";
	}

	// @RequestMapping("display-name")
	// @RequestMapping(value="/display-name")
	// Only get method can be executed
	@GetMapping("display-name")
	public ModelAndView displayName(@RequestParam("first_name") String firstName) {
		ModelAndView modelAndView = new ModelAndView("display-name");
		Date date = new Date();
		List<String> names = new ArrayList<>();
		names.add("FreeDoM");
		names.add("Drago");
		modelAndView.addObject("date", date);
		modelAndView.addObject("first_name", firstName);
		modelAndView.addObject("team", names);
		return modelAndView;
	}
}