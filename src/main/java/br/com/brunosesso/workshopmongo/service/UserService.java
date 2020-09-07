package br.com.brunosesso.workshopmongo.service;

import java.util.List;

import br.com.brunosesso.workshopmongo.domain.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(String id);
}
