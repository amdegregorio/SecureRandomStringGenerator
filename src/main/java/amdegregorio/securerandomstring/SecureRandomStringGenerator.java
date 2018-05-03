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

/**
 * This is the main class for running the SecureRandomStringGenerator.
 * <br>
 * The program takes 1 to 2 arguments:
 * <ul>
 * <li>length_of_string (required): a positive integer indicating the length of the string to generate
 * <li>allowed_characters (optional): a string containing the characters to use in the generated string
 * </ul>
 * Use -h or --help to print the usage message.
 * @author Amy DeGregorio
 * @version 1.0
 */
public class SecureRandomStringGenerator {
	private static final String usageMessage = "Usage: " + SecureRandomStringGenerator.class.getSimpleName() 
			+ " length_of_string [allowed_characters] [-h] [--help]\n" 
			+ " length_of_string: a positive whole number indicating the length of string to generate\n"
			+ " allowed_characters: a string containing the characters to use in the string\n"
			+ " -h, --help: print this usage message";

	/**
	 * Uses supplied arguments to create a secure random string using the SecureRandomString class. 
	 * @param args using -h or --help to print the usage method.  The first parameter should be 
	 *        a whole number indicating the length of secure random string to generate. The optional second
	 *        parameter is a string of characters to use when generating the secure random string.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Error: Missing command line arguments.  Use -h or --help for more information.");
			System.err.println(usageMessage);
			System.exit(1);
		} else {
			//If there are command line args, look first for the help argument
			for (int i = 0; i < args.length; i++) {
				if (args[i].equalsIgnoreCase("-h") || args[i].equalsIgnoreCase("--help")) {
			       System.err.println(usageMessage);
			       System.exit(0);
				}
			}
			
			//If we're still here, check the first argument for integerness
			int stringLength = 0;
			try {
		   	   stringLength = Integer.parseInt(args[0]);
			} catch(NumberFormatException nfe) {
				System.err.println("Error: Invalid commandline argument.  Use -h or --help for more information.");
				System.err.println(usageMessage);
				System.exit(2);
			}
			
			//If the allowed characters parameter was passed in, call the constructor
			//that takes a string of allowed characters, otherwise call the default
			SecureRandomString rsg = null;
			if (args.length == 2) {
				rsg = new SecureRandomString(args[1]);
			} else {
				rsg = new SecureRandomString();
			}
			
			String secureRandomString = rsg.generateSecureRandomString(stringLength);
	        System.out.println("Generated String: " + secureRandomString); 
		}
	}

}
