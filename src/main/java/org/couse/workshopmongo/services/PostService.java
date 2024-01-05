package org.couse.workshopmongo.services;

import org.couse.workshopmongo.domain.Post;
import org.couse.workshopmongo.repositories.PostRepository;
import org.couse.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;
    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);

        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new ObjectNotFoundException("Object not found");
        }
    }
    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }


}
