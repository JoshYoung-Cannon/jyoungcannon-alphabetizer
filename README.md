# jyoungcannon-alphabetizer v1.3.0

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

Eclipse Java
Install Eclipse on your computer

Java JRE 17:
Install a jre of 17.0.2

### Installing

A step by step guide to get a development environment running:

1. Ensure the JDK compliance level is set to 17:
Go to Eclipse Menu Item Window -> Preferences -> Java -> Complier:
Set the "Compiler compience level" to 17

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning
We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Josh Young-Cannon** - *Initial work* - [JoshYoung-Cannon](https://github.com/JoshYoung-Cannon)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 
