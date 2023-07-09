package entities;

import java.util.Objects;

public class Review {
    private final Long id;
    private final byte rating;
    private final String dish_name;
    private final String description;
    private final User createdByUser;
    private final Restaurant createdForRestaurant;


    public Review(Long id, byte rating, String dish_name, String description, User user, Restaurant restaurant) {
        this.id = id;
        this.rating = rating;
        this.dish_name = dish_name;
        this.description = description;
        this.createdByUser = user;
        this.createdForRestaurant = restaurant;
    }

    public Review(Long id, byte rating, User user, Restaurant restaurant) {
        this.id = id;
        this.rating = rating;
        this.dish_name = "";
        this.description = "";
        this.createdByUser = user;
        this.createdForRestaurant = restaurant;
    }

    public Review(byte rating) {
        this.id = null;
        this.rating = rating;
        this.dish_name = "";
        this.description = "";
        this.createdByUser = null;
        this.createdForRestaurant = null;
    }

    public Review(byte rating, String dish_name, String description, User user, Restaurant restaurant) {
        this.id = null;
        this.rating = rating;
        this.dish_name = dish_name;
        this.description = description;
        this.createdByUser = user;
        this.createdForRestaurant = restaurant;
    }

    public Review(byte rating, String dish_name, String description) {
        this.id = null;
        this.rating = rating;
        this.dish_name = dish_name;
        this.description = description;
        this.createdByUser = null;
        this.createdForRestaurant = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review review)) return false;
        return Objects.equals(createdByUser, review.createdByUser) && Objects.equals(createdForRestaurant, review.createdForRestaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdByUser, createdForRestaurant);
    }

    public Long getId() {
        return id;
    }

    public byte getRating() {
        return rating;
    }

    public String getDish_name() {
        return dish_name;
    }

    public String getDescription() {
        return description;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }

    public Restaurant getCreatedForRestaurant() {
        return createdForRestaurant;
    }
}
