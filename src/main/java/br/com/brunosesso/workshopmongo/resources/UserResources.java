package br.com.brunosesso.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunosesso.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/api/1.0/users")
public class UserResources {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User paula = new User("1", "Paula", "paula@gmail.com");
		User bruno = new User("1", "Bruno", "bruno@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(paula, bruno));
		
		return ResponseEntity.ok().body(list);
	}
}
