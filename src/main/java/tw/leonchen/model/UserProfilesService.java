package tw.leonchen.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.leonchen.exception.UserNotFoundException;

@Service
@Transactional
public class UserProfilesService {
	
	@Autowired
	private UserProfilesRepository upResp;
	
	public UserProfiles findByName(String name)   {
		Optional<UserProfiles> op = upResp.findByName(name);
		
		if(op.isEmpty()) {
			throw new UserNotFoundException("Can't find User");
		}
		
		return op.get();
	}
	
	public UserProfiles createUserProfiles(UserProfiles up) {
		return upResp.save(up);
	}

}
