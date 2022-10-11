#Author: sunitha
## (Comments)
#Sample Feature Definition Template
Feature: Search for Available Pet and Order an Pet and Update the Order
  
  
  
  Pet Store Swagger API : https://petstore.swagger.io/

  Scenario: Find Pet By Status
    Given I Set Get Pet By Status API EndPoint "/v2/pet/findByStatus"
    When I search for "available" pets
    And I choose first Pet from the Pet List
    Then a 200 response is returned

  Scenario: Place an Pet Order from Pet Store
    Given I Set Get Pet By Status API EndPoint "/v2/store/order"
    When I "placed" order for 2 Pets with request body
    Then a 200 response is returned

  Scenario: Delete an Existing Order
    Given I Set Get Pet By Status API EndPoint "/v2/store/order"
    When I set the Order Id for Delete
    Then Delete the placed Order and Message is same as Order Id
