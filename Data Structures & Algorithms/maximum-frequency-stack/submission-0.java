class FreqStack {
    private Map<Integer, Integer> freqMap; // val -> frequency
    private Map<Integer, Deque<Integer>> groupMap; // frequency -> stack of values
    private int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);

        if (freq > maxFreq) {
            maxFreq = freq;
        }

        groupMap.computeIfAbsent(freq, k -> new ArrayDeque<>()).push(val);
    }
    
    public int pop() {
        // Pop top element from the stack corresponding to maxFreq
        int val = groupMap.get(maxFreq).pop();
        freqMap.put(val, freqMap.get(val) - 1);

        // If no more elements exist at current maxFreq, decrease maxFreq
        if (groupMap.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}