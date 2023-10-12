/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-27
 * Created Time: 11:04 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.data;

import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Address;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Contact_method;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.customerbasicinformation.Customer_basic_information;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data {
    private Customer_basic_information customer_basic_information;
    private List<Address> address;
    private Contact_method contact_method;
    private Notifications notifications;

}
