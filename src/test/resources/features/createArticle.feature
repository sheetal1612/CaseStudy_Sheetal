Feature: Case Study
https://conduit-realworld-example-app.fly.dev/

    Scenario: Login into App
    Given User is on login page
    When User provide "chaudharysheetal74@gmail.com" and "Test@12345"
    Then User should be on Home Page

    Scenario: Create new Article
    Given User should be on New Article page
    When User enters Article details
    |Title|Desc|Content|Tag|
    |SH3Title|Sh3|Sh3Desc|demo|
    Then Article must be created
    
    Scenario: Create new Article with existing title(Negative Scenario)
    Given User should be on New Article page
    When User enters Article details
    |Title|Desc|Content|Tag|
    |SH3Title|Sh3|Sh3Desc|demo|
    Then Article must not be created if already exist
   
    Scenario: View Article
    Given User should be on Global Feed page
    When User select an article "SH3Title"
    Then Article details page must be displayed
    
    Scenario: Update an Article
    Given Article details page must be displayed
    When User update article detail
    |OldTitle|UpdateValue|
    |SH3Title|UpdatedSH3Title|
    Then Article must be updated
    
    Scenario: Delete an Article
    Given Article details page must be displayed
    When User delete article
    |ArticleToBeDeleted|
    |UpdatedSH3Title|
    Then Article must be deleted
    
    