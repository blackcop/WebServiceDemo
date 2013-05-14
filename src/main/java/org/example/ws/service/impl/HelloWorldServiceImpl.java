package org.example.ws.service.impl;

import javax.jws.WebService;

import org.example.ws.service.HelloWorldService;

@WebService(endpointInterface = "org.example.ws.service.HelloWorldService", serviceName = "HelloWorldServiceImpl")
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String sayHelloWorld(String name) {
		if (name == null) {
			return "Hello World";
		} else {
			return "Hello " + name;
		}
	}
}
