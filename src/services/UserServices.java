package services;

import entities.User;
import repositories.interfaces.IUserRepo;

public class UserServices {
    private final IUserRepo userRepo;

    public UserServices(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void registerUser(String userName) {
        User user = userRepo.save(new User(userName));
        System.out.println(user);
    }
}
