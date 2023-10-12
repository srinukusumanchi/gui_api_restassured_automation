/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-05
 * Created Time: 5:51 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.employment.services.post;


public class Employments {

    private String occupation_cd;

    private String occupation_industry_cd;

    private String occupation_status;

    private String occupation_duration;

    private String employer_name;

    private String start_date;

    private String length_of_employment;

    private Employment_address employment_address;

    private String phone_no;

    private String other_income_source;

    private Others_income_amt others_income_amt;

    private Gross_monthy_income_amt gross_monthy_income_amt;

    public void setOccupation_cd(String occupation_cd){
        this.occupation_cd = occupation_cd;
    }
    public String getOccupation_cd(){
        return this.occupation_cd;
    }
    public void setOccupation_industry_cd(String occupation_industry_cd){
        this.occupation_industry_cd = occupation_industry_cd;
    }
    public String getOccupation_industry_cd(){
        return this.occupation_industry_cd;
    }
    public void setOccupation_status(String occupation_status){
        this.occupation_status = occupation_status;
    }
    public String getOccupation_status(){
        return this.occupation_status;
    }
    public void setOccupation_duration(String occupation_duration){
        this.occupation_duration = occupation_duration;
    }
    public String getOccupation_duration(){
        return this.occupation_duration;
    }
    public void setEmployer_name(String employer_name){
        this.employer_name = employer_name;
    }
    public String getEmployer_name(){
        return this.employer_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setLength_of_employment(String length_of_employment){
        this.length_of_employment = length_of_employment;
    }
    public String getLength_of_employment(){
        return this.length_of_employment;
    }
    public void setEmployment_address(Employment_address employment_address){
        this.employment_address = employment_address;
    }
    public Employment_address getEmployment_address(){
        return this.employment_address;
    }
    public void setPhone_no(String phone_no){
        this.phone_no = phone_no;
    }
    public String getPhone_no(){
        return this.phone_no;
    }
    public void setOther_income_source(String other_income_source){
        this.other_income_source = other_income_source;
    }
    public String getOther_income_source(){
        return this.other_income_source;
    }
    public void setOthers_income_amt(Others_income_amt others_income_amt){
        this.others_income_amt = others_income_amt;
    }
    public Others_income_amt getOthers_income_amt(){
        return this.others_income_amt;
    }
    public void setGross_monthy_income_amt(Gross_monthy_income_amt gross_monthy_income_amt){
        this.gross_monthy_income_amt = gross_monthy_income_amt;
    }
    public Gross_monthy_income_amt getGross_monthy_income_amt(){
        return this.gross_monthy_income_amt;
    }
}
