package com.pedrovalencia.algorithms.coinchange;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by pedrovalencia on 28/03/15.
 */
public class CoinChangeTest {

    private TreeSet<Coin> coins;

    @Before
    public void setUp() throws Exception {
        coins = new TreeSet<Coin>();
        coins.add(new Coin(50));
        coins.add(new Coin(20));
        coins.add(new Coin(10));
        coins.add(new Coin(500));
        coins.add(new Coin(200));
        coins.add(new Coin(100));

    }

    @Test
    public void coinChangeWhenRemainingLessThanChange() throws Exception {
        HashMap<Coin, Integer> result = CoinChange.getCoinChange(coins, 4);
        Assert.assertEquals("There is some coin change",true,result.isEmpty());
    }

    @Test
    public void coinChange10() throws Exception {
        HashMap<Coin, Integer> result = CoinChange.getCoinChange(coins, 10);

        Assert.assertEquals("No change for £10",false,result.isEmpty());
        Assert.assertEquals("The change is incorrect", true, result.get(new Coin(10)).equals(1));
    }

    @Test
    public void coinChangeAllElements() throws Exception {
        HashMap<Coin, Integer> result = CoinChange.getCoinChange(coins, 880);

        Assert.assertEquals("No change for £880",false,result.isEmpty());
        Assert.assertEquals("There is no £10 coin", true, result.get(new Coin(10)).equals(1));
        Assert.assertEquals("There is no £20 coin", true, result.get(new Coin(20)).equals(1));
        Assert.assertEquals("There is no £50 coin", true, result.get(new Coin(50)).equals(1));
        Assert.assertEquals("There is no £100 coin", true, result.get(new Coin(100)).equals(1));
        Assert.assertEquals("There is no £200 coin", true, result.get(new Coin(200)).equals(1));
        Assert.assertEquals("There is no £500 coin", true, result.get(new Coin(500)).equals(1));
    }

    @Test
    public void coinChangeNotAllElements() throws Exception {
        HashMap<Coin, Integer> result = CoinChange.getCoinChange(coins, 3220);

        Assert.assertEquals("No change for £3220",false,result.isEmpty());
        Assert.assertEquals("There is no £20 coin", true, result.get(new Coin(20)).equals(1));
        Assert.assertEquals("There is no £200 coin", true, result.get(new Coin(200)).equals(1));
        Assert.assertEquals("There is no £500 coin", true, result.get(new Coin(500)).equals(6));
    }
}


