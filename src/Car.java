import java.awt.*;

class Car {
    private CarEngine engine;
    private CarWheel wheel;
    private CarTire tire;
    private int x;
    private int y;
    private Color color;
    private int power;


    public Car(CarEngine engine, int wheelSize, CarTire tire, int x, int y, Color color) {
        this.engine = engine;
        this.wheel = new CarWheel(wheelSize);
        this.tire = tire;
        this.x = x;
        this.y = y;
        this.color = color;
        this.power = engine.getPower() - calculatePowerLoss(wheel.calculatePower(wheelSize),tire.getPower());
    }

    private long startTime;

    public void move() {
        double distance = power;
        x += distance;
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
        }
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

    private int calculatePowerLoss(int wheelPower, int tirePower) {
        return wheelPower + tirePower;
    }


    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 50, 30);
    }
}