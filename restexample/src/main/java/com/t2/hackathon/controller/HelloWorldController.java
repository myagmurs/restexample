package com.t2.hackathon.controller;

import com.t2.hackathon.model.Currency;
import com.t2.hackathon.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController {

	@Autowired
	private HelloWorldService helloWorldService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("msg", "Hello World!");
		return "helloWorld";
	}
	
	@RequestMapping(value = "/displayMessage/{msg}", method = RequestMethod.GET)
	public String displayMessage(@PathVariable String msg, ModelMap model) {
		model.addAttribute("msg", msg);
		return "helloWorld";
	}
	
	
	@RequestMapping(value = "/get-random-data/{msg}", method = RequestMethod.GET)
	public String getRandomCurrencyData(@PathVariable String msg, ModelMap model) {
	    model.addAttribute("msg", helloWorldService.getRandomCurrencies());
	    return "helloWorld";
	}
		
}
