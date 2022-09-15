package com.library.management.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.management.Entity.User;
import com.library.management.enumtype.UserType;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "select user from User user where user.firstName = firstName")
    public List<User> getByUserName(String firstName);
	
	//@Query(value = "select user from User user where user.userId=:id")
    //public Optional<User> getUserById(long id);

   @Query("select user from User user where user.userType = userType")
   public List<UserType> getuserByType(String userType);
}
