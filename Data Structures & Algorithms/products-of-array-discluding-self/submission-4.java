class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] incProduct = new int[nums.length];
        int[] decProduct = new int[nums.length];
        incProduct[0] = nums[0];
        decProduct[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            incProduct[i] = incProduct[i - 1] * nums[i];
            decProduct[nums.length - 1 - i] = decProduct[nums.length - i] * nums[nums.length - 1 - i];
        }
        int[] output = new int[nums.length];
        output[0] = decProduct[1];
        output[nums.length - 1] = incProduct[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            output[i] = incProduct[i - 1] * decProduct[i + 1];
        }
        return output;
    }
}  
