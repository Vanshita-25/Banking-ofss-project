package com.ofss.main.Service;
import com.ofss.main.domain.Login;

public interface LoginService {
    int addNewLogin(Login login);
    int validateLogin(int customerId, String password);

}
