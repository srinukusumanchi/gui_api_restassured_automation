/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-23
 * Created Time: 12:44 p.m.
 */

package bns.a6.microui.api.pojo.bf9k.customerlookup.mapper.get;


import bns.a6.microui.api.pojo.bf9k.customerlookup.services.get.request.individual.Individual;
import bns.a6.microui.api.pojo.bf9k.customerlookup.services.get.response.data.Data;
import bns.a6.microui.api.pojo.bf9k.customerlookup.services.get.response.data.Notifications;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mapper {

    private Individual individual;
    private Data data;
    private List<Notifications> notifications;

}
