package org.reverside.bootcamp.ubereats.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	//creating a simple controller
	@RequestMapping("/api/hi")
	public String hi() {
		return "Hello World from Restful API";
	}
}
