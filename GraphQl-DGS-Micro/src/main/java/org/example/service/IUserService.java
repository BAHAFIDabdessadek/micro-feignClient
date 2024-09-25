package org.example.service;

import org.example.model.User;

import java.util.List;

public interface IUserService {

   User getUser(Long id);
   List<User> getAllUser();

   void addUsers(List<User> users);
   void  addUser(User user);

}
