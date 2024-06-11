package com.example.managementSystem.Repository;

import com.example.managementSystem.Entity.User;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepo extends  JpaRepository<User, Integer> {
    @Query("""
         SELECT
                user
            FROM User user
        """)
    Set<CustomUserResponseDTO> findAllUsers();


    @Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);
}
