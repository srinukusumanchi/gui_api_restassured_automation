/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-12
 * Created Time: 1:39 p.m.
 */

package service.requests.bfbk.employment.update;

import bns.a6.microui.api.pojo.bfbk.employment.mapper.put.Mapper;
import bns.a6.microui.api.pojo.bfbk.employment.services.post.*;
import bns.a6.microui.api.pojo.bfbk.employment.utility.Employment;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmploymentUpdate {


    //     *********************************** Employment ******************************************
    public String generateEmploymentUpdateRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //        Employments block
        Employments employment = new Employments();
        employment.setOccupation_cd(resultset.getString("occupation_cd"));
        employment.setOccupation_industry_cd(resultset.getString("occupation_industry_cd"));
        employment.setOccupation_status(resultset.getString("occupation_status"));
        employment.setOccupation_duration(resultset.getString("occupation_duration"));
        employment.setEmployer_name(resultset.getString("employer_name"));
        employment.setStart_date(resultset.getString("start_date"));
        employment.setLength_of_employment(resultset.getString("length_of_employment"));
        employment.setPhone_no(resultset.getString("phone_no"));
        employment.setOther_income_source(resultset.getString("other_income_source"));

        //        Employment_address block
        Employment_address employment_address = new Employment_address();
        employment_address.setLine_1_addr(resultset.getString("line_1_addr"));
        employment_address.setLine_2_addr(resultset.getString("line_2_addr"));
        employment_address.setCity(resultset.getString("city"));
        employment_address.setState(resultset.getString("state"));
        employment_address.setPostal_cd(resultset.getString("postal_cd"));


        //        Country block
        Country_cd country_cd = new Country_cd();
        country_cd.setCode(resultset.getString("code"));

        //        others_income_amt block
        Others_income_amt others_income_amt = new Others_income_amt();
        others_income_amt.setCurrency_cd(resultset.getString("currency_cd_others_income_amt"));
        others_income_amt.setAmount(Double.valueOf(resultset.getString("amount_others_income_amt")));

        //        gross_monthy_income_amt block
        Gross_monthy_income_amt gross_monthy_income_amt = new Gross_monthy_income_amt();
        gross_monthy_income_amt.setCurrency_cd(resultset.getString("currency_cd_gross_monthy_income_amt"));
        gross_monthy_income_amt.setAmount(Double.valueOf(resultset.getString("amount_gross_monthy_income_amt")));

//        Grouping child blocks with parent blocks
        employment_address.setCountry_cd(country_cd);
        employment.setEmployment_address(employment_address);
        employment.setOthers_income_amt(others_income_amt);
        employment.setGross_monthy_income_amt(gross_monthy_income_amt);

        Mapper mapper = new Mapper();
        mapper.setCustomer_id(resultset.getString("customer_id"));
        mapper.setEmployments(employment);

        Employment identification = new Employment();
        return identification.getEmploymentRequestUpdate(mapper);
    }
}
