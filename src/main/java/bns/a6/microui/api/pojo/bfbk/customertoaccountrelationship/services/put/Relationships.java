/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-25
 * Created Time: 6:21 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.services.put;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Relationships {

    private String relationship_type;
    private String account_number;
    private String product_code;
    private String action_type;
}
