Feature: Compute FizzBuzz

  Scenario: Return Fizz if number divisible by three

    Given the number 3
    When we compute FizzBuzz
    Then the result is "Fizz"

  Scenario: Return 1 if 1 is input

      Given the number 1
      When we compute FizzBuzz
      Then the result is "1"

  Scenario: Return 2 if 2 is input

    Given the number 2
    When we compute FizzBuzz
    Then the result is "2"

  Scenario: Return Fizz if 3 is input

    Given the number 3
    When we compute FizzBuzz
    Then the result is "Fizz"

  Scenario: Return 4 if 4 is input

    Given the number 4
    When we compute FizzBuzz
    Then the result is "4"

    Scenario: