Feature: Create a new Vehicle Type
  As a user
  I want to create a new vehicle type
  So that other users can see it

  Scenario: The vehicle type was created successfully
    Given i am a user and entered the correct data
    When i make a post request to "/api/vehicletypes/post"
    Then the response result received should be 200

  Scenario: The vehicle type could not be created
    Given i am a user and entered the incorrect data
    When i make a post request to "/api/vehicletypes/3/posts"
    Then the response result received should be a bad 400
