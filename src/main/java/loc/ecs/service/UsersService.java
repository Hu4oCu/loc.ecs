package loc.ecs.service;

import loc.ecs.entity.Users;

public interface UsersService {
    Users addUser(Users user);
    Users editUser(Users user);
    void deleteUser(int id);
    Users getUserById(int id);
}
