package repositories.interfaces;

import entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepo {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByName(String userName);
    boolean userExists(User user);
    void delete(User user);
    int count();

}
