package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.Person;

@RestController
public class PersonController {
	
//	掃描 
	@Autowired
	private Person person;
	
	
//	找到此路徑 并使用get方法
	@GetMapping("/person.controller")
	public Person processAction() {
		return person;
	}

}
