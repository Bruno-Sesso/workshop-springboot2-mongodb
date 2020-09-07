package br.com.brunosesso.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunosesso.workshopmongo.domain.User;
import br.com.brunosesso.workshopmongo.service.UserService;

@RestController
@RequestMapping(value = "/api/1.0/users")
public class UserResources {
	
	@Autowired
	private UserService service; 
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> listUser = service.findAll();
		if(listUser.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		
		return ResponseEntity.ok().body(listUser);
	}
}
