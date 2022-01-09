package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<User> getUsers(){
		return userRepository.findAll();
	}

    public User getUser(Long id){
        return userRepository.getById(id);
    }

    public void addNewUser(User user) {
        Optional<User> userByUser_name = userRepository.
        findUserByUser_name(user.getUser_name());
        if (userByUser_name.isPresent()){
            throw new IllegalStateException("Username taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        } else throw new IllegalStateException("User with id " +id  + " does not exist");
    }

}
