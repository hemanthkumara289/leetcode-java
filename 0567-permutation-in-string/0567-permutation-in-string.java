class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int left = 0;
        int right = s1.length();

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        while (right < s2.length()) {
            char leftChar = s2.charAt(left);
            freq2[leftChar - 'a']--;

            char rightChar = s2.charAt(right);
            freq2[rightChar - 'a']++;

            left++;
            right++;

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;

    }
}