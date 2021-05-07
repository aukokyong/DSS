package com.dss.ui;

import java.util.Scanner;

import com.dss.util.Colors;

public class MainApp {
	public static void main (String[] args){
        Scanner userInput = new Scanner(System.in);
        String choice = "";
        Colors.pru("DSSProjAPP-V1 Application Started");
        while(!choice.equals("5")) {

            Colors.pp("\nDSSProjAPP-V1 Menu");
            Colors.pg("1. Actor");
            Colors.pg("2. Customer");
            Colors.pg("3. Movie");
            Colors.pg("4. Review");
            Colors.pg("5. Quit");
            System.out.println("");
            choice = userInput.nextLine();
            switch(choice){
                case "1":
                    Colors.pb("Running Actor App");
                    ActorApp.main(null);
                    Colors.pb("\nActor App Ended");
                    break;
                case "2":
                    Colors.pb("Running Customer App");
                    CustomerApp.main(null);
                    Colors.pb("\nCustomer App Ended");
                    break;
                case "3":
                    Colors.pb("Running Movie App");
                    MovieApp.main(null);
                    Colors.pb("\nMovie App Ended");
                    break;
                case "4":
                    Colors.pb("Running Review App");
                    ReviewApp.main(null);
                    Colors.pb("\nReview Junit App");
            }
            System.out.println("");
        }
        Colors.pru("DSSProjAPP-V1 Application Stopped");
    }
}
