package bns.a6.microui.api.pojo.bf9k.customersearch.services.get.response.data;

import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.response.accountsassociated.Account_associated;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.response.basicinformation.Basic_information;
import lombok.Getter;

/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-27
 * Created Time: 11:04 p.m.
 */


@Getter
public class Data {
    private Basic_information basic_information;
    private Account_associated account_associated;


}
