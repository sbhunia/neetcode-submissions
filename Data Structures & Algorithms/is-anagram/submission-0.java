class Solution {

    private HashMap<Character, Integer> strToMap(String s){
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c)+1);
            } else{
                hm.put(c,1);
            }
        }
        return hm;
    }

    private int[] strToArr(String s){
        int [] s_map = new int[26];
        for(int i=0; i<s_map.length; i++)
            s_map[i]=0;
        
        for(int i=0; i<s.length(); i++){
            int k = (int) (s.charAt(i) - 'a');
            s_map[k]+=1;
        }
        return s_map;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int [] arr_s = strToArr(s);
        int [] arr_t = strToArr(t);
        for(int i=0; i<arr_s.length; i++){
            if(arr_s[i] != arr_t[i])
                return false;
        }
        return true;
    }
}
