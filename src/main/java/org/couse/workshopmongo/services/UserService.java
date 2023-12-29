package org.couse.workshopmongo.services;

import org.couse.workshopmongo.domain.User;
import org.couse.workshopmongo.repositories.UserRepository;
import org.couse.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();//vai no banco e retorna todos os objetos do tipo User
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);

        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new ObjectNotFoundException("Object not found");
        }
    }

}
