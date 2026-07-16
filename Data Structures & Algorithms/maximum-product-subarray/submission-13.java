class Solution {
    public int maxProduct(int[] nums) {
        // 1 2 3 4 5 6
        // -1 2 3 4 5 6
        //  given an array with odd negatives we need to exclude either the prefix including the first negative
        // or suffix inclpuding the last negative
        // -1 -2 3 4 5 6
        // even negatives subarray include them
        // 1 2 3 0 4 5 6
        // split array into segments bnased on 0s
        // max subarray with even negatives
        // if a subarray has even negatives we just take the whole product
        // if a subarray has odd negatives keep track of trhe first and last negative
        // calculate product wiht the perfix or with the suffix excluded

        List<List<Integer>> segments = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            if (i == nums.length || nums[i] == 0) {
                segments.add(new ArrayList<>(current));
                current = new ArrayList<>();
                continue;
            }
            current.add(nums[i]);
        } 

        int res = Integer.MIN_VALUE;

        // Zero itself may be the maximum product.
        for (int num : nums) {
            if (num == 0) {
                res = Math.max(res, 0);
            }
        }

        for (List<Integer> s : segments) {
            if (s.size() == 0) continue;
            // find the first and last negative and count
            int negs = 0;
            int first = -1;
            int last = s.size();

            for (int i = 0; i < s.size(); i++) {
                if (s.get(i) < 0) {
                    // update the last negative
                    last = i;
                    // update the first negative if its not yet set (-1)
                    if (first == -1) first = i;
                    negs++;
                }
            }

            int prod = 1;
            // calculate the entire product
            for (int i = 0; i < s.size(); i++) {
                prod *= s.get(i);
            }
            
            // if odd negativescalculate the max excluding prefix starting at first neg and suffix starting at last neg
            if (negs % 2 == 1) {
                
                
                if (first < s.size() - 1) {
                    int preProd = prod;
                    for (int j = 0; j <= first; j++) {
                        preProd /= s.get(j);
                    }
                    res = Math.max(res, preProd);
                }
                
                if (last > 0) {
                    int sufProd = prod;
                    for (int j = last; j < s.size(); j++) {
                        sufProd /= s.get(j);
                    }
                    res = Math.max(res,sufProd);
                }
                

                

            }
            
            // if even we just calculate the whole product
            res = Math.max(res, prod);
        }
        return res;
    }
    
}
