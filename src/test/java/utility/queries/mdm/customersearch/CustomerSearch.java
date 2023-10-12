/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-07-04
 * Created Time: 2:31 p.m.
 */

package utility.queries.mdm.customersearch;

import lombok.Getter;

@Getter
public enum CustomerSearch {

//    Tables Involved
/*    CONTACT, CONTRACTROLE, CDCONTRACTROLETP, CONTRACTCOMPONENT, CDPRODTP, NATIVEKEY, PERSONNAME, CDPREFIXNAMETP,
      CDCLIENTSTTP, PERSON, XCDCUSTOMERTP, ORG, CDORGTP, ORGNAME, CDORGNAMETP, LOCATIONGROUP, ADDRESSGROUP, CDADDRUSAGETP
      ADDRESS, CDPROVSTATETP, CDCOUNTRYTP, LOCATIONGROUP, contactmethodgroup, CONTACTMETHOD, IDENTIFIER, ADMIN_SYS_TP_CD*/

    //
    ACCOUNTNUMBER(" and prod.NAME = '<ACCOUNT_TYPE>' and n.ADMIN_CONTRACT_ID = '<ACCOUNT_NUMBER>'"),
    PERSONALDETAILS(" and c.PERSON_ORG_CODE='<CUSTOMER_TYPE_CD>' AND ptp.NAME='<TITLE_NAME>' and p.GIVEN_NAME_ONE='<FIRST_GIVEN_NAME>' and p.LAST_NAME='<FIRST_LAST_NAME>' and p.XFULL_NAME='FULL_NAME' and p2.BIRTH_DT='BIRTH_DATE'"),
    ADDRESS(" and c.PERSON_ORG_CODE='<CUSTOMER_TYPE_CD>' AND a3.NAME='<ADDRESS_TYPE_CD>' and a2.ADDR_LINE_ONE='<LINE1_ADDR>' and a2.ADDR_LINE_TWO='<LINE2_ADDR>' and a2.CITY_NAME='CITY' and pr.NAME='STATE' AND a2.POSTAL_CODE='POSTAL_CD' AND a2.COUNTRY_TP_CD='COUNTRY_CD'"),
    CARD(" and prod.NAME = '<CARD_TYPE>' and n.ADMIN_CONTRACT_ID = '<CARD_ID>'"),
    NONPERSONALDETAILS("and  c.PERSON_ORG_CODE='<CUSTOMER_TYPE_CD>' and o2.ORG_NAME='<ORGANIZATION_NAME>' AND o4.NAME='<NAME_TYPE>' and a2.POSTAL_CODE ='<POSTAL_CD>'"),
    PHONENUMBER(" and c.PERSON_ORG_CODE='<CUSTOMER_TYPE_CD>' and cm.REF_NUM = '<PHONE_NO>'"),
    SINNUMBER(" and c.PERSON_ORG_CODE='<CUSTOMER_TYPE_CD>' and i.REF_NUM = '<SIN>'"),

