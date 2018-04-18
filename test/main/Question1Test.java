package main;

import main.LintCode.Question1;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by imccl on 2017/11/19.
 */
public class Question1Test {

    Question1 question1 = new Question1();

    @Test
    public void testAplusb1() {
        int a = 11110;
        int b = 10922;
        Assert.assertEquals(22032, question1.aplusb1(a, b));
    }

    @Test
    public void testAplusb2() {
        int a = 11110;
        int b = 10922;
        Assert.assertEquals(22032, question1.aplusb2(a, b));
    }

    @Test
    public void test() {
        int i = (int)0.5;
        System.out.println(i);

        double t = 1.0;
        int j = (int) t;
        System.out.println(j);

        System.out.println(t%1 == 0);
    }


    @Test
    public void test3() {
        System.out.println(Long.MAX_VALUE);
    }
}
