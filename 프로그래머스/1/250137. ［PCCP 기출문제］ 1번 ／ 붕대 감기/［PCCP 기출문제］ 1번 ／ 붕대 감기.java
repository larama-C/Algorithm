class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHp = health;
        int hp = health;
        int castTime = bandage[0];
        int healPerSec = bandage[1];
        int bonusHeal = bandage[2];

        int attackIdx = 0;
        int successTime = 0;
        int endTime = attacks[attacks.length - 1][0];

        for (int time = 1; time <= endTime; time++) {
            if (attackIdx < attacks.length && attacks[attackIdx][0] == time) {
                hp -= attacks[attackIdx][1];
                attackIdx++;
                successTime = 0;
                
                if (hp <= 0) {
                    return -1;
                }
            } 
            else {
                successTime++;
                hp += healPerSec;
                if (successTime == castTime) {
                    hp += bonusHeal;
                    successTime = 0;
                }
                if (hp > maxHp) {
                    hp = maxHp;
                }
            }
        }
        return hp;
    }
}