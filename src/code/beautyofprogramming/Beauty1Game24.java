package code.beautyofprogramming;

import java.util.*;

public class Beauty1Game24 {
    private static int[] numbers = new int[]{3,3,7,7};
    private static List<Set<Float>> collectionResult = new LinkedList<>();

    public static void main(String[] args) {


        System.out.println(computer(numbers));
    }

    private static boolean computer(int[] numbers) {
        int n = numbers.length;
        // 定义一个集合S，用来储存所有的结果
        int maxPow = (int) Math.pow(2, n);
        //初始化
        for (int i = 0; i <= maxPow - 1; i++) {
            collectionResult.add(new HashSet<>());
        }
        System.out.println("collection size is " + collectionResult.size());
        for (int i = 0; i < n; i++) {
            int index = (int) Math.pow(2, i);
            collectionResult.get(index).add((float) numbers[i]);
        }
        for (int i = 1; i <= maxPow - 1; i++) {
            Set<Float> sets = fillResult(i);
            collectionResult.set(i, sets);
        }
        System.out.println(Arrays.toString(collectionResult.toArray()));
        return checkResult(collectionResult.get(maxPow - 1));
    }

    private static boolean checkResult(Set<Float> integers) {
        for (float i : integers) {
            if (i -  24 < 1E6) {
                return true;
            }
        }
        return false;
    }

    private static Set<Float> fillResult(int i) {
        Set<Float> result = new HashSet<>();
        if (collectionResult.get(i).size() != 0) {
            return collectionResult.get(i);
        }

        for (int x = 1; x < i; x++) {
            if ((x & i) == x) {
                result.addAll(computer(fillResult(x), fillResult(i - x)));
            }
        }
        return result;
    }

    private static Set<Float> computer(Set<Float> set1, Set<Float> set2) {
        Set<Float> result = new HashSet<>();
        for (float a : set1) {
            for (float b : set2) {
                result.add(a + b);
                result.add(a - b);
                result.add(b - a);
                if (b != 0) {
                    result.add(a / b);

                }
                if (a != 0) {
                    result.add(b / a);
                }
                result.add(a * b);

            }
        }
        return result;

    }
}
