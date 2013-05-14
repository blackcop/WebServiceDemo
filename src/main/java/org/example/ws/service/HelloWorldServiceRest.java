package org.example.ws.service;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.example.ws.bean.Student;

@WebService
public interface HelloWorldServiceRest {

	@GET
	@Path("/student/getstudent")
	public Student getStudent();
}
