package demo.demo.atm;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		Scanner scn = new Scanner(System.in);
    		System.out.println("Enter Amount to withdraw");
    		int amount = scn.nextInt();
    		if(amount%10!=0) {
    			System.out.println("please enter amount in multiples of 100");
    		}
    		else {
    			ATM atm = new ATM(amount);
    			ATM.calcTotal();
    			Thread t1 = new Thread((Runnable) atm);
    			t1.start();
    			
    		}
    		
    	}
    }
    

