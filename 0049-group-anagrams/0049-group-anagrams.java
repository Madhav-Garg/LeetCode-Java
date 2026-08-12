class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chararray = s.toCharArray();
            Arrays.sort(chararray);
            String sortarray = new String(chararray);
            if(!map.containsKey(sortarray)){
                map.put(sortarray, new ArrayList<>());
            }
            map.get(sortarray).add(s);
        }
        return new ArrayList<>(map.values());
    }
}