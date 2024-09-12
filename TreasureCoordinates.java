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
    public ArrayList determineCoordinates(String digits)
    {
        // for returning later
        ArrayList<String> outCoords = new ArrayList<String>();

        // get the parentheses out, dont need em
        digits = digits.substring(1, digits.length() - 1);

        return outCoords;
    }
}