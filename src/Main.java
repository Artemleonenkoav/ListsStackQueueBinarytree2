
//  кинотеатре вышел новый фильм. В кинотеатре 1 зал, он может вместить 200 зрителей. Каждый день продавалось разное количество билетов на новый фильм в первую и вторую недели его показа. Когда кинотеатр продал больше билетов – на первой или на второй неделе? Какова была выручка кинотеатра за первые две недели проката фильма, если цена одного билета составляет миллион долларов?

import java.util.Scanner;

public class Main
{
    static void input(int[] array)   //array input function
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print("Enter the number of tickets sold in day " + (i+1) + " - ");
            Scanner in = new Scanner(System.in);
            array[i] = in.nextInt();

            if(array[i]>200)
            {
                while(array[i]>200)
                {
                    System.out.println("The hall is full. Enter again.");
                    System.out.print("Enter the number of tickets sold in day " + (i+1) + " - ");
                    array[i] = in.nextInt();
                }
            }
        }
    }

    static void output(int[] array)  //array output function
    {
        for(int i = 0; i < array.length; i++)
            System.out.print( array[i] + " ");
    }

    static int sum(int[] array)     //cinema revenue calculation function
    {
        int sum=0;
        for(int i = 0; i < array.length; i++)
            sum+=array[i];
        return sum;
    }

    public static void main(String[] args) {

        int[] a = new int [7];
        int[] b = new int [7];
        int sum_first = 0;
        int sum_second = 0;

        System.out.println("Enter the number of tickets sold during the first week");
        input(a);
        output(a);
        System.out.println("\nEnter the number of tickets sold during the second week");
        input(b);
        output(b);
        System.out.println("");
        sum_first=sum(a);
        System.out.println(sum_first + " tickets were sold during the first week.");
        sum_second=sum(b);
        System.out.println(sum_second + " tickets were sold during the second week.");

        if(sum_first >sum_second)
            System.out.printf("In the first week, the cinema sold %d more tickets than in the second one.\n",sum_first - sum_second);
        else if(sum_first < sum_second)
            System.out.printf("In the second week,  the cinema sold %d more tickets than in the first one.\n",sum_second - sum_first);
        else System.out.println("The cinema sold the same number of tickets in the first week as in the second week.");

        System.out.print("Enter ticket price: ");
        Scanner in = new Scanner(System.in);
        int price = in.nextInt();
        int total = price*(sum_first+sum_second);

        System.out.println("The total cinema's revenue for two weeks was $" + total + ".");
    }
}