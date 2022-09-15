package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.UserProfiles;
import tw.leonchen.model.UserProfilesService;

@RestController
public class UserProfilesController {
	
	@Autowired
	private UserProfilesService upService;


	@PostMapping("/createuserprofiles.controller")
	public UserProfiles processCreateUserProfilesAction(@RequestBody UserProfiles up) {
//	    加密的方法 —> 將字串加密 在放入Javabean内
		String beEncode = new BCryptPasswordEncoder().encode(up.getPassword());
		up.setPassword(beEncode);
		return upService.createUserProfiles(up);
	}

}
