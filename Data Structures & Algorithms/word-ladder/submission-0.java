class Solution {
    // Step1 :- COnvert this word into character Array
    // Step2 :- loop throgh this word
    // Step3 :- for each letter from a to z loop through and try all the replacement.
    // step4 :- if this one is found in the hashshet then append this word to queue and then 

    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        int level = 1;
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        Deque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        if(!set.contains(endWord)) return 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int j=0;j<size;j++){
                String word = queue.poll();
                // if(word.equals(endWord)) return level; do not write it here just to avoid small optimisation of one iteration
                char[] arr = word.toCharArray();
                for (int i=0;i<arr.length;i++){
                    char org = arr[i];
                    for(char c='a';c<='z';c++){
                        if(c==org) continue;
                        arr[i] = c;
                        String next = new String(arr);
                        if(next.equals(endWord)) return level+1; // if(next.equals(word))continue;
                        if(set.contains(next)){
                            queue.add(next);
                            set.remove(next); // removing because of unnecessary checking the same word again.
                        }
                    }
                    arr[i] = org;
                }
            }
            level++;
        }
        return 0;
    }
}
