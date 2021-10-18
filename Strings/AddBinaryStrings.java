public class Solution {
    public String addBinary(String A, String B) {

//      Approach-1:

        // StringBuilder sb_A = new StringBuilder(A);
        // StringBuilder sb_B = new StringBuilder(B);

        // sb_A.reverse();
        // sb_B.reverse();

        // A = sb_A.toString();
        // B = sb_B.toString();

        // int i=0;
        // int j=0;
        // int carry = 0;

        // StringBuilder ans = new StringBuilder();

        // while(i < A.length() || j < B.length()){
        //     int sum = carry;
        //     if(i <A.length()){
        //         sum += (A.charAt(i) - '0');
        //     }
        //     if(j < B.length()){
        //         sum += (B.charAt(j) - '0');
        //     }
        //     String sum_binary = Integer.toBinaryString(sum);
        //     if(sum_binary.length() == 1){
        //         ans.append(sum_binary.charAt(0));
        //         carry = 0;
        //     } else{
        //         carry = 1;
        //         ans.append(sum_binary.charAt(sum_binary.length()-1));
        //     }
        //     i++;
        //     j++;
        // }
        // if(carry != 0){
        //     ans.append(carry);
        // }
        // ans.reverse();
        // return ans.toString();

//      Approach-2:

        StringBuilder ans = new StringBuilder();
        int i = A.length()-1;
        int j = B.length()-1;

        int carry = 0;

        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0){
                sum += (A.charAt(i) - '0');
            }
            if(j>=0){
                sum += (B.charAt(j) - '0');
            }
            ans.append(sum%2);
            carry = sum/2;
            i--;
            j--;
        }
        if(carry != 0)
            ans.append(carry);

        return ans.reverse().toString();
    }
}
