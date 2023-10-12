/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-22
 * Created Time: 8:16 a.m.
 */

package bns.a6.microui.api.pojo.bfbk.intentofuse.mapper.put;

import bns.a6.microui.api.pojo.bfbk.intentofuse.services.put.intentuseaccounts.IntentUseOfUse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mapper {

    private IntentUseOfUse intentUseOfAccounts;
    private String customer_id;
}
