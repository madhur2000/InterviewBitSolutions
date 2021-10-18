public class Solution {
    public String intToRoman(int A) {

        // Approach-1:

        // StringBuilder ans = new StringBuilder();

        // if(A == 0)
        //     return "";
        // if(A/1000 != 0){
        //     int firstDigit = A/1000;
        //     ans.append('M');
        //     ans.append(intToRoman(A - 1000));
        //     return ans.toString();
        // }
        // if(A/100 != 0){
        //     int firstDigit = A/100;
        //     if(firstDigit == 9){
        //         ans.append("CM");
        //         ans.append(intToRoman(A - 900));
        //         return ans.toString();
        //     }
        //     if(firstDigit >= 5){
        //         ans.append('D');
        //         ans.append(intToRoman(A - 500));
        //         return ans.toString();
        //     }
        //     if(firstDigit == 4){
        //         ans.append("CD");
        //         ans.append(intToRoman(A - 400));
        //         return ans.toString();
        //     }
        //     ans.append('C');
        //     ans.append(intToRoman(A - 100));
        //     return ans.toString();
        // }

        // if(A/10 != 0){
        //     int firstDigit = A/10;
        //     if(firstDigit == 9){
        //         ans.append("XC");
        //         ans.append(intToRoman(A - 90));
        //         return ans.toString();
        //     }
        //     if(firstDigit >= 5 && firstDigit <= 8){
        //         ans.append('L');
        //         ans.append(intToRoman(A - 50));
        //         return ans.toString();
        //     }
        //     if(firstDigit == 4){
        //         ans.append("XL");
        //         ans.append(intToRoman(A - 40));
        //         return ans.toString();
        //     }
        //     ans.append("X");
        //     ans.append(intToRoman(A - 10));
        //     return ans.toString();
        // }
        // if(A == 9){
        //     return "IX";
        // }
        // if(A >= 5 && A <= 8){
        //     ans.append('V');
        //     ans.append(intToRoman(A - 5));
        //     return ans.toString();
        // }
        // if(A == 4){
        //     return "IV";
        // }
        // ans.append("I");
        // ans.append(intToRoman(A - 1));
        // return ans.toString();

        // Approach-2:

        int[] bases = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder ans = new StringBuilder();

        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        for(int i : bases){
            while(A >= i){
                A = A - i;
                ans.append(map.get(i));
            }
        }
        return ans.toString();
    }
}
