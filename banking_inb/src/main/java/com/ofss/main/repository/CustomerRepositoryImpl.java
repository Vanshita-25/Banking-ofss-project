package com.ofss.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;

//import javax.naming.spi.DirStateFactory.Result;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;

public class CustomerRepositoryImpl implements CustomerRepository {
	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/banking";
	private static final String username = "root";
	private static final String password = "root";

	// connect to db
	private Connection connection = null;

	// store and execute query
	private PreparedStatement preparedStatement = null;

	// store retrieved results
	private ResultSet resultSet = null;

	// private static final String SELECT_ALL_CUSTOMER = "SELECT * from
	// bank_customer";
	private static final String SELECT_ONE_CUSTOMER = "SELECT * FROM bank_customer WHERE customer_id = ?";
	private static final String INSERT_NEW_CUSTOMER = "INSERT INTO bank_customer (first_name,last_name,address_1,address_2,address_3, city,state,zip,phone,cell,email,approval_status,login_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,true,?)";
	// private static final String UPDATE_CUSTOMER = "UPDATE bank_customer SET
	// first_name=?,last_name=?,address_1=?,address_2=?,address_3=?,city=?,state=?,zip=?,phone=?,cell=?,email=?,approval_status=?
	// WHERE customer_id=?";
	// private static final String DELETE_CUSTOMER = "DELETE FROM bank_customer
	// WHERE customer_id=?";

	// @Override
	// public List<Customer> getAllCustomers() {
	// try {
	// Class.forName(driverName);
	// try {
	// connection = DriverManager.getConnection(url, username, password);
	// preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
	// resultSet = preparedStatement.executeQuery();
	// List<Customer> customerList = new ArrayList<>();

	// while(resultSet.next()){
	// int customerId = resultSet.getInt("customer_id");
	// String firstName = resultSet.getString("first_name");
	// String lastName = resultSet.getString("last_name");
	// String address1 = resultSet.getString("address_1");
	// String address2 = resultSet.getString("address_2");
	// String address3 = resultSet.getString("address_3");
	// String city = resultSet.getString("city");
	// String state = resultSet.getString("state");
	// int zip = resultSet.getInt("zip");
	// int phone = resultSet.getInt("phone");
	// int cell = resultSet.getInt("cell");
	// String email = resultSet.getString("email");
	// boolean approvalStatus = resultSet.getBoolean("approval_status");

	// Customer customer = new
	// Customer(customerId,firstName,lastName,address1,address2,address3,city,state,zip,phone,cell,email,approvalStatus);
	// customerList.add(customer);
	// }
	// return customerList;

	// } catch (SQLException e) {
	// System.out.println("Failed to connect to database");
	// e.printStackTrace();
	// }
	// }
	// catch (ClassNotFoundException e) {
	// System.out.println("Failed to load driver");
	// e.printStackTrace();
	// }
	// finally{
	// try {
	// connection.close();
	// } catch (SQLException e) {
	// System.out.println("Failed to close connection");
	// e.printStackTrace();
	// }
	// }
	// return null;

