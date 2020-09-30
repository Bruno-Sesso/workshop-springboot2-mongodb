package br.com.brunosesso.workshopmongo.service;

import java.util.Date;
import java.util.List;

import br.com.brunosesso.workshopmongo.domain.Post;

public interface PostService {
	
	public List<Post> findAll(); 
	
	public Post findById(String id);
	
	public List<Post> findByTitle(String text);
	
	public List<Post> search(String text, Date startDate, Date endDate);
}
