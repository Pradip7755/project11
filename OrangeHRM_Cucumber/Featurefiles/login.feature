
@tag
Feature: Admin Login
  I want to use this for Admin Login Test

  @tag1
  Scenario: Admin Login
    Given i open a browser with url "http://orangehrm.qedgetech.com"
    Then i should see Login Module
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    Then i should see Admin Module
    When i click logout
    Then i should see Login Moule
    Then i close Browser 

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
