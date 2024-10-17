package com.dollop.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollop.lms.bean.Admin;
import com.dollop.lms.bean.Book;
import com.dollop.lms.bean.BookOperation;
import com.dollop.lms.bean.Librarian;
import com.dollop.lms.bean.Student;
import com.dollop.lms.bean.Validation;
import com.dollop.lms.dao.lmpl.LibrarianDaoImpl;
import com.dollop.lms.service.IAdminService;
import com.dollop.lms.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAdminService adminService = null;   
	LibrarianDaoImpl LDImpl = new LibrarianDaoImpl();
	Admin admin;
   Validation vali=new Validation(); 
   
	Scanner sc = new Scanner(System.in);
    /**
     * @see HttpServlet#HttpServlet()
     */
	public AdminController() {
		super();
		this.adminService = new AdminServiceImpl();
		createAdmins();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//	response.getWriter().append("Served at: ").append(request.getParameter("email"));
	 
	  String action=request.getParameter("action");
	  System.out.println(action);
	  switch(action) {
	  case "login":
		  login(request,response);
		  break;
	  case "signup":
		  signup(request,response);
		  break;
	  case "addLibrarian":
		  addLibrarian(request,response);
	  		break;
	  case "deletelibrarian":
		//    delLibrarian(request,response);
		    break;
	  case "Cancel":
		  RequestDispatcher rs=request.getRequestDispatcher("adminDashboard.jsp");
	 	   rs.forward(request, response);
	 	   break;
	  default:
		  System.out.println("Something went wrong");
		  break;
	  }
	
	}

	private void signup(HttpServletRequest request, HttpServletResponse response) {
	   System.out.println("signup successfully");
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void createAdmins() {
		if (!adminService.isAdminAvailable()) {
			String EnPass = EncryptPass("1234");
			String EnPass1 = EncryptPass("12345");
			List<Admin> admins = Arrays.asList(
					new Admin(null, "admin123", EnPass, "indore", "2445687654", true, AutoDateTime()),
					new Admin(null, "admin222", EnPass1, "indore", "9383883445", true, AutoDateTime()));
			adminService.saveAdmins(admins);
		}
	}

	public static String AutoDateTime() {
		LocalDateTime currentDate = LocalDateTime.now();

		DateTimeFormatter mycurrentDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		String formattedDate = currentDate.format(mycurrentDate);
		return formattedDate;

	}
	
	public static String EncryptPass(String str) {
		String hashText = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(str.getBytes());
			byte[] digest = md.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			hashText = bigInt.toString(16);
			while (hashText.length() > 32) {
				hashText = "0" + hashText;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashText;
	}
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		 String uName=req.getParameter("uName");
		  String uPass=req.getParameter("uPass");
		
		
		admin = adminService.login(uName, EncryptPass(uPass));

		if (admin != null) {
		//	adminDashboard(admin);
			//adminDashboard.jsp;  
			RequestDispatcher rs =req.getRequestDispatcher("adminDashboard.jsp");
			rs.forward(req,res);

		} 
        else {
	    	
//	    	String msg="<h2>Username--> '"+uName+"' OR Password--> '"+uPass+"' is wrong data</h2>";
//		     res.setContentType("text/html");
//			 PrintWriter out= res.getWriter();
//			 out.println(msg);
			 RequestDispatcher rs=req.getRequestDispatcher("PopupBox.html");
		 	    rs.include(req, res);
        }
}

	void adminDashboard(Admin admin) {
		while (true) {
			System.out.println("-----Admin Dashboard-----");
			System.out.println("Please select Any one option from below");
			System.out.println("1. Librarian Panel ");
			System.out.println("2. Student Panel");
			System.out.println("3. Books Panel");
			System.out.println("4. Staf Panel ");
			System.out.println("5. Return Main Page");
			System.out.println("6. Logout ");

			Librarian librarian = null;
			// Test t=new Test();
			String c = sc.nextLine();
			switch (c) {
			case "1":
				LibrarianPanel(librarian);
				break;
			case "2":
				StudentPanel();
				break;
			case "3":
				bookPanel();
				break;
			case "4":
				// StaffPanel();
				System.out.println("--Staff panel--");
				break;
			case "5":
		//		Test.mainPage();
				break;
			case "6":
				System.exit(0);
				break;
			default:
				System.out.println("Please choice currect option");

			}
		}
	}
	public void LibrarianPanel(Librarian librarian) {
		while (true) {
			System.out.println("----- Librarian Panel -----");
			System.out.println(" ***Please choice any option from below*** ");
			System.out.println("1) Add Librarian ");
			System.out.println("2) Delete Librarian");
			System.out.println("3) Update Liibrarian ");
			System.out.println("4) Show Librarian ");
			System.out.println("5) Show Perticular Librarian ");
			System.out.println("6) Change Librarian status");
			System.out.println("7) Return Back Admin DashBoard");
			String uName = "";
			String c = sc.nextLine();
			switch (c) {
			case "1":
			//	addLibrarian();
				break;
			case "2":
				deleteLibrarian();
				break;
			case "3":
				System.out.println("Enter Librarian User Name");
				uName = sc.nextLine();
				adminService.updateLibrarian(uName);
				break;
			case "4":
				adminService.showLibrarian();
				break;
			case "5":
				System.out.println("Enter Librarian User Name");
				uName = sc.nextLine();
				adminService.showOneLibrarian(uName);
				break;
			case "6":
				Boolean b = adminService.changeLibrarianStatus();
				if(b==false)
					System.out.println("!! You Enter invalid librarian user name or password");
				else
					System.out.println("--Change librarian Status Successfully--");
				break;
			case "7":
				adminDashboard(admin);
				break;
			default:
				System.out.println(" Please choice currect option ");
				break;
			}
		}
	}

	
	int count = 0;
	LibrarianDaoImpl l = new LibrarianDaoImpl();

	private void addLibrarian(HttpServletRequest req, HttpServletResponse res) {
		String lName=req.getParameter("lName");
		String lPass=req.getParameter("lPass");
		String lConPass=req.getParameter("lConPass");
		String lEmail=req.getParameter("lEmail");
		String lAddress=req.getParameter("lAddress");
		String lContact=req.getParameter("lContact");
		
		
		System.out.println("---"+lName);
		
         String sName=vali.capToSmall(lName);
//		if (l.isLibrarianAvailable(sName)) {
//			if (count == 3) {
//				Librarian librarian = null;
//				System.out.println("--Sorry try again--");
//				count = 0;
//				LibrarianPanel(librarian);
//			}
//			count++;
//			System.out.println("!! Librarian Already Exist please Enter currect User Name \n");
//			addLibrarian();
//		}

			
		List<Librarian> librarian = Arrays
				.asList(new Librarian(null, lName,lPass,lEmail,lAddress,lContact, true, AutoDateTime()));
		adminService.saveLibrarians(librarian);

		System.out.println("Add librarian succefully");
	}

	private void deleteLibrarian() {
		System.out.println(" Enter Librarian Name ");
		String Lname = sc.nextLine();
		System.out.println(" Enter Librarian Password ");
		String LPassword = sc.nextLine();
		String EPassword = EncryptPass(LPassword);

		adminService.removeLibrarian(Lname, EPassword);

	}

	public Integer StudentPanel() {
		while (true) {
			System.out.println("----- Student Panel -----");
			System.out.println(" ***Please choice any option from below*** ");
			System.out.println("1) Add Student ");
			System.out.println("2) Delete Student");
			System.out.println("3) Update Student ");
			System.out.println("4) Show All Student ");
			System.out.println("5) Show Perticular Student ");
			System.out.println("6) Return to Back");
			String c = sc.nextLine();

			if ("6".equals(c)) {
				break;
			}
			switch (c) {
			case "1":
				addStudent();
				break;
			case "2":
				deleteStudent();
				break;
			case "3":
				adminService.updateStudent();
				break;
			case "4":
				adminService.showAllStudent();
				break;
			case "5":
				System.out.println("Enter Student User Name");
				String uName = sc.nextLine();
				adminService.showOneStudent(uName);
				break;
//			  case "6":
//				   Test.mainPage();
//				   break;

			default:
				System.out.println(" Please choice currect option ");
				break;
			}
		}
		return 0;
	}

	int c = 0;
    int x = 0;
	private Integer addStudent() {
		System.out.println("Enter Student User Name");
		String sName = sc.nextLine();
		if(!vali.checkSpace(sName)) {
			System.out.println("--Blank space is not allowed ReEnter your details--");
			if(x==3) {
				x=0;
				System.out.println("--You Enter Wrong Name many time--");
				return StudentPanel();
			}
			x++;
			return addStudent();
		}
		if (adminService.isStudentAvailable(sName)) {
			if (c == 3) {
				System.out.println("--Sorry try again--");
				c = 0;
				StudentPanel();
			}
			c++;
			System.out.println("!! Student Already Exist please Enter currect User Name \n");
			return addStudent();
		}

		String sPass = vali.confirmPassword();
	    if("".equals(sPass)) {
	    	System.out.println("--You Enter Wrong Password many time Please try Again--");
	    	StudentPanel();
	    }
		String enPass = EncryptPass(sPass);

		System.out.println("Enter Student address");
		String sAddress = sc.nextLine();
		sAddress=vali.empty(sAddress);
		if(sAddress.equals("false")){
			System.out.println("--You Enter Wrong Address many time Please try Again--");
			return StudentPanel();
		}

		System.out.println("Enter Student Contact Number");
		String contact = sc.nextLine();
		contact=vali.phoneNumber(contact);
		 if(contact.equals("false")) {
			 System.out.println("--You Enter Wrong contact many time Please try Again--");
			 return StudentPanel();
		 }

		System.out.println("Enter Student Email ID Properly-->");
		String email = sc.nextLine();
		email=vali.emailId(email);
		if(vali.emailId(email).equals("false")) {
			 System.out.println("--You Enter Wrong Email id many time Please try Again--");
			 return StudentPanel();
		}
		List<Student> student = Arrays
				.asList(new Student(null, sName, enPass, sAddress, contact, email, true, AutoDateTime()));
		adminService.saveStudents(student);

		System.out.println("Add Student succefully");
		return 0;
	}

	private void deleteStudent() {
		System.out.println(" Enter Student Name ");
		String sName = sc.nextLine();
		adminService.removeStd(sName);
	}

	public Integer bookPanel() {
		while (true) {
			System.out.println("----- Book Panel -----");
			System.out.println(" ***Please choice any option from below*** ");
			System.out.println("1) Add Book ");
			System.out.println("2) Delete Book");
			System.out.println("3) Update Book ");
			System.out.println("4) Show Book by Name ");
			System.out.println("5) Show All Books ");
			System.out.println("6) Book available");
			System.out.println("7) Issue Book");
			System.out.println("8) Return  Book");
			System.out.println("9)Show All Issued Book");
			System.out.println("10) Back ");
			String c = sc.nextLine();

			if ("10".equals(c)) {
				break;
			}
			switch (c) {
			case "1":
				addBook();
				break;
			case "2":
				deleteBook();
				break;
			case "3":
				adminService.updateBook();
				break;
			case "4":
				System.out.println("Enter Book Name");
				String bName = sc.nextLine();
				adminService.showOneBook(bName);
				break;
			case "5":
				adminService.showAllBook();
				break;
			case "6":
				System.out.println("Enter book Name");
				bName = sc.nextLine();
				Boolean result = adminService.isBookExist(bName);
				if (result == true) {
					System.out.println("--This Book is Available--");
				} else {
					System.out.println("--This Book is not Available--");
				}
				break;
			case "7":
				try {
					IssueBook();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;
			case "8":
				try {
					returnIssueBook();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "9":
				adminService.showAllIssueBooks();
				break;
			default:
				System.out.println(" Please choice currect option ");
				break;
			}
		}
		return 0;
	}

	private Integer addBook() {
		System.out.println("Enter Book Name");
		String bName = sc.nextLine();
		bName=vali.empty(bName);
		if(bName.equals("false")){
			System.out.println("--You Enter Wrong Book name many time Please try Again--");
			return bookPanel();
		}

		if (adminService.isBookExist(bName)) {
			System.out.println("!! Book Already Available in your library please Enter currect Book Name \n"
						+ "--You want to increase book Quantity--\n 1) Yes \n 2) No");
		    String ch=sc.nextLine();
			switch(ch){
			    case "1":
			    	adminService.increaseBookQuantity(bName);
			    	System.out.println("-Book Quantity is increase by One successfully-");
			    	break;
			    case "2":
			    	break;
		     }
		
		}
		else {
			System.out.println("Enter Book Author Name");
			String bAuthorName = sc.nextLine();
			bAuthorName=vali.empty(bAuthorName);
			if(bAuthorName.equals("false")){
				System.out.println("--You Enter Wrong Author Name many time Please try Again--");
				return bookPanel();
			}

	
			System.out.println("Enter Book Pages");
			int bPages = 0;
			try {
			   bPages = sc.nextInt();
			}catch(Exception e){
				System.out.println("Wrong format");
				
			}
	
			System.out.println("Enter BookQuantity");
			int bQuantity = sc.nextInt();
			sc.nextLine();
			List<Book> book = Arrays.asList(new Book(null, bName, bAuthorName, bPages, bQuantity, AutoDateTime()));
			adminService.insertBooks(book);
	
			System.out.println("Add Book succefully");
		}
		return 0;
  }

	public Boolean IssueBook() throws SQLException {
		Boolean result = false;
		System.out.println("Enter Issue Book Name");
		String bName = sc.nextLine();

		if (adminService.isBookExist(bName) && adminService.quantityCheck(bName) > 0) {
			System.out.println("-Enter which user Issue this book-");
			String userName = sc.nextLine();

			if (!adminService.AlreadyIssued(bName, userName)) {

				if (adminService.isStudentAvailable(userName)) {

					List<BookOperation> book = Arrays
							.asList(new BookOperation(null, userName, bName, 1, AdminController.AutoDateTime()));
					adminService.insertIssueBooks(book);
					adminService.decreaseBookQuantity(bName);
					System.out.println("Book is Issued successfully ");
					result = true;
				} else {
					System.out.println("--This Student Not Available--");
				}
			} else {
				System.out.println("--This book has Already been issued to this student--");
			}
		} else {
			System.out.println("-This book is not available-");
		}
		return result;
	}

	public void returnIssueBook() throws SQLException {

		System.out.println("Enter Return Book Name");
		String bName = sc.nextLine();
		int Quantity = adminService.quantityCheck(bName);
		if (adminService.isBookIssue(bName)) {
			System.out.println("-Enter which user is issued this book-");
			String userName = sc.nextLine();
			if (adminService.AlreadyIssued(bName, userName)) {
				if (Quantity >= 0) {
					adminService.increaseBookQuantity(bName);
					System.out.println("Your Book is submited --> " + bName);
				} else {
					System.out.println("first of all add this book and this book Quantity give => 0 ");
				}
			} else {
				System.out.println("This User is not issue this book");
			}
		} else {
			System.out.println("-- This book is not issued from your librariry --");
		}
	}

	private void deleteBook() {
		System.out.println(" Enter Book Name ");
		String bName = sc.nextLine();

		adminService.removeBook(bName);

	}

}
