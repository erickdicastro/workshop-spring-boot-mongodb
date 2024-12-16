package com.erickcastro.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erickcastro.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User erick = new User("1", "erick castro", "erickcastro123@gmail.com");
		User mara = new User ("2", "mara castro", "maradicastro123@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(erick, mara));
		return ResponseEntity.ok().body(list);
	}
}
