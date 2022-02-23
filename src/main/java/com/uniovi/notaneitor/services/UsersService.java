package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.User;
import com.uniovi.notaneitor.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void init() {
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(Long id) {
        return usersRepository.findById(id).get();
    }

    public User getUserByDni(String dni){
        return usersRepository.findByDni(dni);
    }

    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    public void updateUser(User user){
        User persistentUser = getUser(user.getId());
        if(!persistentUser.equals(null)){
            persistentUser.setDni(user.getDni());
            persistentUser.setName(user.getName());
            usersRepository.save(persistentUser);
        }
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}