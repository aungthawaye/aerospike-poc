package com.gnomesys.aerospike;

import java.util.ArrayList;
import java.util.List;

import com.gnomesys.aerospike.domain.User;
import com.gnomesys.aerospike.service.UserService;

public class App {
	public static void main(String args[]) {
		UserService userService = new UserService();

		for (int i = 3000; i < 40000; i++) {

			User user = new User();
			user.setEmail("user" + i + "@somewhere.com");
			user.setName("User " + i);
			List<String> preferredHeroes = new ArrayList<>();
			preferredHeroes.add("Crystal Maiden");
			preferredHeroes.add("Void");
			preferredHeroes.add("Legion Commander");
			preferredHeroes.add("Wraith King");
			preferredHeroes.add("Slarder");
			user.setPreferredHeroes(preferredHeroes);

			userService.save(user);
		}
	}

}
