package org.couse.workshopmongo.resources;

import org.couse.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "maria", "@gmail");
        User alex = new User("2", "alex", "@gmail");
        List<User> list = new ArrayList<>(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}

