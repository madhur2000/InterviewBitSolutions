public class Solution {
    public ArrayList<String> reorderLogs(ArrayList<String> A) {
        ArrayList<String> let_logs = new ArrayList<>();
        ArrayList<String> dig_logs = new ArrayList<>();
        for(int i=0; i<A.size(); i++){
            if(isLetterLog(A.get(i))){
                let_logs.add(A.get(i));
            } else{
                dig_logs.add(A.get(i));
            }
        }
        Collections.sort(let_logs, new Comparator<String>(){
            public int compare(String s1, String s2){
                String s1_content = getContent(s1);
                String s2_content = getContent(s2);
                if(s1_content.compareTo(s2_content) == 0 && getId(s1).compareTo(s2)>0){
                    return 1;
                }
                return s1_content.compareTo(s2_content);
            }
        });
        ArrayList<String> ans = new ArrayList<>();
        ans.addAll(let_logs);
        ans.addAll(dig_logs);
        return ans;
    }
    static boolean isLetterLog(String s){
        int start = -1;
        int end = -1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '-'){
                start = i;
                break;
            }
        }
        char ch = s.charAt(start+1);
        if(Character.isDigit(ch)) return false;
        return true;
    }
    static String getContent(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '-'){
                return s.substring(i+1);
            }
        }
        return "";
    }
    static String getId(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '-'){
                return s.substring(0, i);
            }
        }
        return "";
    }
}
