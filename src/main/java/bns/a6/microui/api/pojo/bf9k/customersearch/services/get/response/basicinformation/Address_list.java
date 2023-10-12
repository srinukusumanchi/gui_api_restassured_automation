/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-24
 * Created Time: 8:55 p.m.
 */

package bns.a6.microui.api.pojo.bf9k.customersearch.services.get.response.basicinformation;

import lombok.Getter;

@Getter
public class Address_list {
    private String address_type_cd;
    private String line_1_addr;
    private String line_2_addr;
    private String line_3_addr;
    private String city;
    private String state;
    private String postal_cd;
    private String country_cd;
}
