class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String answer = "";
        for(int i = 0; i < words.length; i++)
        {
            char[] word = words[i].toCharArray();
            int left = 0;
            int right = word.length - 1;
            while(left < right)
            {
                char temp = word[left];
                word[left] = word[right];
                word[right] = temp;
                left++;
                right--;
            }
            words[i] = new String(word);
            answer = answer + words[i] + " ";

        }
        return answer.trim();
    }
}