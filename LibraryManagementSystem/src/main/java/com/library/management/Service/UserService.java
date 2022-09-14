package com.library.management.Service;

import java.util.List;

import com.library.management.Entity.User;
import com.library.management.enumtype.UserType;

public interface UserService {

	public User saveUser(User user);

	public List<User> getAllUser();

	public User getUserById(long id);

	public List<User> getUserByName(String name);

	public User updateUser(User user, long id);

	public void deleteUser(long id);

	public List<UserType> getuserByType(String type);
}

