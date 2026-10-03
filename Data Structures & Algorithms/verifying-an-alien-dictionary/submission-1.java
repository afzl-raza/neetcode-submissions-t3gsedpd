class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Create rank[26]
        int[] rank = new int[26];
        // for each character in order:
        // rank[character] = its position
        int m = order.length();
        for(int i=0;i<m;i++){
            rank[order.charAt(i)-'a'] = i;
        }
        int n = words.length;
        for(int i=0;i<n-1;i++){
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[i+1].toCharArray();
            int min = Math.min(word1.length,word2.length);
            boolean diff =false;
            for(int j=0;j<min;j++){
                if(word1[j]!=word2[j]){
                    diff = true;
                    if(rank[word1[j]-'a']>rank[word2[j]-'a']){
                        
                        return false;
                    }
                    break;
                }
            }
            if(!diff && word1.length > word2.length) return false;
        }
        return true;
    }
}
// for every adjacent pair of words:

//     compare characters from left to right

//     if characters are different:
//         if rank[first] > rank[second]:
//             return false

//         stop comparing this pair

//     if no characters were different:
//         if first word is longer:
//             return false

// return true
