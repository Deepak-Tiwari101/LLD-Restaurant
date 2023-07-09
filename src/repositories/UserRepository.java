package repositories;

import entities.User;
import repositories.interfaces.IUserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository implements IUserRepo {
    private final Map<Long, User> userMap;
    private Long autoIncreament = 1L;

    public UserRepository(Map<Long, User> userMap) {
        this.userMap = userMap;
    }

    @Override
    public User save(User user) {
        User u = new User(autoIncreament, user.getName());
        userMap.put(autoIncreament++, u);
        return u;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public Optional<User> findByName(String userName) {
        for (Map.Entry<Long, User> entry : userMap.entrySet()) {
            if (entry.getValue().getName().equalsIgnoreCase(userName))
                return Optional.ofNullable(entry.getValue());
        }
        return Optional.empty();
    }

    @Override
    public boolean userExists(User user) {
        return userMap.values().stream().anyMatch(value -> value.equals(user));
    }

    @Override
    public void delete(User user) {
        userMap.remove(user.getId());
    }

    @Override
    public int count() {
        return userMap.size();
    }
}
