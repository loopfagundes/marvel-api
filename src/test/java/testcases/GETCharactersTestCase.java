package testcases;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.sql.Timestamp;
import static io.restassured.RestAssured.given;
import static utils.HashUtil.getHash;

public class GETCharactersTestCase {

    @Test
    public void getCharactersWithSuccess() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timesTampStr = timestamp.toString();

        String apiKey = "66d0c804b001482adf657292b89d40f3";
        String privateApiKey = "fbd395fc6146e4248406ccccab35a28a1db00ae1";

        String md5Str = timesTampStr + privateApiKey + apiKey;

        String hash = getHash(md5Str);

        Response response =
                given().
                    baseUri("https://gateway.marvel.com/v1/public").
                    basePath("characters").
                    param("ts", timesTampStr).
                    param("apiKey",apiKey).
                    param("hash",hash).
                    param("name","Thor").
                when().
                    get();
    }
}
