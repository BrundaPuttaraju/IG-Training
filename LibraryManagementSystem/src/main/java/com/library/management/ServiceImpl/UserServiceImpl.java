package com.library.management.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.Entity.User;
import com.library.management.Service.UserService;
import com.library.management.enumtype.UserType;
import com.library.management.exception.ResourceNotFoundException;
import com.library.management.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		log.info("getting all users");
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		log.info("getting user by id");
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new ResourceNotFoundException("User not found with specified id:" + id);
		}
	}

	@Override
	public List<User> getUserByName(String firstName) {
		log.info("getting user by name");
		return userRepository.getByUserName(firstName);
	}

	@Override
	public User updateUser(User user, long id) {
		log.info("updating user by id");
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
		log.info("deleting user by id");
		Optional < User > user = this.userRepository.findById(id);

        if (user.isPresent()) {
            this.userRepository.delete(user.get());
        } else {
            throw new ResourceNotFoundException("User not found with specified id : " + id);
        }
	}

	@Override
	public List<UserType> getuserByType(String userType) {
		log.info("getting user by type");
		return userRepository.getuserByType(userType);
	}

}
