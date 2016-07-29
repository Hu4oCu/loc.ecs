package loc.ecs.service.impl;

import loc.ecs.entity.Users;
import loc.ecs.repository.UsersRepository;
import loc.ecs.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users addUser(Users user) {
        return usersRepository.saveAndFlush(user);
    }

    @Override
    public Users editUser(Users user) {
        return usersRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(int id) {
        usersRepository.delete(id);
    }

    @Override
    public Users getUserById(int id) {
        return usersRepository.getOne(id);
    }
}
