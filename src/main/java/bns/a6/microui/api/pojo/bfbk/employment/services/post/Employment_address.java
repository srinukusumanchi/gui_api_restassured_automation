/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-05
 * Created Time: 2:31 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.employment.services.post;

public class Employment_address {

    private String line_1_addr;

    private String line_2_addr;

    private String city;

    private String state;

    private String postal_cd;

    private Country_cd country_cd;

    public void setLine_1_addr(String line_1_addr) {
        this.line_1_addr = line_1_addr;
    }

    public String getLine_1_addr() {
        return this.line_1_addr;
    }

    public void setLine_2_addr(String line_2_addr) {
        this.line_2_addr = line_2_addr;
    }

    public String getLine_2_addr() {
        return this.line_2_addr;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void setPostal_cd(String postal_cd) {
        this.postal_cd = postal_cd;
    }

    public String getPostal_cd() {
        return this.postal_cd;
    }

    public void setCountry_cd(Country_cd country_cd) {
        this.country_cd = country_cd;
    }

    public Country_cd getCountry_cd() {
        return this.country_cd;
    }
}
