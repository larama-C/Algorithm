import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        String[] sortlist = {"code" , "date", "maximum", "remain"};
        List<int[]> list = new ArrayList<>();
        
        
        int extidx = Arrays.asList(sortlist).indexOf(ext);
        
        for(int i = 0; i < data.length; i++)
        {
            if(data[i][extidx] < val_ext)
            {
                list.add(data[i]);
            }
        }
        
        int sortidx = Arrays.asList(sortlist).indexOf(sort_by);
        
        list.sort((a, b) -> a[sortidx] - b[sortidx]);
        
        return list.toArray(new int[list.size()][]);
    }
}