package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;

public class UserDao {

	public void saveUser(User  user1) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_db";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO user VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user1.getId());
			preparedStatement.setString(2, user1.getName());
			preparedStatement.setString(3, user1.getEmail());
			preparedStatement.setInt(4, user1.getAge());
			preparedStatement.execute();

			System.out.println("User successfully added");
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet getUsers() {
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_db";
			String user = "root";
			String password = "root";
			 connection = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM user";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;

	}

	public ResultSet getUserById(int id) {
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_db";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM user WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;

	}

	public int deleteUser(int id) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_db";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM user WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public int updateUser(User user2) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user_db";
			String user = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE user SET name=?,email=?,age=? WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user2.getName());
			preparedStatement.setString(2, user2.getEmail());
			preparedStatement.setInt(3, user2.getAge());
			preparedStatement.setInt(4, user2.getId());
			result = preparedStatement.executeUpdate();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

}
