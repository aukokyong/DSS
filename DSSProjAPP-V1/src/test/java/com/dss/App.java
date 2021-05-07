package com.dss;

import com.dss.util.Colors;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import javax.xml.bind.Marshaller;
import java.util.Scanner;

public class App {
    public static void main (String[] args){
        Scanner userInput = new Scanner(System.in);
        String choice = "";
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        Colors.pru("DSSProjAPP-V1 Application Started");
        while(!choice.equals("5")) {

            Colors.pp("\nDSSProjAPP-V1 Junit Menu");
            Colors.pg("1. Actor");
            Colors.pg("2. Customer");
            Colors.pg("3. Movie");
            Colors.pg("4. Review");
            Colors.pg("5. Quit");
            System.out.println("");
            choice = userInput.nextLine();
            switch(choice){
                case "1":
                    Colors.pb("Running Actor Junit Tests");
                    junit.run(ActorTest.class);
                    Colors.pb("\nActor Junit Tests Ended");
                    break;
                case "2":
                    Colors.pb("Running Customer Junit Tests");
                    junit.run(CustomerTest.class);
                    Colors.pb("\nCustomer Junit Tests Ended");
                    break;
                case "3":
                    Colors.pb("Running Movie Junit Tests");
                    junit.run(MovieTest.class);
                    Colors.pb("\nMovie Junit Tests Ended");
                    break;
                case "4":
                    Colors.pb("Running Review Junit Tests");
                    junit.run(ReviewTest.class);
                    Colors.pb("\nReview Junit Tests Ended");
            }
            System.out.println("");
        }
        Colors.pru("DSSProjAPP-V1 Application Stopped");
    }
}
