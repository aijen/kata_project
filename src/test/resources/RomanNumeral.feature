Feature: Compute Roman Numeral
  
  Scenario: Return I if 1 is input
   
    Given the input 1
    When we compute Roman Numeral
    Then the roman numeral result is "I"
  
  Scenario: Return II if 2 input
    
    Given the input 2
    When we compute Roman Numeral
    Then the roman numeral result is "II"

  Scenario: Return III if 3 input

    Given the input 3
    When we compute Roman Numeral
    Then the roman numeral result is "III"

  Scenario: Return IV if 4 input

    Given the input 4
    When we compute Roman Numeral
    Then the roman numeral result is "IV"
    
  Scenario: Return V if 5 input
    
    Given the input 5
    When we compute Roman Numeral
    Then the roman numeral result is "V"
    
  Scenario: Return VI if 6 input
    
    Given the input 6
    When we compute Roman Numeral
    Then the roman numeral result is "VI"
    
  Scenario: Return VII if 7 input
    
    Given the input 7
    When we compute Roman Numeral
    Then the roman numeral result is "VII"
    
  Scenario: Return VIII if 7 input
    
    Given the input 8
    When we compute Roman Numeral
    Then the roman numeral result is "VIII"
    
  Scenario: Return VIII if 8 input
    
    Given the input 9
    When we compute Roman Numeral 
    Then the roman numeral result is "VIIII"
    
  Scenario: Return X if 10 input
    
    Given the input 10
    When we compute Roman Numeral
    Then the roman numeral result is "X"
    
  Scenario: Return invalid message if input larger then 3000
    
    Given the input 3001
    When we compute Roman Numeral
    Then the roman numeral result is "The Romans themselves didn't tend to go any higher"

  Scenario: Return invalid message if input larger then 3000

    Given the input 5200
    When we compute Roman Numeral
    Then the roman numeral result is "The Romans themselves didn't tend to go any higher"
