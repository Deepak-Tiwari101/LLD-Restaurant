package commands;

import services.RestaurantServices;

import java.util.List;

public class DescribeRestaurantCommand implements ICommand{
    private final RestaurantServices restaurantServices;

    public DescribeRestaurantCommand(RestaurantServices restaurantServices) {
        this.restaurantServices = restaurantServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long restaurantID = Long.valueOf(tokens.get(1));
        restaurantServices.describeRestaurant(restaurantID);
    }
}
