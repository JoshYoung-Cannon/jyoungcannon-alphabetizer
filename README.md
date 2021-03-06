# jyoungcannon-alphabetizer v1.5.0

# QMMS Interview Task202112: Josh Young-Cannon

This is a word alphabetizer, written with a the goal of using the minimum amount of inbuilt libary code as possible.

### Assumptions
1. The input text file will seperate different words using a single white space e.g. " "

2. The individual words will only contain language letter characters, apostrophes or hyphens and will not contain numbers, punctuation or sysmbols
   e.g. Valid input: Fizz, fizz, Fizz-Buzz, Fizz't
        Invalid input: F!zz, f00, Fizz:Buzz, Fizz\Buzz

3. The alphabetical order (in ragards to tie breakers) is as follows:
   1. FIZZ
   2. Fizz
   3. Fizz-Buzz
   4. FizzBuzz
   5. Fizz'Buzz
   6. fizz

4. Least Viable Product will returns an alphabetical list of all input items (including duplicates)

## Getting Started

### Prerequisites

Java 17 JDK:
A copy of Java 17 can be found here: https://www.oracle.com/java/technologies/downloads/#jdk17-windows

1. Add the the location of the installed JDK to your System Environment Variables and name it JAVA_HOME Add %JAVA_HOME%\bin to your System Path.
2. You can test if java has been installed by typing java -version into a command prompt.

apache-maven-3.8.5:
A copy of apache-maven-3.8.5-bin.zip can be found here: https://maven.apache.org/download.cgi

1. Extract the contents of apache-maven-3.8.5-bin.zip to any directory (ideally Program Files).
2. Add the location of the apache-maven folder to your System Environment Variables and name it M2_HOME Add %M2_HOME%\bin to your System Path.
3. You can test if maven has been installed by typing mvn -version into a command prompt.

Optional: Java Editor (to edit code files)

1. Install your prefered Java editor on your computer making sure that it is set to be able to open maven projects.

### Building

A step by step guide to building the project:

1. Go to the project folder jyoungcannon-alphabetizer, which contains the src folder and pom.xml
2. Open a command prompt in the source folder
3. Check Java 17 & Apache Maven 3.8.5 has been installed
4. Run the command: mvn clean
5. Run the command: mvn package
6. Check a target folder and contains a newly made jyoungcannon-alphabetizer-0.0.1-SNAPSHOT.jar file

### Running

A step by step guide to run and use the project:

Running the project:
1. Go to the folder containing the jyoungcannon-alphabetizer-0.0.1-SNAPSHOT.jar file
2. Open a command prompt in this folder
3. Run the command: java -jar jyoungcannon-alphabetizer-0.0.1-SNAPSHOT.jar

Using the project:
1. The program will ask for a file path to your input text file
2. If it is a valid file path the program will continue
   Otherwise it will ask you for a new file path (typing QUIT here will close the program)
3. The code will then display all the words from the input file, seperate them into valid and invalid word lists and sort the valid words
4. The code will then display the sorted words followed by the invalid words
5. The code will then ask for a directory to save the output
6. If it is a valid file path the program will save the text files SortedWordsOfYourInputFileName.txt, UniqueSortedWordsOfYourInputFileName.txt and InvalidWordsOfYourInputFileName.txt
   Otherwise it will ask you for a new file path (typing QUIT here will allow you to continue without saving the files)
7. The code will then ask if you would like to exit the program
   Typing Y or QUIT here will exit the program
   Typing N will cause the program to ask you for another input file, and repeat all previous steps

Program outputs:
- SortedWordsOfYourInputFileName.txt: Contains an alphabetized list of all the valid words including duplicates.
- UniqueSortedWordsOfYourInputFileName.txt: Contains an alphabetized list of all the valid words excluding duplicates.
- InvalidWordsOfYourInputFileName.txt: Contains a list off all invalid words for the purpose of future tool improvements.

NOTE: 
1. An example text file has been included in the jyoungcannon-alphabetizer\example folder, when jyoungcannon-alphabetizer-0.0.1-SNAPSHOT.jar is run from the target folder the example text can be called using the file path:
..\example\Reaper-Man-Amazon-BookDescription.txt

2. If desired the example folder can be used to hold the output files, when jyoungcannon-alphabetizer-0.0.1-SNAPSHOT.jar is run from the target folder use the file path: 
..\example

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning
We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Josh Young-Cannon** - *Initial work* - [JoshYoung-Cannon](https://github.com/JoshYoung-Cannon)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 