	// }
	@Override
	public Customer getCustomerbyCustomerId(int customerId) {
		try {
			// loading the driver
			Class.forName(driverName);
			try {
				// connecting db
				connection = DriverManager.getConnection(url, username, password);
				// store query
				preparedStatement = connection.prepareStatement(SELECT_ONE_CUSTOMER);
				preparedStatement.setInt(1, customerId);
				// execute query ans store
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					int cId = resultSet.getInt("customer_id");
					String firstName = resultSet.getString("first_name");
					String lastName = resultSet.getString("last_name");
					String address1 = resultSet.getString("address_1");
					String address2 = resultSet.getString("address_2");
					String address3 = resultSet.getString("address_3");
					String city = resultSet.getString("city");
					String state = resultSet.getString("state");
					int zip = resultSet.getInt("zip");
					int phone = resultSet.getInt("phone");
					int cell = resultSet.getInt("cell");
					String email = resultSet.getString("email");
					boolean approvalStatus = resultSet.getBoolean("approval_status");
					int loginId = resultSet.getInt("login_id");
					Login login = new Login();
					login.setLoginId(loginId);

					Customer customer = new Customer(cId, firstName, lastName, address1, address2, address3, city,
							state, zip, phone, cell, email, approvalStatus, login);
					return customer;

				}
			} catch (SQLException e) {
				System.out.println("Failed to Connect database");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Failed to close connection");
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public int addNewCustomer(Customer customer) {
		System.out.println();
		System.out.println(customer);
		System.out.println();
		try {
			// loading the driver
			Class.forName(driverName);
			// connecting db
			connection = DriverManager.getConnection(url, username, password);
			// store query
			preparedStatement = connection.prepareStatement(INSERT_NEW_CUSTOMER, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getAddress1());
			preparedStatement.setString(4, customer.getAddress2());
			preparedStatement.setString(5, customer.getAddress3());
			preparedStatement.setString(6, customer.getCity());
			preparedStatement.setString(7, customer.getState());
			preparedStatement.setInt(8, customer.getZip());
			preparedStatement.setInt(9, customer.getPhone());
			preparedStatement.setInt(10, customer.getCell());
			preparedStatement.setString(11, customer.getEmail());

//          Have edited the isApprovalStatus and set it to true
			preparedStatement.setInt(12, customer.getLogin().getLoginId());

			// execute query and store
			int rowCount = preparedStatement.executeUpdate();

			if (rowCount > 0) {
				ResultSet generateKeys = preparedStatement.getGeneratedKeys();
				if (generateKeys.next()) {
					int insertId = generateKeys.getInt(1);
					return insertId;
				}
			}
		}

		catch (SQLException e) {
			System.out.println("Failed to Connect database");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Failed to close connection");
				e.printStackTrace();
			}
		}
		return 0;
	}

	// @Override
	// public boolean deleteCustomerbyCustomerId(int customerId) {
	// try {
	// Class.forName(driverName);
	// connection = DriverManager.getConnection(url, username, password);
	// preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
	// preparedStatement.setInt(1, customerId);

	// int rowCount= preparedStatement.executeUpdate();

	// if (rowCount > 0) {
	// return true;
	// }
	// } catch (ClassNotFoundException e) {
	// System.out.println("Failed to load driver");
	// e.printStackTrace();
	// } catch (SQLException e) {
	// System.out.println("Failed to connect database");
	// e.printStackTrace();
	// } finally {
	// try {
	// connection.close();
	// } catch (SQLException e) {
	// System.out.println("Failed to close connection");
	// e.printStackTrace();
	// }
	// }
	// return false;
	// }
	// @Override
	// public boolean updateCustomer(Customer customer) {
	// try {
	// //loading the driver
	// Class.forName(driverName);
	// //connecting db
	// connection = DriverManager.getConnection(url, username, password);
	// //store query
	// preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
	// preparedStatement.setString(1, customer.getFirstName());
	// preparedStatement.setString(2, customer.getLastName());
	// preparedStatement.setString(3, customer.getAddress1());
	// preparedStatement.setString(4, customer.getAddress2());
	// preparedStatement.setString(5, customer.getAddress3());
	// preparedStatement.setString(6, customer.getCity());
	// preparedStatement.setString(7, customer.getState());
	// preparedStatement.setInt(8, customer.getZip());
	// preparedStatement.setInt(9, customer.getPhone());
	// preparedStatement.setInt(10, customer.getCell());
	// preparedStatement.setString(11, customer.getEmail());
	// preparedStatement.setBoolean(12, customer.isApprovalStatus());

	// // execute query and store
	// int rowCount = preparedStatement.executeUpdate();

	// if(rowCount > 0){
	// return true;
	// }
	// }

	// catch (SQLException e) {
	// System.out.println("Failed to Connect database");
	// e.printStackTrace();
	// }
	// catch (ClassNotFoundException e) {
	// System.out.println("Failed to load driver");
	// e.printStackTrace();
	// }
	// finally{
	// try {
	// connection.close();
	// } catch (SQLException e) {
	// System.out.println("Failed to close connection");
	// e.printStackTrace();
	// }
	// }
	// return false;
	// }

}
