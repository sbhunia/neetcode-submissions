class Solution {

    Map<Character, Integer> charCount(String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            int count =1;
            if(map.containsKey(c))
                count+=map.get(c);
            map.put(c,count);
        }
        return map;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = charCount(s);
        Map<Character, Integer> tMap = charCount(t);
        return sMap.equals(tMap);
    }
}
