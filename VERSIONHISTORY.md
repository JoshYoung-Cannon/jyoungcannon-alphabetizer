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