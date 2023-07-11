package services;

import entities.RatingOrder;
import entities.Restaurant;
import entities.Review;
import repositories.interfaces.IRestaurantRepo;

import java.util.Comparator;
import java.util.List;

public class RestaurantServices {
    private final IRestaurantRepo restaurantRepo;

    public RestaurantServices(IRestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }
    public void registerRestaurant(String restaurantName) {
        Restaurant restaurant = restaurantRepo.save(new Restaurant(restaurantName));
        System.out.println(restaurant);
    }
    public void getReviewsOrderByRating(Long restaurantID, RatingOrder order) {
        Restaurant restaurant = restaurantRepo.findById(restaurantID).orElseThrow(() -> new RuntimeException("Restaurant with restaurant id: " + restaurantID + " not found!"));
        List<Review> reviewList = restaurant.getReviewsList();

        if (RatingOrder.RATING_ASC == order)
            reviewList = reviewList.stream().sorted(Comparator.comparingInt(Review::getRating)).toList();
        else
            reviewList = reviewList.stream().sorted(Comparator.comparingInt(Review::getRating).reversed()).toList();

        System.out.print('[');
        for (int i = 0; i < reviewList.size(); i++) {
            System.out.print(reviewList.get(i));
            if (i < reviewList.size() - 1) System.out.print(", ");
        }
        System.out.println(']');
    }
    public void getReviewsFilterOrderByRating(Long restaurantID, int low, int high, RatingOrder order) {
        Restaurant restaurant = restaurantRepo.findById(restaurantID).orElseThrow(() -> new RuntimeException("Restaurant with restaurant id: " + restaurantID + " not found!"));
        List<Review> reviewList = restaurant.getReviewsList();

        if (RatingOrder.RATING_ASC == order)
            reviewList = reviewList.stream().filter(review -> review.getRating() >= low && review.getRating() <= high).sorted(Comparator.comparingInt(Review::getRating)).toList();
        else
            reviewList = reviewList.stream().filter(review -> review.getRating() >= low && review.getRating() <= high).sorted(Comparator.comparingInt(Review::getRating).reversed()).toList();

        System.out.print('[');
        for (int i = 0; i < reviewList.size(); i++) {
            System.out.print(reviewList.get(i));
            if (i < reviewList.size() - 1) System.out.print(", ");
        }
        System.out.println(']');
    }
    public void describeRestaurant(Long restaurantID) {
        Restaurant restaurant = restaurantRepo.findById(restaurantID).orElseThrow(() -> new RuntimeException("Restaurant with restaurant id: " + restaurantID + " not found!"));
        System.out.println(restaurant.descRestaurant());
    }
    public void listRestaurant() {
        List<Restaurant> restaurantList = restaurantRepo.findAll();
        System.out.print('[');
        for (int i = 0; i < restaurantList.size(); i++) {
            System.out.print(restaurantList.get(i));
            if (i < restaurantList.size() - 1) System.out.print(", ");
        }
        System.out.println(']');
    }
}
