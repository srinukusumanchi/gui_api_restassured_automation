/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-07-04
 * Created Time: 2:31 p.m.
 */

package utility.queries.mdm.countrycodereference;

import lombok.Getter;

@Getter
public enum CountryCodeReference {

//    Tables Involved
//    CDCOUNTRYTP

    //    WHERE clauses
    LANGUAGE(" WHERE LANG_TP_CD='<LANGUAGE_CODE>'"),
    ACTIVEFLAG(" AND ACTIVE_FLAG='<ACTIVE_FLAG>'"),
    //    MDM Queries
    COUNTRY_CODE_REFERENCE("SELECT NAME,ISO_CODE_3,DESCRIPTION,ACTIVE_FLAG FROM OSCDM.CDCOUNTRYTP");

    private final String query;

    CountryCodeReference(String queries) {
        this.query = queries;
    }

    public String getQuery() {
        return query;
    }
}
