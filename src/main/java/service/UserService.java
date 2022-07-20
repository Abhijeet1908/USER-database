package service;


import java.sql.ResultSet;

import dao.UserDao;
import dto.User;

public class UserService {
	
	public void saveUser(User  user1) {
		UserDao dao= new UserDao();
		dao.saveUser(user1);
	}

	public ResultSet getUsers() {
		UserDao dao= new UserDao();
		return dao.getUsers();

	}

	public ResultSet getUserById(int id) {
		UserDao dao= new UserDao();
		return dao.getUserById(id);
	}

	public int deleteUser(int id) {
		UserDao dao= new UserDao();
		return dao.deleteUser(id);

	}

	public int updateUser(User user2) {
		UserDao dao= new UserDao();
		return dao.updateUser(user2);

	}

}
