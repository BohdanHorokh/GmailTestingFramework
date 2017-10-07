Feature: Login on Gmail

  Scenario:Successful Login with Valid Credentials

    Given User enter username as "qa.lviv.test@gmail.com" and submit
    And user enter password as "QualityAssurance" and submit
    Then Gmail home page is opened
