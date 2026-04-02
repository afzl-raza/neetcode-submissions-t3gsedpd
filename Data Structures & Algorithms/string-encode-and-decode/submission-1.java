class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String word:strs){
            int len = word.length();
            sb.append(len).append('*').append(word);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> ans_list = new ArrayList();
        int i=0;
        while (i<s.length()){
            int j = i;
            while(s.charAt(j)!='*'){
                j++;
            }
            int len = Integer.parseInt(s.substring(i,j));
            i = j+1;
            ans_list.add(s.substring(i,i+len));
            i+=len;
        }
        return ans_list;
    }
}
