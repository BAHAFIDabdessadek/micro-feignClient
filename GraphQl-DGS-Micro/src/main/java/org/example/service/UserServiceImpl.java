package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService{

    private final UserRepo userRepo;

    @Override
    public User getUser(Long id) {
        return userRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("Sorry, we can't found any user with id you entered."));
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public void addUsers(List<User> users) {
        userRepo.saveAll(users);
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }
}
