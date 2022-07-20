package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.exceptions.RSAException;

import dto.User;
import service.UserService;

public class UserController {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
		System.out.println("------------HomePage----------------------");
		System.out.println("Press 1 to enter new User");
		System.out.println("Press 2 to View all users");
		System.out.println("Press 3 to get User by id");
		System.out.println("Press 4 to Update existing user");
		System.out.println("Press 5 to delete user by id");
		System.out.println("Press 6 to exit");
		int choice = t.nextInt();
		
			switch (choice) {
			case 1: {
				UserService service= new UserService();
				User user = new User();
				System.out.println("Enter user id");
				int id = t.nextInt();
				user.setId(id);
				System.out.println("Enter user name");
				String name = t.next();
				user.setName(name);
				System.out.println("Enter user email");
				String email = t.next();
				user.setEmail(email);
				System.out.println("Enter user age");
				int age = t.nextInt();
				user.setAge(age);
				service.saveUser(user);
				System.out.println("user saved sucessfully ");
			
			}

				break;
			case 2: {
				UserService service= new UserService();
				ResultSet resultSet = service.getUsers();
				try {
					while (resultSet.next()) {
						int id = resultSet.getInt(1);
						String name = resultSet.getString(2);
						String email = resultSet.getString(3);
						int age = resultSet.getInt(4);

						System.out.println("User id is = " + id);
						System.out.println("User name is = " + name);
						System.out.println("User emil is = " + email);
						System.out.println("User age is = " + age);
						System.out.println("--------------------------------------------");

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

				break;
			case 3: {
				UserService service= new UserService();
				System.out.println("Enter user id");
				int ida = t.nextInt();
				ResultSet resultSet = service.getUserById(ida);
				try {
					if (resultSet.next()) {
						int id = resultSet.getInt(1);
						String name = resultSet.getString(2);
						String email = resultSet.getString(3);
						int age = resultSet.getInt(4);

						System.out.println("User id is = " + id);
						System.out.println("User name is = " + name);
						System.out.println("User emil is = " + email);
						System.out.println("User age is = " + age);
						System.err.println("--------------------------------------------");

					} else {
						System.out.println("No user found");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
				break;
			case 4: {
				UserService service= new UserService();
				User user = new User();
				System.out.println("Enter user id");
				int id = t.nextInt();
				user.setId(id);
				System.out.println("Enter user name");
				String name = t.next();
				user.setName(name);
				System.out.println("Enter user email");
				String email = t.next();
				user.setEmail(email);
				System.out.println("Enter user age");
				int age = t.nextInt();
				user.setAge(age);
				int res = service.updateUser(user);
				System.out.println(res + " user updated sucessfully ");

			}
				break;
			case 5: {
				UserService service= new UserService();
				System.out.println("Enter id to delete the user");
				int id = t.nextInt();
				int res = service.deleteUser(id);
				System.out.println(res + " deleted sucessfully");

			}
				break;
			case 6: {
				flag = false;
				System.out.println("thank you");
			}
				break;
			default: {

			}
			}
		}
	}

}
