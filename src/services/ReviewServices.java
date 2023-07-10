package services;

import entities.Restaurant;
import entities.Review;
import entities.User;
import repositories.interfaces.IRestaurantRepo;
import repositories.interfaces.IReviewRepo;
import repositories.interfaces.IUserRepo;

import java.util.List;

public class ReviewServices {
    private final IReviewRepo reviewRepo;
    private final IUserRepo userRepo;
    private final IRestaurantRepo restaurantRepo;

    public ReviewServices(IReviewRepo reviewRepo, IUserRepo userRepo, IRestaurantRepo restaurantRepo) {
        this.reviewRepo = reviewRepo;
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
    }

    private Review getReviewIfPresentAlready(User user, Restaurant restaurant) {
        return reviewRepo.findByUserAndRestaurant(user, restaurant);
    }

    public void addRating(byte rating, Long userId, Long restaurantId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User with userID: " + userId + " not found"));
        Restaurant restaurant = restaurantRepo.findById(restaurantId).orElseThrow(() -> new RuntimeException("Restaurant with restaurantID: " + userId + " not found"));
        Review review = getReviewIfPresentAlready(user, restaurant);
        if (review != null) // this review is already added from the user to the restaurant but may be with different rating
        {
            Review newReview = new Review(review.getId(), rating, user, restaurant); // created a review with new rating to override the old one
            reviewRepo.updateRevMapWithNewReview(review.getId(), newReview);

            user.getReviewList().set(user.getReviewList().indexOf(review), newReview);
            user.refreshUserLevel();

            restaurant.getReviewsList().set(restaurant.getReviewsList().indexOf(review), newReview);
            restaurant.refreshAvgRating();

            review = newReview;
        } else {
            review = reviewRepo.save(new Review(rating), user, restaurant);
            user.getReviewList().add(review);
            user.refreshUserLevel();

            restaurant.getReviewsList().add(review);
            restaurant.refreshAvgRating();
        }
        System.out.println(review + " added successfully for " + restaurant + " by " + user + "!");
    }

    public void addReview(byte rating, Long userId, Long restaurantId, String dishNames, String descriptions) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User with userID: " + userId + " not found"));
        Restaurant restaurant = restaurantRepo.findById(restaurantId).orElseThrow(() -> new RuntimeException("Restaurant with restaurantID: " + userId + " not found"));
        Review review = getReviewIfPresentAlready(user, restaurant);
        if (review != null) // this review is already added from the user to the restaurant but may be with different rating
        {
            Review newReview = new Review(review.getId(), rating, dishNames, descriptions, user, restaurant); // created a review with new rating to override the old one
            reviewRepo.updateRevMapWithNewReview(review.getId(), newReview);

            user.getReviewList().set(user.getReviewList().indexOf(review), newReview);
            user.refreshUserLevel();

            restaurant.getReviewsList().set(restaurant.getReviewsList().indexOf(review), newReview);
            restaurant.refreshAvgRating();

            review = newReview;
        } else {
            review = reviewRepo.save(new Review(rating, dishNames, descriptions), user, restaurant);
            user.getReviewList().add(review);
            user.refreshUserLevel();

            restaurant.getReviewsList().add(review);
            restaurant.refreshAvgRating();
        }
        System.out.println(review + " added successfully for " + restaurant + " by " + user);
    }
}
