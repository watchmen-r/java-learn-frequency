import java.util.PriorityQueue;

class MaximumUnitsTrack {
    class Unit {
        int numBox;
        int unitsPerBox;
        public Unit(int numBox, int unitsPerBox) {
            this.numBox = numBox;
            this.unitsPerBox = unitsPerBox;
        }
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<Unit> pq = new PriorityQueue<>((x, y) -> y.unitsPerBox - x.unitsPerBox);

        for(int i = 0; i < boxTypes.length; i++) {
            Unit unit = new Unit(boxTypes[i][0], boxTypes[i][1]);
            pq.add(unit);
        }

        int ans = 0;
        while(truckSize > 0 && !pq.isEmpty()) {
            Unit unit = pq.poll();
            int numBox = unit.numBox;
            int unitsPerBox = unit.unitsPerBox;
            
            if(truckSize >= numBox) {
                ans = ans + (numBox * unitsPerBox);
                truckSize = truckSize - numBox;
            } else {
                ans = ans + (truckSize * unitsPerBox);
                truckSize = 0;
            }
        }
        return ans;
    }
}