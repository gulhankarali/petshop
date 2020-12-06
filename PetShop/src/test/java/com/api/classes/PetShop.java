package com.api.classes;

import com.api.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.RestAssured.given;

public class PetShop {

    long id;
    String name;
    String status;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = ConfigurationReader.get("petshop.uri");
    }



    public void JsonSchemaValidation() {
        given().accept(ContentType.JSON).
                queryParam("status", "sold").
                when().get("/pet/findByStatus").then().
                assertThat().statusCode(200).body(matchesJsonSchemaInClasspath("JsonSchemaModel"));
    }


    public void deleteOrder(){

        Response response = given().accept(ContentType.JSON).and().
                pathParam("orderId", 1).when().
                delete("/store/order/{orderId}");

        assertEquals(response.contentType(), "application/json");
        System.out.println(response.statusCode());

    }


    public void getInventories(){
        Response response = given().accept(ContentType.JSON).
                when().get("store/inventory");

        response.prettyPeek();
        assertEquals(response.contentType(), "application/json");
        System.out.println(response.statusCode());

    }

    @Test
    public void userLogin(){
        Response response = given().accept(ContentType.JSON).queryParam("username", "fatmakarali").
                queryParam("password", "$£££R%£").
                 when().get("/user/login");
        response.prettyPeek();
        assertEquals(response.contentType(), "application/json");
        System.out.println(response.statusCode());


    }

    public void userLogout(){
        Response response = given().accept(ContentType.JSON).
                when().get("/user/logout");
        response.prettyPeek();
        assertEquals(response.contentType(), "application/json");
        System.out.println(response.statusCode());

    }

    
    public void userDelete(){
        Response response = given().accept(ContentType.JSON).
                pathParam("username", "fatmakarali").
                when().delete("/user/{username}");
        response.prettyPeek();
        assertEquals(response.contentType(), "application/json");
        System.out.println(response.statusCode());

    }

    public void createUserArray(){

        List<Map<String, Object>> userList = new ArrayList<>();
        List<User> usersList = new ArrayList<>();

        User user = new User(1,"gulhankarali","Gulhan", "Karali", "email@gmail.com","aaazzaa", "07893123456", 1);
        usersList.add(user);

        user = new User(2,"fatmakarali","Fatma", "Karali", "email@gmail.com","aaazzaa", "07893123456", 1);
        usersList.add(user);

//        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put("id", 0);
//        linkedHashMap.put("username", "gulhankarali");
//        linkedHashMap.put("firstName", "Gulhan");
//        linkedHashMap.put("lastName", "Karali Balci");
//        linkedHashMap.put("email", "email@gmail.com");
//        linkedHashMap.put("password", "$£££R%£");
//        linkedHashMap.put("phone", "07234980789");
//        linkedHashMap.put("userStatus", 1);
//        userList.add(linkedHashMap);


        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).
                body(usersList).when().post("/user/createWithArray");

        assertEquals(response.contentType(), "application/json");
        System.out.println(response.statusCode());

    }

    public void getByOrderId(){
        Response response = given().accept(ContentType.JSON).and().pathParam("orderId", 1).
                when().get("/store/order/{orderId}");

        response.prettyPrint();
        assertEquals(response.contentType(), "application/json");
        System.out.println(response.statusCode());


    }


    public void updatePet(){
        Pet pet = new Pet();
        pet = CreatePet.createPet(pet);

        Response response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON).
                body(pet).when().put("/pet");

        assertEquals(response.contentType(), "application/json");
        System.out.println(response.statusCode());


    }

    public void addNewPat(){


        Pet pet = new Pet();
        pet = CreatePet.createPet(pet);

        String bodyString = "{  \"id\": 0,  \"category\": {    \"id\": 0,    \"name\": \"string\"  },  \"name\": \"perma\",  \"photoUrls\": [    \"string\"  ],  \"tags\": [    {      \"id\": 0,      \"name\": \"string\"    }  ],  \"status\": \"available\"}";

        Response response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON).
                body(pet).when().post("/pet");

        assertEquals(response.contentType(), "application/json");
        System.out.println(response.statusCode());

    }

    public void bringAllSold(){

        Response response = given().accept(ContentType.JSON).
                queryParam("status", "sold").when().
                get("/pet/findByStatus");

        response.prettyPrint();
        List<LinkedHashMap<String,Object>> petList = response.body().as(List.class);

        List<String> names = new ArrayList<>();
        for (LinkedHashMap<String, Object> linkedHashMap: petList)
        {
            names.add((String)linkedHashMap.get("name"));
        }
        System.out.println(names);

        System.out.println("petListSize = " + petList.size());


    }


    public void bringAllPending(){

        Response  response = given().accept(ContentType.JSON).and().
                queryParam("status", "pending").
                when().get("/pet/findByStatus");

        //queryParam("q", "{\"region_id\":2}").
         assertEquals(response.contentType(), "application/json");
        assertEquals(response.statusCode(), 200);

        response.body().prettyPrint();

        List<Map<String, Object>> objectList = response.body().as(List.class);

        for (Map<String, Object> map:objectList)
        {
            System.out.println(map.get("id"));
            System.out.println(map.get("name"));
            System.out.println(map.get("status"));
            System.out.println(map.get("category"));
            System.out.println(map.get("tag"));
        }

        System.out.println("objectList.size() = " + objectList.size());

    }


    public void uploadImage(){

        RestAssured.baseURI = ConfigurationReader.get("petshop.uri");
        Category category = new Category();
        Tag tag = new Tag();
        List<Tag> tagList = new ArrayList<>();

        Pet pet = new Pet();
        pet.setId(9222968140491043506L);
        pet.setStatus("sold");
        pet.setName("karaoglan");
        pet.setCategory(category);
        pet.setTags(tagList);

        File fileUpload = new File("temp.png");

        Response response = given().accept(ContentType.JSON).and().
                multiPart(fileUpload).when().pathParam("petId", 922296814).
                and().post("/pet/{petId}/uploadImage");

        assertEquals(response.contentType(), "application/json");
        assertEquals(response.statusCode(),200);

    }



    public void postPet(){

        RestAssured.baseURI = ConfigurationReader.get("petshop.uri");

        Pet pet = new Pet();
        pet.setId(9222968140491043506L);
        pet.setStatus("sold");
        pet.setName("karaoglan");


        String postData = "{\n" +
                "  \"name\": \"karaoglan\",\n" +
                "  \"status\": \"sold\",\n" +
                "}";

        Response response = given().accept(ContentType.JSON).when().
                formParam("name","karaoglan").and().
                formParam("status", "sold").
                pathParam("petId", 9222968140491043506L).
                and().post("/pet/{petId}");

        assertEquals(response.contentType(), "application/json");
        assertEquals(response.statusCode(),200);

    }

    public void getByPetId() {

        Response response = given().accept(ContentType.JSON).and().
                pathParam("petId", 9222968140491043506L).
                when().get("/pet/{petId}");

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(),"application/json");

        response.body().prettyPrint();

        id = response.body().path("id");
        name = response.body().path("name");
        status = response.body().path("status");

        System.out.println(id);
        System.out.println(name);
        System.out.println(status);

    }


    public void getStoreOrderId(){
        Response response = given().accept(ContentType.JSON).and().
                pathParam("orderId",1).
                when().get("/store/order/{orderId}");

        assertEquals(response.contentType(), "application/json");
        assertEquals(response.statusCode(), 200);

        boolean isComplete = response.body().path("complete");
        int orderId = response.body().path("id");
        int petId = response.body().path("petId");
        int quantity = response.body().path("quantity");
        String shipDate  = response.body().path("shipDate");
        String status = response.body().path("status");

        System.out.println("shipDate = " + shipDate);
        System.out.println("quantity = " + quantity);
        System.out.println("petId = " + petId);
        System.out.println("orderId = " + orderId);
        System.out.println("isComplete = " + isComplete);
        System.out.println("status = " + status);
    }
}