package edu.mum.cs.cs472.service;

import edu.mum.cs.cs472.dao.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    public List<User> getUserById(int userId);

    public User login(String username, String password);

    public void logout();

    public String registerUser(User newUser);
}
