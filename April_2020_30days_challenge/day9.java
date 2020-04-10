// https://leetcode.com/problems/backspace-string-compare/

// Space O(1) method

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        
        while (i >= 0 || j >= 0) {
            int cnt = 0;
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    cnt++;
                    i--;
                } else if (cnt > 0) {
                    i--;
                    cnt--;
                } else {
                    break;
                }
            }
            
            cnt = 0;
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    cnt++;
                    j--;
                } else if (cnt > 0) {
                    j--;
                    cnt--;
                } else {
                    break;
                }
            }
            
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            }
            
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            
            i--;
            j--;
        }
        
        return true;
    }
}