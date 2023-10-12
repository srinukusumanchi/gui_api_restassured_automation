/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 12:49 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.post;


import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Address;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Contact_method;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.customerbasicinformation.Customer_basic_information;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Mapper {
    private Customer_basic_information customer_basic_information;
    private List<Address> address;
    private Contact_method contact_method;
    private String customer_key;
}
