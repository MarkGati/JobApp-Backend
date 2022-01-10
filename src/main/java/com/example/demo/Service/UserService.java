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

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
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

    public Object findById(long id) {
        return null;
    }

    public Optional<User> authentification(String username, String password){
        Optional<User> user = userRepository.findUserByUser_name(username);
        if (user != null){
            if (user.get().password.equals(password)){
                return user;
            }
        }
        return null;
    }

}
