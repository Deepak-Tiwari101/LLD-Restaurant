package commands;

import services.ReviewServices;

import java.util.List;

public class AddReviewCommand implements ICommand{
    private final ReviewServices reviewServices;

    public AddReviewCommand(ReviewServices reviewServices) {
        this.reviewServices = reviewServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        byte rating = Byte.parseByte(tokens.get(1));
        Long userID = Long.valueOf(tokens.get(2));
        Long restaurantID = Long.valueOf(tokens.get(3));
        String dishNames = tokens.get(4);
        String description = tokens.get(5);
        reviewServices.addReview(rating, userID, restaurantID, dishNames, description);
    }
}
