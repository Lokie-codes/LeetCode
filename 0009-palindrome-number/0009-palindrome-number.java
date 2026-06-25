class Solution {
    public boolean isPalindrome(int x) {
        char[] s = String.valueOf(x).toCharArray();
        int n = s.length;
        for(int i=0, j=n-1; i<n/2; i++, j--) {
            if(s[i] != s[j]) {
                return false;
            }
        }
        return true;
    }
}