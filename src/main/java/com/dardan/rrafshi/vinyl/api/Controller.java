package com.dardan.rrafshi.vinyl.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public final class Controller
{
	@RequestMapping("/")
	public String index()
	{
		return "Hello World!";
	}
}
