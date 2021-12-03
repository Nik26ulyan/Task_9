package ru.vsu.sc.uliyanov_n_s;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.sc.uliyanov_n_s.utils.ArrayAndListUtils;

import java.util.List;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1() {
        List<Integer> input = ArrayAndListUtils.readListFromFile("testFiles/test1.txt");
        List<Integer> output = ArrayAndListUtils.readListFromFile("testFiles/answer1.txt");

        assert input != null;
        List<Integer> testResult = solution.createRightList(input);

        Assert.assertEquals(output, testResult);
    }

    @Test
    public void test2() {
        List<Integer> input = ArrayAndListUtils.readListFromFile("testFiles/test2.txt");
        List<Integer> output = ArrayAndListUtils.readListFromFile("testFiles/answer2.txt");

        assert input != null;
        List<Integer> testResult = solution.createRightList(input);

        Assert.assertEquals(output, testResult);
    }

    @Test
    public void test3() {
        List<Integer> input = ArrayAndListUtils.readListFromFile("testFiles/test3.txt");
        List<Integer> output = ArrayAndListUtils.readListFromFile("testFiles/answer3.txt");

        assert input != null;
        List<Integer> testResult = solution.createRightList(input);

        Assert.assertEquals(output, testResult);
    }

    @Test
    public void test4() {
        List<Integer> input = ArrayAndListUtils.readListFromFile("testFiles/test4.txt");
        List<Integer> output = ArrayAndListUtils.readListFromFile("testFiles/answer4.txt");

        assert input != null;
        List<Integer> testResult = solution.createRightList(input);

        Assert.assertEquals(output, testResult);
    }

    @Test
    public void test5() {
        List<Integer> input = ArrayAndListUtils.readListFromFile("testFiles/test5.txt");
        List<Integer> output = ArrayAndListUtils.readListFromFile("testFiles/answer5.txt");

        assert input != null;
        List<Integer> testResult = solution.createRightList(input);

        Assert.assertEquals(output, testResult);
    }
}