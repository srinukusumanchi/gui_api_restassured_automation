/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-20
 * Created Time: 8:46 p.m.
 */

package bns.a6.microui.api.testbase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class APIBasePage {


    /* *//**
     * This function is to convert Java object to Json
     *
     * @param classObject - It is a page class object
     * @return Json String   - Converts Java object to Json string
     *//*
    protected String toJson(Object classObject) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

//        Gson gson = new GsonBuilder().serializeNulls().create();
//        Gson gson = new Gson();
//        return gson.toJson(classObject);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(classObject);
    }*/


    /**
     * This function create request specification object for URI
     *
     * @param uri - Accepts Unified Resource Identifier
     * @return - Returns Request specification object having URI
     */
    public RequestSpecification uri(String uri) {
        return given().baseUri(uri);
    }

    /**
     * This function is to return Response object with help of request specification
     *
     * @param requestSpecification - Accepts request specification object
     * @param pathParameter        - Path parameters
     * @return - Returns response object for post action
     */
    public Response get(RequestSpecification requestSpecification, String pathParameter) {
        return requestSpecification.when().get(pathParameter);
    }

    /**
     * This function is to return Response object with help of request specification
     *
     * @param requestSpecification - Accepts request specification object
     * @param pathParameter        - Path parameters
     * @return - Returns response object for post action
     */
    public Response post(RequestSpecification requestSpecification, String pathParameter) {
        return requestSpecification.when().post(pathParameter);
    }

    /**
     * This function is to return Response object with help of request specification
     *
     * @param requestSpecification - Accepts request specification object
     * @param pathParameter        - Path parameters
     * @return - Returns response object for post action
     */
    public Response put(RequestSpecification requestSpecification, String pathParameter) {
        return requestSpecification.when().put(pathParameter);
    }

    /**
     * This function converts json string to Json Object
     *
     * @param jsonString - String having JSON content
     * @return - Returns JSON object
     */
    public JsonPath parseJsonString(String jsonString) {
        return new JsonPath(jsonString);
    }

    /**
     * This function converts Java object to String
     *
     * @param obj - Accepts java object
     * @return - Returns by serializing any Java object as a String.
     */
    public String parseJavaObjectToString(Object obj) throws JsonProcessingException {
        /*ObjectMapper class ObjectMapper provides functionality for reading and writing JSON,
        either to and from basic POJOs (Plain Old Java Objects),or
        to and from a general - purpose JSON Tree Model(JsonNode),
        as well as related functionality for performing conversions.*/
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(obj);
    }

    /**
     * This function gives response key value
     *
     * @param response - Accepts Json object
     * @param jsonPath - Navigation path for respective key
     * @return - Returns json value from a key
     */
    public String getStringResponse(JsonPath response, String jsonPath) {
        return response.get(jsonPath);
    }

    /**
     * This function converts String to Java object
     *
     * @param json - Accepts JSON String
     * @param c
     * @return - Returns  de-serializing Java object
     */
    public Object parseJsonStringToJavaObject(String json, Class<?> c) throws JsonProcessingException {
        /*ObjectMapper class ObjectMapper provides functionality for reading and writing JSON,
        either to and from basic POJOs (Plain Old Java Objects),or
        to and from a general - purpose JSON Tree Model(JsonNode),
        as well as related functionality for performing conversions.*/
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, c);
    }


//    Functionality Re-usable functions

    /**
     * This function validates Phone number size 10 digits and all are numeric
     *
     * @param phoneNumber - Accepts String
     * @return - Returns  true or false if it is phone number
     */
    public Boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }


    /**
     * This function validates email address
     *
     * @param email - Accepts String
     * @return - Returns  true or false if it valid email address
     */
    public Boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * This function genarates random first name
     *
     * @return - Returns  random first name
     */
    public String getRandomFirstName() {
        Faker faker = new Faker(Locale.CANADA);
        return faker.name().firstName();
    }

    /**
     * This function genarates random last name
     *
     * @return - Returns  random last name
     */
    public String getRandomLastName() {
        Faker faker = new Faker(Locale.CANADA);
        return faker.name().lastName();
    }

    /**
     * This function genarates random birth date
     *
     * @return - Returns  random birth date
     */
    public String getRandomBirthDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Faker faker = new Faker();
        return sdf.format(faker.date().birthday());
    }

    /**
     * This function genarates random phone number
     *
     * @return - Returns  random phone number
     */
    public String getRandomPhoneNumber() {
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }

    /**
     * This function genarates random postal code
     *
     * @return - Returns  random postal code
     */
    public String getRandomPostalCode() {
        Faker faker = new Faker(Locale.CANADA);
        return faker.address().zipCode();
    }

    /**
     * This function genarates random email
     *
     * @return - Returns  random email
     */
    public String getRandomEmail() {
        Faker faker = new Faker(Locale.CANADA);
        return faker.internet().emailAddress();
    }
}
