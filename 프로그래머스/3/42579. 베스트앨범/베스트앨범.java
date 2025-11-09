import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if (genreTotal.containsKey(genre)) {
                genreTotal.put(genre, genreTotal.get(genre) + play);
            } else {
                genreTotal.put(genre, play);
            }

            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new ArrayList<int[]>());
            }
            genreSongs.get(genre).add(new int[]{i, play});
        }

        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        Collections.sort(genreOrder, new Comparator<String>() {
            public int compare(String a, String b) {
                return genreTotal.get(b) - genreTotal.get(a);
            }
        });

        List<Integer> result = new ArrayList<>();

        for (String genre : genreOrder) {
            List<int[]> songs = genreSongs.get(genre);

            Collections.sort(songs, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[1] == b[1]) {
                        return a[0] - b[0];
                    } else {
                        return b[1] - a[1];
                    }
                }
            });

            result.add(songs.get(0)[0]);
            if (songs.size() > 1) {
                result.add(songs.get(1)[0]);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}