/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-03-08
 * Created Time: 4:52 p.m.
 */

package bns.a6.microui.api.pojo.test;

import bns.a6.microui.web.utility.database.TestDataDB;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Test {
static String bearercode = "eyJ0eXAiOiJKV1QiLCJraWQiOiJpdVhRQ2FvKzM5RmF1M3ZJdTR4eDlJRTZJNHc9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiI5ZTNiZGNkYi05ZTQ5LTQ3OWUtYmIxNy1jYzQxMTAwMWE1NWIiLCJjdHMiOiJPQVVUSDJfU1RBVEVMRVNTX0dSQU5UIiwiYXVkaXRUcmFja2luZ0lkIjoiYjAxZWE1ZGEtNDBiYi00NzdlLTlhMDctNjA1ODY2MjQxMDNkLTU1NDAwNyIsInN1Ym5hbWUiOiI5ZTNiZGNkYi05ZTQ5LTQ3OWUtYmIxNy1jYzQxMTAwMWE1NWIiLCJpc3MiOiJodHRwczovL3dhbS11YXQuY2xvdWQuYm5zOjQ0My9zc28vb2F1dGgyL2FwaSIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6Im1BM0lXdVRjVXd3QlNlcExMdFZNRFhIOG5ldyIsImF1ZCI6IjllM2JkY2RiLTllNDktNDc5ZS1iYjE3LWNjNDExMDAxYTU1YiIsIm5iZiI6MTY3ODQ3MjIyNSwiZ3JhbnRfdHlwZSI6ImNsaWVudF9jcmVkZW50aWFscyIsInNjb3BlIjpbImN1c3RvbWVycy5jdXN0b21lcnByb2ZpbGVzLmNidGN1c3QuY3VzdG9tZXJwcm9maWxlcmVxdWVzdC5hbGwiXSwiYXV0aF90aW1lIjoxNjc4NDcyMjI1LCJyZWFsbSI6Ii9pbnRlcm5hbHMycyIsImV4cCI6MTY3ODQ3NTgyNSwiaWF0IjoxNjc4NDcyMjI1LCJleHBpcmVzX2luIjozNjAwLCJqdGkiOiJRVV9sMVp0OUlfMDJULXo4UVBpSEZJcC14SzgifQ.ME7Pm-cb7ZZfl1HDzJe49Z9PcCu7l2QYUDWmvaRHk35ammUIxdY24CaL7l_O45hoPuzV7P2fiqnceyCmF_AzejTijfdWxwAZE0QgdHM-lGxf65T9ILOHl39A-8gYG-jLeTdMBxHnoTWzJVmtarvvftxKOG4kKcvdTZt7FMFh0HuogMrJqid5jntbbslyZxHbtq_vkEa6TIvlwdHLrE77Zfg4pp7CG6uPmvKwJGIYmSdUYCpuVqPCY3sSD7uzfBZOmLCBdIjpejlCLuGk8_iEkcz7WOWp4lZNkNnUY_i-E4RQaZj32YBak3-93D1uYeLN19vZjVAa-ZXDvT4DA9kpkw";

    public static void main(String[] args) {
        TestDataDB testDataDB = new TestDataDB();
//        ResultSet resultSet = testDataDB.getData("SELECT * FROM a6_uplift_tdm.personal_api where ScenarioId in('Update personal customer contact method380',\n" +
//                "'Update personal customer contact method381',\n" +
//                "'Update personal customer contact method382',\n" +
//                "'Update personal customer contact method383',\n" +
//                "'Update personal customer contact method384',\n" +
//                "'Update personal customer contact method385',\n" +
//                "'Update personal customer contact method386',\n" +
//                "'Update personal customer contact method387',\n" +
//                "'Update personal customer contact method388',\n" +
//                "'Update personal customer contact method389',\n" +
//                "'Update personal customer contact method390',\n" +
//                "'Update personal customer contact method391',\n" +
//                "'Update personal customer contact method392',\n" +
//                "'Update personal customer contact method393',\n" +
//                "'Update personal customer contact method394',\n" +
//                "'Update personal customer contact method395',\n" +
//                "'Update personal customer contact method396',\n" +
//                "'Update personal customer contact method397',\n" +
//                "'Update personal customer contact method398',\n" +
//                "'Update personal customer contact method399',\n" +
//                "'Update personal customer contact method400',\n" +
//                "'Update personal customer contact method401',\n" +
//                "'Update personal customer contact method402',\n" +
//                "'Update personal customer contact method403',\n" +
//                "'Update personal customer contact method404',\n" +
//                "'Update personal customer contact method405',\n" +
//                "'Update personal customer contact method406',\n" +
//                "'Update personal customer contact method407',\n" +
//                "'Update personal customer contact method408',\n" +
//                "'Update personal customer contact method409',\n" +
//                "'Update personal customer contact method410',\n" +
//                "'Update personal customer contact method411',\n" +
//                "'Update personal customer contact method412',\n" +
//                "'Update personal customer contact method413',\n" +
//                "'Update personal customer contact method414',\n" +
//                "'Update personal customer contact method415',\n" +
//                "'Update personal customer contact method416',\n" +
//                "'Update personal customer contact method417',\n" +
//                "'Update personal customer contact method418',\n" +
//                "'Update personal customer contact method419',\n" +
//                "'Update personal customer contact method420',\n" +
//                "'Update personal customer contact method421',\n" +
//                "'Update personal customer contact method422',\n" +
//                "'Update personal customer contact method423',\n" +
//                "'Update personal customer contact method424')");
        String[] cids = {"995130000019343", "013071140635095", "009124141539638", "002144132702907", "011137110314230", "012105085039109", "012105103548235", "012136023630157", "011255093740202"};
//        while (resultSet.next()) {
        for(String cid : cids){
//            String cid = resultSet.getString("customer_key");
//            String scenarioId = resultSet.getString("ScenarioId");
            /*Response r = given()
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJraWQiOiJpdVhRQ2FvKzM5RmF1M3ZJdTR4eDlJRTZJNHc9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiI5ZTNiZGNkYi05ZTQ5LTQ3OWUtYmIxNy1jYzQxMTAwMWE1NWIiLCJjdHMiOiJPQVVUSDJfU1RBVEVMRVNTX0dSQU5UIiwiYXVkaXRUcmFja2luZ0lkIjoiMmZkOGJkMDAtMjA2MS00ZGEwLWE1ZWMtMmZkZWQxYmMxOGI2LTc4NDc0NCIsInN1Ym5hbWUiOiI5ZTNiZGNkYi05ZTQ5LTQ3OWUtYmIxNy1jYzQxMTAwMWE1NWIiLCJpc3MiOiJodHRwczovL3dhbS11YXQuY2xvdWQuYm5zOjQ0My9zc28vb2F1dGgyL2FwaSIsInRva2VuTmFtZSI6ImFjY2Vzc190b2tlbiIsInRva2VuX3R5cGUiOiJCZWFyZXIiLCJhdXRoR3JhbnRJZCI6IlZJSkhVbTNFcl9QLXU1MldreDdnOXhwaE4wcyIsImF1ZCI6IjllM2JkY2RiLTllNDktNDc5ZS1iYjE3LWNjNDExMDAxYTU1YiIsIm5iZiI6MTY3ODMxMzI1OCwiZ3JhbnRfdHlwZSI6ImNsaWVudF9jcmVkZW50aWFscyIsInNjb3BlIjpbImN1c3RvbWVycy5jdXN0b21lcnByb2ZpbGVzLmNidGN1c3QuY3VzdG9tZXJwcm9maWxlcmVxdWVzdC5hbGwiXSwiYXV0aF90aW1lIjoxNjc4MzEzMjU4LCJyZWFsbSI6Ii9pbnRlcm5hbHMycyIsImV4cCI6MTY3ODMxNjg1OCwiaWF0IjoxNjc4MzEzMjU4LCJleHBpcmVzX2luIjozNjAwLCJqdGkiOiJuU3Y3cFF5ZTVYd05mWHpmME9YYThmNDJ6WmMifQ.HK97NOXR1FV89tU7BjI4CLNa8TT9SKJuT0utRbIaDghawT4PgbwJhU2Pe7JQ_tAhNV6VOqkn3MGh5YMjr-EmIc_qsbfwpd33lpnRx4KArE0ZKt-mxl10BXVC5DYqDYYKST2mpqhCJyKIcc3vIWhQs1Lqd34NP5XC9ESdFO3HoRjfbs1gUwvcyrwnWU5N8PqvEZG5f6aeqMROgO48x-tw0BGK3jxynVGuU_N1fsa2qYTOVhJXvYmY1ABwKrR7g4ogCrXJrwtG7VzvcYHNbt3D_tjWAav9qEQxJ1RzULP8JWpTAJf-hjwQDDgRBWOxwrvHhQRZOrlHH0Qna0kjdSQZ_Q")
                    .body("{\"customer_key\" : \""+cid+"\"}")
                    .post("https://customer-profile-services-uat.apps.stg.azr-use2-pcf.cloud.bns/api/v1/customers/get");*/

            try {
                Response r = given().header("authorization", "Bearer "+bearercode)
                        .header("x-channel-id", "BRANCH")
                        .header("x-user-context", "[{\"sub-channel\":\"MOB\"},{\"officer-id\": \"3103196\"},{\"transit-id\": \"80010\"},{\"teller-num\": \"\"}]")
                        .header("x-country-code", "CA")
                        .header("x-originating-appl-code", "H7")
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .and()
                        .body("{\"customer_key\" : \"" + cid + "\"}")
                        .when()
                        .post("https://customer-profile-services-uat.apps.stg.azr-use2-pcf.cloud.bns/api/v1/customers/get");
                System.out.println(r.getStatusLine());
                System.out.println(r.asString());
                JsonPath jsonPath = new JsonPath(r.asString());
                String customerType = jsonPath.getString("data.customer_basic_information.customer_type_cd");
                if(customerType.equals("O")){
                    updateNonPersonalCustomer(cid);
                }else if(customerType.equals("P")){
                    updatePersonalCustomer(cid);
                }else{
                    System.err.println("Error CID- "+cid);
                }
//                testDataDB.updateData("UPDATE a6_uplift_tdm.personal_api SET customer_type_cd='" + customerType + "' where ScenarioId='" + scenarioId + "'");
            } catch (Exception e) {
                System.err.println("Error CID- "+cid);
            }

        }


    }


    public static void updatePersonalCustomer(String cid) {
        Response r = given().header("authorization", "Bearer " + bearercode)
                .header("x-channel-id", "BRANCH")
                .header("x-user-context", "[{\"sub-channel\":\"MOB\"},{\"officer-id\": \"3103196\"},{\"transit-id\": \"80010\"},{\"teller-num\": \"\"}]")
                .header("x-country-code", "CA")
                .header("x-originating-appl-code", "H7")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and()
                .body("{\n" +
                        "    \"customer_basic_information\": {\n" +
                            "        \"customer_key\": \"" + cid + "\",\n" +
                            "        \"customer_type_cd\": \"P\",\n" +
                            "        \"profile_type\": \"CUS\",\n" +
                            "        \"customer_status_cd\": \"OP\",\n" +
                            "        \"sensitivity_type_cd\": \"0000\",\n" +
                            "        \"primary_branch_transit_no\": \"00042\",\n" +
                            "        \"preferred_language_cd\": \"en\",\n" +
                            "        \"onboard_date\": \"\",\n" +
                            "        \"offboard_date\": \"\",\n" +
                            "        \"last_updated_dt\": \"\",\n" +
                            "        \"kyc_refreshed_date\": \"2021-01-01\",\n" +
                            "        \"source\": \"RO\",\n" +
                            "        \"relationship_value_indicator\": \"\",\n" +
                            "        \"relationship_pricing_indicator\": \"\",\n" +
                            "        \"vip\": false,\n" +
                            "        \"individual\": {\n" +
                            "            \"full_name\": \"MR SRINIVAS V\",\n" +
                            "            \"title_name\": \"M\",\n" +
                            "            \"first_given_name\": \"SRINIVAS\",\n" +
                            "            \"first_last_name\": \"V\",\n" +
                            "            \"initials_text\": \"\",\n" +
                            "            \"third_given_name\": \"\",\n" +
                            "            \"suffix_name\": \"\",\n" +
                            "            \"birth_date\": \"1990-08-17\",\n" +
                            "            \"sex_type\": \"Male\",\n" +
                            "            \"marital_status\": \"Unknown\",\n" +
                            "            \"bankruptcy_date\": \"\",\n" +
                            "            \"deceased_date\": \"\",\n" +
                            "            \"employee_ind\": false,\n" +
                            "            \"sin\": \"789596319\",\n" +
                            "            \"sin_expiry_date\": \"\",\n" +
                            "            \"kyc_trigger_event_id\": \"001\",\n" +
                            "            \"number_of_dependants\": 0,\n" +
                            "            \"customer_residence_status\": \"\",\n" +
                            "            \"current_address_start_date\": \"2022-02-01\"\n" +
                            "        }\n" +
                            "    },\n" +
                            "    \"address\": [\n" +
                            "        {\n" +
                            "            \"address_key\": \"DMCL\",\n" +
                            "            \"address\": {\n" +
                            "                \"line_1_addr\": \"65-54201 RGE RD 265\",\n" +
                            "                \"line_2_addr\": \"\",\n" +
                            "                \"line_3_addr\": \"\",\n" +
                            "                \"city\": \"STURGE COUNTY\",\n" +
                            "                \"state\": \"CA-AB\",\n" +
                            "                \"postal_cd\": \"T8T0E2\",\n" +
                            "                \"address_type\": {\n" +
                            "                    \"code\": \"DMCL\"\n" +
                            "                },\n" +
                            "                \"country_cd\": {\n" +
                            "                    \"code\": \"CA\",\n" +
                            "                    \"description\": \"Verify the Customer update is sucessful via Customer profile API then inquire using customer profile api and verify the customer details in BGX4.\"\n" +
                            "                },\n" +
                            "                \"verify_method\": \"CA|CP|B|1688576\",\n" +
                            "                \"last_updated_dt\": \"\"\n" +
                            "            }\n" +
                            "        }\n" +
                            "    ],\n" +
                            "    \"contact_method\": {\n" +
                            "        \"phone\": [\n" +
                            "            {\n" +
                            "                \"contact_type_cd\": \"HomePhone\",\n" +
                            "                \"phone_no\": \"6476653419\",\n" +
                            "                \"phone_extension_no\": \"\",\n" +
                            "                \"full_telephone_no\": \"\"\n" +
                            "            }\n" +
                            "        ],\n" +
                            "        \"email\": [\n" +
                            "            {\n" +
                            "                \"email_type\": \"\",\n" +
                            "                \"email_address_text\": \"\"\n" +
                            "            }\n" +
                            "        ],\n" +
                            "        \"contact_title\": \"\",\n" +
                            "        \"contact_name\": \"\"\n" +
                            "    }\n" +
                            "}")
                    .when()
                    .put("https://customer-profile-services-uat.apps.stg.azr-use2-pcf.cloud.bns/api/v1/customers");
        if(r.getStatusCode()==204){

        }else{
            System.err.println("Response code is "+r.getStatusCode()==204+" cid- "+cid);
        }
        }


        public static void updateNonPersonalCustomer(String cid){
            Response r = given().header("authorization", "Bearer "+bearercode)
                        .header("x-channel-id", "BRANCH")
                        .header("x-user-context", "[{\"sub-channel\":\"MOB\"},{\"officer-id\": \"3103196\"},{\"transit-id\": \"80010\"},{\"teller-num\": \"\"}]")
                        .header("x-country-code", "CA")
                        .header("x-originating-appl-code", "H7")
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .and()
                        .body("{\n" +
                                "    \"customer_basic_information\": {\n" +
                                "        \"customer_key\": \"" + cid + "\",\n" +
                                "        \"customer_type_cd\": \"O\",\n" +
                                "        \"profile_type\": \"CUS\",\n" +
                                "        \"customer_status_cd\": \"PR\",\n" +
                                "        \"sensitivity_type_cd\": \"0000\",\n" +
                                "        \"primary_branch_transit_no\": \"47696\",\n" +
                                "        \"preferred_language_cd\": \"en\",\n" +
                                "        \"institution\": {\n" +
                                "            \"legal_name\": \"*APPLE NEGONE ADDRSS 20140130\",\n" +
                                "            \"business_name\": \"BUSINESS LEGAL22\",\n" +
                                "            \"institution_type\": \"COMAB\",\n" +
                                "            \"standard_industrial_cd\": {\n" +
                                "                \"code\": \"7795\"\n" +
                                "            },\n" +
                                "            \"naics_cd\": {},\n" +
                                "            \"annual_sale_amt\": {\n" +
                                "                \"currency_cd\": \"CAD\",\n" +
                                "                \"amount\": 1500000\n" +
                                "            },\n" +
                                "            \"annual_sales_availability\": \"Available\",\n" +
                                "            \"annual_sales_effective_date\": \"2007-02-01\",\n" +
                                "            \"constituted_date\": \"2000-12-01\",\n" +
                                "            \"total_employee_cnt\": 50,\n" +
                                "            \"number_of_employees_availability\": \"Available\",\n" +
                                "            \"association_affiliation_cd\": [],\n" +
                                "           \"account_holders\": [\n" +
                                "                {\n" +
                                "                    \"key\": 1,\n" +
                                "                    \"first_name\": \"firstName1\",\n" +
                                "                    \"initial\": \"lk\",\n" +
                                "                    \"last_name\": \"lastName1\"\n" +
                                "                }\n" +
                                "            ]            \n" +
                                "        }\n" +
                                "    },\n" +
                                "    \"address\": [\n" +
                                "        {\n" +
                                "            \"address_key\": \"BA\",\n" +
                                "            \"address\": {\n" +
                                "                \"address_type\": {\n" +
                                "                    \"code\": \"BA\"\n" +
                                "                },\n" +
                                "                \"line_1_addr\": \"BLOCK 25\",\n" +
                                "                \"line_2_addr\": \"FLAT 406\",\n" +
                                "                \"city\": \"TORONTO\",\n" +
                                "                \"state\": \"CA-ON\",\n" +
                                "                \"postal_cd\": \"M1M2M3\",\n" +
                                "                \"country_cd\": {\n" +
                                "                    \"code\": \"CA\"\n" +
                                "                }\n" +
                                "            }\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"address_key\": \"BusMail\",\n" +
                                "            \"address\": {\n" +
                                "                \"address_type\": {\n" +
                                "                    \"code\": \"BusMail\"\n" +
                                "                },\n" +
                                "                \"line_1_addr\": \"9999 YONGE ST 123458\",\n" +
                                "                \"line_2_addr\": \"LINE 99\",\n" +
                                "                \"city\": \"TORONTO\",\n" +
                                "                \"state\": \"CA-ON\",\n" +
                                "                \"postal_cd\": \"L2L2L2\",\n" +
                                "                \"country_cd\": {\n" +
                                "                    \"code\": \"CA\"\n" +
                                "                }\n" +
                                "            }\n" +
                                "        }\n" +
                                "    ],\n" +
                                "    \"contact_method\": {\n" +
                                "        \"phone\": [\n" +
                                "            {\n" +
                                "                \"contact_type_cd\": \"BusCtPhone\",\n" +
                                "                \"phone_no\": \"4165432345\",\n" +
                                "                \"phone_extension_no\": null,\n" +
                                "                \"full_telephone_no\": \"4165432345\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"contact_type_cd\": \"NPBusPhone\",\n" +
                                "                \"phone_no\": \"4167865432\",\n" +
                                "                \"phone_extension_no\": null,\n" +
                                "                \"full_telephone_no\": \"4167865432\"\n" +
                                "            },\n" +
                                "            {\n" +
                                "                \"contact_type_cd\": \"BusFax\",\n" +
                                "                \"phone_no\": \"4167865432\",\n" +
                                "                \"phone_extension_no\": null,\n" +
                                "                \"full_telephone_no\": \"4167865432\"\n" +
                                "            }\n" +
                                "        ],\n" +
                                "        \"email\": [\n" +
                                "            {\n" +
                                "                \"email_type\": \"GenEmail\",\n" +
                                "                \"email_address_text\": \"outsidecontact@gmail.com\"\n" +
                                "            }\n" +
                                "        ],\n" +
                                "        \"contact_title\": \"MR\",\n" +
                                "        \"contact_name\": \"TEST\"\n" +
                                "    }\n" +
                                "}")
                        .when()
                        .put("https://customer-profile-services-uat.apps.stg.azr-use2-pcf.cloud.bns/api/v1/customers");
                if(r.getStatusCode()==204){

                }else{
                    System.err.println("Response code is "+r.getStatusCode()==204+" cid- "+cid);
                }
            }



        }


