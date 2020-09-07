package br.com.brunosesso.workshopmongo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunosesso.workshopmongo.domain.User;
import br.com.brunosesso.workshopmongo.dto.UserDTO;
import br.com.brunosesso.workshopmongo.repository.UserRepository;
import br.com.brunosesso.workshopmongo.service.UserService;
import br.com.brunosesso.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public User findById(String id) {
		Optional<User> optUser = repo.findById(id);
		
		return optUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public User addUser(User obj) {
		return repo.save(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
