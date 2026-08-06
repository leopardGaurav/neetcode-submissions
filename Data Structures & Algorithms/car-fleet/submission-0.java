class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Store [position, timeToTarget]
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort cars by position in descending order (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double maxTime = 0;

        for (int i = 0; i < n; i++) {
            double currentTime = cars[i][1];
            
            // If this car takes strictly longer than the fleet ahead of it,
            // it can never catch up and forms a new fleet.
            if (currentTime > maxTime) {
                fleets++;
                maxTime = currentTime;
            }
        }

        return fleets;
    }
}