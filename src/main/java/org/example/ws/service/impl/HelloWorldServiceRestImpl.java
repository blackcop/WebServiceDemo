package org.example.ws.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.example.ws.bean.Student;

@Path("/student")
@Produces("application/json")
public class HelloWorldServiceRestImpl {

	@GET
	@Path("/getstudent")
	@Produces({ "application/json" })
	public Student getStudent() {
		Student student = new Student("ABC", "Male");
		return student;
	}
}
