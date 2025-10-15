class RandomizedSet {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    public RandomizedSet() {
        //Nothing
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;


        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int index = map.get(val);
        int lastIndex = list.size() -1;
        int lastValue = list.get(lastIndex);

        list.set(index, lastValue);
        list.remove(lastIndex);

        map.put(lastValue, index);
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