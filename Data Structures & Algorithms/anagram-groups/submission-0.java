class Solution {
    private HashMap<Character, Integer> strToMap(String s){
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c))
                hm.put(c, 1+hm.get(c));
            else
                hm.put(c,1);
        }
        return hm;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>>
            hm2 = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();
        for(int i=0; i<strs.length; i++){
            HashMap<Character, Integer> hm = strToMap(strs[i]);
            ArrayList<String> al = new ArrayList<String>();
            al.add(strs[i]);
            if(hm2.containsKey(hm))
                al.addAll(hm2.get(hm));
            
            hm2.put(hm, al);
        }
        return new ArrayList(hm2.values());
    }
}
