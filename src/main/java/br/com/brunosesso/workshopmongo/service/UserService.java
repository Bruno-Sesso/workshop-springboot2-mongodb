package br.com.brunosesso.workshopmongo.service;

import java.util.List;

import br.com.brunosesso.workshopmongo.domain.User;
import br.com.brunosesso.workshopmongo.dto.UserDTO;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(String id);
	
	public User addUser(User obj);
	
	public User fromDTO(UserDTO objDTO);
}
