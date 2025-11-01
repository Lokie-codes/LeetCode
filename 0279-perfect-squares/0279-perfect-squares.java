class Solution {
    int arr[];

    public int numSquares(int n) {
        arr = new int[10001];
       return helper(n);
    }

    private int helper(int n) {
        if(n == 0) {
            return 0;
        }

        if(arr[n] != 0) return arr[n];

        int minCount = Integer.MAX_VALUE;
        for(int i=1; i*i <= n; i++) {
            int res = 1 + helper(n - i*i);
            minCount = Math.min(minCount, res);
        }
        arr[n] = minCount;
        return minCount;
    }
}