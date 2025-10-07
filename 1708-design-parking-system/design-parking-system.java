class ParkingSystem {

    Map<Integer, Integer> slot = new HashMap<>();
    public ParkingSystem(int big, int medium, int small) {
        slot.put(1, big);
        slot.put(2, medium);
        slot.put(3, small);
    }
    
    public boolean addCar(int carType) {
        if(slot.get(carType) != 0){
            slot.put(carType, slot.get(carType) - 1);
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */