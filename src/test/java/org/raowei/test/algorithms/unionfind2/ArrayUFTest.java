package org.raowei.test.algorithms.unionfind2;

import org.junit.Test;
import org.raowei.test.util.CommonUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * test
 * create: 2016-08-30 17:50
 *
 * @author terryrao
 */
public class ArrayUFTest {

    @Test
    public void testTiny() throws IOException {
        this.test("tinyUF.txt");

    }

    @Test
    public void testMediumUF() throws IOException {

        this.test("mediumUF.txt");
    }

    @Test
    public void testLargeUF() throws IOException {
        this.test("largeUF.txt");
    }

    private List<String> readLines (String name) throws IOException {
        InputStream inputStream = CommonUtils.getResource(name);
        BufferedReader ds = new BufferedReader(new InputStreamReader(inputStream));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = ds.readLine()) != null) {
            lines.add(line);
        }
        ds.close();

        return lines;
    }


    private Integer[] parseInt(List<String> list) {
        List<Integer> result = new ArrayList<>();
        list.forEach(line -> {
            String[] strs = line.split(" ");
            Integer[] ints = new Integer[strs.length];
            for (int i = 0; i < strs.length; i++) {
                ints[i] = Integer.valueOf(strs[i]);
            }
            result.addAll(Arrays.asList(ints));
        });

        return  result.toArray(new Integer[result.size()]);
    }


    private void test(String fileName) throws IOException {
        List<String> s = readLines(fileName);
        Integer[] nums = this.parseInt(s);
        int n = nums[0];
        UF uf = new ArrayUF(n);

        for (int i = 1; i < nums.length -1; i++) {
            int p = nums[i];
            int q = nums[i + 1];
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            System.out.println(p + " " + q);
        }


        System.out.println(uf.count() + " components");
    }

}