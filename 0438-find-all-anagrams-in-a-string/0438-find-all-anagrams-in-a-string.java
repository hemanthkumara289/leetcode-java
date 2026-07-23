class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()){
            return result;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int left = 0;
        int right = p.length();

        for (int i = 0; i < p.length(); i++) {
            freq1[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            freq2[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) {
            result.add(left);
        }

        while(right < s.length()){
            char leftChar = s.charAt(left);
            freq2[leftChar - 'a']--;

            char rightChar = s.charAt(right);
            freq2[rightChar - 'a']++;

            left++;
            right++;

            if (Arrays.equals(freq1, freq2)) {
                result.add(left);
            }
        }

        return result;
    }
}

