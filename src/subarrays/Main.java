package subarrays;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> arrayList = Arrays.asList(5, -1, 4, 3, 2, -4, 7, 2);

        System.out.println(findLargestSum(arrayList));

    }

    private static int findLargestSum(List<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(list.get(k) + " ");
                    sum += list.get(k);
                }

                System.out.print(" ->  suma pe subarray: " + sum);
                max = Math.max(sum, max);
                System.out.println();
            }
        }
        return max;
    }

    /*
    Optional - pt cine vrea o metoda mai eficienta (parcurge array list-ul o singura data)
    Algoritmul lui Kandane: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

     */
    private static int maxSubArraySum(List<Integer> list) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < list.size(); i++) {
            maxEndingHere += list.get(i);
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
