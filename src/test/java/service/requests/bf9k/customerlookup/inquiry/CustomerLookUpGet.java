/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 12:43 p.m.
 */

package service.requests.bf9k.customerlookup.inquiry;

import bns.a6.microui.api.pojo.bf9k.customerlookup.mapper.get.Mapper;
import bns.a6.microui.api.pojo.bf9k.customerlookup.services.get.request.individual.Individual;
import bns.a6.microui.api.pojo.bf9k.customerlookup.utility.CustomerLookUp;
import bns.a6.microui.api.testbase.APIBasePage;

public class CustomerLookUpGet extends APIBasePage {


    //     *********************************** Customer Search using Individual details ******************************************

    public String generateCustomerSearchWithIndividualRequest(String firstNameMDMData, String lastNameMDMData,
                                                              String birthDateMDMData, String phoneNumberMDMData,
                                                              String postalCodeMDMData, String emailMDMData) throws Exception {

        //        Individual block
        Individual individual = new Individual();

        individual.setFirst_given_name(firstNameMDMData);
        individual.setFirst_last_name(lastNameMDMData);
        if (birthDateMDMData != null)
            individual.setBirth_date(birthDateMDMData.substring(0, 10));
        individual.setPhone_no(phoneNumberMDMData);
        individual.setPostal_cd(postalCodeMDMData);
        individual.setEmail(emailMDMData);

        //        Mapper
        Mapper mapper = new Mapper();
        mapper.setIndividual(individual);
        CustomerLookUp customerLookUp = new CustomerLookUp();
        return customerLookUp.getCustomerLookUpRequest(mapper);

    }

}