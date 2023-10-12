/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-07-15
 * Created Time: 8:14 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.countrycodereference.services.get.countrylist;

import lombok.Getter;

@Getter
public class CountryList {

    private String country_iso2_code;
    private String country_iso3_code;
    private String description;
    private Boolean active_flag;

}
