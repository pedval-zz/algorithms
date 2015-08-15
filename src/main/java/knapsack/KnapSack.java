package knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by pedrovalencia on 28/03/15.
 */
public class KnapSack {

    static public List<Item> calculate(int maxWeight, PriorityQueue<Item> priorityQueue) {
        int remainingWeight = maxWeight;
        List<Item> result = new ArrayList<Item>();

        while(!priorityQueue.isEmpty() && remainingWeight >= priorityQueue.peek().getWeight()) {
            Item nextItem = priorityQueue.poll();
            result.add(nextItem);
            remainingWeight -= nextItem.getWeight();

        }

        return result;

    }
}
