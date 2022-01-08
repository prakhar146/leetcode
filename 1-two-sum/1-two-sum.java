class Solution {
    public int[] twoSum(int[] nums, int target) {
//        int[] arrayToSort = Arrays.copyOf(nums, nums.length);
//         Arrays.sort(arrayToSort);
//         int[] twoNums = new int[2];

//         int leftPtr = 0;
//         int rightPtr = arrayToSort.length - 1;

//         while (leftPtr < rightPtr) {
//             int leftElement = arrayToSort[leftPtr];
//             int rightElement = arrayToSort[rightPtr];
//             int numSum = leftElement + rightElement;

//             if (numSum == target) {
//                 twoNums[0] = indexOf(nums, leftElement)[0];
//                 int[] rightIndexes = indexOf(nums, rightElement);
//                 twoNums[1] = rightIndexes.length > 1 ? rightIndexes[1] : rightIndexes[0];
//                 // twoNums[0] = indexOf(nums, leftElement);
//                 // twoNums[1] = indexOf(nums, rightElement);
//                 break;
//             } else if (numSum > target) {
//                 rightPtr--;
//             } else  if (numSum < target) {
//                 leftPtr++;
//             }
//         }

//         return twoNums;
        
// ************************************************************************************************
        
        Map<Integer, List<Integer>> numWithIndexes = new HashMap<>();
        
        for (int i = 0 ; i < nums.length ; i++) {
            if (numWithIndexes.containsKey(nums[i])) {
                List<Integer> idxList = numWithIndexes.get(nums[i]);
                idxList.add(i);
            } else {
                List<Integer> idxList = new ArrayList<>();
                idxList.add(i);
                numWithIndexes.put(nums[i], idxList);
            }
        }

        for (int i: nums) {
            int complement = target - i;
            if (i == complement) {
                if (numWithIndexes.get(complement).size() > 1) {
                    return new int[] { numWithIndexes.get(complement).get(0), numWithIndexes.get(complement).get(1) };
                }
            } else {
                if (numWithIndexes.containsKey(complement)) {
                    return new int[] { numWithIndexes.get(i).get(0), numWithIndexes.get(complement).get(0) };
                }
            }
        }

        
        throw new IllegalArgumentException("No pair found");
    }
    // public int[] indexOf(int[] nums, int ele) {
    //     List<Integer> indexes = new ArrayList<>();
    //     for (int i = 0 ; i < nums.length ; i ++) {
    //         if (nums[i] == ele) {
    //             indexes.add(i);
    //         }
    //     }
    //     return indexes.stream().mapToInt(it -> it).toArray();
    // }
}