package com.jpa.test;

import java.util.List;
//import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		
		ApplicationContext context= SpringApplication.run(BootjpaexampleApplication.class, args);
		
//	1. We saved the data of 2 Users	
//		User user1= new User();
//		user1.setName("Dines Raj Shrestha");
//		user1.setCity("Toronto");
//		user1.setStatus("I am a React programmer");
	
		//Here my object is ready! And I want to save in the database! How can I do that?		
		
		//Before, After creating these two user datas, in the time of JDBC we have those seven steps of connecting to the database if you remember.
		//And ofcourse we can use those steps here also, like for eg..
		//    Class.forName("com.mysql.cj.jdbc.Driver");  (
		//      Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentregistration", "root", "Suraj123@");
		//        String sql = "insert into user(id, name, city, status) + "values(?,?,?,?)");
		//          PreparedStatement ps = conn.prepareStatment(sql);
		//    	         ps.setInt(1, user1.getId());
		//		         ps.setString(2, user1.getName());......etc
		//          int count = ps.executeUpdate();
		//               if (count==1) {syso "data inserted into DB successfully"}	
		//          ps.close();
		//          conn.close();
		
		//Then after that we came to learn Hibernate to save the data in Database which looked like as below:
		//     Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
	    //     SessionFactory sf = con.buildSessionFactory();
		//	   Session session =sf.openSession();   
		//     Transaction tx = session.beginTransaction();
		//     session.save(user1);  
		//     tx.commit(); session.close(); 
		
		
		//But we do not want to have these codes written by us being a developer right. Here comes the picture of SpringBootFramework
		//That simplies us by not allowing to write these codes and connect with our database.
		
		// In normal applications, we have controller, service layer, DAO layer(which is called repository layer in Spring boot) and
		// so far, we have been calling the methods from service layer to the DAO layer(reposity layer) to save data right!!!!!
		//Since this class is acting as a service layer for us, we only need to create repository layer (like DAO class) in Springboot
		// framework that helps in connecting the Database, and that's why we created the class called "User repository".
	
	//So, we create a class called UserRepository for example. and put the @Repository annotation (which has @Component included)	
	//				UserRepository repo = context.getBean(UserRepository.class); 
	//	            repo.save(user1);  
	//And the above save method will call the method inside the UserRepository Class where we will have codes (the use of JDBC
	// template, in order to escape the codes of hibernate) for Database connection.
	// Please go and check inside the save() method!!We use the JdbcTemplate class provided by the Spring for performing DB
	// operations and write the queries manually...
				
	//But in SpringBoot Data JPA, we don't write those codes as well, rather use an Interface (anyname is ok, and I used--> UserRepository), 
	//that extends the CRUSRepsository which automatically performs all the operations of Dataconnection with DB.
	//Remember we do not use class here, we used interface, and write the code as below, which will connect to that Interface!
	
		UserRepository userRepository= context.getBean(UserRepository.class);
//		User u = userRepository.save(user1);  //so here this save method is not present in the Interface, howeever, is automatica
//		System.out.println(u);

//		How about saving 2 or many objects??
//		User user2 = new User();
//		user2.setName("Ravi Raj Shrestha");
//		user2.setCity("Canada");
//		user2.setStatus("I am a Javascript programmer");		
////		
//		List<User> users= List.of(user1, user2);
//		Iterable<User> result = userRepository.saveAll(users);
//	
//		result.forEach(user-> {
//			System.out.println("Saved all users: " + user );
//		});
		
//2. update the data of user whose id = 1
//		Optional<User> optional = userRepository.findById(1);
//		User user = optional.get();
//		user.setName("Ankit Tiwari");
//		
//		User result = userRepository.save(user);
//		
//		System.out.println(result);
//		
//	}
//3. Read/Get all the user data
//		Iterable<User> itr = userRepository.findAll();
//		itr.forEach(user->{System.out.println(itr);});
		
//4. Deleting the user by ID
//		userRepository.deleteById(1);
//		System.out.println("deleted");
	
//5. Deleting all the users
//		Iterable<User> allUsers = userRepository.findAll();
//		allUsers.forEach(user->{System.out.println(user);});
//		
//		userRepository.deleteAll(allUsers);
	
	//By Default methods are there given by CRUDRepository like:
	//	->findALLbyID
	//	->findById
	//	->findALL
	
	//But we may need to get the data by name, by password, by name starting with prefix A, etc...
	//So in this case, Spring helps in developing Custom Finder Methods  or Derived Query Methods.
	//The good part of it is, we only need to wrtie the format but not the implementation.
	//We only have to write the prototype in the format given by Spring..
	//FOr eg: If we want to fire the query something like select * from user where name = 'Abhishek'
	//Then we must write something like public List<User> findByName(String name), so that Spring will 
	//understand that it has to find the data on the basis of the name.
	
	//As I said earlier above, CRUDRepsository which automatically performs all the operations of Dataconnection with DB,
	//so coming to this situation, what we came to know is that, CRUDRepository doesnot have all the methods to perform all the DB
	//operations. For any other operations except than the operations(methods) defined in CRUDRepository, we need to make our
	//own custome methods in the Interface. So once again go in the inteface to check the custom method that I created.
		
		List<User> uu = userRepository.findByName("Suraj Raj Shrestha");
		uu.forEach(user-> {System.out.println(user);});
	}
}
