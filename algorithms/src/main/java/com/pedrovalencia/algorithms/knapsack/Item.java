package com.pedrovalencia.algorithms.knapsack;


/**
 * Created by pedrovalencia on 27/03/15.
 */
public class Item implements Comparable<Item>{
    private Integer value;
    private Integer weight;

    public Item(int valueIn, int weightIn) {
        this.value = valueIn;
        this.weight = weightIn;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Item o) {
        return -new Integer(value/weight).compareTo(o.getValue()/o.getWeight());
    }
}
