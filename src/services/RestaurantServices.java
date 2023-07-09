package services;

import entities.Restaurant;
import repositories.interfaces.IRestaurantRepo;

public class RestaurantServices {
    private final IRestaurantRepo restaurantRepo;

    public RestaurantServices(IRestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }
    public void registerRestaurant(String restaurantName) {
        Restaurant restaurant = restaurantRepo.save(new Restaurant(restaurantName));
        System.out.println(restaurant);
    }
}
