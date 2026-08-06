class TimeMap {
    private static class DataNode {
        int timestamp;
        String value;

        DataNode(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<DataNode>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new DataNode(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<DataNode> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).value; // Save candidate answer
                left = mid + 1;           // Search right for a larger timestamp <= given timestamp
            } else {
                right = mid - 1;          // Search left
            }
        }

        return res;
    }
}