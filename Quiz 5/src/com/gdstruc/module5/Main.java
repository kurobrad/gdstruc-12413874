package com.gdstruc.module5;

public class Main
{
    public static void main(String[] args)
    {
        int numbers[] = { 1, 25, 40, 21, 20, 16, -20, 24 };

        System.out.println(linearSearch(numbers, 105));
        System.out.println(linearSearch(numbers, 420));
        System.out.println(binarySearch(numbers, 33));
        System.out.println(binarySearch(numbers, 67));

        // my own search algo
        System.out.println("Iris Search for 1: " + irisSearch(numbers, 1));
        System.out.println("Iris Search for 20: " + irisSearch(numbers, 20));
    }

    public static int linearSearch(int[] input, int value)
    {
        for (int i = 0; i < input.length; i++)
        {
            if (input[i] == value)
            {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] input, int value)
    {
        int start = 0;
        int end = input.length - 1;

        while (start <= end)
        {
            int middle = (start + end) / 2;

            if (input[middle] == value)
            {
                return middle;
            } else if (value < input[middle]) // value might be left half
            {
                end = middle - 1;
            } else if (value > input[middle]) // value might be right half
            {
                start = middle + 1;
            }
        }
        return -1;
    }

    // my own search algo
    public static int irisSearch(int[] arr, int target)
    {
        // starts from the middle
        int middle = arr.length / 2;

        // from the middle, spreads and searches
        for (int i = 0; i <= arr.length / 2; i++)
        {
            // checks the left side (middle - i)
            int left = middle - i;
            if (left >= 0 && arr[left] == target)
                return left;

            // checks the right side (middle + i)
            int right = middle + i;
            if (right < arr.length && arr[right] == target)
                return right;
        }
        return -1;
    }
}