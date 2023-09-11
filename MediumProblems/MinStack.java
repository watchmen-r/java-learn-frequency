import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MinStack {

    List<Integer> list;

    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        list.get(list.size() - 1);
        list.remove(list.size() - 1);
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return list.stream().min(Comparator.naturalOrder()).get();
    }
}