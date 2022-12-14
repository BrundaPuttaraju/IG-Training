package com.library.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.Entity.User;
import com.library.management.Service.UserService;
import com.library.management.enumtype.UserType;

@RestController
@RequestMapping("/register")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUser() {
		log.info("Fetching all the user informations");
		return ResponseEntity.ok().body(userService.getAllUser());
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		log.info("Fetching the user information by id");
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
		log.info("Fetching the user information by name");
		return new ResponseEntity<User>((User) userService.getUserByName(name), HttpStatus.OK);
	}

	@GetMapping("/type/{type}")
	public ResponseEntity<List<UserType>> getuserByType(@PathVariable("type") String type) {
		log.info("Fetching the user information by usertype");
		return ResponseEntity.ok().body(userService.getuserByType(type));
	}

	@PostMapping("/add")
	public ResponseEntity addUser(@RequestBody User user) {
		log.info("Adding user information");
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		log.info("Updating the user information");
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		log.info("Deleting the user information by id");
		userService.deleteUser(id);
		return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
	}

}
