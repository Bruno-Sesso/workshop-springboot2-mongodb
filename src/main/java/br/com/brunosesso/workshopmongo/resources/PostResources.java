package br.com.brunosesso.workshopmongo.resources;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunosesso.workshopmongo.domain.Post;
import br.com.brunosesso.workshopmongo.dto.PostDTO;
import br.com.brunosesso.workshopmongo.resources.util.URL;
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
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/search")
	public ResponseEntity<List<Post>> search(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "startDate", defaultValue = "") String startDate,
			@RequestParam(value = "endDate", defaultValue = "") String endDate) {
		
		text = URL.decodeParam(text);
		Date start = URL.convertDate(startDate, new Date(0));
		Date end = URL.convertDate(endDate, new Date());
		
		List<Post> list = service.search(text, start, end);
		
		return ResponseEntity.ok().body(list);
	}
}