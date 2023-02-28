class CarWheel {
    private int size;
    private int power;

    public CarWheel(int size) {
        this.size = size;
        this.power = calculatePower(size);
    }

    public int getPower(){
        return power;
    }

    public int calculatePower(int wheelSize){
        return switch (wheelSize) {
            case 15 -> 1;
            case 16 -> 2;
            case 17 -> 3;
            default -> 0;
        };
    }

    public int getSize() {
        return size;
    }

}