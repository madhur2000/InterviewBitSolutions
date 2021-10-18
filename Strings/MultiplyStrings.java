public class Solution {
    public String multiply(String A, String B) {
        // if(B.equals("0") || A.equals("0"))
        //     return "0";

        int itr = 0;
        while(itr < A.length() && A.charAt(itr) == '0'){
            itr++;
        }

        A = A.substring(itr);
        

        itr = 0;
        while(itr < B.length() && B.charAt(itr) == '0'){
            itr++;
        }

        B = B.substring(itr);

        if(A.length() == 0 || B.length() == 0)
            return "0";

        int zeroes = 0;
        String sum = "0";
        for(int i=B.length()-1; i>=0; i--){
            int num1 = B.charAt(i) - '0';
            StringBuilder res = new StringBuilder();
            int carry = 0;
            for(int j=A.length()-1; j>=0; j--){
                int num2 = A.charAt(j) - '0';
                int num = (num1 * num2) + carry;
                carry = num/10;
                res.append(num%10);
            }
            if(carry != 0)
                res.append(carry);
            res.reverse();
            for(int k=1; k<=zeroes; k++){
                res.append(0);
            }
            sum = addTwoNumbers(sum, res.toString());
            zeroes++;
        }
        return sum;
    }

    static String addTwoNumbers(String A, String B){
        int i = A.length()-1;
        int j = B.length()-1;

        StringBuilder ans = new StringBuilder();
        int carry = 0;
        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0)
                sum += (A.charAt(i) - '0');
            if(j>=0)
                sum += (B.charAt(j) - '0');
            ans.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        if(carry != 0)
            ans.append(carry);
        return ans.reverse().toString();
    }
}
