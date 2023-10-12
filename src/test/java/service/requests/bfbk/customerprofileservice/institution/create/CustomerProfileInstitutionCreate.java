/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-13
 * Created Time: 2:03 p.m.
 */

package service.requests.bfbk.customerprofileservice.institution.create;


import bns.a6.microui.api.pojo.bfbk.customerprofile.mapper.post.Mapper;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Address;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Address_;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Address_type;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.addressdetail.Country_cd;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Contact_method;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Email;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Phone;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.customerbasicinformation.Customer_basic_information;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.institution.*;
import bns.a6.microui.api.pojo.bfbk.customerprofile.utility.CustomerProfile;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CustomerProfileInstitutionCreate {


    // Non-Personal customer creation request body - Customer Profile
    public String generateCustomerCreateRequest(ResultSet resultset) throws SQLException, JsonProcessingException {

//        customer_basic_information block
        Customer_basic_information customer_basic_information = new Customer_basic_information();
        customer_basic_information.setCustomer_type_cd(resultset.getString("customer_type_cd"));
        customer_basic_information.setProfile_type(resultset.getString("profile_type"));
        customer_basic_information.setCustomer_status_cd(resultset.getString("customer_status_cd"));
        customer_basic_information.setSensitivity_type_cd(resultset.getString("sensitivity_type_cd"));
        customer_basic_information.setPrimary_branch_transit_no(resultset.getString("primary_branch_transit_no"));
        customer_basic_information.setPreferred_language_cd(resultset.getString("preferred_language_cd"));
        customer_basic_information.setOffboard_date(resultset.getString("offboard_date"));
        customer_basic_information.setKyc_refreshed_date(resultset.getString("kyc_refreshed_date"));
        customer_basic_information.setSource(resultset.getString("source"));
        customer_basic_information.setRelationship_value_indicator(resultset.getString("relationship_value_indicator"));
        customer_basic_information.setRelationship_pricing_indicator(resultset.getString("relationship_pricing_indicator"));
        customer_basic_information.setVip(Boolean.parseBoolean(resultset.getString("vip")));

        //        Institution Block
        Institution institution = new Institution();
        institution.setLegal_name(resultset.getString("legal_name"));
        institution.setTrading_name(resultset.getString("trading_name"));
        institution.setBusiness_name(resultset.getString("business_name"));
        institution.setBusiness_trading_name(resultset.getString("business_trading_name"));
        institution.setInstitution_type(resultset.getString("institution_type"));


//        Registration Number
        List<RegistrationNumbers> registration_numbers = new LinkedList<>();

        RegistrationNumbers registrationNumbers = new RegistrationNumbers();

        for (String registrationType : resultset.getString("registration_number_type").split("\\|")) {
            registrationNumbers.setRegistration_number_type(registrationType);

        }

        for (String registrationNumber : resultset.getString("registration_number").split("\\|")) {
            registrationNumbers.setRegistration_number(registrationNumber);
        }

        RegistrationCountryOfIssue registrationCountryOfIssue = new RegistrationCountryOfIssue();
        for (String registrationCountryOfIssueCode : resultset.getString("registration_country_of_issue_code").split("\\|")) {
            registrationCountryOfIssue.setCode(registrationCountryOfIssueCode);
        }

        /*for (String registrationCountryOfIssueDescription : resultset.getString("registration_country_of_issue_description").split("\\|")) {
            registrationCountryOfIssue.setDescription(registrationCountryOfIssueDescription);
        }*/

        RegistrationProvStateOfIssue registrationProvStateOfIssue = new RegistrationProvStateOfIssue();
        for (String registrationProvStateOfIssueCode : resultset.getString("registration_prov_state_of_issue_code").split("\\|")) {
            registrationProvStateOfIssue.setCode(registrationProvStateOfIssueCode);
        }

        for (String registrationProvStateOfIssueDescription : resultset.getString("registration_prov_state_of_issue_description").split("\\|")) {
//            registrationProvStateOfIssue.setDescription(registrationProvStateOfIssueDescription);
            registrationNumbers.setRegistration_prov_state_of_issue(registrationProvStateOfIssue);
        }

        registrationNumbers.setExpiry_date(resultset.getString("expiry_date"));
        registrationNumbers.setRegistration_country_of_issue(registrationCountryOfIssue);
        registrationNumbers.setRegistration_prov_state_of_issue(registrationProvStateOfIssue);

        registration_numbers.add(registrationNumbers);

//   Account Holders
        AccountHolder accountHolder = new AccountHolder();
        List<AccountHolder> accountHolderList = new LinkedList<>();
        accountHolder.setKey(Integer.parseInt(resultset.getString("key")));
        accountHolder.setFirst_name(resultset.getString("first_name"));
        accountHolder.setInitial(resultset.getString("initial"));
        accountHolder.setLast_name(resultset.getString("last_name"));
        accountHolderList.add(accountHolder);

//        Standard Industrial code
        StandardIndustrialCd standardIndustrialCd = new StandardIndustrialCd();
        standardIndustrialCd.setCode(resultset.getString("standard_industrial_cd_code"));
        standardIndustrialCd.setDescription(resultset.getString("standard_industrial_cd_description"));

//        Naics code
        NaicsCd naicsCd = new NaicsCd();
        naicsCd.setCode(resultset.getString("naics_cd_code"));
        naicsCd.setDescription(resultset.getString("naics_cd_description"));

//        Annual Statement amount
        AnnualSaleAmt annualSaleAmt = new AnnualSaleAmt();
        annualSaleAmt.setCurrency_cd(resultset.getString("currency_cd"));
        if (!resultset.getString("amount").equals(""))
            annualSaleAmt.setAmount(Double.parseDouble(resultset.getString("amount")));
        institution.setAnnual_sales_availability(resultset.getString("annual_sales_availability"));
        institution.setAnnual_sales_effective_date(resultset.getString("annual_sales_effective_date"));
        institution.setBankruptcy_date(resultset.getString("bankruptcy_date"));
        institution.setConstituted_date(resultset.getString("constituted_date"));
        institution.setTotal_employee_cnt(Integer.parseInt(resultset.getString("total_employee_cnt")));
        institution.setNumber_of_employees_availability(resultset.getString("number_of_employees_availability"));
        institution.setBusiness_structure(resultset.getString("business_structure"));
        institution.setBusiness_sub_structure(resultset.getString("business_sub_structure"));

//        Association Affliation code
//        List<List<String>> associationAffiliationCds = new LinkedList<>();
        List<String> affiliationCd = new LinkedList<>(Arrays.asList(
                resultset.getString("association_affiliation_cd").split("\\|")));
//        associationAffiliationCds.add(affiliationCd);


//        Supplier
        List<Supplier> supplierList = new LinkedList<>();
        Supplier supplier = new Supplier();

        CountryCd countryCd = new CountryCd();
        countryCd.setCode(resultset.getString("supplier_country_cd_code"));
        countryCd.setDescription(resultset.getString("supplier_country_cd_description"));
        supplier.setRegion_type(resultset.getString("supplier_region_type"));

        supplier.setCountry_cd(countryCd);
        supplierList.add(supplier);


        //        client
        List<Client> clientList = new LinkedList<>();
        Client client = new Client();

        CountryCd countryCdClient = new CountryCd();
        countryCdClient.setCode(resultset.getString("client_country_cd_code"));
        countryCdClient.setDescription(resultset.getString("client_country_cd_description"));
        client.setRegion_type(resultset.getString("client_region_type"));

        client.setCountry_cd(countryCdClient);
        clientList.add(client);

        //        Operation
        List<Operation> operationList = new LinkedList<>();
        Operation operation = new Operation();

        CountryCd countryCdOperation = new CountryCd();
        countryCdOperation.setCode(resultset.getString("operation_country_cd_code"));
        countryCdOperation.setDescription(resultset.getString("operation_country_cd_description"));
        operation.setRegion_type(resultset.getString("operation_region_type"));

        operation.setCountry_cd(countryCdOperation);
        operationList.add(operation);

        institution.setFranchise_code(resultset.getString("franchise_code"));
        institution.setOther_association_franchise_desc(resultset.getString("other_association_franchise_desc"));
        institution.setBusiness_service_method(resultset.getString("business_service_method"));
        institution.setProvide_financial_services(Boolean.parseBoolean(resultset.getString("provide_financial_services")));
        institution.setFinancial_services_activity_over50000(Boolean.parseBoolean(resultset.getString("financial_services_activity_over50000")));
        institution.setCanadian_regulated_financial_institution_type(resultset.getString("canadian_regulated_financial_institution_type"));
        institution.setNon_profit_organization(Boolean.parseBoolean(resultset.getString("non_profit_organization")));
        institution.setHigh_risk_business_type(resultset.getString("high_risk_business_type"));
        institution.setCredit_admin_rating(resultset.getString("credit_admin_rating"));
        institution.setProfitability(resultset.getString("profitability"));
        institution.setWidely_held_flag(Boolean.parseBoolean(resultset.getString("widely_held_flag")));
        institution.setPublicly_traded_flag(Boolean.parseBoolean(resultset.getString("publicly_traded_flag")));
        institution.setBusiness_type(resultset.getString("business_type"));
        institution.setSimplified_due_diligence(Boolean.parseBoolean(resultset.getString("simplified_due_diligence")));
        institution.setKyc_trigger_event_id(resultset.getString("kyc_trigger_event_id"));


        institution.setRegistration_numbers(registration_numbers);
        institution.setAccount_holders(accountHolderList);
        institution.setStandard_industrial_cd(standardIndustrialCd);
        institution.setNaics_cd(naicsCd);
        institution.setAnnual_sale_amt(annualSaleAmt);
//        institution.setAssociation_affiliation_cd(associationAffiliationCds);
        institution.setAssociation_affiliation_cd(affiliationCd);
        institution.setSupplier(supplierList);
        institution.setClient(clientList);
        institution.setOperation(operationList);

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

        //  Country code block
        Country_cd country_cd = new Country_cd();
        country_cd.setCode(resultset.getString("country_cd"));
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
        if (!resultset.getString("phone_extension_no").equals(""))
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

        customer_basic_information.setInstitution(institution);

        Mapper mapper = new Mapper();
        mapper.setCustomer_basic_information(customer_basic_information);
        mapper.setAddress(addresses);
        mapper.setContact_method(contact_method);

        CustomerProfile customerProfile = new CustomerProfile();
        return customerProfile.getCustomerProfileRequest(mapper);

    }

}
