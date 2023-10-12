/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 1:27 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.customerbasicinformation;

import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.individual.Individual;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer_basic_information {

    private String customer_key;
    private String customer_type_cd;
    private String profile_type;
    private String customer_status_cd;
    private String sensitivity_type_cd;
    private String primary_branch_transit_no;
    private String preferred_language_cd;
    private String onboard_date;
    private String offboard_date;
    private String last_updated_dt;
    private String kyc_refreshed_date;
    private String source;
    private String relationship_value_indicator;
    private String relationship_pricing_indicator;
    private boolean vip;
    private Individual individual;
    private bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.institution.Institution institution;
}
