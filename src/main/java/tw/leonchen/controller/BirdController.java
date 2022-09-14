package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.Bird;
import tw.leonchen.model.BirdService;

@RestController
public class BirdController {
	
	@Autowired
	private BirdService bService;
	
	@GetMapping("/birdinsert.controller")
	public Bird processInsertAction() {
		Bird b1 = new Bird();
		b1.setBname("angrybird");
		b1.setSize("L");
		b1.setColor("navy");
		b1.setAge(15);
		return bService.insert(b1);
	}
	
	@GetMapping("/birdinsert2.controller")
	public Bird processInsertAction2(@RequestBody Bird bird) {
		return bService.insert(bird);
	}
	
	@GetMapping("/birddelete.controller")
	public String processDeleteAction() {
		bService.deleteById(104);
		return "delete ok";
	}
	
	
	@GetMapping("/birdquerybyid.controller")
	public Bird processQueryById() {
		return bService.selectById(101);
	}
	
	@GetMapping("/birdquerybyid2.controller/{bid}")
	public Bird processQueryById2(@PathVariable("bid") Integer bid) {
		return bService.selectById(bid);
	}
	
	@GetMapping("/birdupdate.controller")
	public Bird processUpdateAction() {
		Bird b2 = new Bird();
		b2.setBid(103);
		b2.setBname("littlebird");
		b2.setSize("s");
		b2.setColor("silver");
		b2.setAge(3);
		return bService.update(b2);
	}
}
