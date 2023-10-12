/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-27
 * Created Time: 2:21 p.m.
 */

package bns.a6.microui.api.pojo.bfqj.accountprofile.mapper.create;

import bns.a6.microui.api.pojo.bfqj.accountprofile.services.post.address.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mapper {

    private String account_number;
    private String account_title1;
    private String account_title2;
    private String product_type;
    private String sub_product_code;
    private Address address;


}
