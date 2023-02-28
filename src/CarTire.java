class CarTire {
    private String type;
    private int power;



    public CarTire(String type) {
        this.type = type;
        this.power = calculatePower(type);
    }

    public String getType() {
        return type;
    }

    public int getPower(){
        return power;
    }

    public int calculatePower(String type){
        return switch (type) {
            case "summer" -> 2;
            case "winter" -> 3;
            case "sport" -> 1;
            default -> 0;
        };
    }

}