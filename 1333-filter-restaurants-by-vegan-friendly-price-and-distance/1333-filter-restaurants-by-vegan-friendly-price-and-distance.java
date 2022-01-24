class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
//         Map<Integer[], Integer> restaurantIdx = new HashMap<>();
//         Integer[][] boxedRestaurants = new Integer[restaurants.length][4];
        
//         for(int i = 0; i < restaurants.length; i++) {
//             boxedRestaurants[i] = Arrays.stream(restaurants[i]).boxed().toArray(Integer[]::new);
//             restaurantIdx.put(boxedRestaurants[i], i + 1);
//         }
        List<Integer> filteredRestaurantsIdx = new ArrayList<>();
        Arrays.sort(restaurants, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                int r1 = o1[1];
                int r2 = o2[1];
                if(r1 < r2) {
                    return 1;
                } else if(r1 > r2) {
                    return -1;
                } else {
                    int id1 = o1[0];
                    int id2 = o2[0];
                    return Integer.compare(id2, id1);
                }
            }
        });
        
        for(int[] restaurant: restaurants) {
            if(veganFriendly == 1 && restaurant[2] != veganFriendly) {
                continue;
            }
            if (restaurant[3] > maxPrice) {
                continue;
            }
            if (restaurant[4] > maxDistance) {
                continue;
            }
            filteredRestaurantsIdx.add(restaurant[0]);
        }

        return filteredRestaurantsIdx;
        
    }
}