class Solution {
    public int[] solution(String[] wallpaper) {

        int lux = -1, luy = -1, rdx = -1, rdy = -1;
        boolean found = false;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {

                if (wallpaper[i].charAt(j) == '#') {

                    if (!found) {
                        lux = i;
                        luy = j;
                        rdx = i + 1;
                        rdy = j + 1;
                        found = true;
                    } else {
                        if (i < lux) {
                            lux = i;
                        }
                        if (j < luy) {
                            luy = j;
                        }
                        if (i + 1 > rdx) {
                            rdx = i + 1;
                        }
                        if (j + 1 > rdy) {
                            rdy = j + 1;
                        }
                    }
                }
            }
        }

        return new int[]{lux, luy, rdx, rdy};
    }
}
