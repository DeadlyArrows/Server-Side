package com.hackdead.wheelmanager.cucumber.StepDefinitions;

import com.hackdead.wheelmanager.cucumber.SpringIntegrationTest;
import com.hackdead.wheelmanager.entities.VehicleType;
import com.hackdead.wheelmanager.resource.SaveVehicleTypeResource;
import com.hackdead.wheelmanager.resource.VehicleTypeResource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class VehicleTypeCreationSteps extends SpringIntegrationTest {
    VehicleType vehicleType = new VehicleType();
    @Given("i am a user and entered the correct data")
    public void i_am_a_user_and_entered_the_correct_data() {
        vehicleType.setTypeName("bicimoto");
    }

    @Given("i am a user and entered the incorrect data")
    public void i_am_a_user_and_entered_the_incorrect_data() {vehicleType = null;}

    @When("i make a post request to {string}")
    public void i_make_a_post_request_to(String path) throws IOException {
        makePost(path, vehicleType);
    }
    @Then("the response result received should be {int}")
    public void the_response_result_received_should_be(Integer codeResponse) {
        assertThat(response.value(), is(codeResponse));
    }
    @Then("the response result received should be a bad {int}")
    public void the_response_result_received_should_be_a_bad(Integer codeResponse) {
        assertThat(response.value(), is(HttpStatus.BAD_REQUEST.value()));
    }
}
