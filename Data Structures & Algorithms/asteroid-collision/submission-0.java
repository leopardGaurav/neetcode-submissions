class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            // Collision condition: stack top is moving RIGHT (> 0) and current 'a' is moving LEFT (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                int diff = a + stack.peek(); // Compare sizes

                if (diff < 0) {
                    // Top asteroid is smaller; top explodes, current 'a' keeps moving
                    stack.pop();
                } else if (diff == 0) {
                    // Both are same size; both explode
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Current 'a' is smaller; current 'a' explodes
                    destroyed = true;
                    break;
                }
            }
            // If current asteroid survived all collisions, add it to the stack
            if (!destroyed) {
                stack.push(a);
            }
        }
        // Convert stack to result array (reverse order output)
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}