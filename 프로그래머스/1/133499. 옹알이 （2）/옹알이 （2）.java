class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) 
        {
            StringBuilder sb = new StringBuilder(word);
            boolean valid = true;
            String prev = "";

            while (sb.length() > 0 && valid) 
            {
                boolean matched = false;
                for (String sound : arr) 
                {
                    if (sb.indexOf(sound) == 0 && !sound.equals(prev)) 
                    {
                        sb.delete(0, sound.length());
                        prev = sound;
                        matched = true;
                        break;
                    }
                }
                
                if (!matched) 
                {
                    valid = false;
                }
            }
            
            if (valid)
            {
                answer++;
            }
            
        }
        return answer;
    }
}
