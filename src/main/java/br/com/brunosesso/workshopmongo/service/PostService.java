package br.com.brunosesso.workshopmongo.service;

import java.util.List;

import br.com.brunosesso.workshopmongo.domain.Post;

public interface PostService {
	
	public List<Post> findAll(); 
	
	public Post findById(String id);
	
	public List<Post> findByTitle(String text);
}
