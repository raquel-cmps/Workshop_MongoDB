package org.couse.workshopmongo.services;

import org.couse.workshopmongo.domain.User;
import org.couse.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();//vai no banco e retorna todos os objetos do tipo User
    }
}
