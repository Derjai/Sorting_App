package com.example.sortingapp;

/**
 * Hello world!
 *
 */
public class SortingApp
{
    public static void main( String[] args )
    {
        if (args.length>10){
            System.out.println("Error: Too many arguments");
            return;
        }

        int[] numbers = new int[args.length];
        for (int i=0; i<args.length; i++){
            try{
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e){
                System.out.println("Error: Invalid number format for argument: " + args[i]);
                return;
            }
        }

        IntegerUtils.sort(numbers);

        System.out.println("Ordered numbers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
