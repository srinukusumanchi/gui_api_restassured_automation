/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-21
 * Created Time: 3:51 p.m.
 */

package bns.a6.microui.api.pojo.bf9k.customersearch.mapper.get;

import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.acount.Account;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.address.Address;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.card.Card;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.individual.Individual;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.institution.Institution;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.sin.Sin;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.request.telephone.Telephone;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.response.accountsassociated.Account_associated;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.response.basicinformation.Address_list;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.response.basicinformation.Basic_information;
import bns.a6.microui.api.pojo.bf9k.customersearch.services.get.response.data.Data;
import bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.data.Notifications;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Mapper {
    //    Request Objects
    private Account account;
    private Sin sin;
    private Telephone telephone;
    private Card card;
    private Institution institution;
    private Individual individual;
    private Address address;
    private String customer_type_cd;

    //    Response Objects
    private List<Data> data;
    private Basic_information basic_information;
    private bns.a6.microui.api.pojo.bf9k.customersearch.services.get.response.basicinformation.Individual individualResponse;
    private List<Address_list> addressList;
    private Account_associated account_associated;
    private List<Notifications> notifications;
}
