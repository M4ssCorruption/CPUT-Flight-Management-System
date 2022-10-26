package za.ac.cput.flightmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.flightmanagementsystem.domain.User;
import za.ac.cput.flightmanagementsystem.exception.NotFoundException;
import za.ac.cput.flightmanagementsystem.repository.IUserRepository;

import java.util.List;

@Service
public class UserServiceImpl {

    private final IUserRepository userRepository;

    @Autowired

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);

    }
    public User findByUserId(Long id){
        return userRepository.findUserById(id).orElseThrow(
                ()->new NotFoundException("User by id "+id+" was not found"));
    }
    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username).orElseThrow(
                ()->new NotFoundException("User by id "+username+" was not found"));
    }
}

