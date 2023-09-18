import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

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
        for (int i = 0; i < list.size(); i++) {
            Car car = list.get(i);
            double time = (double) (target - car.positionCar) / car.speedCar;
            System.out.println(time);
            if (timeList.size() != 0 && time <= timeList.get(i - 1)) {
                timeList.add(timeList.get(i - 1));
            } else {
                answer++;
                timeList.add(time);
            }
        }

        return answer;
    }

    class Car {
        int positionCar;
        int speedCar;
    }

    public int carFleetExampleWay(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;

        Stack<Double> stack = new Stack<>();
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, Comparator.comparingInt(o -> o[0]));

        for (int i = combine.length - 1; i >= 0; i--) {
            double currentTime = (double) (target - combine[i][0]) / combine[i][1];
            System.out.println(currentTime);
            if (!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            } else {
                stack.push(currentTime);
            }
        }
        return stack.size();
    }
}
