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

        // used for staging coordinates for validity check
        String currentCoord = "";

        // get the parentheses out, dont need em
        digits = digits.substring(1, digits.length() - 1);

        // first call recursive function
        determineCoordinatesR(digits, currentCoord, coords, 1, digits.length(), 1, 1);

        return coords;
    }

    // recursive part of function
    static void determineCoordinatesR(String inDigits, String currentCoord, ArrayList<String> outCoords, int k, int n, int x, int y)
    {
        // end of recursive loop; comma reached end
        if (k == n)
            return;
        
        else
        {
            // adds comma, periods
            currentCoord = insertPunc(inDigits, k, x, y + k);

            // add current coord to array if valid
            if (isCoordValid(currentCoord))
                outCoords.add(addParentheses(currentCoord));
            
            // reset variable
            currentCoord = "";

            // if we need to iterate k, backtracking x and y
            if (x == k && y == (n - k))
                determineCoordinatesR(inDigits, currentCoord, outCoords, k + 1, n, 1, 1);
            
            // if we need to iterate x, backtracking y
            else if (y == (n - k))
                determineCoordinatesR(inDigits, currentCoord, outCoords, k, n, x + 1, 1);
            
            // otherwise just iterate y
            else
                determineCoordinatesR(inDigits, currentCoord, outCoords, k, n, x, y + 1);
        }
        
    }

    // checks if coordinate string is valid
    static boolean isCoordValid(String input)
    {
        // split by comma
        String[] inSplit = input.split(", ");

        // check both components individually
        for (int c = 0; c <= 1; c++)
        {
            if (inSplit[c].startsWith("0") && inSplit[c].length() > 1)
            {
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
        int len = input.length();
        
        // add dot if needed
        if (dotPos1 != comPos)
            output += input.substring(0, dotPos1) + "." + input.substring(dotPos1, comPos);
        
        // or leave it out
        else
            output += input.substring(0, comPos);
        
        // always add comma
        output += ", ";
        
        // add 2nd dot if needed
        if (dotPos2 != len)
            output += input.substring(comPos, dotPos2) + "." + input.substring(dotPos2);
        
        // or leave it out
        else
            output += input.substring(comPos);

        return output;
    }
}