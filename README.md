# String Calculator

A Java implementation of the String Calculator kata that provides a method to add numbers from a string input with various delimiter support.

## Overview

This project implements a `StringCalculator` class with an `add()` method that can handle:

- Empty strings and null inputs
- Single numbers
- Multiple numbers separated by commas
- Newline characters as delimiters
- Custom delimiters
- Negative number validation
- Large number filtering (>1000)

## Features

### Basic Functionality

- **Empty/Null Input**: Returns `0` for empty strings or null input
- **Single Number**: Returns the number itself
- **Multiple Numbers**: Sums comma-separated numbers
- **Newline Support**: Handles newline characters as delimiters

### Advanced Features

- **Custom Delimiters**: Support for single character delimiters using `//delimiter\n` format
- **Negative Number Detection**: Throws `IllegalArgumentException` with all negative numbers listed
- **Large Number Filtering**: Ignores numbers greater than 1000
- **Custom Delimiter of Any Length**: Supports delimiters of any length using `//[delimiter]\n` format

## Project Structure

```
incubyte/
├── pom.xml                                    # Maven configuration
├── README.md                                  # Project documentation
├── src/
│   ├── main/java/com/example/
│   │   └── StringCalculator.java              # Main implementation
│   └── test/java/com/example/
│       └── StringCalculatorTest.java          # Test suite
└── target/                                    # Maven build output
```

## Usage Examples

### Basic Usage

```java
StringCalculator calc = new StringCalculator();

// Empty string
calc.add("");                    // Returns: 0

// Single number
calc.add("1");                   // Returns: 1

// Multiple numbers
calc.add("1,2,3");               // Returns: 6

// Newline as delimiter
calc.add("1\n2,3");              // Returns: 6
```

### Custom Delimiters

```java
// Single character delimiter
calc.add("//;\n1;2;3");          // Returns: 6

// Pipe delimiter
calc.add("//|\n4|5|6");          // Returns: 15

// Custom delimiter of any length
calc.add("//[***]\n1***2***3");  // Returns: 6
```

### Error Handling

```java
// Negative numbers
calc.add("1,-2,3,-4");           // Throws: IllegalArgumentException
                                 // Message: "negative numbers not allowed -2,-4"

// Large numbers are ignored
calc.add("2,1001");              // Returns: 2 (1001 is ignored)
```

## Test Coverage

The project includes comprehensive test coverage with 7 test cases:

1. **Empty String Test**: Verifies empty string returns 0
2. **Single Number Test**: Verifies single number returns itself
3. **Two Numbers Test**: Verifies comma-separated numbers are summed
4. **Newline Separator Test**: Verifies newline characters work as delimiters
5. **Custom Delimiter Test**: Verifies custom delimiters work correctly
6. **Negative Numbers Test**: Verifies negative numbers throw appropriate exception
7. **Large Numbers Test**: Verifies numbers >1000 are ignored

## Running the Project

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Build and Test

```bash
# Compile the project
mvn compile

# Run tests
mvn test

# Clean and compile
mvn clean compile

# Run tests with verbose output
mvn test -X
```

### Test Results

```
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## Development

This project follows Test-Driven Development (TDD) principles:

1. Write failing tests first
2. Implement minimal code to pass tests
3. Refactor while keeping tests green
4. Add new features with corresponding tests

