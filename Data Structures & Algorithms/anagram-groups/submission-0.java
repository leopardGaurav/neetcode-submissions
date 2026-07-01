class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Ek HashMap banayein jahan Key = Sorted String, Value = List of Anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // 1. String ko character array mein convert karein aur sort karein
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray); // Yeh hamari KEY ban gayi
            
            // 2. Agar yeh key map mein nahi hai, to ek nayi list banayein
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            
            // 3. Original string ko us key ki list mein add kar dein
            map.get(sortedStr).add(s);
        }
        
        // HashMap ki saari values (sublists) ko ek badi list mein convert karke return karein
        return new ArrayList<>(map.values());
    }
}