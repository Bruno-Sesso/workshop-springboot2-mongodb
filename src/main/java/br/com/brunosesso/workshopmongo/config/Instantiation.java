package br.com.brunosesso.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.brunosesso.workshopmongo.domain.User;
import br.com.brunosesso.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User bruno = new User(null, "Bruno Sesso", "bruno.sesso@gmail.com");
		User paula = new User(null, "Paula Pereira", "paula.ph@gmail.com");
		User maria = new User(null, "Maria Eduarda", "maria.eduarda@gmail.com");
		
		userRepository.saveAll(Arrays.asList(bruno, paula, maria));
	}

}
