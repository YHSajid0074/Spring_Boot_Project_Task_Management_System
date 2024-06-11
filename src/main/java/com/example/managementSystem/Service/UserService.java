package com.example.managementSystem.Service;

import com.example.managementSystem.Dtos.UserDto;
import com.example.managementSystem.Entity.Task;
import com.example.managementSystem.Entity.User;
import com.example.managementSystem.Exception.EmailAlreadyExists;
import com.example.managementSystem.Exception.NoUserExists;
import com.example.managementSystem.Repository.CustomUserResponseDTO;
import com.example.managementSystem.Repository.TaskRepo;
import com.example.managementSystem.Repository.UserRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;


@Service
@Data

public class UserService {
    UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public User createUser(UserDto userdto) {

        User email=userRepo.findByEmail(userdto.email());
     if(email!=null){
         throw new EmailAlreadyExists("Email Already Exists");
     }
        User user=new User();
        user.setFirstName(userdto.firstName());
        user.setLastName(userdto.lastName());
        user.setEmail(userdto.email());
        user.setPassword(userdto.password());
        user.setUsername(userdto.username());
        return userRepo.save(user);
    }
    public User findUserById(int id) {
        User user = userRepo.findById(id).orElseThrow(
                ()->new NoUserExists("User","id",id)
        )
                ;
        return user;
    }
    public List<User> findall() {
        return  userRepo.findAll();
    }
    public User updateUser(int id, UserDto userDto) {
        User existingUser = userRepo.findById(id).orElseThrow(
                ()->new NoUserExists("User","id",id)
        );
        existingUser.setFirstName(userDto.firstName());
        existingUser.setLastName(userDto.lastName());
        existingUser.setEmail(userDto.email());
        existingUser.setPassword(userDto.password());
        existingUser.setUsername(userDto.username());
        return userRepo.save(existingUser);
    }

    public String deleteuser(int id){
         userRepo.findById(id).orElseThrow(
                ()->new NoUserExists("User","id",id)
        );
        userRepo.deleteById(id);
        return "successfully deleted";
    }

   public  Set<CustomUserResponseDTO> findAllUsers(){
        return userRepo.findAllUsers();
   }

    public String asyncMethod() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "i am a big data";
    }


}
