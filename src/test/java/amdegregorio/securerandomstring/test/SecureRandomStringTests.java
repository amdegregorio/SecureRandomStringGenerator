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
package amdegregorio.securerandomstring.test;

import org.junit.jupiter.api.Test;

import com.google.common.base.CharMatcher;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import amdegregorio.securerandomstring.SecureRandomString;

/**
 * Runs basic Unit Tests for the SecureRandomString class
 *
 * @author AMD
 * @version 1.0
 */
public class SecureRandomStringTests {

	@Test
	public void whenOnlyLengthSuppliedSuccess() {
		CharMatcher matcher = CharMatcher.anyOf("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
		int stringLength = 128;
		SecureRandomString srs = new SecureRandomString();
		String randomString = srs.generateSecureRandomString(stringLength);
		assertTrue(randomString.length()==stringLength && matcher.matchesAllOf(randomString));
	}
	
	@Test
	public void whenAlphanumericStringSupplied() {
		String alphanumericString = "abcdefg12345";
		CharMatcher matcher = CharMatcher.anyOf(alphanumericString);
		int stringLength = 128;
		SecureRandomString srs = new SecureRandomString(alphanumericString);
		String randomString = srs.generateSecureRandomString(stringLength);
		assertTrue(randomString.length()==stringLength && matcher.matchesAllOf(randomString));
	}
	
	@Test
	public void whenSpecialCharacterStringSupplied() {
		String specialString = "`~!@#$%^&*()-_=+{[}]|\\;:'\"<,.>?/";
		CharMatcher matcher = CharMatcher.anyOf(specialString);
		int stringLength = 128;
		SecureRandomString srs = new SecureRandomString(specialString);
		String randomString = srs.generateSecureRandomString(stringLength);
		assertTrue(randomString.length()==stringLength && matcher.matchesAllOf(randomString));
	}
	
	@Test
	public void whenCharacterArraySupplied() {
		char[] charsToUse = {'a', 'b', 'c', '1', '2', '3', '(', ')', '#', '\\', '?'};
		CharMatcher matcher = CharMatcher.anyOf(String.valueOf(charsToUse));
		int stringLength = 128;
		SecureRandomString srs = new SecureRandomString(charsToUse);
		String randomString = srs.generateSecureRandomString(stringLength);
		assertTrue(randomString.length()==stringLength && matcher.matchesAllOf(randomString));
	}
	
	@Test
	public void whenUnicodeSpecialValuesSupplied() {
		String unicodeString = "\u0000";;
		unicodeString += "\u0007";;
		unicodeString += "\u0008";;
		unicodeString += "\\u000A";
		unicodeString += "\u0011";
		unicodeString += "\u007F";
		unicodeString += "\u0094\u0020\u00A2\u00A9\u00B1\u00B6\u00D8\u0100\u0191\u01C0\u01C7\u0394";
		CharMatcher matcher = CharMatcher.anyOf(unicodeString);
		int stringLength = 128;
		SecureRandomString srs = new SecureRandomString(unicodeString);
		String randomString = srs.generateSecureRandomString(stringLength);
		assertTrue(randomString.length()==stringLength && matcher.matchesAllOf(randomString));
	}
	
	@Test
	public void whenVeryLargeStringRequred() {
		CharMatcher matcher = CharMatcher.anyOf("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
		int stringLength = 100000;
		SecureRandomString srs = new SecureRandomString();
		String randomString = srs.generateSecureRandomString(stringLength);
		assertTrue(randomString.length()==stringLength && matcher.matchesAllOf(randomString));
	}
	
	@Test
	public void whenInvalidStringPassedToConstructor() {
		String invalidStringArg = "";
		assertThrows(IllegalArgumentException.class, ()->{new SecureRandomString(invalidStringArg);});
	}
	
	@Test
	public void whenInvalidCharArrayPassedToConstructor() {
		String invalidCharArrayArg = null;
		assertThrows(IllegalArgumentException.class, ()->{new SecureRandomString(invalidCharArrayArg);});
	}
	
	@Test
	public void whenInvalidLengthPassedToMethod() {
		int length = -5;
		SecureRandomString srs = new SecureRandomString();
		assertThrows(IllegalArgumentException.class, ()->{srs.generateSecureRandomString(length);});
	}
}
