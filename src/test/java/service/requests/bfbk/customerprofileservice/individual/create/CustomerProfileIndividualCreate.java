/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-13
 * Created Time: 2:03 p.m.
 */

package service.requests.bfbk.customerprofileservice.individual.create;

import bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.post.Mapper;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Address;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Address_;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Address_type;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Country_cd;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Contact_method;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Email;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Phone;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.customerbasicinformation.Customer_basic_information;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.individual.Individual;
import bns.a6.microui.api.pojo.bfbk.customerprofile.utility.CustomerProfile;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CustomerProfileIndividualCreate {


    // Personal customer creation request body - Customer Profile
    public String generateCustomerCreateRequest(ResultSet resultset) throws SQLException, JsonProcessingException {

//        customer_basic_information block
        Customer_basic_information customer_basic_information = new Customer_basic_information();
        customer_basic_information.setCustomer_type_cd(resultset.getString("customer_type_cd"));
        customer_basic_information.setProfile_type(resultset.getString("profile_type"));
        customer_basic_information.setCustomer_status_cd(resultset.getString("customer_status_cd"));
        customer_basic_information.setSensitivity_type_cd(resultset.getString("sensitivity_type_cd"));
        customer_basic_information.setPrimary_branch_transit_no(resultset.getString("primary_branch_transit_no"));
        customer_basic_information.setPreferred_language_cd(resultset.getString("preferred_language_cd"));
        customer_basic_information.setOnboard_date(resultset.getString("onboard_date"));
        customer_basic_information.setOffboard_date(resultset.getString("offboard_date"));
        customer_basic_information.setLast_updated_dt(resultset.getString("last_updated_dt"));
        customer_basic_information.setKyc_refreshed_date(resultset.getString("kyc_refreshed_date"));
        customer_basic_information.setSource(resultset.getString("source"));
        customer_basic_information.setRelationship_value_indicator(resultset.getString("relationship_value_indicator"));
        customer_basic_information.setRelationship_pricing_indicator(resultset.getString("relationship_pricing_indicator"));
        customer_basic_information.setVip(Boolean.parseBoolean(resultset.getString("vip")));


        //   individual block
        Individual individual = new Individual();
        individual.setFull_name(resultset.getString("full_name"));
        individual.setTitle_name(resultset.getString("title_name"));
        individual.setFirst_given_name(resultset.getString("first_given_name"));
        individual.setFirst_last_name(resultset.getString("first_last_name"));
        individual.setInitials_text(resultset.getString("initials_text"));
        individual.setThird_given_name(resultset.getString("third_given_name"));
        individual.setSuffix_name(resultset.getString("suffix_name"));
        individual.setBirth_date(resultset.getString("birth_date"));
        individual.setSex_type(resultset.getString("sex_type"));
        individual.setMarital_status(resultset.getString("marital_status"));
        individual.setBankruptcy_date(resultset.getString("bankruptcy_date"));
        individual.setDeceased_date(resultset.getString("deceased_date"));
        individual.setEmployee_ind(Boolean.parseBoolean(resultset.getString("employee_ind")));
        individual.setSin(resultset.getString("sin"));
        individual.setSin_expiry_date(resultset.getString("sin_expiry_date"));
        individual.setKyc_trigger_event_id(resultset.getString("kyc_trigger_event_id"));
        individual.setNumber_of_dependants(Integer.parseInt(resultset.getString("number_of_dependants")));
        individual.setCustomer_residence_status(resultset.getString("customer_residence_status"));
        individual.setCurrent_address_start_date(resultset.getString("current_address_start_date"));

        customer_basic_information.setIndividual(individual);

//        address block
        Address addressDetail = new Address();
        addressDetail.setAddress_key(resultset.getString("address_key"));

        //     Inner block of  address block
        Address_ address = new Address_();
        Address_type addressType = new Address_type();
        addressType.setCode(resultset.getString("address_type"));
        address.setAddress_type(addressType);
        address.setLine_1_addr(resultset.getString("line_1_addr"));
        address.setLine_2_addr(resultset.getString("line_2_addr"));
        address.setLine_3_addr(resultset.getString("line_3_addr"));
        address.setCity(resultset.getString("city"));
        address.setState(resultset.getString("state"));
        address.setPostal_cd(resultset.getString("postal_cd"));
        address.setVerify_method(resultset.getString("verify_method"));
        address.setLast_updated_dt(resultset.getString("last_updated_dt"));

        //  Country code block
        Country_cd country_cd = new Country_cd();
        country_cd.setCode(resultset.getString("code"));
        country_cd.setDescription(resultset.getString("description"));

        address.setCountry_cd(country_cd);
        List<Address> addresses = new LinkedList<>();
        addressDetail.setAddress(address);
        addresses.add(addressDetail);

        //  Contact method block
        Contact_method contact_method = new Contact_method();


        Phone phone = new Phone();
        phone.setContact_type_cd(resultset.getString("contact_type_cd"));
        phone.setPhone_no(resultset.getString("phone_no"));
        phone.setPhone_extension_no(resultset.getString("phone_extension_no"));
        phone.setFull_telephone_no(resultset.getString("full_telephone_no"));

        List<Phone> phoneList = new LinkedList<>();
        phoneList.add(phone);

        Email email = new Email();
        email.setEmail_type(resultset.getString("email_type"));
        email.setEmail_address_text(resultset.getString("email_address_text"));

        List<Email> emailList = new LinkedList<>();
        emailList.add(email);

        contact_method.setContact_title(resultset.getString("contact_title"));
        contact_method.setContact_name(resultset.getString("contact_name"));

        contact_method.setPhone(phoneList);
        contact_method.setEmail(emailList);

        Mapper mapper = new Mapper();
        mapper.setCustomer_basic_information(customer_basic_information);
        mapper.setAddress(addresses);
        mapper.setContact_method(contact_method);

        CustomerProfile customerProfile = new CustomerProfile();
        return customerProfile.getCustomerProfileRequest(mapper);

    }

}
