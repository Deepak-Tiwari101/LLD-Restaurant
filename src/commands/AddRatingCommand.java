package commands;

import services.ReviewServices;

import java.util.List;

public class AddRatingCommand implements ICommand{
    private final ReviewServices reviewServices;

    public AddRatingCommand(ReviewServices reviewServices) {
        this.reviewServices = reviewServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        byte rating = Byte.parseByte(tokens.get(1));
        Long userID = Long.valueOf(tokens.get(2));
        Long restaurantID = Long.valueOf(tokens.get(3));
        reviewServices.addRating(rating, userID, restaurantID);
    }
}
