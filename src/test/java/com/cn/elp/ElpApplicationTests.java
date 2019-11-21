package com.cn.elp;

import com.cn.elp.service.TowerinfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
class ElpApplicationTests {
@Resource
    TowerinfoService towerinfoService;
    @Test
    void contextLoads() {
       int rel= towerinfoService.findAllTowerPageCount(null,"启用");
        System.out.println(rel);
    }
    @Test
     public  void abc() {
        int a[] = new int[6];
        int n = 7;
        for (int i = 1; i <= n; i++) {//控制行数
            for (int k = 1; k <= n - i; k++) {//控制空格的个数
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {//控制打印的图形
                System.out.print("*");
            }
            System.out.println();//控制换行
        }
    }
    @Test
    public void bc(){
        final int NMAX = 10;

        // allocate triangular array
        int[][] odds = new int[NMAX + 1][];
        for (int n = 0; n <= NMAX; n++)
            odds[n] = new int[n + 1];

        // fill triangular array
        for (int n = 0; n < odds.length; n++)
            for (int k = 0; k < odds[n].length; k++)
            {
                /*
                 * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
                 */
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++)
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;

                odds[n][k] = lotteryOdds;
            }

        // print triangular array
        for (int[] row : odds)
        {
            for (int odd : row)
                System.out.printf("%4d", odd);
            System.out.println();
        }
    }

}
