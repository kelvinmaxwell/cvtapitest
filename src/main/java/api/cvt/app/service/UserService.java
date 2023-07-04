package api.cvt.app.service;

import java.util.List;

import api.cvt.app.controller.UserRecord;
import api.cvt.app.model.User;

public interface UserService {
    User add(User user);
    List<UserRecord> getAllUsers();
    void delete(String email);
   User getUser(String email);
    User update(User user);
}
