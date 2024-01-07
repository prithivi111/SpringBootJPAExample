package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
import com.jpa.test.entities.User;
//import org.springframework.data.repository.CrudRepository;

//@Repository  // Here Repository includes @Componnet
//public class UserRepository{
//	
		//@Autowired	
		//private final JdbcTemplate jdbcTemplate;  //The JdbcTemplate is a simplified JDBC template class provided by Spring
                                                    //for performing database operations.


		//public UserRepository(JdbcTemplate jdbcTemplate) {
    	//		this.jdbcTemplate = jdbcTemplate;
		//	}

		//public void save(User user) {	
		//   String sql = "INSERT INTO user (name, city, status) VALUES (?, ?, ?)";
        //   jdbcTemplate.update(sql, user.getName(), user.getStatus(), user.getCity());
		//   System.out.println("User saved successfully!");
//				}
//}
	
	//@Repository or @Component  --> this is unnecessary here
   public interface UserRepository extends CrudRepository<User, Integer>{
//	In the case of a Spring Data JPA repository interface, such as UserRepository that extends CrudRepository,
//	you don't need to explicitly annotate it with @Component/@Repository. Spring Data JPA provides a mechanism to
//	automatically generate an implementation of the repository interface during runtime.
//
//	When you extend CrudRepository (or other Spring Data repository interfaces), Spring Data JPA will generate
//	a proxy implementation of your interface at runtime. This implementation will handle the
//	basic CRUD operations (create, read, update, delete) for the entity (User in our case), 
//	without the need to implement/write them manually as above..
//
//	Adding @Component to the repository interface is unnecessary because Spring Data JPA will 
//	automatically create a bean for the repository implementation when the application starts. 
//	As a result, you can simply inject UserRepository's instance into other Spring components or services 
//	without explicitly marking it with @Component.
//	In summary, you don't need to use @Component on Spring Data JPA repository interfaces because 
//	the framework takes care of generating the necessary implementation at runtime.
	   	
//	-------------   
	 //Creation of the custom methods
	   
	   public List<User> findByName(String name);  
	   //And we don't have to write the body here since this is the method of the inteface. Spring will automatically handle the internal code.
	   //Here, find is called 'introducer', and ByName is called 'Criteria'.
	   //And, name is the property of User Class//
	   //So, it is very important to write the method name in the standard format as spring understands.
	   //So the combination of this introducer, criteria and property will let Spring understand that
	   //It has to FIND the data ByName with the name equivalent to 'name'.
	   //Now go back to main method to call this method and run it once to check!
	   
	   
}
