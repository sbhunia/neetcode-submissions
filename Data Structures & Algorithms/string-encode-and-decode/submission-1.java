class Solution {

    public String encode(List<String> strs) {

        String result="";
        for(String s: strs){
            String lengthStr = "000"+Integer.toString(s.length());
            int len = lengthStr.length();
            lengthStr = lengthStr.substring(len-3, len);
            result+=lengthStr+s;
        }
        return result;
    }

    public List<String> decode(String str) {
        
        ArrayList<String> result = new ArrayList<String>();
        if(str==null || str.equals(""))
            return result;
            
        int start = 0;
        do{
            int len = Integer.parseInt(str.substring(start,start+3));
            start+=3;
            result.add(str.substring(start, start+len));
            start+=len;
        }while(start<str.length());

        return result;

    }
}
