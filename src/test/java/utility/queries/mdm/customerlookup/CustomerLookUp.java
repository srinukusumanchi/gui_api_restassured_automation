/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-07-04
 * Created Time: 2:31 p.m.
 */

package utility.queries.mdm.customerlookup;

import lombok.Getter;

@Getter
public enum CustomerLookUp {

    //    WHERE clauses
    FIRSTNAMELASTNAME(" AND p.GIVEN_NAME_ONE='<GIVENNAME>' AND p.LAST_NAME='<LASTNAME>'"),
    DOB(" AND p2.BIRTH_DT='<DOB>'"),
    PHONENumber(" AND cm.REF_NUM='<PHONEOREMAIL>'"),
    POSTALCODE(" AND a2.POSTAL_CODE='<POSTALCODE>'"),
    CUSTOMERSTATUS(" AND c2.NAME ='<CUSTOMERSTATUS>'"),
    EMAIL(" AND cm.REF_NUM='<PHONEOREMAIL>'"),
    //    MDM Queries
//    Full Name and Birth date
//    Tables :- PERSONNAME, PERSON
    CUSTOMER_LOOK_UP("SELECT DISTINCT ce.ADMIN_CLIENT_ID AS CID, p.GIVEN_NAME_ONE AS first_given_name, " +
            " p.LAST_NAME AS first_last_name , p2.BIRTH_DT AS birth_date,  " +
            " a2.postal_code AS postal_cd,cm.REF_NUM as phone_or_email,c2.NAME AS CLIENT_STATUS FROM OSCDM.CONTEQUIV ce" +
            " INNER JOIN oscdm.CONTACT c ON c.CONT_ID = ce.CONT_ID AND c.INACTIVATED_DT IS NULL " +
            " INNER JOIN OSCDM.PERSONNAME p ON p.CONT_ID = ce.CONT_ID AND p.NAME_USAGE_TP_CD = 1" +
            " LEFT JOIN OSCDM.CDCLIENTSTTP c2 ON c2.CLIENT_ST_TP_CD = c.CLIENT_ST_TP_CD " +
            " INNER JOIN OSCDM.PERSON p2 ON p2.CONT_ID = ce.CONT_ID" +
            " LEFT JOIN OSCDM.LOCATIONGROUP la ON la.CONT_ID = ce.CONT_ID AND la.END_DT IS NULL AND la.LOC_GROUP_TP_CODE ='A'" +
            " LEFT JOIN OSCDM.ADDRESSGROUP a ON a.LOCATION_GROUP_ID = la.LOCATION_GROUP_ID" +
            " LEFT JOIN OSCDM.ADDRESS a2 ON a2.ADDRESS_ID = a.ADDRESS_ID" +
            " left outer join OSCDM.CDPROVSTATETP pr on pr.PROV_STATE_TP_CD=a2.PROV_STATE_TP_CD" +
            " left outer join OSCDM.CDCOUNTRYTP co on co.COUNTRY_TP_CD=a2.country_tp_cd AND co.LANG_TP_CD =100" +
            " LEFT  JOIN OSCDM.LOCATIONGROUP lc ON lc.CONT_ID = ce.CONT_ID AND lc.END_DT IS NULL AND lc.LOC_GROUP_TP_CODE = 'C'" +
            " left join OSCDM.contactmethodgroup cg on lc.LOCATION_GROUP_ID = cg.LOCATION_GROUP_ID " +
            " LEFT JOIN OSCDM.CONTACTMETHOD cm ON cm.CONTACT_METHOD_ID = cg.CONTACT_METHOD_ID" +
            " WHERE ce.ADMIN_SYS_TP_CD =100001 AND ce.DESCRIPTION IS NULL");

    private final String query;

    CustomerLookUp(String queries) {
        this.query = queries;
    }

    public String getQuery() {
        return query;
    }
}
