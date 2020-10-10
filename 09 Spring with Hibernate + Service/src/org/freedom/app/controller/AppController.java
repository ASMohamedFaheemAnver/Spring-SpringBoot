package org.freedom.app.controller;

import java.util.List;

import org.freedom.app.dao.ProductDAO;
import org.freedom.app.entity.Product;
import org.freedom.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	
	@Autowired
	private AppService appService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		List<Product> productList = appService.getProducts();
		model.addAttribute("products", productList);
		return "products";
	}
	
	@RequestMapping(value = "/add-product-form", method = RequestMethod.GET)
	public String addProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "add-product";
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product) {
		System.out.println(product);
		appService.addProduct(product);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update-product-form", method = RequestMethod.GET)
	public String updateProductForm(@RequestParam("id") int product_id, Model model) {
		Product product = appService.getProduct(product_id);
		model.addAttribute("product", product);
		return "add-product";
	}

}