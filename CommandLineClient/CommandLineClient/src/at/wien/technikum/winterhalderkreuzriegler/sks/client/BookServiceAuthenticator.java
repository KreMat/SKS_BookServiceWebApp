package at.wien.technikum.winterhalderkreuzriegler.sks.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class BookServiceAuthenticator {

	private BookServiceAuthenticator() {
	}

	public static void setAsDefault(String username, String password) {
		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password.toCharArray());
			}
		});
	}

}
