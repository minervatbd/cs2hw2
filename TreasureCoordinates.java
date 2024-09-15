/* Mina Georgoudiou
 * Dr. Steinberg
 * COP3503 Fall 2024
 * Programming Assignment 1
 */

// good ol treasure coords class

import java.util.ArrayList;

public class TreasureCoordinates
{
    /*
     * input for this will be a string with a digit in parentheses
     * output will be arraylist of strings with coordinates in parentheses
     * we will trust that the input will have at least 2 digits
     */
    public ArrayList<String> determineCoordinates(String digits)
    {
        // for returning later
        ArrayList<String> coords = new ArrayList<String>();

        // get the parentheses out, dont need em
        digits = digits.substring(1, digits.length() - 1);

        determineCoordinatesR(digits, coords, 1, digits.length());

        return coords;
    }

    // recursive part of function
    static void determineCoordinatesR(String inDigits, ArrayList<String> outCoords, int k, int n)
    {
        System.err.println(k);
        // end of recursive loop
        if (k == n)
            return;
        else
        {
            // add a comma
            //inDigits = insertStr(inDigits, ", ", k);

            for (int i = 1; i <= k; i++)
            {
                //if (i != k)
                //    inDigits = insertPt(inDigits, true, i);
                int passi = i;
                if (i == k)
                    passi = -1;
                
                for (int j = k + 1; j <= n; j++)
                {
                    //if (j != n - k)
                    //    inDigits = insertPt(inDigits, false, j + k - 1);
                    int passj = j;
                    if (j == n)
                        passj = -1;

                    if (isCoordValid(inDigits))
                        outCoords.add(addParentheses(insertPunc(inDigits, k, passi, passj)));
                    
                    System.out.println(addParentheses(insertPunc(inDigits, k, passi, passj)));

                    //if (j != n)
                    //    inDigits = removePt(inDigits, false);
                }

                //if (i != k)
                //    inDigits = removePt(inDigits, true);
            }

            // back track the comma
            //inDigits = removeStr(inDigits, ", ");

            // increment k
            determineCoordinatesR(inDigits, outCoords, k + 1, n);
        }
        
    }

    // checks if coordinate string is valid
    static boolean isCoordValid(String input)
    {
        // TODO
        return true;
    }

    // prep strings for output
    static String addParentheses(String input)
    {
        return "(" + input + ")";
    }

    static String insertPunc(String input, int comPos, int dotPos1, int dotPos2)
    {
        if (dotPos1 == -1 && dotPos2 != -1)
            return input.substring(0, comPos) + ", " + input.substring(comPos, dotPos2) + "." + input.substring(dotPos2);

        else if (dotPos1 != -1 && dotPos2 == -1)
            return input.substring(0, dotPos1) + "." + input.substring(dotPos1, comPos) + ", " + input.substring(comPos);
        
        else if (dotPos1 == -1 && dotPos2 == -1)
            return input.substring(0, comPos) + ", " + input.substring(comPos);
        
        else
            return input.substring(0, dotPos1) + "." + input.substring(dotPos1, comPos) + ", " + input.substring(comPos, dotPos2) + "." + input.substring(dotPos2);
    }
}