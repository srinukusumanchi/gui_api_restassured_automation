/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 12:43 p.m.
 */

package service.requests.bf9k.customersearch.inquiry;

import bns.a6.microui.api.pojo.bf9k.customersearch.mapper.get.Mapper;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.acount.Account;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.address.Address;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.card.Card;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.individual.Individual;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.institution.Institution;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.sin.Sin;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.telephone.Telephone;
import bns.a6.microui.api.pojo.bf9k.customersearch.utility.CustomerSearch;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerSearchUsingGet {


    //     *********************************** Customer Search using account number ******************************************
    public String generateCustomerSearchWithAccountNumberRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //        Account block
        Account account = new Account();
        account.setAccount_no(resultset.getString("account_no"));
        account.setAccount_type(resultset.getString("account_type"));

        //        Mapper
        Mapper mapper = new Mapper();
        mapper.setAccount(account);

        CustomerSearch customerSearch = new CustomerSearch();
        return customerSearch.getCustomerSearchRequest(mapper);
    }

    //     *********************************** Customer Search using SIN ******************************************
    public String generateCustomerSearchWithSINRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //        SIN block
        Sin sin = new Sin();
        sin.setSin(resultset.getString("sin"));

        //        Mapper
        Mapper mapper = new Mapper();
        mapper.setSin(sin);
        mapper.setCustomer_type_cd(resultset.getString("customer_type_cd"));

        CustomerSearch customerSearch = new CustomerSearch();
        return customerSearch.getCustomerSearchRequest(mapper);
    }

    //     *********************************** Customer Search using Phone ******************************************
    public String generateCustomerSearchWithPhoneRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //        Telephone block
        Telephone telephone = new Telephone();
        telephone.setPhone_no(resultset.getString("phone_no"));

        //        Mapper
        Mapper mapper = new Mapper();
        mapper.setTelephone(telephone);
        mapper.setCustomer_type_cd(resultset.getString("customer_type_cd"));

        CustomerSearch customerSearch = new CustomerSearch();
        return customerSearch.getCustomerSearchRequest(mapper);
    }

    //     *********************************** Customer Search using Card ******************************************
    public String generateCustomerSearchWithCardRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //        Card block
        Card card = new Card();
        card.setCard_id(resultset.getString("card_id"));
        card.setCard_type(resultset.getString("card_type"));

        //        Mapper
        Mapper mapper = new Mapper();
        mapper.setCard(card);

        CustomerSearch customerSearch = new CustomerSearch();
        return customerSearch.getCustomerSearchRequest(mapper);
    }


    //     *************************** Customer Search using Non-Personal customer details *********************
    public String generateCustomerSearchWithNonPersonalRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //        Institution block
        Institution institution = new Institution();
        institution.setOrganization_name(resultset.getString("organization_name"));
        institution.setName_type(resultset.getString("name_type"));
        institution.setPostal_cd(resultset.getString("postal_cd"));
        //        Mapper
        Mapper mapper = new Mapper();
        mapper.setInstitution(institution);
        mapper.setCustomer_type_cd(resultset.getString("customer_type_cd"));

        CustomerSearch customerSearch = new CustomerSearch();
        return customerSearch.getCustomerSearchRequest(mapper);
    }

    //     *************************** Customer Search using Personal customer details *********************
    public String generateCustomerSearchWithPersonalRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //        Institution block
        Individual individual = new Individual();
        individual.setTitle_name(resultset.getString("title_name"));
        individual.setFirst_given_name(resultset.getString("first_given_name"));
        individual.setFirst_last_name(resultset.getString("first_last_name"));
        individual.setFull_name(resultset.getString("full_name"));
        individual.setBirth_date(resultset.getString("birth_date"));
        //        Mapper
        Mapper mapper = new Mapper();
        mapper.setIndividual(individual);
        mapper.setCustomer_type_cd(resultset.getString("customer_type_cd"));

        CustomerSearch customerSearch = new CustomerSearch();
        return customerSearch.getCustomerSearchRequest(mapper);
    }


    //     *************************** Customer Search using Address customer details *********************
    public String generateCustomerSearchWithAddressRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        //        Institution block
        Address address = new Address();
        address.setAddress_type_cd(resultset.getString("address_type_cd"));
        address.setLine_1_addr(resultset.getString("line_1_addr"));
        address.setLine_2_addr(resultset.getString("line_2_addr"));
        address.setCity(resultset.getString("city"));
        address.setState(resultset.getString("state"));
        address.setPostal_cd(resultset.getString("postal_cd"));
        address.setCountry_cd(resultset.getString("country_cd"));
        //        Mapper
        Mapper mapper = new Mapper();
        mapper.setAddress(address);
        mapper.setCustomer_type_cd(resultset.getString("customer_type_cd"));

        CustomerSearch customerSearch = new CustomerSearch();
        return customerSearch.getCustomerSearchRequest(mapper);
    }


}
