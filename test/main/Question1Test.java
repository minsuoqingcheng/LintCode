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
        int i = (int) (10000000000l % 10);
        System.out.println(i);
    }

}
