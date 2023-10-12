/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 6:25 p.m.
 */

package bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.address;

public class Address {

    private String address_type_cd;
    private String line_1_addr;
    private String line_2_addr;
    private String city;
    private String state;
    private String postal_cd;
    private String country_cd;

    public String getAddress_type_cd() {
        return address_type_cd;
    }

    public void setAddress_type_cd(String address_type_cd) {
        this.address_type_cd = address_type_cd;
    }

    public String getLine_1_addr() {
        return line_1_addr;
    }

    public void setLine_1_addr(String line_1_addr) {
        this.line_1_addr = line_1_addr;
    }

    public String getLine_2_addr() {
        return line_2_addr;
    }

    public void setLine_2_addr(String line_2_addr) {
        this.line_2_addr = line_2_addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_cd() {
        return postal_cd;
    }

    public void setPostal_cd(String postal_cd) {
        this.postal_cd = postal_cd;
    }

    public String getCountry_cd() {
        return country_cd;
    }

    public void setCountry_cd(String country_cd) {
        this.country_cd = country_cd;
    }


}
