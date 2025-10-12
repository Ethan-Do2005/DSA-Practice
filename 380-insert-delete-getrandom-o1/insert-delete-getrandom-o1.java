class RandomizedSet {
    private final Map<Integer, Integer> map = new HashMap<>();
    private final List<Integer> list = new ArrayList<>();
    private final Random random = new Random();

    public RandomizedSet() {
        //Nothing to do
    }
    
    public boolean insert(int val) {
        if(list.contains(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        Integer valIdx = map.get(val);
        if(valIdx == null) return false;

        int lastIdx = list.size() - 1;
        int lastVal = list.get(lastIdx);

        list.set(valIdx, lastVal);
        list.remove(lastIdx);

        map.put(lastVal, valIdx);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */