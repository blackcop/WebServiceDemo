package org.example.ws.service;

import javax.jws.WebService;

@WebService
public interface HelloWorldService {

	public String sayHelloWorld(String a);
}
