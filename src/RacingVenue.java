import java.awt.*;

class RacingVenue {
    private int finishLineX;
    private static final int CAR_Y_POSITION = 100;
    private Car[] cars;
    private static final Color[] CAR_COLORS = {Color.RED, Color.BLUE, Color.GREEN};

    private static final int[] WHEEL_SIZES = {15, 18, 15};
    private static final String[] TIRE_TYPES = {"all-season","summer", "summer"};

    public RacingVenue() {
        cars = new Car[3];

        for (int i = 0; i < cars.length; i++) {
            CarWheel wheel = new CarWheel(WHEEL_SIZES[i]);
            CarTire tire = new CarTire(TIRE_TYPES[i]);
            Car car = new Car(new CarEngine(), wheel, tire, 0, CAR_Y_POSITION + i * 100, CAR_COLORS[i]);
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