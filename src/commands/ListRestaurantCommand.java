package commands;

import services.RestaurantServices;

import java.util.List;

public class ListRestaurantCommand implements ICommand{
    private final RestaurantServices restaurantServices;

    public ListRestaurantCommand(RestaurantServices restaurantServices) {
        this.restaurantServices = restaurantServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        restaurantServices.listRestaurant();
    }
}
