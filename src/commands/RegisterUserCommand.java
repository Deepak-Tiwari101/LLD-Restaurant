package commands;

import services.UserServices;

import java.util.List;

public class RegisterUserCommand implements ICommand{
    private final UserServices userServices;

    public RegisterUserCommand(UserServices userServices) {
        this.userServices = userServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        String userName = tokens.get(1);
        userServices.registerUser(userName);
    }
}
