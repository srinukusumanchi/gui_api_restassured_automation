/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 1:33 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.individual;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Individual {

    private String full_name;
    private String title_name;
    private String first_given_name;
    private String first_last_name;
    private String initials_text;
    private String third_given_name;
    private String suffix_name;
    private String birth_date;
    private String sex_type;
    private String marital_status;
    private String bankruptcy_date;
    private String deceased_date;
    private boolean employee_ind;
    private String sin;
    private String sin_expiry_date;
    private String kyc_trigger_event_id;
    private int number_of_dependants;
    private String customer_residence_status;
    private String current_address_start_date;
}
