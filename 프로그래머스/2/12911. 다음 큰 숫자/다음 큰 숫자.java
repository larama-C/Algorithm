class Solution {
    public int solution(int n) {
        int cnt = 0;
        String str = Integer.toBinaryString(n);
        
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                cnt++;
            }
        }
        
        int a = n;
        int ncnt = 0;
        
        while(cnt != ncnt)
        {
            a++;
            
            String chk = Integer.toBinaryString(a);
            
            for(int i = 0; i < chk.length(); i++) 
            {
                if (chk.charAt(i) == '1') 
                {
                    ncnt++;
                }
            }
            
            if(ncnt != cnt)
            {
                ncnt = 0;
            }
        }
        
        return a;
    }
}