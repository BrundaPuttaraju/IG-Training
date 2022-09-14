package com.library.management.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.Entity.User;
import com.library.management.Service.UserService;
import com.library.management.enumtype.UserType;
import com.library.management.exception.ResourceNotFoundException;
import com.library.management.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new ResourceNotFoundException("User not found with specified id:" + id);
		}
	}

	@Override
	public List<User> getUserByName(String name) {
		return userRepository.getByUserName(name);
	}

	@Override
	public User updateUser(User user, long id) {
		User preUser = userRepository.findById(user.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found with specified id:" + id));

		preUser.setFirstName(user.getFirstName());
		preUser.setLastName(user.getLastName());
		preUser.setUserId(user.getUserId());
		preUser.setPhoneNo(user.getPhoneNo());
		preUser.setAddress(user.getAddress());
		preUser.setEmail(user.getEmail());
		preUser.setUserType(user.getUserType());

		return userRepository.save(preUser);

	}

	@Override
	public void deleteUser(long id) {
		Optional < User > user = this.userRepository.findById(id);

        if (user.isPresent()) {
            this.userRepository.delete(user.get());
        } else {
            throw new ResourceNotFoundException("User not found with specified id : " + id);
        }
	}

	@Override
	public List<UserType> getuserByType(String type) {
		return userRepository.getuserByType(type);
	}

}
