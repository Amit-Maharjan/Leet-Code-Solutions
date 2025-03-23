package com.company.TopInterview150.DP.OneDimensional;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount+1];
        Arrays.fill(minCoins, amount+1);
        minCoins[0] = 0;

        for (int i=1; i<= amount; i++) {
            for (int coin : coins) {
                if (i-coin >= 0) {
                    minCoins[i] = Math.min(minCoins[i], 1+minCoins[i-coin]);
                }
            }
        }

        return minCoins[amount] == (amount+1) ? -1 : minCoins[amount];
    }
}
