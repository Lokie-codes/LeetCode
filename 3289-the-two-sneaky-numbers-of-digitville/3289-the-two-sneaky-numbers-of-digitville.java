class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res= new int[2];
        int[] digits = new int[100];
        int j = 0;
        for(int num: nums) {
            digits[num] += 1;
            if(digits[num] > 1) {
                res[j] = num;
                j++;
            }
        }
        return res;
    }
}