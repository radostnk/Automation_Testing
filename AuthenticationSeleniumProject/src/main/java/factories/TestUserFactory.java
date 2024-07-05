package factories;

import com.github.javafaker.Faker;
import com.mailslurp.models.InboxDto;
import infrastructure.MailslurpService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.TestUser;

import static io.restassured.RestAssured.given;

public class TestUserFactory {

    private static final Faker faker = new Faker();

    //TODO: Public methods

    private String generateUsername() {
        String username = faker.name().firstName() + faker.number().digits(5);
        username = username.replaceAll("[^a-zA-Z0-9]", "");
        return username;
    }

    private String generatePassword() {
        return faker.lorem().characters(10) + "Aa";
    }

    private String generatePhoneNumber() {
        return faker.number().digits(10);
    }

    private static TestUser createTestUser(String username, String email, String password, String phone, String status) {

        TestUser testUser = new TestUser();
        testUser.setUsername(username);
        testUser.setEmail(email);
        testUser.setPassword(password);
        testUser.setPhone(phone);
        testUser.setStatus(status);

        Response response = callCreateTestUserApi(testUser, "/createUser");
        return response.as(TestUser.class);
    }

    private static TestUser createTestUserWithRealEmail(String username, String password, String phone, String status) {

        TestUser testUser = new TestUser();
        InboxDto newInbox = MailslurpService.createInbox(null);
        testUser.setUsername(username);
        testUser.setEmail(newInbox.getEmailAddress());
        testUser.setPassword(password);
        testUser.setPhone(phone);
        testUser.setStatus(status);

        Response response = callCreateTestUserApi(testUser, "/createUser");
        testUser = response.as(TestUser.class);
        testUser.setUserInbox(newInbox);
        return testUser;
    }

    private static TestUser createTestUser2FAWithRealEmail(String username, String password, String phone, String status) {

        TestUser testUser = new TestUser();
        InboxDto newInbox = MailslurpService.createInbox(null);

        testUser.setUsername(username);
        testUser.setEmail(newInbox.getEmailAddress());
        testUser.setPassword(password);
        testUser.setPhone(phone);
        testUser.setStatus(status);

        Response response = callCreateTestUserApi(testUser, "/createTestUser2FA");
        testUser = response.as(TestUser.class);
        testUser.setUserInbox(newInbox);
        return testUser;
    }

    private static Response callCreateTestUserApi(TestUser testUser, String path) {
        RestAssured.useRelaxedHTTPSValidation();

        return given()
                .baseUri("file:///C:/Users/koleva/Desktop/test-login-app-main/")
                .contentType(ContentType.JSON)
                .body(testUser)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
