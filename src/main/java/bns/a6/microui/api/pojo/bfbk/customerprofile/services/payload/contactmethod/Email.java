/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 4:38 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod;


public class Email {

    private String email_type;

    private String email_address_text;

    public String getEmail_type() {
        return this.email_type;
    }

    public void setEmail_type(String email_type) {
        this.email_type = email_type;
    }

    public String getEmail_address_text() {
        return this.email_address_text;
    }

    public void setEmail_address_text(String email_address_text) {
        this.email_address_text = email_address_text;
    }
}
