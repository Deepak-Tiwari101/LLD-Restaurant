package repositories;

import entities.Restaurant;
import entities.Review;
import entities.User;
import repositories.interfaces.IReviewRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReviewRepository implements IReviewRepo {
    private final Map<Long, Review> reviewMap;
    private Long autoIncreament = 1L;

    public ReviewRepository(Map<Long, Review> reviewMap) {
        this.reviewMap = reviewMap;
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
    public void decreamentAutoId() {
        autoIncreament--;
    }
}
