package utility;

public enum Queries {

    //    MDM Queries
    CUSTOMERPRODUCTS_MDM("Select DISTINCT N.admin_contract_id,C.admin_client_id,CP.NAME,N.LAST_UPDATE_DT from OSCDM.contractcomponent CC, OSCDM.Nativekey N, OSCDM.contractrole CR, OSCDM.Contequiv C,OSCDM.cdprodtp CP where " +
            "N.contract_id = CC.contr_component_id and " +
            "CC.contr_component_id =CR.CONTR_COMPONENT_ID and " +
            "CR.CONT_ID = C.CONT_ID and " +
            "CC.PROD_TP_CD=CP.PROD_TP_CD and " +
            "CP.NAME = '<Product>'and LENGTH (ADMIN_CLIENT_ID) = 15 and (LENGTH (ADMIN_CONTRACT_ID) =13 or LENGTH (ADMIN_CONTRACT_ID) =11) and CR.END_DT is NULL order by N.LAST_UPDATE_DT desc"),

    //    Test data Queries
    ACCOUNTNUMBERPRODUCTS_TESTDATA("SELECT * FROM a6_tdm.accountnumbersproducts");

    private String query;

    Queries(String queries) {
        this.query = queries;
    }

    public String getQuery() {
        return query;
    }
}
