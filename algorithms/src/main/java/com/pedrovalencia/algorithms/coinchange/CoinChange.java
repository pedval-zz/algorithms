package com.pedrovalencia.algorithms.coinchange;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by pedrovalencia on 28/03/15.
 */
public class CoinChange {

    static public HashMap<Coin, Integer> getCoinChange(TreeSet<Coin> coins, Integer amount) {

        HashMap<Coin, Integer> result = new HashMap<Coin, Integer>();

        while(coins.size() > 0 && amount.compareTo(((Coin)(coins.toArray()[coins.size()-1])).getAmount()) >= 0) {
            int currentChange = coins.pollFirst().getAmount();
            while(amount >= currentChange) {
                updateNumberCoins(result, currentChange);
                amount -= currentChange;
            }

        }

        return result;
    }

    private static void updateNumberCoins(HashMap<Coin, Integer> result, int amount) {
        Coin coin = new Coin(amount);
        if(result.get(coin) != null) {
            int how = result.get(coin) + 1;
            result.remove(coin);
            result.put(coin,how);
        } else {
            result.put(coin, 1);
        }
    }
}
