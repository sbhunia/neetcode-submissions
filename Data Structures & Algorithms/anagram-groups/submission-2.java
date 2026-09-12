class Solution {
    /*
    cc1 : hat
    cc2 : act cat
    cc3 : stop pots tops
    
    for cat: c:1 a:1 t:1
    [1  0   1   0   0   0   0.....1     0   0]
    
    */

    String stringHash(String s){
        //s = s.toLowerCase();
        int[] charCount = new int[26];
        for(int x: charCount)
            x=0;
        for(int i =0; i<s.length(); i++){
            charCount[ s.charAt(i) - 'a'] ++;
        }
        return Arrays.toString(charCount);
    }
    

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String hash = stringHash(s);
            if(!map.containsKey(hash))
                map.put(hash, new ArrayList<>());
            map.get(hash).add(s);
        }
        return new ArrayList(map.values());
    }
}
