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

        return coords;
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

    // remove ', '
    static String removeStr(String input, String target)
    {
        return input.replaceAll(target, "");
    }

    // remove .
    static String removeChar(String input, char target)
    {
        return input.replace(target, (char)0);
    }

    // remove specific point
    static String removePt(String input, boolean firstHalf)
    {
        String[] inSplit = input.split(", ");

        if (firstHalf)
            return removeChar(inSplit[0], '.') + ", " + inSplit[1];
    
        else
            return inSplit[0] + ", " + removeChar(inSplit[1], '.');
    }

    // insert . or ,
    static String insertStr(String input, String newStr, int pos)
    {
        return input.substring(0, pos) + newStr + input.substring(pos, input.length());
    }
}