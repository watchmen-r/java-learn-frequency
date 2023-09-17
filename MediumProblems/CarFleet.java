import java.util.ArrayList;
import java.util.List;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> list = new ArrayList<>();
        for (int i = 0 ; i < position.length; i++) {
            int order = i;
            list.add(new Car(){
                {
                    positionCar = position[order];
                    speedCar = speed[order];
                }
            });
        }
        list.sort((a, b) -> b.positionCar - a.positionCar);

        List<Double> timeList = new ArrayList<>();
        int answer = 0;
        Car onecar = list.get(0);
        double onetime = (target - onecar.positionCar) / onecar.speedCar;
        timeList.add(onetime);

        for (int i = 1; i < list.size(); i++) {
            Car car = list.get(i);
            double time = (target - car.positionCar) / car.speedCar;
            if (time < timeList.get(i - 1)) {
                timeList.add(timeList.get(i - 1));
            } else {
                timeList.add(time);
                answer++;
            }
            timeList.add(time);
        }

        return answer;
    }

    class Car {
        int positionCar;
        int speedCar;
    }
}
