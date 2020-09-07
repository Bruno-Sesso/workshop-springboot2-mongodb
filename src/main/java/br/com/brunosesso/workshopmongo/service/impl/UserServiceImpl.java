package br.com.brunosesso.workshopmongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunosesso.workshopmongo.domain.User;
import br.com.brunosesso.workshopmongo.repository.UserRepository;
import br.com.brunosesso.workshopmongo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public List<User> findAll() {
		return repo.findAll();
	}
	
}
