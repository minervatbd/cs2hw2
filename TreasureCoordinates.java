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
        // end of recursive loop
        if (k == n)
            return;
        
        else
        {
            // first point position loop
            for (int i = 1; i <= k; i++)
            {
                int dotPos1 = i;

                if (i == k)
                    dotPos1 = -1;
                
                // second point position loop
                for (int j = k + 1; j <= n; j++)
                {
                    int dotPos2 = j;

                    if (j == n)
                        dotPos2 = -1;

                    if (isCoordValid(insertPunc(inDigits, k, dotPos1, dotPos2)))
                        outCoords.add(addParentheses(insertPunc(inDigits, k, dotPos1, dotPos2)));
                    
                }
            } // end of loop, backtrack dot positions

            // increment comma position
            determineCoordinatesR(inDigits, outCoords, k + 1, n);
        }
        
    }

    // checks if coordinate string is valid
    static boolean isCoordValid(String input)
    {

        String[] inSplit = input.split(", ");

        for (int c = 0; c <= 1; c++)
        {
            if (inSplit[c].startsWith("0") && inSplit[c].length() > 1)
            {
                System.out.println(inSplit[c].charAt(1) + " " + (inSplit[c].charAt(1) != '.'));
                if (inSplit[c].charAt(1) != '.')
                    return false;
                
                else if (inSplit[c].charAt(1) == '.' && inSplit[c].endsWith("0"))
                    return false;

            }
        }

        return true;
    }

    // prep strings for output
    static String addParentheses(String input)
    {
        return "(" + input + ")";
    }

    static String insertPunc(String input, int comPos, int dotPos1, int dotPos2)
    {
        String output = "";
        
        // add dot if needed
        if (dotPos1 != -1)
            output += input.substring(0, dotPos1) + "." + input.substring(dotPos1, comPos);
        
        // or leave it out
        else
            output += input.substring(0, comPos);
        
        // always add comma
        output += ", ";
        
        // add 2nd dot if needed
        if (dotPos2 != -1)
            output += input.substring(comPos, dotPos2) + "." + input.substring(dotPos2);
        
        // or leave it out
        else
            output += input.substring(comPos);

        return output;
    }
}