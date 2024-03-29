package org.couse.workshopmongo.services;

import org.couse.workshopmongo.domain.User;
import org.couse.workshopmongo.dto.UserDTO;
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
    public User insert(User obj){
        return repository.insert(obj);
    }
    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user){
        User newObj = findById(user.getId());
        updateData(newObj, user);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User user) {
        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO dto){
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

}
