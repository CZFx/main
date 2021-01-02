package com.xinhua.bookstore.data;

import com.xinhua.bookstore.Table.User;
import com.xinhua.bookstore.data.model.LoggedInUser;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.List;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            List<User> users = DataSupport.where("username = ?", username).find(User.class);
            if (!users.isEmpty() && users.get(0).getPassword().equals(password)){
                // TODO: handle loggedInUser authentication
                LoggedInUser normalUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(), username);
                return new Result.Success<>(normalUser);
            }
            return null;
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}