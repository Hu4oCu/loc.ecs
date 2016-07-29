package loc.magazine.service;

import loc.magazine.entity.Users;

public interface UsersService {
    Users addUser(Users user);
    Users editUser(Users user);
    void deleteUser(int id);
    Users getUserById(int id);
}
