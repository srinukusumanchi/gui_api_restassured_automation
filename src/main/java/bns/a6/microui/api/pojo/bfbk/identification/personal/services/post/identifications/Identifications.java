/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-04
 * Created Time: 2:08 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identifications;

public class Identifications {

    private String confirmed_date;
    private String country_of_issue;
    private String prov_state_of_issue;
    private String captured_date;
    private String identification_number;
    private String identification_type;
    private String expiry_date;
    private String place_of_birth;
    private String source_name;
    private String source_other_desc;
    private String source_method;
    private String parent_guardian_cid;
    private Identification_source identification_source;


    public String getConfirmed_date() {
        return confirmed_date;
    }

    public void setConfirmed_date(String confirmed_date) {
        this.confirmed_date = confirmed_date;
    }

    public String getCountry_of_issue() {
        return country_of_issue;
    }

    public void setCountry_of_issue(String country_of_issue) {
        this.country_of_issue = country_of_issue;
    }

    public String getProv_state_of_issue() {
        return prov_state_of_issue;
    }

    public void setProv_state_of_issue(String prov_state_of_issue) {
        this.prov_state_of_issue = prov_state_of_issue;
    }

    public String getCaptured_date() {
        return captured_date;
    }

    public void setCaptured_date(String captured_date) {
        this.captured_date = captured_date;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getIdentification_type() {
        return identification_type;
    }

    public void setIdentification_type(String identification_type) {
        this.identification_type = identification_type;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getSource_other_desc() {
        return source_other_desc;
    }

    public void setSource_other_desc(String source_other_desc) {
        this.source_other_desc = source_other_desc;
    }

    public String getSource_method() {
        return source_method;
    }

    public void setSource_method(String source_method) {
        this.source_method = source_method;
    }

    public String getParent_guardian_cid() {
        return parent_guardian_cid;
    }

    public void setParent_guardian_cid(String parent_guardian_cid) {
        this.parent_guardian_cid = parent_guardian_cid;
    }

    public Identification_source getIdentification_source() {
        return identification_source;
    }

    public void setIdentification_source(Identification_source identification_source) {
        this.identification_source = identification_source;
    }
}
