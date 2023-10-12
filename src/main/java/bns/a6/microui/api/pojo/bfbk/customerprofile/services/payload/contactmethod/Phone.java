/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 4:39 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod;


public class Phone {

    private String contact_type_cd;

    private String phone_no;

    private String phone_extension_no;

    private String full_telephone_no;

    public String getContact_type_cd() {
        return this.contact_type_cd;
    }

    public void setContact_type_cd(String contact_type_cd) {
        this.contact_type_cd = contact_type_cd;
    }

    public String getPhone_no() {
        return this.phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPhone_extension_no() {
        return this.phone_extension_no;
    }

    public void setPhone_extension_no(String phone_extension_no) {
        this.phone_extension_no = phone_extension_no;
    }

    public String getFull_telephone_no() {
        return this.full_telephone_no;
    }

    public void setFull_telephone_no(String full_telephone_no) {
        this.full_telephone_no = full_telephone_no;
    }
}
