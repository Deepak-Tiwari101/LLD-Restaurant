package commands;

import entities.RatingOrder;
import services.RestaurantServices;

import java.util.List;

public class GetReviewsCommand implements ICommand{
    private final RestaurantServices restaurantServices;

    public GetReviewsCommand(RestaurantServices restaurantServices) {
        this.restaurantServices = restaurantServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long restaurantID = Long.valueOf(tokens.get(1));
        RatingOrder order = RatingOrder.valueOf(tokens.get(2));
        restaurantServices.getReviewsOrderByRating(restaurantID, order);
    }
}
