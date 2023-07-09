package repositories.interfaces;

import entities.Restaurant;
import entities.Review;
import entities.User;

import java.util.List;
import java.util.Optional;

public interface IReviewRepo {
    Review save(Review review, User user, Restaurant restaurant);
    List<Review> findAll();
    Optional<Review> findById(Long id);
    Review findByUserAndRestaurant(User user, Restaurant restaurant);
    boolean reviewExists(Review review);
    void delete(Review review);
    int count();
    void updateRevMapWithNewReview(Long id, Review review);
}
