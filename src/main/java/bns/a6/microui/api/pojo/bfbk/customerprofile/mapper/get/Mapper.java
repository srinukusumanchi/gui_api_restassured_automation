/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 12:49 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.get;


import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Address;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Contact_method;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.customerbasicinformation.Customer_basic_information;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.data.Data;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.data.Notifications;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class Mapper {
    private Data data;
    private List<Notifications> notifications;
    private Customer_basic_information customer_basic_information;
    private List<Address> address;
    private Contact_method contact_method;

}
