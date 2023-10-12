/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-01-17
 * Created Time: 1:33 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.customerprofile.services.payload.institution;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Institution {

    private String legal_name;
    private String trading_name;
    private String business_name;
    private String business_trading_name;
    private String institution_type;
    private List<RegistrationNumbers> registration_numbers;
    private List<AccountHolder> account_holders;
    private StandardIndustrialCd standard_industrial_cd;
    private NaicsCd naics_cd;
    private AnnualSaleAmt annual_sale_amt;
    private String annual_sales_availability;
    private String annual_sales_effective_date;
    private String bankruptcy_date;
    private String constituted_date;
    private Integer total_employee_cnt;
    private String number_of_employees_availability;
    private String business_structure;
    private String business_sub_structure;
    //    private List<List<String>> association_affiliation_cd;
    private List<String> association_affiliation_cd;
    private List<Supplier> supplier;
    private List<Client> client;
    private List<Operation> operation;

    private String franchise_code;
    private String other_association_franchise_desc;
    private String business_service_method;
    private Boolean provide_financial_services;
    private Boolean financial_services_activity_over50000;
    private String canadian_regulated_financial_institution_type;
    private Boolean non_profit_organization;
    private String high_risk_business_type;
    private String credit_admin_rating;
    private String profitability;
    private Boolean widely_held_flag;
    private Boolean publicly_traded_flag;
    private String business_type;
    private Boolean simplified_due_diligence;
    private String kyc_trigger_event_id;


}
