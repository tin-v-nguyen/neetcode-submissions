class Solution {
    public int numDecodings(String s) {
        /*
            
            - how many ways can we take from a given index?
            - at each index we can take two paths
                - 0 if it is a 0
                - decode the int at the index
                    - same as ways[i + 1] since we are just prepending a char
                - decode the int and the next together at the index
                    - same as ways[i + 2]
                    - can only do this if first int is < 2 || (char ==  2 and second int < 7)
            - maintain array ways[i] of how many paths we can take from a given index i
            - looking for ways[0]
        */

        int[] ways = new int[s.length() + 1];
        ways[s.length()] = 1;
        if (s.charAt(s.length() - 1) != '0') ways[s.length() - 1] = 1;
    
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') ways[i] = 0;
            else {
                ways[i] = ways[i + 1];
                if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    ways[i] += ways[i + 2];
                }
            }

        }
        return ways[0];
    }
}
