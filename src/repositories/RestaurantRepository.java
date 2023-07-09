package repositories;

import entities.Restaurant;
import entities.User;
import repositories.interfaces.IRestaurantRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RestaurantRepository implements IRestaurantRepo {
    private final Map<Long, Restaurant> restaurantMap;
    private Long autoIncreament = 1L;
    public RestaurantRepository(Map<Long, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        Restaurant r = new Restaurant(autoIncreament, restaurant.getName());
        restaurantMap.put(autoIncreament++, r);
        return r;
    }

    @Override
    public List<Restaurant> findAll() {
        return new ArrayList<>(restaurantMap.values());
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return Optional.ofNullable(restaurantMap.get(id));
    }

    @Override
    public Optional<Restaurant> findByName(String restaurantName) {
        for (Map.Entry<Long, Restaurant> entry : restaurantMap.entrySet()) {
            if (entry.getValue().getName().equalsIgnoreCase(restaurantName))
                return Optional.ofNullable(entry.getValue());
        }
        return Optional.empty();
    }

    @Override
    public boolean restaurantExists(Restaurant restaurant) {
        return restaurantMap.values().stream().anyMatch(value -> value.equals(restaurant));
    }

    @Override
    public void delete(Restaurant restaurant) {
        restaurantMap.remove(restaurant.getId());
    }

    @Override
    public int count() {
        return restaurantMap.size();
    }
}
