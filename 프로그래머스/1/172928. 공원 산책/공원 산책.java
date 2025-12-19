class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();

        int r = 0, c = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                }
            }
        }

        for (String route : routes) {
            char dir = route.charAt(0);
            int dist = route.charAt(2) - '0';

            int nr = r;
            int nc = c;
            boolean possible = true;

            for (int i = 0; i < dist; i++) {
                if (dir == 'N') nr--;
                else if (dir == 'S') nr++;
                else if (dir == 'W') nc--;
                else if (dir == 'E') nc++;

                if (nr < 0 || nr >= h || nc < 0 || nc >= w || park[nr].charAt(nc) == 'X') {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                r = nr;
                c = nc;
            }
        }

        return new int[]{r, c};
    }
}