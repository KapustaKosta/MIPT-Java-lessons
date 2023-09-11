import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        convert(10);
        System.out.println(normalize(721));
        System.out.println(max(10, 12, -14));
        System.out.println(fact(12));
        System.out.println(fact(BigInteger.valueOf(30)));
        multipleTable();
        System.out.println(average(1, 2, 3, 4, 5, 6, 7));
        System.out.println(isMagicSquare(new int[][]{
                {16, 3, 2, 13},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {4, 15, 14, 1}}));
        System.out.println(isMagicSquare(new int[][]{
                {2, 7, 6},
                {9, 5, 1},
                {1, 3, 8}}));
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(sort(new int[]{2, 1, 45, 34, 12, 2})));
        System.out.println(Arrays.toString(removeExtra(new int[]{2, 1, 45, 2, 34, 1, 12, 2}, 2)));
    }

    // task 1
    static void convert(int arg) {
        System.out.println("Binary: " + Integer.toBinaryString(arg));
        System.out.println("Octal: " + Integer.toOctalString(arg));
        System.out.println("Heg: " + Integer.toHexString(arg));
    }


    // task 2
    static int normalize(int angle) {
        return Math.floorMod(angle, 360);
    }


    // task 3
    static int max(int... numbers) {
        Arrays.sort(numbers);
        int lastIndex = numbers.length-1;
        return numbers[lastIndex];
    }


    // task 4
    static int fact(int n) {
        if(n==1) return 1;
        return n * fact(n-1);
    }


    // task 5
    static BigInteger fact(BigInteger n) {
        if(n.equals(BigInteger.ONE)) return BigInteger.ONE;
        return  n.multiply(fact(n.subtract(BigInteger.ONE)));
    }

    // task 6
    static void multipleTable() {
        int[][] multiplicationTable = new int[10][10];
        for(int i = 1 ; i < 10 ; i++)
        {
            for(int j = 1 ; j < 10 ; j++)
            {
                multiplicationTable[i][j] = i*j;
            }
        }
        for(int i = 1; i < multiplicationTable.length ; i++)
        {
            for(int j = 1; j < multiplicationTable[0].length ; j++)
            {
                System.out.print(multiplicationTable[i][j] + " ");
            }
            System.out.println();
        }
    }


    // task 7
    static double average(int... nums) {
        double res = 0d;
        for (int n : nums)
        {
            res += n;
        }
        res /= nums.length;
        return  res;
    }


    // task 8
    static boolean isMagicSquare(int[][] square) {
        if(square == null)
        {
            return false;
        }
        if(square.length != square[0].length)
        {
            return false;
        }

        boolean res = true;

        int length = square.length;

        int mainSum = -1;
        int sum = 0;
        for(int i = 0 ; i < length ; i++)
        {
            sum = 0;
            for(int j = 0 ; j < length ; j++)
            {
                sum += square[i][j];
            }
            if(i==0) mainSum = sum;
            if(sum != mainSum) res = false;
        }

        for(int i = 0 ; i < length ; i++)
        {
            sum = 0;
            for(int j = 0 ; j < length ; j++)
            {
                sum += square[j][i];
            }
            if(sum != mainSum) res = false;
        }

        sum = 0;
        for(int i = 0, j = length - 1 ; i < length ; i++, j--)
        {
            sum += square[j][i];
        }
        if(sum != mainSum) res = false;

        sum = 0;
        for(int i = 0 ; i < length ; i++)
        {
            sum += square[i][i];
        }
        if(sum != mainSum) res = false;

        return res;
    }


    // task 9
    static int[] reverse(int[] arr)
    {
        if(arr == null) return null;
        int[] res = new int[arr.length];
        for(int i = arr.length - 1 , j = 0; i >= 0 ; i--, j++)
        {
            res[j] = arr[i];
        }
        return res;
    }


    // task 10
    static int[] sort(int[] arr) {
        if(arr == null) return  null;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return  arr;
    }

    // task 11
    static Integer[] removeExtra(int[] arr, int n) {
        if(arr == null) return null;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int num:arr)
        {
            if(num != n) res.add(num);
        }
        Integer[] arrRes = new Integer[res.size()];
        return res.toArray(arrRes);
    }
}