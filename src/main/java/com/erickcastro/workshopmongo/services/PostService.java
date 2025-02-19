package com.erickcastro.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickcastro.workshopmongo.domain.Post;
import com.erickcastro.workshopmongo.repository.PostRepository;
import com.erickcastro.workshopmongo.services.exception.ObjectNoFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
	    return repo.findById(id)
	    .orElseThrow(() -> new ObjectNoFoundException("Objeto não encontrado para o ID: " + id));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime()+24*60*60*1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
