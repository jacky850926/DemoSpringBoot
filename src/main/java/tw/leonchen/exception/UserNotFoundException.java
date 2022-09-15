package tw.leonchen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//當出現找不到的時候 會產生的Excpetion-Page
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

//	只是序列化
	private static final long serialVersionUID = 1L;
	
	
	public UserNotFoundException() {
	}
	
	

	public UserNotFoundException(String message) {
		super(message);
	}

}
