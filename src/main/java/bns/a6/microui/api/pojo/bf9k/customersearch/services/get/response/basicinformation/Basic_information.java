/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 1:27 p.m.
 */

package bns.a6.microui.api.pojo.bf9k.customersearch.services.get.response.basicinformation;


import lombok.Getter;

import java.util.List;

@Getter
public class Basic_information {

    private String customer_key;
    private String customer_type;
    private String customer_status;
    private String profile_type;
    private String sensitivity_cd;
    private String external_customer_id;
    private Individual individual;
    private List<Address_list> address_list;


}
