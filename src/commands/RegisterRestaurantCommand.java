package commands;

import services.RestaurantServices;

import java.util.List;

public class RegisterRestaurantCommand implements ICommand{
    private final RestaurantServices restaurantServices;

    public RegisterRestaurantCommand(RestaurantServices restaurantServices) {
        this.restaurantServices = restaurantServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        String restaurantName = tokens.get(1);
        restaurantServices.registerRestaurant(restaurantName);
    }
}
