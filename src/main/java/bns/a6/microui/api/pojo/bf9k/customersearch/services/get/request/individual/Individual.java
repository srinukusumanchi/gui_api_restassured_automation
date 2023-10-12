/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 5:45 p.m.
 */

package bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.individual;

public class Individual {

    private String title_name;
    private String first_given_name;
    private String first_last_name;
    private String full_name;
    private String birth_date;

    public String getFirst_given_name() {
        return first_given_name;
    }

    public void setFirst_given_name(String first_given_name) {
        this.first_given_name = first_given_name;
    }

    public String getFirst_last_name() {
        return first_last_name;
    }

    public void setFirst_last_name(String first_last_name) {
        this.first_last_name = first_last_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
