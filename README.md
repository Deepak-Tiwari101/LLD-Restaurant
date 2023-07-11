# LLD-Restaurant

## Problem Statement:
Everyone uses zomato or swiggy but have you ever seen how restaurant rating systems work? Now when you give a review or rating to the restaurant you will know how it is working because we are going to design a rating platform. So let’s design a restaurant rating platform for the below features.
## Features:
1. Users should be able to register to give ratings for restaurants.
2. Among the pre-populated list of restaurants, registered users can give ratings between 1 to 5. If the same user gives a new rating for the same restaurant, it should be overwritten.
3. Along with a rating, users can add optional dish name(s) and rating description. Basically It is a review.
4. When fetching reviews for a restaurant based on filter and order by
    Filter: Reviews should be able to be filtered based on range of rating (eg. ratings between 2 (lower range) and 5  (higher range))
    Order by ascending or descending rating
    Default ordering is higher rating without any filter
5. When describing a restaurant, along with the name, give the average rating it received so far. We will make use of the 5 Star Rating Approach to display rating of the restaurants.
6. List restaurants based on descending order of (average) rating.
