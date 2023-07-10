package commands;

import entities.RatingOrder;
import services.RestaurantServices;

import java.util.List;

public class GetReviewsFilterOrderCommand implements ICommand{
    private final RestaurantServices restaurantServices;

    public GetReviewsFilterOrderCommand(RestaurantServices restaurantServices) {
        this.restaurantServices = restaurantServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long restaurantID = Long.valueOf(tokens.get(1));
        int low = Integer.parseInt(tokens.get(2));
        int high = Integer.parseInt(tokens.get(3));
        RatingOrder order = RatingOrder.valueOf(tokens.get(4));
        restaurantServices.getReviewsFilterOrderByRating(restaurantID, low, high, order);
    }
}
