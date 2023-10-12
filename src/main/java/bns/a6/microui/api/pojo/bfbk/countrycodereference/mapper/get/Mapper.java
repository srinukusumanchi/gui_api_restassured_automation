/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-07-15
 * Created Time: 8:16 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.countrycodereference.mapper.get;


import bns.a6.microui.api.pojo.bfbk.countrycodereference.services.get.data.Data;
import bns.a6.microui.api.pojo.bfbk.countrycodereference.services.get.data.Notifications;
import lombok.Getter;

import java.util.List;

@Getter
public class Mapper {

    private Data data;
    private List<Notifications> notifications;
}
