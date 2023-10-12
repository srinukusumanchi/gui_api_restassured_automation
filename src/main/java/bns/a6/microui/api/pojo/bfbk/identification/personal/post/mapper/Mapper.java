/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-04
 * Created Time: 4:03 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.identification.personal.post.mapper;

import bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identificationinfo.Identification_info;

public class Mapper {

    private String customer_id;
    private Identification_info identification_info;


    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public Identification_info getIdentification_info() {
        return identification_info;
    }

    public void setIdentification_info(Identification_info identification_info) {
        this.identification_info = identification_info;
    }

}
