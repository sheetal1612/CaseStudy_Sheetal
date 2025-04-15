Feature: Case Study
https://conduit-realworld-example-app.fly.dev/

    Scenario: Create Article
     Given User is on login page
    When User enters "chaudharysheetal74@gmail.com" and "Test@12345"
    Then User should be on Home Page
    When User click on New Article page
    And User fill required values
    |Title|Body|Description|
    |SH3Title|Sh3|Sh3Desc|
    Then User should be able to create article sucessfully
    
    Scenario: Edit Article
    Given User should be on Home Page
    And User click on Global Feed
    Then User should be able to find article list
    Then User click on Edit button for required article and update some field
    |Title|UpdateValue|
    |SH3Title|UpdatedSH3Title|
    Then User should be able to updated article
    
    Scenario: Delete Article
   Given User should be on Home Page
    And User click on Global Feed
    Then User should be able to find article list
    Then User click on Delete article button
    |UpdatedValue|
    |UpdatedSH3Title|
    Then Article should be deleted successfuly 
    
    