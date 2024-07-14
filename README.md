# Secure Random String Generator
---

The Secure Random String Generator is a simple utility for using Java's [java.security.SecureRandom](https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html) to generate secure random strings.  

The application can be built and then run as a command line application or the jar file can be brought into an application and the SecureRandomString class used within your application.
___

## Using the application

### To Build and Run with Gradle

From the command line, go to the directory containing the application.

```
> gradlew clean build
> java -jar .\build\libs\SecureRandomGenerator-1.0.1.jar length_of_string [characters_to_use]

```
*length\_of\_string*: a positive whole number indicating the length of the string to generate
*characters\_to\_use*: an optional string containing the characters to use in the string

Use *-h* or *--help* for a usage help

**Example**

`java -jar .\build\libs\SecureRandomGenerator-1.0.1.jar 64 ABCDEFG1234567890`

**Output**

>Generated String: G1A3553C8E6132C3G0B45F4CD2632DAF4FA8F1A5EDCE39DE2B228BB24EDE4EAF


### To Build and Run with Maven

From the command line, go to the directory containing the application.

```
>mvn clean package
>java -jar .\target\SecureRandomGenerator-1.0.1.jar length_of_string [characters_to_use]
```
*length\_of\_string*: a positive whole number indicating the length of the string to generate
*characters\_to\_use*: an optional string containing the characters to use in the string

Use *-h* or *--help* for a usage help

**Example**

`java -jar .\target\SecureRandomGenerator-1.0.1.jar 64 ABCDEFG1234567890`

**Output**
>Generated String: 5B9GADAG7A4501E26E4G285139G5EBF1FAFBGDEA7B67AAG73F012GA60B1FC4FD

### To Build and use in an application

Build the jar file using Gradle or Maven and add it to your project's dependencies directory.

To generate an alphanumeric string, use the default constructor.  To use different characters in the generated string, use one of the other constructors. 

Common usage:

```
int stringLength = 64;
SecureRandomString secureRandomString = new SecureRandomString();
String generatedString = secureRandomString.generateSecureRandomString(stringLength);
```

For more information see [Presenting the SecureRandomStringGenerator](https://amydegregorio.com/2018/05/03/presenting-the-securerandomstringgenerator/)

#### License
This project is licensed with GNU General Public License Version 3.  See the LICENSE file for more information or go to [GNU General Public License](https://www.gnu.org/licenses/gpl-3.0.en.html).
