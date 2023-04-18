package sdf_day01_workshop;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Console;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<String> cart = new ArrayList<String>();
        int size = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your shopping cart");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("list")) {
                if (size == 0) {
                    System.out.println("Your cart is empty");
                }
                else {
                    for (int i = 0; i < size; i++) {
                        System.out.println((i+1) + ". " + cart.get(i));
                    }
                }
            }

            else if (input.startsWith("add ")) {
                String items = input.substring(4);
                String[] itemList = items.split(", ");
                for (String item : itemList) {
                    if (cart.contains(item)) {
                        System.out.println("You have " + item + " in your cart");
                    }
                    else {
                        cart.add(item);
                        size++;
                        System.out.println(item + " added to cart");
                    }
                }
            }

            else if (input.startsWith("delete ")) {
                int index = Integer.parseInt(input.substring(7));
                if (index < 1 || index > size) {
                    System.out.println("Invalid index");
                }
                else {
                    String item = cart.get(index - 1);
                    cart.remove(item);
                    size--;
                    System.out.println(item + " removed from cart");
                }
            }

            else {
                System.out.println("Invalid input");
            }
        }
    }
}
