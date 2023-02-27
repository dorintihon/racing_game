import java.awt.*;

class Car {
    private CarEngine engine;
    private CarWheel wheel;
    private CarTire tire;
    private int x;
    private int y;
    private Color color;
    private int power;


    public Car(CarEngine engine, CarWheel wheel, CarTire tire, int x, int y, Color color) {
        this.engine = engine;
        this.wheel = wheel;
        this.tire = tire;
        this.x = x;
        this.y = y;
        this.color = color;
        this.power = engine.getPower() - calculatePowerLoss(wheel.getSize(),tire.getType());
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public CarEngine getEngine() {
        return engine;
    }

    public CarWheel getWheel() {
        return wheel;
    }

    public CarTire getTire() {
        return tire;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    private int calculatePowerLoss(int wheelSize, String tireType) {
        int powerLoss = 0;
        if (wheelSize > 17) {
            powerLoss += 1;
        }
        if (tireType.equals("summer")) {
            powerLoss += 2;
        }
        return powerLoss;
    }


    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 50, 30);
    }
}