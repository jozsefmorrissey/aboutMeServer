package com.aboutMe.server.utils;

import java.security.SecureRandom;

import com.goebl.david.Response;
import com.goebl.david.Webb;

public class GenUtils {

	public static String randStringSecure(int length) {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[length];
		random.nextBytes(bytes);
		String token = bytes.toString();
		return token;
	}
	
	public static String getPassword(String identifier) {
		Webb webb = Webb.create();
		Response<String> req = webb.post("http://localhost:9000/password/get")
		        .param("groupIdentifier", "aboutMe")
		        .param("passwordIdentifier", identifier)
		        .ensureSuccess()
		        .asString();
		
		String password = req.getBody();
		password = password.substring(1, password.length() - 3);

		return password;
	}
	
	public static String getIdentifer() {
		Webb webb = Webb.create();
		Response<String> req = webb.post("http://localhost:9000/get")
		        .param("groupIdentifier", "aboutMe")
		        .ensureSuccess()
		        .asString();
		
		String password = req.getBody();

		return password;
	}
}
