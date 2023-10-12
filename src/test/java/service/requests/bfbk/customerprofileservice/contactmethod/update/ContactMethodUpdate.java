/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-13
 * Created Time: 2:05 p.m.
 */

package service.requests.bfbk.customerprofileservice.contactmethod.update;

import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Contact_method;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Email;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.contactmethod.Phone;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.put.contactmethod.root.UnNamed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ContactMethodUpdate {




    // Personal customer - Contact method Update request body - Customer Profile - Contact method
    public String generateCustomerContactUpdateRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        // Class name is empty in Json Request
        UnNamed unNamed = new UnNamed();
        unNamed.setCustomer_key(resultset.getString("customer_key"));
        unNamed.setCustomer_type_cd(resultset.getString("customer_type_cd"));

        //  Contact method block
        Contact_method contact_method = new Contact_method();


        if (!resultset.getString("contact_type_cd").equals("")) {
            Phone phone = new Phone();
            phone.setContact_type_cd(resultset.getString("contact_type_cd"));
            phone.setPhone_no(resultset.getString("phone_no"));
            phone.setPhone_extension_no(resultset.getString("phone_extension_no"));
            phone.setFull_telephone_no(resultset.getString("full_telephone_no"));

            List<Phone> phoneList = new LinkedList<>();
            phoneList.add(phone);
            contact_method.setPhone(phoneList);

        }

        if (!resultset.getString("email_type").equals("")) {
            Email email = new Email();
            email.setEmail_type(resultset.getString("email_type"));
            email.setEmail_address_text(resultset.getString("email_address_text"));

            List<Email> emailList = new LinkedList<>();
            emailList.add(email);
            contact_method.setEmail(emailList);
        }
//        contact_method.setContact_title(resultset.getString("contact_title"));
//        contact_method.setContact_name(resultset.getString("contact_name"));

        List<Contact_method> contact_methodList = new LinkedList<>();
        contact_methodList.add(contact_method);
        unNamed.setContact_method(contact_methodList);
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        return mapper.writeValueAsString(unNamed);
    }
}
