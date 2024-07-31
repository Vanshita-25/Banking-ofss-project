package com.ofss.main.repository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;

public class AccountRepositoryImpl implements AccountRepository {
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/banking";
    private static final String username = "root";
    private static final String password = "root";

     // connect to db
    private Connection connection = null;
    //store and execute query
    private PreparedStatement preparedStatement = null;
    //store retrieved results
    private ResultSet resultSet = null;

    private static final String CREATE_ACCOUNT = "INSERT INTO bank_account(opening_date,balance,account_status,accountType,customer_id) VALUES (sys.date,10000,'Active',?,?) ";
    private static final String GET_ALL_ACCOUNTS ="SELECT * FROM bank_account where customer_id = ?";
    private static final String UPDATE_ACCOUNT_BALANCE = "UPDATE bank_account set balance = ?";

    @Override
    public int createNewAccount(Account account) {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement(CREATE_ACCOUNT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, account.getAccountType());
            preparedStatement.setInt(2,account.getcustomer().getCustomerId());
            int rowCount= preparedStatement.executeUpdate();

            if (rowCount > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int insertId = generatedKeys.getInt(2);
                    System.out.println("Your account id is :: " + insertId);
                    return insertId;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect database");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection");
                e.printStackTrace();
            }
        }
        return  0;
    }
    
    @Override
    public List<Account> getAccountsbyCustomerId(int customerId) {
         try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement(GET_ALL_ACCOUNTS);
            preparedStatement.setInt(1, customerId);
            resultSet = preparedStatement.executeQuery();

            List<Account> accountList = new ArrayList<>();
            while (resultSet.next()) {
                int accountId = resultSet.getInt("account_id");
                Date openingDate = resultSet.getDate("opening_date");
                String accountStatus = resultSet.getString("account_status");
                int custId = resultSet.getInt("customer_id");
                String accountType = resultSet.getString("accountType");
                double balance = resultSet.getDouble("balance");

                Customer customer = new Customer();
                customer.setCustomerId(custId);

                Account account = new Account(openingDate,balance,accountId,accountStatus,accountType,customer);
                accountList.add(account);
            }
            return accountList;

        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect database");
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
    public int withdrawMoney() {
        return 0;
    }

    @Override
    public int depositMoney() {
        return 0;
    }


}
