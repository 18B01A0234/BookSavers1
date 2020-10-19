package com.ts;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.BookDAO;
import com.dao.UserDAO;
import com.dto.Book;
import com.dto.User;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	@Path("hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hi() throws UnsupportedEncodingException {
		System.out.println("Hi...");
		return "Hi Service!";
	}
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@Path("getUserByEmail/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByUserPass(@PathParam("email") String email) {
		System.out.println("Recieved path params: "+email); 
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByEmail(email);
		return user;
	}

	@Path("getUserByUserPass/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getEmpByUserPass(@PathParam("loginId") String loginId,@PathParam("password") String password) {
		System.out.println("Recieved path params: "+loginId+" "+password); 
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByUserPass(loginId, password);
		return user;
	}


	@Path("getUser")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser() {

		UserDAO userDAO = new UserDAO();
		List <User> userList = userDAO.getAllUsers();

		return userList;
	}


	@Path("getBooks")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks() {        
		BookDAO bookDao = new BookDAO();
		List <Book> bookList = bookDao.getAllBooks();
		return bookList;
	}

	@Path("getBookByName/{bookName}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBookByName(@PathParam("bookName") String bookName) {        
		System.out.println(bookName);      
		BookDAO bookDao = new BookDAO();
		List<Book> books = bookDao.getBookByName(bookName);
		System.out.println(books); 
		return books;
	}
	
	@Path("registerUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerUser(User user) {
		System.out.println("Data Recieved in User Register : " + user);
		UserDAO userDao = new UserDAO();
		userDao.register(user);
	
	}
	@Path("registerBook")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerBook(Book book) {
		System.out.println("Data Recieved in Book Register : "+book); 
		BookDAO bookDao = new BookDAO();
		bookDao.register(book);
	}
	
	//It is sample code if need to test and insert values into any tables
	/*@Path("registerEmp")
	@GET
	public void registerEmp() {
		DeptDAO deptDao = new DeptDAO();
		
		Department dept = deptDao.getDept(1);
		
		Employee employee = new Employee();
		employee.setEmpName("PASHA");
		employee.setEmail("email@gmail.com");
		employee.setGender("Male");
		employee.setJoinDate(new java.util.Date());
		employee.setDepartment(dept); 
		
		EmployeeDAO employeeDao = new EmployeeDAO();
		employeeDao.register(employee);
	
	}*/
	/*@Path("registerUser1")
	@GET
	public String registerUser1() {
				
		User user = new User();
		user.setUserId(1);
		user.setFirstName("VYSHNAVI");
		user.setLastName("TADIKONDA");
		user.setEmailId("email@gmail.com");
		user.setMobile("7981160809");
		user.setState("AP");
		user.setCity("Gudivada");
		user.setStreet("RajendraNagar");
		
		UserDAO userDao = new UserDAO();
		userDao.register(user);
		
		return "Success";
	
	}
	
	@Path("registerBook1")
	@GET
	public String registerBook1() {
		UserDAO userDao = new UserDAO();
		
		User user = userDao.getUser(1);
		
		Book book = new Book();
		book.setBookName("Financial Managment");
		book.setAuthorName("IM Pandey");
		book.setBookImage("Yes");
		book.setBookPrice(1000.20);
		book.setCategoryName("MBA");
		
		BookDAO bookDao = new BookDAO();
		bookDao.register(book);
		
		return "Success";	
	}*/

}
