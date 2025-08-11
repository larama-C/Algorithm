class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String[] Map1 = CreateMap(n, arr1);
        String[] Map2 = CreateMap(n, arr2);

        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n; j++) {
                char c1 = Map1[i].charAt(j);
                char c2 = Map2[i].charAt(j);

                if (c1 == '1' || c2 == '1') {
                    row.append("#");
                } else {
                    row.append(" ");
                }
            }

            answer[i] = row.toString();
        }

        return answer;
    }

    public String[] CreateMap(int n, int[] arr) {
        String[] Map = new String[n];

        for (int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr[i]);
            Map[i] = String.format("%" + n + "s", binary).replace(' ', '0');
        }

        return Map;
    }
}