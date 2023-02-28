import java.awt.*;
import java.util.Random;

class RacingVenue {
    private int finishLineX;
    private static final int CAR_Y_POSITION = 100;
    private Car[] cars;
    private static final Color[] CAR_COLORS = {Color.RED, Color.BLUE, Color.GREEN};

    private static final int[] WHEEL_SIZES = {15, 16, 17};
    private static final String[] TIRE_TYPES = {"sport","summer", "winter"};



    public RacingVenue() {
        cars = new Car[3];

        Random random = new Random();

        for (int i = 0; i < cars.length; i++) {
            int wheelIndex = random.nextInt(WHEEL_SIZES.length);
            CarWheel wheel = new CarWheel(WHEEL_SIZES[wheelIndex]);

            int tireIndex = random.nextInt(TIRE_TYPES.length);
            CarTire tire = new CarTire(TIRE_TYPES[tireIndex]);
            Car car = new Car(new CarEngine(), wheel.getPower(), tire, 0, CAR_Y_POSITION + i * 100, CAR_COLORS[i]);
            cars[i] = car;
        }

        finishLineX = 500;

    }

    public void updatePositions() {
        for (Car car : cars) {
            if (car.getX() < finishLineX) {
                car.setX(car.getX() + car.getPower());
            }
        }
    }

    public boolean isRaceFinished() {
        for (Car car : cars) {
            if (car.getX() < finishLineX) {
                return false;
            }
        }
        return true;
    }

    public void draw(Graphics g) {
        for (Car car : cars) {
            car.draw(g);
        }
        g.setColor(Color.BLACK);
        g.drawLine(finishLineX, 0, finishLineX, 600);
    }
}