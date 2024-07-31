package com.ofss.main.Service;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.repository.CustomerRepositoryImpl;
import com.ofss.main.repository.LoginRepository;
import com.ofss.main.repository.LoginRepositoryImpl;
import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;

public class LoginServiceImpl implements LoginService{
    private LoginRepository loginRepository = new LoginRepositoryImpl();
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

  @Override
    public int addNewLogin(Login login) {
        int loginId = loginRepository.addNewLogin(login);
        if (loginId != 0) {
            login.setLoginId(loginId);
            return loginId;
        }
        return 0;
    }

    // return flags 
    // loginStatus = NEW => -1
    // loginStatus = LOCKED => -2
    // loginAttempts > 3 = -3
    // INVALID PASSWORD = CountOfLoginAttempts
    // INVALID CUSTOMERID = -4
    // ALL VALID DETAILS = 1
    @Override
    public int validateLogin(int customerId, String password) {
        System.out.println("in service :: " + customerId);
        Customer customer = customerRepository.getCustomerbyCustomerId(customerId);
        //System.out.println(customer);
        if (customer != null) {
            Login login = loginRepository.getLoginByCustomerId(customer.getCustomerId());
            System.out.println("Input Password :: " + password + "Login id is: " + login.getLoginId());
            switch (login.getLoginStatus()) {
                case "NEW":
                    return -1;
                case "LOCKED":
                    return -2;
                case "ACTIVE":
                    if (login.getAttempts() < 3) {
                        if (login.getPassword().equals(password)) {
                            return 0;
                        } else {
                            loginRepository.incrementLoginAttemptsByLoginId(login.getLoginId());
                            return login.getAttempts();
                        }
                    } else {
                        return -3;
                    }
                default:
                    return -4;
            }
        } else {
            return -4;
        }

    }


}
