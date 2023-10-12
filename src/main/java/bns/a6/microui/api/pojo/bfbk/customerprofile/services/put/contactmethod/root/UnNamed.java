/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-03-04
 * Created Time: 3:27 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.services.put.contactmethod.root;

import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Contact_method;

import java.util.List;

public class UnNamed {
    private String customer_key;

    private String customer_type_cd;

    private List<Contact_method> contact_method;

    public String getCustomer_key() {
        return this.customer_key;
    }

    public void setCustomer_key(String customer_key) {
        this.customer_key = customer_key;
    }

    public String getCustomer_type_cd() {
        return this.customer_type_cd;
    }

    public void setCustomer_type_cd(String customer_type_cd) {
        this.customer_type_cd = customer_type_cd;
    }

    public List<Contact_method> getContact_method() {
        return this.contact_method;
    }

    public void setContact_method(List<Contact_method> contact_method) {
        this.contact_method = contact_method;
    }
}
