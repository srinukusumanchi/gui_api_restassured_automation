/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 5:45 p.m.
 */

package bns.a6.microui.api.pojo.bf9k.customerlookup.services.get.request.individual;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Individual {

    private String first_given_name;
    private String first_last_name;
    private String birth_date;
    private String phone_no;
    private String postal_cd;
    private String email;

}
