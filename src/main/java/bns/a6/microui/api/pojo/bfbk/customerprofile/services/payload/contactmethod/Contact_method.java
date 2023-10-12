/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 4:36 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod;

import java.util.List;


public class Contact_method {

    private List<Phone> phone;
    private List<Email> email;
    private String contact_title;
    private String contact_name;

    public List<Phone> getPhone() {
        return this.phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public List<Email> getEmail() {
        return this.email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public String getContact_title() {
        return this.contact_title;
    }

    public void setContact_title(String contact_title) {
        this.contact_title = contact_title;
    }

    public String getContact_name() {
        return this.contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }
}
