/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-13
 * Created Time: 5:01 p.m.
 */

package service.requests.bfbk.employment.create;

import bns.a6.microui.api.pojo.bfbk.employment.mapper.post.Mapper;
import bns.a6.microui.api.pojo.bfbk.employment.services.post.*;
import bns.a6.microui.api.pojo.bfbk.employment.utility.Employment;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmploymentCreate {


    //     *********************************** Employment ******************************************
    public String generateEmploymentCreateRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //        Employments block
        List<Employments> employmentsList = new LinkedList<>();

        Employments employments = new Employments();
        employments.setOccupation_cd(resultset.getString("occupation_cd"));
        employments.setOccupation_industry_cd(resultset.getString("occupation_industry_cd"));
        employments.setOccupation_status(resultset.getString("occupation_status"));
        employments.setOccupation_duration(resultset.getString("occupation_duration"));
        employments.setEmployer_name(resultset.getString("employer_name"));
        employments.setStart_date(resultset.getString("start_date"));
        employments.setLength_of_employment(resultset.getString("length_of_employment"));
        employments.setPhone_no(resultset.getString("phone_no"));
        employments.setOther_income_source(resultset.getString("other_income_source"));

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
        employments.setEmployment_address(employment_address);
        employments.setOthers_income_amt(others_income_amt);
        employments.setGross_monthy_income_amt(gross_monthy_income_amt);
        employmentsList.add(employments);

        Mapper mapper = new Mapper();
        mapper.setCustomer_id(resultset.getString("customer_id"));
        mapper.setEmployments(employmentsList);

        Employment identification = new Employment();
        return identification.getEmploymentRequestCreate(mapper);
    }
}
