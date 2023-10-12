/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 1:46 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address_ {

    private String line_1_addr;
    private String line_2_addr;
    private String line_3_addr;
    private String city;
    private String state;
    private String postal_cd;
    private Address_type address_type;
    private Country_cd country_cd;
    private String verify_method;
    private String last_updated_dt;

}
