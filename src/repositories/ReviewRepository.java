package repositories;

import entities.Restaurant;
import entities.Review;
import entities.User;
import repositories.interfaces.IReviewRepo;

import java.util.*;

public class ReviewRepository implements IReviewRepo {
    private final Map<Long, Review> reviewMap;
    private Long autoIncreament = 1L;

    public ReviewRepository() {
        this.reviewMap = new HashMap<>();
    }

    @Override
    public Review save(Review review, User user, Restaurant restaurant) {
        Review rev = new Review(autoIncreament, review.getRating(), review.getDish_name(), review.getDescription(), user, restaurant);
        reviewMap.put(autoIncreament++, rev);
        return rev;
    }
    @Override
    public List<Review> findAll() {
        return new ArrayList<>(reviewMap.values());
    }

    @Override
    public Optional<Review> findById(Long id) {
        return Optional.ofNullable(reviewMap.get(id));
    }

    @Override
    public Review findByUserAndRestaurant(User user, Restaurant restaurant) {
        return reviewMap.values().stream().filter(review ->
                review.getCreatedByUser().equals(user) && review.getCreatedForRestaurant().equals(restaurant)
        ).findFirst().orElse(null);
    }

    @Override
    public boolean reviewExists(Review review) {
        return reviewMap.values().stream().anyMatch(value -> value.equals(review));
    }

    @Override
    public void delete(Review review) {
        reviewMap.remove(review.getId());
    }

    @Override
    public int count() {
        return reviewMap.size();
    }

    @Override
    public void updateRevMapWithNewReview(Long id, Review review) {
        reviewMap.put(id, review);
    }
}
