class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        int end = s.length() - 1;
        String ans = "";

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == ' ' && i + 1 < s.length() && s.charAt(i + 1) != ' ') {

                ans += s.substring(i + 1, end + 1) + " ";

                end = i - 1;

                while (end >= 0 && s.charAt(end) == ' ') {
                    end--;
                }
            }
        }

        ans += s.substring(0, end + 1);

        return ans.trim();
    }
}