public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Approach-1:
        // return helper(s, 3);

        // Approach-2:
        ArrayList<String> ans = new ArrayList<>();
        for(int i=1; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                for(int k=j+1; k<s.length(); k++){
                    StringBuilder ip_address = new StringBuilder();
                    for(int m=0; m<s.length(); m++){
                        if(m == i || m == j || m == k){
                            ip_address.append('.');
                            ip_address.append(s.charAt(m));
                        } else{
                            ip_address.append(s.charAt(m));
                        }
                    }
                    if(isValid(ip_address.toString())){
                        ans.add(ip_address.toString());
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;

    }
    
    // static ArrayList<String> helper(String s, int dots){
    //     if(s.length() < dots+1){
    //         return new ArrayList<>();
    //     }
    //     if(dots == 0){
    //         ArrayList<String> ans = new ArrayList<>();
    //         ans.add(s);
    //         return ans;
    //     }
    //     ArrayList<String> ans = new ArrayList<>();
    //     for(int i=s.length()-1; i>=0; i--){
    //         String lastNum = s.substring(i);
    //         ArrayList<String> list = helper(s.substring(0, i), dots-1);
    //         for(String str : list){
    //             ans.add(str + "." + lastNum);
    //         }
    //     }
    //     ArrayList<String> real_ans = new ArrayList<>();
    //     for(String ip_address : ans){
    //         if(isValid(ip_address)){
    //             real_ans.add(ip_address);
    //         }
    //     }
    //     Collections.sort(real_ans);
    //     return real_ans;
    // }
    static boolean isValid(String ip_address){
        String[] nums = ip_address.split("\\.");
        for(int i=0; i<nums.length; i++){
            // if(nums[i].length() == 0)
            //     return false;
            
            int currNum = Integer.parseInt(nums[i]);
            if(nums[i].charAt(0) == '0' && nums[i].length() > 1)
                return false;
            if(currNum < 0 || currNum > 255){
                return false;
            }
        }
        return true;
    }
}
