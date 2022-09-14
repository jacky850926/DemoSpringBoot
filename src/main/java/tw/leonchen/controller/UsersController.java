package tw.leonchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.Users;
import tw.leonchen.model.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService uService;
	
	@GetMapping("/findusers1.controller")
	public List<Users> processFindUsersLikeAction1(){
		return uService.findUsers("o");
	}
	
	@GetMapping("/findusers2.controller")
	public List<Users> processFindUsersLikeAction2(){
		return uService.findByNameLike("%o%");
	}
	
//	此兩種寫法得到同一種效果
	
	@GetMapping("/findallusers.controller")
	public List<Users> processFindAllUsersAction(){
		return uService.findAll();
	}

}
