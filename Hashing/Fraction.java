public class Solution {
    public String fractionToDecimal(int A, int B) {
        long n = A;
        long d = B;
        boolean n_is_negative = false;
        boolean d_is_negative = false;
        if(n < 0){
            n_is_negative = true;
            n = -1*n;
        }
        if(d < 0){
            d_is_negative = true;
            d = -1*d;
        }

        StringBuilder ans = new StringBuilder();
        
        if(((n_is_negative && !d_is_negative) || (!n_is_negative && d_is_negative)) && n != 0){
            ans.append("-");
        }

        long q = n/d;
        long r = n%d;
        ans.append(q);
        if(r == 0)
            return ans.toString();
        else{
            ans.append(".");
            Map<Long, Integer> map = new HashMap<>();
            while(r != 0){
                if(!map.containsKey(r)){
                    map.put(r, ans.length());
                    r = r*10;
                    q = r/d;
                    r = r%d;
                    ans.append(q);
                } else{
                    int startIndex = map.get(r);
                    ans.insert(startIndex, "(");
                    ans.append(")");
                    // return ans.toString();
                    break;
                }
            }
        }
        
        return ans.toString();
    }
}
