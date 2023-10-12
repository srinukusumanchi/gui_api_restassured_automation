/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-26
 * Created Time: 4:17 p.m.
 */

package bns.a6.microui.api.pojo.bfqj.accountprofile.services.put.address;

import bns.a6.microui.api.pojo.bfqj.accountprofile.services.put.countrycode.Country_cd;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String state;
    private String city;
    private String line_1_addr;
    private String line_2_addr;
    private String postal_cd;

    private Country_cd country_cd;

}
