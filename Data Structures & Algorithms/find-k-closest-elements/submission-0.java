

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - k;

        while (l < r) {
            int m = l + (r - l) / 2;

            // Shift right if arr[m + k] is strictly closer to x than arr[m]
            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        // Return the k elements starting at index 'l'
        List<Integer> res = new ArrayList<>(k);
        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}