    //    MDM Queries
    CUSTOMERSEARCH("select distinct " +
            "ce.ADMIN_CLIENT_ID as CID, " +
            "c.PERSON_ORG_CODE as customer_type, " +
            "c2.NAME as customer_status, " +
            "coalesce(xtp.NAME, o3.NAME) as profile_type, " +
            "coalesce(p2.XSENSITIVITY_TP_CD, o.XSENSITIVITY_TP_CD) as sensitivity_code, " +
            "ptp.NAME as individual_title, " +
            "p.GIVEN_NAME_ONE, " +
            "p.LAST_NAME, " +
            "coalesce(p.XFULL_NAME, o2.ORG_NAME) as full_name, " +
            "p2.BIRTH_DT, " +
            "a3.NAME as address_type_cd, " +
            "a2.ADDR_LINE_ONE, " +
            "a2.ADDR_LINE_TWO, " +
            "a2.CITY_NAME, " +
            "pr.NAME as state_name, " +
            "a2.POSTAL_CODE, " +
            "a2.COUNTRY_TP_CD, " +
            "n.ADMIN_CONTRACT_ID as account_number, " +
            "prod.NAME as account_type, " +
            "ctp.NAME as relationship " +
            "FROM OSCDM.CONTEQUIV ce  " +
            "left JOIN oscdm.CONTACT c ON c.CONT_ID = ce.CONT_ID AND c.INACTIVATED_DT IS NULL " +
            "left join oscdm.CONTRACTROLE ct on ct.CONT_ID = c.CONT_ID and ct.END_DT IS NULL " +
            "LEFT JOIN oscdm.CDCONTRACTROLETP ctp on ctp.CONTR_ROLE_TP_CD = ct.CONTR_ROLE_TP_CD " +
            "LEFT JOIN oscdm.CONTRACTCOMPONENT cp on cp.CONTR_COMPONENT_ID = ct.CONTR_COMPONENT_ID and cp.EXPIRY_DT is null " +
            "left join oscdm.CDPRODTP prod on prod.PROD_TP_CD = cp.PROD_TP_CD " +
            "left join oscdm.NATIVEKEY n on n.CONTRACT_ID = cp.CONTR_COMPONENT_ID " +
            "left JOIN OSCDM.PERSONNAME p ON p.CONT_ID = c.CONT_ID AND p.NAME_USAGE_TP_CD = 1 " +
            "left join oscdm.CDPREFIXNAMETP ptp on ptp.PREFIX_NAME_TP_CD = p.PREFIX_NAME_TP_CD " +
            "LEFT JOIN OSCDM.CDCLIENTSTTP c2 ON c2.CLIENT_ST_TP_CD = c.CLIENT_ST_TP_CD  " +
            "left JOIN OSCDM.PERSON p2 ON p2.CONT_ID = c.CONT_ID " +
            "LEFT JOIN oscdm.XCDCUSTOMERTP xtp on xtp.CUSTOMER_TP_CD = p2.XCUSTOMER_TP_CD " +
            "left JOIN oscdm.ORG o on o.CONT_ID = c.CONT_ID " +
            "left join oscdm.CDORGTP o3 on o3.ORG_TP_CD = o.ORG_TP_CD " +
            "left join oscdm.ORGNAME o2 on o2.CONT_ID = c.CONT_ID " +
            "left join oscdm.CDORGNAMETP o4 on o4.ORG_NAME_TP_CD = o2.ORG_NAME_TP_CD " +
            "LEFT JOIN OSCDM.LOCATIONGROUP la ON la.CONT_ID = c.CONT_ID AND la.END_DT IS NULL AND la.LOC_GROUP_TP_CODE ='A' " +
            "LEFT JOIN OSCDM.ADDRESSGROUP a ON a.LOCATION_GROUP_ID = la.LOCATION_GROUP_ID AND a.ADDR_USAGE_TP_CD in (1,3) " +
            "left join oscdm.CDADDRUSAGETP a3 on a3.ADDR_USAGE_TP_CD = a.ADDR_USAGE_TP_CD " +
            "LEFT JOIN OSCDM.ADDRESS a2 ON a2.ADDRESS_ID = a.ADDRESS_ID " +
            "left outer join OSCDM.CDPROVSTATETP pr on pr.PROV_STATE_TP_CD=a2.PROV_STATE_TP_CD " +
            "left outer join OSCDM.CDCOUNTRYTP co on co.COUNTRY_TP_CD=a2.country_tp_cd AND co.LANG_TP_CD =100 " +
            "LEFT  JOIN OSCDM.LOCATIONGROUP lc ON lc.CONT_ID = c.CONT_ID AND lc.END_DT IS NULL AND lc.LOC_GROUP_TP_CODE = 'C' " +
            "left join OSCDM.contactmethodgroup cg on lc.LOCATION_GROUP_ID = cg.LOCATION_GROUP_ID  " +
            "LEFT JOIN OSCDM.CONTACTMETHOD cm ON cm.CONTACT_METHOD_ID = cg.CONTACT_METHOD_ID " +
            "left join oscdm.IDENTIFIER i on i.CONT_ID = c.CONT_ID and i.ID_TP_CD in (100021,100022) " +
            "WHERE ce.ADMIN_SYS_TP_CD =100001 AND ce.DESCRIPTION IS NULL");

    private final String query;

    CustomerSearch(String queries) {
        this.query = queries;
    }

    public String getQuery() {
        return query;
    }
}
