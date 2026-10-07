/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * Topic: Hash set, string, sliding window
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        // pointers
        int left = 0;
        int max = 0;

        // // adding the first char to the hash table
        // for (char ch : s.toCharArray()) {
        //     if (!seen.add(ch)) {          // add() returns false if already there
        //         System.out.println("Duplicate: " + ch);
        //         // left += 1;
                
        //         // Option 2: Print each element individually using a for-each loop
        //         for (char item : seen) {
        //             System.out.println(item);
        //         }
        //         // Shrinking the substring until we found the duplicate
        //         // by having the left pointer increment
        //         while (seen.contains(ch)) {
        //             System.out.println("Removing: " + s.charAt(left));
        //             left +=1;
        //         }
        //         seen.remove(ch);
        //     } else {
        //         // Check current substring length
        //         if ((right - left + 1) > max) {
        //             max = right - left + 1;
        //         }
        //     }
        //     // Increment to next one
        //     right += 1;
        // }

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Shrink from the left until the earlier copy of ch is gone
            while (seen.contains(ch)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(ch);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}