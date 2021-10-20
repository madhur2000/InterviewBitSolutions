public class Solution {
    public int romanToInt(String A) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        
        for(int i=A.length()-1; i>=0; ){
            if(i-1 >= 0 && map.containsKey(A.substring(i-1, i+1))){
                ans += map.get(A.substring(i-1, i+1));
                i = i-2;
            } else{
                ans += map.get(String.valueOf(A.charAt(i)));
                i--;
            }
        }
        return ans;
    }
}
