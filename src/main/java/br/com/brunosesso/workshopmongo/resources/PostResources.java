package br.com.brunosesso.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunosesso.workshopmongo.domain.Post;
import br.com.brunosesso.workshopmongo.dto.PostDTO;
import br.com.brunosesso.workshopmongo.service.PostService;

@RestController
@RequestMapping(value = "/api/1.0/posts")
public class PostResources {
	
	@Autowired
	private PostService service; 
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll() {
		List<Post> listPost = service.findAll();
		
		List<PostDTO> listDTO = listPost.stream().map(p -> new PostDTO(p)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}