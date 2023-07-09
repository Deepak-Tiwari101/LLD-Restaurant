package entities;

import java.util.List;
import java.util.Objects;

public class User {
    private final Long id;
    private final String name;
    private UserLevel level;
    private final List<Review> reviewList;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
        level = UserLevel.LEVEL1; // at the beginning every user will have to start with level 1
        reviewList = null;
    }

    public User(String name) {
        this.id = null;
        this.name = name;
        level = UserLevel.LEVEL1;
        reviewList = null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNum_ratings() {
        assert reviewList != null : "Review list is null for the user: " + this.id;
        return reviewList.size();
    }

    public UserLevel getLevel() {
        return level;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "User [" +
                "id=" + id +
                ']';
    }

    public void refreshUserLevel() {
        assert reviewList != null: "Review list is null for the user: \" + this.id";
        int count = reviewList.size();
        if(count < 4) return;
        if (count >= 4 && count < 8) this.level = UserLevel.LEVEL2;
        else if (count >= 8 && count < 16) this.level = UserLevel.LEVEL3;
        else this.level = UserLevel.LEVEL4;
    }
}
