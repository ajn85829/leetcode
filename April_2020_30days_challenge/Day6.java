// https://leetcode.com/problems/group-anagrams/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            
            int[] base = new int[26];
            Arrays.fill(base, 0);
            
            for (char c : str.toCharArray()) {
                base[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(base[i]);
            }
            
            String key = sb.toString();
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());   
            }
            
            map.get(key).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> value : map.values()) {
            result.add(value);
        }
        
        return result;
    }
}