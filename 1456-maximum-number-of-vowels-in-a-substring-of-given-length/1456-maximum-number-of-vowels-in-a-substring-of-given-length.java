class Solution {

    private boolean isVowel(char ch) {
        return ch == 'a' ||
                ch == 'e' ||
                ch == 'i' ||
                ch == 'o' ||
                ch == 'u';
    }

    public int maxVowels(String s, int k) {

        int vowelCount = 0;

        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowelCount++;
            }
        }

        int maxCount = vowelCount;

        for (int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i-k))){
                vowelCount--;
            }
            if(isVowel(s.charAt(i))){
                vowelCount++;
            }

            maxCount = Math.max(maxCount,vowelCount);
        }
        return maxCount;
    }

}
