package personal.controllers;

import personal.model.Field33333s;
import personal.model.Repository;
import personal.model.User;
import personal.utils.Validat;

import java.util.List;

public class UserController {
    private final Repository repository;
    private final Validat validat;


    public UserController(Repository repository, Validat validat) {
        this.repository = repository;
        this.validat = validat;
    }

    public void saveUser(User user) throws Exception {
        validat.checkNumber(user.getPhone());
        repository.CreateUser(user);
    }
    public void updateUser(User user,Field33333s field, String param) throws Exception {
        if(field == Field33333s.TELEPHONE) {
            validat.checkNumber(param);
        }
        repository.UpdateUser(user, field, param);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }

        throw new Exception("User not found");
    }
    public List <User> getUsers() throws Exception {
        return repository.getAllUsers();
    }
    public void deleteUser(User user) throws Exception {
        repository.delUser(user);}
}
