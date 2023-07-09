package entities;

import java.util.List;
import java.util.Objects;

public class Restaurant {
    private final Long id;
    private final String name;
    private float avg_rating;
    private final List<Review> reviewsList;


    public Restaurant(Long id, String name) {
        this.id = id;
        this.name = name;
        this.avg_rating = 0f;
        reviewsList = null;
    }

    public Restaurant(String name) { // constructor override with no ID
        this.id = null;
        this.name = name;
        this.avg_rating = 0f;
        reviewsList = null;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant that)) return false;
        return Float.compare(that.getAvg_rating(), getAvg_rating()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAvg_rating());
    }

    public String getName() {
        return name;
    }

    public float getAvg_rating() {
        return avg_rating;
    }

    public List<Review> getReviewsList() {
        return reviewsList;
    }

    @Override
    public String toString() {
        return "Restaurant [" +
                "id=" + id +
                ']';
    }

    public void refreshAvgRating() {
        assert reviewsList != null;
        this.avg_rating = (float)reviewsList.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);
    }
}
