package br.com.brunosesso.workshopmongo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunosesso.workshopmongo.domain.Post;
import br.com.brunosesso.workshopmongo.repository.PostRepository;
import br.com.brunosesso.workshopmongo.service.PostService;
import br.com.brunosesso.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository repo;
	
	@Override
	public List<Post> findAll() {
		return repo.findAll();
	}

	@Override
	public Post findById(String id) {
		Optional<Post> optPost = repo.findById(id);
		
		return optPost.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	@Override
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

	@Override
	public List<Post> search(String text, Date startDate, Date endDate) {
		endDate = new Date(endDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.search(text, startDate, endDate);
	}
}