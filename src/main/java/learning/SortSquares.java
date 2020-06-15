package main.java.learning;
/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * Example :
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * via: leetcode.com && TheBrownBox
 * */
public class SortSquares {

    public static int[] sortSquares(int[] arr) {
        int size = arr.length;
        int i = -1;
        while ((i+1) < size && arr[i+1] < 0) {
            i++;
        }
        int j = size;
        while ((j-1) >= 0 && arr[j-1] >= 0) {
            j--;
        }
        int[] ans = new int[size];
        int k = 0;
        while ( i >= 0 || j < size) {
            if (i >= 0 && j < size) {
                int ii = arr[i] * arr[i];
                int jj = arr[j] * arr[j];
                if (ii <= jj ) {
                    ans[k] = ii;
                    i--;
                } else {
                    ans[k] = jj;
                    j++;
                }
                k++;
            } else if ( i >= 0) {
                ans[k] = arr[i] * arr[i];
                i--;
                k++;
            } else {
                ans[k] = arr[j] * arr[j];
                j++;
                k++;
            }
        }
        return ans;
    }

    public static int[] test(int[] arr) {
        int size = arr.length;
        int i = -1;
        while ((i+1) < size && arr[i+1] < 0) {
            i++;
        }
        System.out.println(" = = = i = = = "+i + " = = = value = = = " +arr[i]);
        int j = size;
        while ((j-1) < size && arr[j-1] >= 0) {
            j--;
        }
        System.out.println(" = = = i = = = "+j + " = = = value = = = " +arr[j]);
        return arr;
    }
     public static void main(String[] args) {
        int[] a = {-4, -1 , 0 , 3 , 10};
//        test(a);
        int[] arr = sortSquares(a);
        for (int value : arr) {
            System.out.println(value);
        }
    }
}
