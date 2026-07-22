class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        while (right < s.length()) {

            char ch = s.charAt(right);
            freq[ch - 'A']++;

            maxFrequency = Math.max(maxFrequency, freq[ch - 'A']);

            if ((right - left + 1) - maxFrequency > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            right++;
        }

        return maxLength;
    }
}