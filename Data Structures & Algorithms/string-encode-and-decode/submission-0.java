class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    // Decodes a single string back to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int j = i;
            // '#' delimiter ko dundho
            while (s.charAt(j) != '#') {
                j++;
            }
            
            // Length nikaalo aur string extract karo
            int length = Integer.parseInt(s.substring(i, j));
            res.add(s.substring(j + 1, j + 1 + length));
            
            // i ko agle block par le jao
            i = j + 1 + length;
        }
        
        return res;
    }
}