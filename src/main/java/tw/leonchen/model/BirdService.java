package tw.leonchen.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BirdService {
	
	@Autowired
	private BirdRepository birdResp;
	
	public Bird insert(Bird bird) {
		return birdResp.save(bird);
	}
	
	public Bird update(Bird bird) {
		return birdResp.save(bird);
	}
	
	public void deleteById(Integer id) {
		birdResp.deleteById(id);
	}
	
	public Bird selectById(Integer id) {
		Optional<Bird> optional = birdResp.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

}
