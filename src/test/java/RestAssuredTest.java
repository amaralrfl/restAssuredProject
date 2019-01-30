import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredTest {

    String url = "https://reqres.in/api/users";

    @Test
    public void getPageOne(){

        given().
            param("page", "1").
        when().
            get(url).
        then().
            statusCode(200).
            body("page", equalTo(1));
    }

    @Test
    public void getUser() {
        get(url + "/2").then().body("data.id", equalTo(2));
    }
}