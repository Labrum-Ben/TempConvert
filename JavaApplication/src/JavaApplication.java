/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
package javaapplication;


/**
 * A program to convert temperature from Fahrenheit to Celsius.
 * @author Ben Labrum
 *
 */
import java.util.Scanner;
public class JavaApplication {
    public static void main (String [] args) {
        /* Set up variables */
        float valueTemperature=0;
        String typeTemperature = "", fullInput = "";
        int counter = 0;
 
        /* Ask for input */
        speakIntroduction();
        Scanner keyboard = new Scanner (System.in);
 
        while ((!fullInput.equals("quit")) && (!fullInput.equals("stop"))) {
            counter++;
            if (counter > 5) {
                /* Every 5 occurences, remind the user of the introduction */
                speakIntroduction();
                counter = 0;
            }
            /* Collect Input */
            System.out.println("");
            System.out.println("To quit, enter 'quit' or 'stop'.");
            System.out.print("Temperature to convert: ");
            fullInput = keyboard.nextLine();
 
            /* Parse Input */
            fullInput.trim();
            fullInput = fullInput.toLowerCase();
 
            //verify the string is not empty:
            if (fullInput.length() <=0) 
                continue;
 
            typeTemperature = fullInput.substring(fullInput.length()-1);
            /* Verify that requested temperature is numeric (float) */
            try {
                valueTemperature = Float.parseFloat(fullInput.substring(0,fullInput.length()-1));
            } catch(NumberFormatException nfe) {
                if ((!fullInput.equals("quit")) && (!fullInput.equals("stop"))) 
                    System.out.println("Please specify a numerical temperature.");
                continue;
            }
            /* Calculate Output */
            calculateOutput(typeTemperature, valueTemperature);
        }
 
        /* END */
        System.out.println(""); 
        System.out.println("Thank you!");
 
    }
 
    /**
     * Prints the introduction text.
     */
    public static void speakIntroduction () {
        System.out.println(""); 
        System.out.println("Please enter a temperature to convert.");
        System.out.println("(Examples: 150f, 32f)\n"); 
        return;
    }
 
    /**
     * Calculates and outputs the converted temperature based 
     * on the parameters received by the user.
     *
     * @param typeOfTemperature   Temperature type, expects
     *                            F or f for Fahrenheit.
     * @param valueOfTemperature  Temperature value, expects
     *                            numerical representation (float)
     *
     */
    public static void calculateOutput (String typeOfTemperature, float valueOfTemperature) {

        /* expected input: calculateOutput(typeTemperature, valueTemperature) */
          String resultConvert = "", resultType = "";
        float convertedResult = 0;
 
        switch (typeOfTemperature) {
            case "f":
                /* convert to celsius */
                convertedResult = 5*(valueOfTemperature - 32)/9;
                resultConvert = " Fahrenheit ";
                resultType = " Celsius ";
                break;
        }
        /* Display Output */
        System.out.println(""); 
        System.out.println(valueOfTemperature + resultConvert + "is " + convertedResult + resultType);
    }
}
    

