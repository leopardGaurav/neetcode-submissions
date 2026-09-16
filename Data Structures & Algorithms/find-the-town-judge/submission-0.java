public class Solution {
    public int findJudge(int n, int[][] trust) {
        // score[i] = (times person i is trusted) - (times person i trusts someone)
        int[] score = new int[n + 1]; // 1-indexed

        for (int[] edge : trust) {
            int a = edge[0]; // truster
            int b = edge[1]; // trustee

            score[a]--; // a trusts someone -> decrease a's score
            score[b]++; // b is trusted -> increase b's score
        }

        for (int person = 1; person <= n; person++) {
            if (score[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}