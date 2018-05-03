/*
 *  This application generates a secure random string using Java's SecureRandom class.
 *   Copyright (C) 2018  Amy DeGregorio
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package amdegregorio.securerandomstring;

import java.security.SecureRandom;

/**
 * This class creates a secure random alphanumeric string using java.util.SecureRandom.
 * <br>
 * The default constructor sets the characters to be used to all upper and lower case 
 * letters and digits 0 through 9.
 * <br>
 * Common Usage: <br>
 * <pre>
 *   SecureRandomString secRndStr = new SecureRandomString();
 *   String generatedString = secRndStr.generateSecureRandomString(64);
 * </pre>
 * 
 * @author Amy DeGregorio
 * @version 1.0
 */
public class SecureRandomString {
   //Default characters to be used when generating a secure random string.
   private static final char[] defaultChars = {'a', 'b', 'c', 'd', 'e', 'f', 
		   'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
		   't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 
		   'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 
		   'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', 
		   '6', '7', '8', '9'};
   
   private char[] allowedChars;
   
   /**
    * Creates a default SecureRandomString that creates a secure random string
    * of alphanumeric characters.
    */
   public SecureRandomString() {
	   allowedChars = defaultChars;
   }
   
   /**
    * Creates a SecureRandomString that generates a secure random string
    * using the characters supplied.
    * 
    * @param allowedChars an array of characters to use when generating the secure random string.
    * @throws IllegalArgumentException If the provided array is null or 0 length
    */
   public SecureRandomString(char[] allowedChars) throws IllegalArgumentException {
	   if (allowedChars == null || allowedChars.length == 0) {
		  throw new IllegalArgumentException("The allowedChars value must be a non null character array with at least one value");
	   } else {
	      this.allowedChars = allowedChars;
	   }
   }
   
   /**
    * Creates a SecureRandomString that generates a secure random string using 
    * the string of characters supplied.
    * 
    * @param allowedCharsString a string of characters to use when generating the secure random string.
    * @throws IllegalArgumentException If the provided string is null or 0 length
    */
   public SecureRandomString(String allowedCharsString) {
	   if (allowedCharsString == null || allowedCharsString.length() == 0) {
		  throw new IllegalArgumentException("The allowedCharsString may non be null or zero length");
	   } else {
	      this.allowedChars = allowedCharsString.toCharArray();
	   }
   }
   
   /**
    * Generates a secure random string of the length provided using the 
    * array of allowed characters.
    * 
    * @param length the length of secure string to generate.
    * @return a secure random string of the length specified.
    * @throws IllegalArgumentException if the length parameter is not a positive, non-zero string
    */
   public String generateSecureRandomString(int length) throws IllegalArgumentException {
	   if (length <=0) throw new IllegalArgumentException("Invalid length.  Must be a positive, non-zero integer.");
	   String randomString = "";
	   SecureRandom secRnd = new SecureRandom();
	   
	   for (int i = 0; i < length; i++) {
	      randomString+= allowedChars[secRnd.nextInt(allowedChars.length)];
	   }
	   
	   return randomString;
   }
}
