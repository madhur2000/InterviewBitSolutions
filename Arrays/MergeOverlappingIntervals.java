/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<>();
        if(intervals.size() == 0) return ans;

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return (a.start - b.start);
            }
        });

        ans.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start > ans.get(ans.size()-1).end){
                ans.add(intervals.get(i));
            } else{
                int newStart = Math.min(intervals.get(i).start, ans.get(ans.size()-1).start);
                int newEnd = Math.max(intervals.get(i).end, ans.get(ans.size()-1).end);
                ans.remove(ans.size()-1);
                ans.add(new Interval(newStart, newEnd));
            }
        }
        return ans;
    }
}
