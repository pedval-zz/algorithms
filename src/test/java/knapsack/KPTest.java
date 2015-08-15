package knapsack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by pedrovalencia on 27/03/15.
 */
public class KPTest {

    //Item(value, weight)


    @Test
    public void testOptimalResult() throws Exception {
        Item element1 = new Item(5,7);
        Item element2 = new Item(2,3);
        Item element3 = new Item(10,4);
        Item element4 = new Item(2,2);

        int maxWeight = 15;

        PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>();
        priorityQueue.add(element1);
        priorityQueue.add(element2);
        priorityQueue.add(element3);
        priorityQueue.add(element4);

        List<Item> result = KnapSack.calculate(maxWeight, priorityQueue);
        Assert.assertEquals(3, result.size());

    }




}
