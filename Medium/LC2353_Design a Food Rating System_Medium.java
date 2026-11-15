class FoodRatings {

    HashMap<String, String> cuisine = new HashMap<>();
    HashMap<String, Integer> rating = new HashMap<>();
    HashMap<String, TreeSet<String>> map = new HashMap<>();

    FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        for (int i = 0; i < foods.length; i++) {
            cuisine.put(foods[i], cuisines[i]);
            rating.put(foods[i], ratings[i]);

            map.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
                if (!rating.get(a).equals(rating.get(b))) {
                    return rating.get(b) - rating.get(a);
                }
                return a.compareTo(b);
            }));

            map.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String c = cuisine.get(food);

        map.get(c).remove(food);
        rating.put(food, newRating);
        map.get(c).add(food);
    }

    public String highestRated(String c) {
        return map.get(c).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
