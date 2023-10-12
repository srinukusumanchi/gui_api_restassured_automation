/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-09-16
 * Created Time: 12:15 a.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.institution;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationNumbers {

    private String registration_number_type;
    private String registration_number;
    private RegistrationCountryOfIssue registration_country_of_issue;
    private RegistrationProvStateOfIssue registration_prov_state_of_issue;
    private String expiry_date;
}
