class ParkingSystem {
    int[] typeOfCarPark;
    public ParkingSystem(int big, int medium, int small) {
        typeOfCarPark = new int[4];

        typeOfCarPark[1] = big;
        typeOfCarPark[2] = medium;
        typeOfCarPark[3] = small;
    }
    
    public boolean addCar(int carType) {
        return typeOfCarPark[carType]-->0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */