package com.propecta.assignment;
/*

Create an API that lists the title, description based on the category passed as an input parameter.
Create an API that would save a new entry with all the relevant properties which retrieves values from the endpoint GET /entries.
Question: what are the key things you would consider when creating/consuming an API to ensure that it is secure and reliable?

 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

}
