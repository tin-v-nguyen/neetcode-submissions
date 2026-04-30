class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("|");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != ('|')) j++;
            int length = Integer.valueOf(str.substring(i, j));
            output.add(str.substring(j + 1, j + length + 1));
            i = j + length + 1;
        }
        return output;
    }
}
