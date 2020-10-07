package org.freedom.app.controller;

import java.util.List;

import org.freedom.app.dao.ProductDAO;
import org.freedom.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	
	@Autowired
	private ProductDAO products;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		List<Product> productList = products.getProducts();
		model.addAttribute("products", productList);
		return "products";
	}

}