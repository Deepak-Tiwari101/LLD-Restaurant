import commands.*;
import repositories.RestaurantRepository;
import repositories.ReviewRepository;
import repositories.UserRepository;
import repositories.interfaces.IRestaurantRepo;
import repositories.interfaces.IReviewRepo;
import repositories.interfaces.IUserRepo;
import services.RestaurantServices;
import services.ReviewServices;
import services.UserServices;

public class Configuration {
    //Singleton Pattern
    private static final Configuration instance = new Configuration();
    private final CommandRegistry commandRegistry = new CommandRegistry();
    private Configuration(){} // making the constructor private so that this class cannot be instantiated
    public static Configuration getInstance() {
        return instance;
    }

    // Initialize Repositories
    private final IUserRepo userRepo = new UserRepository();
    private final IReviewRepo reviewRepo = new ReviewRepository();
    private final IRestaurantRepo restaurantRepo = new RestaurantRepository();

    // Initialize Services
    private final UserServices userServices = new UserServices(userRepo);
    private final ReviewServices reviewServices = new ReviewServices(reviewRepo, userRepo, restaurantRepo);
    private final RestaurantServices restaurantServices = new RestaurantServices(restaurantRepo);

    //Initialize commands
    private final ICommand addRatingCommand = new AddRatingCommand(reviewServices);
    private final ICommand addReviewCommand = new AddReviewCommand(reviewServices);
    private final ICommand describeRestaurantCommand = new DescribeRestaurantCommand(restaurantServices);
    private final ICommand getReviewsCommand = new GetReviewsCommand(restaurantServices);
    private final ICommand getReviewsFilterOrderCommand = new GetReviewsFilterOrderCommand(restaurantServices);
    private final ICommand listRestaurantCommand = new ListRestaurantCommand(restaurantServices);
    private final ICommand registerRestaurantCommand = new RegisterRestaurantCommand(restaurantServices);
    private final ICommand registerUserCommand = new RegisterUserCommand(userServices);

    // Register commands
    private void registerCommands() {
        commandRegistry.registerCommand(CommandKeyword.ADD_RATING_COMMAND.getName(), addRatingCommand);
        commandRegistry.registerCommand(CommandKeyword.ADD_REVIEW_COMMAND.getName(), addReviewCommand);
        commandRegistry.registerCommand(CommandKeyword.DESCRIBE_RESTAURANT_COMMAND.getName(), describeRestaurantCommand);
        commandRegistry.registerCommand(CommandKeyword.GET_REVIEWS_COMMAND.getName(), getReviewsCommand);
        commandRegistry.registerCommand(CommandKeyword.GET_REVIEWS_FILTER_ORDER_COMMAND.getName(), getReviewsFilterOrderCommand);
        commandRegistry.registerCommand(CommandKeyword.LIST_RESTAURANT_COMMAND.getName(), listRestaurantCommand);
        commandRegistry.registerCommand(CommandKeyword.REGISTER_RESTAURANT_COMMAND.getName(), registerRestaurantCommand);
        commandRegistry.registerCommand(CommandKeyword.REGISTER_USER_COMMAND.getName(), registerUserCommand);
    }

    public CommandRegistry getCommandRegistry() {
        registerCommands();
        return commandRegistry;
    }
}
