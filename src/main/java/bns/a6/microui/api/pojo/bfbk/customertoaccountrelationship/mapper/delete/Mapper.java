/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-22
 * Created Time: 8:16 a.m.
 */

package bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.mapper.delete;

import bns.a6.microui.api.pojo.bfbk.customertoaccountrelationship.services.delete.Relationships;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Mapper {

    private String customer_id;
    private List<Relationships> relationships;
}
