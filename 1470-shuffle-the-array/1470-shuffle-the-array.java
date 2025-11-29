class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        for(int i=0, j=n, k=0; i<n; i++, j++, k+=2) {
            res[k] = nums[i];
            res[k+1] = nums[j];
        }
        return res;
    }
}