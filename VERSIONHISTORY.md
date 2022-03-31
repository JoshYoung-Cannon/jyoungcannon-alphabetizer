### v1.1.0
Project Setup

### v1.1.0
Feature-Branch: StringManipulator Class created;
Class contains methods:
StringManipulator.splitString(sentence, splitChar)
StringManipulator.anglosizeString(raw)
StringManipulator.stringEquals(base, comparison)

### v1.2.0
Feature-Branch: SortOptions Class created;
Class contains methods:
SortOptions.bubbleSortAlphabetically(toSort)
SortOptions.stringCompareAlphabetically(a, b)
SortOptions.charCompareAlphabetically(a, b)
SortOptions.hyphenCompareAlphabetically(a, b)


StringManipulator Class updated;
Class contains new fields:
StringManipulator.upperCaseMin
StringManipulator.upperCaseMax
StringManipulator.lowerCaseMin
StringManipulator.lowerCaseMax
StringManipulator.caseChange

Class contains new methods:
StringManipulator.isLowerCase(a)
StringManipulator.isUpperCase(a)
StringManipulator.toLowerCase(a)
StringManipulator.toUpperCase(a)

Class methods updated:
StringManipulator.containsCount(sentence, splitChar) is now public.

### v1.3.0
Full test coverage for SortOptions Class completed

### v1.4.0
Feature-Branch: FileIO Class created;
Class contains new fields:
FileIO.encoder

Class contains methods:
FileIO()
FileIO(encoder)
FileIO.setEncoder(encoder)
FileIO.getEncoder()
FileIO.loadData(fileLocation)
FileIO.writeData(fileLocation, data, appendToFile)

### v1.5.0
Feature-Branch: Controller Class created;
Class contains new fields:
Controller.inputFileLocation
Controller.outputFileLocation
Controller.running
Controller.read = true
Controller.write = false

Class contains methods:
Controller.askFileLocation(reading)
Controller.arrayListToArray(arrayList)
Controller.printArray(toPrint, seperator)
Controller.getInputFileLocation()
Controller.getUniqueItems(words)
Controller.getOutputFileLocation(sortedWords, invalidWords)
Controller.quitProgram()
Controller.run()


Feature-Branch: UserInput Class created;
Class contains methods:
UserInput.fileInput(message)
UserInput.exitInput()


Feature-Branch: Validator Class created;
Class contains methods:
Validator.Validator(exceptionChars)
Validator.Validator()
Validator.getExceptionChars()
Validator.setExceptionChars(exceptionChars)
Validator.validateChars(word)
Validator.regexValidateFormat(word)
Validator.validateFormat(word)
Validator.validateWord(word)
Validator.validateWordRegex(word)


FileIO Class updated;
New methods:
FileIO.loadDataThrowable(fileLocation)

Class methods updated:
FileIO.writeData(fileLocation, data, appendToFile) improved error handling


SortOptions Class updated;
Class methods updated:
SortOptions.stringCompareAlphabetically(a, b) fixed to correctly handle different length word comparisons


StringManipulator Class updated;
New methods:
StringManipulator.wordToUpperCase(word)
StringManipulator.removeDuplicateChars(sentence, keyChar)

### v1.5.0
Validator Class updated;
Class methods updated:
Validator.validateWord(word) and Validator.validateWordRegex(word) now reject words begining with apostrophes