package tw.leonchen.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//有了這句話之後，我就能帶入到yml的 profiles裏面json資料
@ConfigurationProperties(prefix = "profiles")
public class PersonalProfiles {
	
	private String username;
	private String address;
	private String phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
