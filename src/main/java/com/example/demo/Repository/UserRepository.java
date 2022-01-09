package com.example.demo.Repository;

import java.util.Optional;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("Select u from User u where u.user_name = ?1")
    Optional<User> findUserByUser_name(String username);

}
