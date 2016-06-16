package com.angluswang.smartrobot;

import com.angluswang.smartrobot.utils.HttpUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        String res = HttpUtils.doGet("能给我讲个笑话么");
        System.out.println(res);
        res = HttpUtils.doGet("笑话一点也不好听");
        System.out.println(res);
        res = HttpUtils.doGet("呵呵");
        System.out.println(res);
        res = HttpUtils.doGet("你叫什么");
        System.out.println(res);
        res = HttpUtils.doGet("做什么好呢");
        System.out.println(res);
    }
}