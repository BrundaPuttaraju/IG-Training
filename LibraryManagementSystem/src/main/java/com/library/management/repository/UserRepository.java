package com.library.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.management.Entity.User;
import com.library.management.enumtype.UserType;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "select user from User user where user.first_name=:name")
    public List<User> getByUserName(String name);
	
	//@Query(value = "select user from User user where user.userId=:id")
    //public Optional<User> getUserById(long id);

   @Query("select user from User user where user.user_type = :type")
   public List<UserType> getuserByType(String type);
}
