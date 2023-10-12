/**
 * User
 * Created Date
 * Created Time
 */

package bns.a6.microui.web.managers;

import bns.a6.microui.web.pages.a6.CS2CustomerLocateOrSetup;
import bns.a6.microui.web.pages.a6.CS4CustomerProductsAndServices;
import bns.a6.microui.web.pages.accessbyaccount.AccessByAccountNumber;
import bns.a6.microui.web.pages.accessbyaccount.AccountProfile;
import bns.a6.microui.web.pages.accessbyaccount.BusinessAccountProfile;
import bns.a6.microui.web.pages.accountprofilemaintenance.AccountProfileMaintenaceFooter;
import bns.a6.microui.web.pages.accounts.accountmaintenance.customerToAccountMaintenance.CustomerToAccountRelationship;
import bns.a6.microui.web.pages.accounts.accountsetup.business.businessaccountwithoutcreditbureau.*;
import bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking.*;
import bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking.kycrefresh.customerinformationreview.ReviewAccountIntendedUseInformation;
import bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking.kycrefresh.customerinformationreview.ReviewEmploymentInformation;
import bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking.kycrefresh.customerinformationreview.ReviewProfile;
import bns.a6.microui.web.pages.accounts.accountsetup.daytodaybanking.kycrefresh.customerinformationreview.ReviewResidentialAddress;
import bns.a6.microui.web.pages.accounts.accountsetup.onlineloanaccount.AccountLink;
import bns.a6.microui.web.pages.accounts.accountsetup.scotiacard.maintenance.AA1AccountAdministration;
import bns.a6.microui.web.pages.accounts.accountsetup.scotiacard.setup.AA3aAccountAccessChanges;
import bns.a6.microui.web.pages.accounts.accountsetup.scotiacard.setup.AA3aSetupNewScotiaCard;
import bns.a6.microui.web.pages.accounts.accountsetup.scotiacard.setup.PrintChoices;
import bns.a6.microui.web.pages.accounttocustomersummary.AccountToSummaryFooter;
import bns.a6.microui.web.pages.bgx4.customerInformation.PopUps;
import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.BusinessAddress;
import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.BusinessInformation;
import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.CustomerRelationship;
import bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.LoanAdministration;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.*;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.CustomerInformation;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.ProductsAndServices;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.CustomerName;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.MotherMaidenName;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.ResidenceInformation;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.preferences.CustomerPreferences;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.preferences.Preferences;
import bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.taxInformation.FATCA;
import bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.NonPersonalCustomer;
import bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.PersonalCustomerName;
import bns.a6.microui.web.pages.bgx4.customerLocateOrSetup.ScotiaCardOrAccount;
import bns.a6.microui.web.pages.bgx4.customersalesandservices.AccountMaintenance;
import bns.a6.microui.web.pages.bgx4.customersalesandservices.AccountSetup;
import bns.a6.microui.web.pages.bgx4.customersalesandservices.CustomerSelection;
import bns.a6.microui.web.pages.bgx4.pagecomponents.Footer;
import bns.a6.microui.web.pages.bgx4.pagecomponents.create.personal.Header;
import bns.a6.microui.web.pages.ciscentre.CISCentre;
import bns.a6.microui.web.pages.intralink.*;
import bns.a6.microui.web.pages.tore.DDAAccountNumbers;
import bns.a6.microui.web.pages.tore.SavingsAccountNumber;
import bns.a6.microui.web.pages.tore.ScotiaCardAccountNumbers;
import bns.a6.microui.web.utility.reporting.ReportPortal;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class PageObjectManager {

    private static PageObjectManager INSTANCE = null;
    private final WebDriver driver = null;
    private ReportPortal reportportal;
    private BNSEmployeeLogin bnsEmployeeLogin;
    private OfficerContext officerContext;
    private FormIsNotSecure formnotSecure;
    private Page1_ConcentToReceiptOfElectronicDocuments page1_concentToReceiptOfElectronicDocuments;
    private CISCentre cisCentre;
    private IntraLinkHomePage intraLinkHomePage;
    private IntralinkHeader intralinkHeader;
    private bns.a6.microui.web.pages.a6.IntralinkHeader intralinkHeaderLegacy;
    private CS2CustomerLocateOrSetup cs2CustomerLocateOrSetup;
    private CS4CustomerProductsAndServices cs4CustomerProductsAndServices;
    private ScotiaCardOrAccount scotiaCardOrAccount;
    private NonPersonalCustomer nonPersonalCustomer;
    private BusinessAddress businessAddress;
    private bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.ContactInformation contactInformationNonPersonal;
    private PersonalCustomerName personalCustomerName;
    private Header personalHeaderCreate;
    private bns.a6.microui.web.pages.bgx4.pagecomponents.maintenance.personal.Header personalHeaderUpdate;
    private bns.a6.microui.web.pages.bgx4.pagecomponents.create.involvedparty.Header headerInvolvedParty;
    private bns.a6.microui.web.pages.bgx4.pagecomponents.create.nonpersonal.Header headerMaintenance;
    private PersonalInformation personalInformationCreate;
    private AddressInformation addressInformation;
    private ContactInformation
            contactInformationPersonalCreate;
    private Identification identificationCreate;
    private EmploymentAndIncome employmentAndIncomeCreate;
    private MulticulturalInformation multiculturalInformationCreate;
    private bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.ResidenceInformation residenceInformationCreate;
    private bns.a6.microui.web.pages.accounttocustomersummary.ExistingCustomerLinkedToAccount
            existingCustomerLinkedToAccount;
    private AccountProfileMaintenaceFooter accountProfileMaintenanceFooter;
    private AccountToSummaryFooter accountToSummaryFooter;
    private BusinessInformation businessInformation;
    private LoanAdministration loanAdministrationCreatePersonal;
    private CustomerRelationship customerRelationship;
    private Footer footer;
    private PopUps popUps;
    private CustomerSelection customerSelection;
    private ProductsAndServices productsAndServicesPersonal;
    private FATCA fatca;
    private bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian.PersonalInformation personalInformationInvolvedParty;
    private bns.a6.microui.web.pages.bgx4.parentorguardian.PersonalCustomerName personalCustomerNameInvolvedParty;
    private bns.a6.microui.web.pages.bgx4.parentorguardian.CustomerFound customerFound;
    private bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian.AddressInformation addressInformationInvolvedParty;
    private bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian.Employment employmentInvolvedParty;
    private bns.a6.microui.web.pages.bgx4.parentorguardian.PopUps popUpsInvolvedParty;
    private AccountSetup accountSetup;
    private SavingsAccountNumber savingsAccountNumber;
    private DDAAccountNumbers ddaAccountNumbers;
    private ScotiaCardAccountNumbers scotiaCardAccountNumbers;
    private AccountMaintenance accountMaintenance;
    private BusinessAccountOpenOwnership businessAccountOpenOwnership;
    private BusinessAccountOpenOptionsI businessAccountOpenOptionsI;
    private BusinessAccountOpenOptionsII businessAccountOpenOptionsII;
    private BusinessAccountOpenConfirmation businessAccountOpenConfirmation;
    private CustomerInformation customerInformation;
    private bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.CustomerInformation customerInformationnp;
    private CustomerPreferences customerPreferences;
    private Preferences preferences;
    private CustomerName customerNamePersonal;
    private bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.PersonalInformation personalInformationUpdate;
    private bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.AddressInformation addressInformationUpdate;
    private bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerinquiry.AddressInformation addressInformationInquiry;
    private ResidenceInformation residenceInformationUpdate;
    private bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.ContactInformation contactInformationPersonalUpdate;
    private MotherMaidenName motherMaidenName;
    private bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.Identification identificationPersonalUpdate;
    private bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.EmploymentAndIncome employmentAndIncomeUpdate;
    private bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.MulticulturalInformation multiculturalInformationUpdate;
    private CustomerToAccountRelationship customerToAccountRelationship;
    private DayToDayHighwayOwnership dayToDayHighwayOwnership;
    private ReviewProfile reviewProfile;
    private HB100CreditBureauRequest hb100CreditBureauRequest;
    private ReviewResidentialAddress reviewResidentialAddress;
    private ReviewEmploymentInformation reviewEmploymentInformation;
    private ReviewAccountIntendedUseInformation reviewAccountIntendedUseInformation;
    private AA3aSetupNewScotiaCard aa3aSetupNewScotiacard;
    private AA3aAccountAccessChanges aa3aAccountAccessChanges;
    private PrintChoices printChoices;
    private AA1AccountAdministration aa1AccountAdministration;
    private DayToDayHighwayOptions dayToDayHighwayOptions;
    private DayToDayHighwayAccepted dayToDayHighwayAccepted;
    private SalesAttribution salesAttribution;
    private SalesAssignment salesAssignment;
    private bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.ProductsAndServices productsAndServicesNonPersonal;
    private bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.CustomerName customerNameNonPersonal;
    private bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessAddress businessAddressMaintenanceNonPersonal;
    private bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.ContactInformation contactInformationMaintenanceNonPersonal;
    private bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessInformation businessInformationMaintenanceNonPersonal;
    private bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.LoanAdministration loanAdministrationMaintenanceNonPersonal;
    private AccessByAccountNumber accessByAccountNumber;
    private AccountProfile accountProfile;
    private AccountLink accountLink;
    private BusinessAccountProfile businessAccountProfile;

    private PageObjectManager() {

    }

    public BNSEmployeeLogin getBnsEmployeeLogin() {
        return bnsEmployeeLogin = new BNSEmployeeLogin(DriverManager.getDriver());
    }

    public OfficerContext getOfficerContext() {
        return officerContext = new OfficerContext(DriverManager.getDriver());

    }

    public FormIsNotSecure getFormisnotSecure() {
        return formnotSecure = new FormIsNotSecure(DriverManager.getDriver());
    }

    public Page1_ConcentToReceiptOfElectronicDocuments getPage1_concentToReceiptOfElectronicDocuments() {
        return page1_concentToReceiptOfElectronicDocuments = new Page1_ConcentToReceiptOfElectronicDocuments(DriverManager.getDriver());
    }

    public IntraLinkHomePage getIntralinkHomePage() {
        return intraLinkHomePage = new IntraLinkHomePage(DriverManager.getDriver());

    }

    public IntralinkHeader getIntralinkHeader() {
        return intralinkHeader = new IntralinkHeader(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.a6.IntralinkHeader getIntralinkHeaderLegacy() {
        return intralinkHeaderLegacy = new bns.a6.microui.web.pages.a6.IntralinkHeader(DriverManager.getDriver());

    }

    public CS4CustomerProductsAndServices getCS4ProductsAndServicesPersonal() {
        return cs4CustomerProductsAndServices = new CS4CustomerProductsAndServices(DriverManager.getDriver());

    }

    public CS2CustomerLocateOrSetup getCS2CustomerLocateOrSetup() {
        return cs2CustomerLocateOrSetup = new CS2CustomerLocateOrSetup(DriverManager.getDriver());

    }

    public ScotiaCardOrAccount getScotiaCardOrAccount() {
        return scotiaCardOrAccount = new ScotiaCardOrAccount(DriverManager.getDriver());

    }

    public NonPersonalCustomer getNonPersonalCustomer() {
        return nonPersonalCustomer = new NonPersonalCustomer(DriverManager.getDriver());

    }

    public BusinessAddress getBusinessAddress() {
        return businessAddress = new BusinessAddress(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.ContactInformation getContactInformationNonPersonal() {
        return contactInformationNonPersonal = new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerCreate.ContactInformation(DriverManager.getDriver());

    }

    public PersonalCustomerName getPersonalCustomerName() {
        return personalCustomerName = new PersonalCustomerName(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.pagecomponents.create.nonpersonal.Header getHeaderNonPersonal() {
        return headerMaintenance = new bns.a6.microui.web.pages.bgx4.pagecomponents.create.nonpersonal.Header(DriverManager.getDriver());

    }


    public Header getPersonalHeaderCreate() {
        return personalHeaderCreate = new Header(DriverManager.getDriver());

    }


    public bns.a6.microui.web.pages.bgx4.pagecomponents.maintenance.personal.Header getPersonalHeaderUpdate() {
        return personalHeaderUpdate = new bns.a6.microui.web.pages.bgx4.pagecomponents.maintenance.personal.Header(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.pagecomponents.create.involvedparty.Header getHeaderInvolvedParty() {
        return headerInvolvedParty = new bns.a6.microui.web.pages.bgx4.pagecomponents.create.involvedparty.Header(DriverManager.getDriver());

    }

    public PersonalInformation getPersonalInformationCreate() {
        return personalInformationCreate = new PersonalInformation(DriverManager.getDriver());

    }

    public AddressInformation getAddressInformationPersonal() {
        return addressInformation = new AddressInformation(DriverManager.getDriver());

    }


    public ContactInformation getContactInformationCreate() {
        return contactInformationPersonalCreate = new
                ContactInformation(DriverManager.getDriver());

    }

    public Identification getIdentificationCreate() {
        return identificationCreate = new
                Identification(DriverManager.getDriver());

    }

    public EmploymentAndIncome getEmploymentAndIncomeCreate() {
        return employmentAndIncomeCreate = new
                EmploymentAndIncome(DriverManager.getDriver());

    }


    public MulticulturalInformation getMultiCulturalInformationCreate() {
        return multiculturalInformationCreate = new MulticulturalInformation(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.ResidenceInformation getResidenceInformationCreate() {
        return residenceInformationCreate = new bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerCreate.ResidenceInformation(DriverManager.getDriver());

    }

    public CISCentre getCISCentre() {
        return cisCentre = new CISCentre(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.accounttocustomersummary.
            ExistingCustomerLinkedToAccount getExistingCutomersLinkToAccount() {
        return existingCustomerLinkedToAccount = new bns.a6.microui.web.pages.accounttocustomersummary.ExistingCustomerLinkedToAccount(DriverManager.getDriver());

    }

    public AccountProfileMaintenaceFooter getAccountProfileMaintenaceFooter() {
        return accountProfileMaintenanceFooter = new AccountProfileMaintenaceFooter(DriverManager.getDriver());

    }

    public AccountToSummaryFooter getAccountToSummaryFooter() {
        return accountToSummaryFooter = new AccountToSummaryFooter(DriverManager.getDriver());

    }

    public BusinessInformation getBusinessInformation() {
        return businessInformation = new BusinessInformation(DriverManager.getDriver());

    }


    public LoanAdministration getLoanAdministrationCreatePersonal() {
        return loanAdministrationCreatePersonal = new LoanAdministration(DriverManager.getDriver());

    }

    public CustomerRelationship getCustomerRelationship() {
        return customerRelationship = new CustomerRelationship(DriverManager.getDriver());

    }


    public Footer getFooter() {
        return footer = new Footer(DriverManager.getDriver());

    }

    public PopUps getPopUps() {
        return popUps = new PopUps(DriverManager.getDriver());

    }

    public CustomerSelection getCustomerSelection() {
        return customerSelection = new CustomerSelection(DriverManager.getDriver());

    }

    public ProductsAndServices getProductsAndServicesPersonal() {
        return productsAndServicesPersonal = new ProductsAndServices(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.ProductsAndServices getProductsAndServicesNonPersonal() {
        return productsAndServicesNonPersonal = new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.ProductsAndServices(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.parentorguardian.PersonalCustomerName getPersonalCustomerNameInvolvedParty() {
        return personalCustomerNameInvolvedParty = new bns.a6.microui.web.pages.bgx4.parentorguardian.PersonalCustomerName(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.parentorguardian.CustomerFound getCustomerFoundInvolvedParty() {
        return customerFound = new bns.a6.microui.web.pages.bgx4.parentorguardian.CustomerFound(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian.PersonalInformation getPersonalInformationInvolvedParty() {
        return personalInformationInvolvedParty = new bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian.PersonalInformation(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian.AddressInformation getAddressInformationInvolvedParty() {
        return addressInformationInvolvedParty = new bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian.AddressInformation(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian.Employment getEmployment() {
        return employmentInvolvedParty = new bns.a6.microui.web.pages.bgx4.parentorguardian.involvedpartyinformationsetupforparentorguardian.Employment(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.parentorguardian.PopUps getPopUpsInvolvedParty() {
        return popUpsInvolvedParty = new bns.a6.microui.web.pages.bgx4.parentorguardian.PopUps(DriverManager.getDriver());

    }

    public AccountSetup getAccountSetup() {
        return accountSetup = new AccountSetup(DriverManager.getDriver());

    }

    public SavingsAccountNumber getSavingsAccountNumber() {
        return savingsAccountNumber = new SavingsAccountNumber(DriverManager.getDriver());

    }

    public DDAAccountNumbers getDDAAccountNumber() {
        return ddaAccountNumbers = new DDAAccountNumbers(DriverManager.getDriver());

    }

    public ScotiaCardAccountNumbers getScotiaCardAccountNumber() {
        return scotiaCardAccountNumbers = new ScotiaCardAccountNumbers(DriverManager.getDriver());

    }

    public AccountMaintenance getAccountMaintenance() {
        return accountMaintenance = new AccountMaintenance(DriverManager.getDriver());

    }

    public CustomerToAccountRelationship getCustomerToAccountRelationship() {
        return customerToAccountRelationship = new CustomerToAccountRelationship(DriverManager.getDriver());

    }

    public DayToDayHighwayOwnership getDayToDayHighwayOwnership() {
        return dayToDayHighwayOwnership = new DayToDayHighwayOwnership(DriverManager.getDriver());

    }

    public AA3aSetupNewScotiaCard getAA3ASetupNewScotiaCard() {
        return aa3aSetupNewScotiacard = new AA3aSetupNewScotiaCard(DriverManager.getDriver());

    }

    public AA3aAccountAccessChanges getAA3AAccountAccessChanges() {
        return aa3aAccountAccessChanges = new AA3aAccountAccessChanges(DriverManager.getDriver());

    }

    public PrintChoices getPrintChoices() {
        return printChoices = new PrintChoices(DriverManager.getDriver());

    }

    public AA1AccountAdministration getAA1AccountAdministration() {
        return aa1AccountAdministration = new AA1AccountAdministration(DriverManager.getDriver());

    }

    public DayToDayHighwayOptions getDayToDayHighwayOptions() {
        return dayToDayHighwayOptions = new DayToDayHighwayOptions(DriverManager.getDriver());

    }

    public DayToDayHighwayAccepted getDayToDayHighwayAccepted() {
        return dayToDayHighwayAccepted = new DayToDayHighwayAccepted(DriverManager.getDriver());
    }

    public SalesAttribution getSalesAttribution() {
        return salesAttribution = new SalesAttribution(DriverManager.getDriver());
    }

    public SalesAssignment getSalesAssignment() {
        return salesAssignment = new SalesAssignment(DriverManager.getDriver());
    }

    public BusinessAccountOpenOwnership getBusinessAccountOpenOwnership() {
        return businessAccountOpenOwnership = new BusinessAccountOpenOwnership(DriverManager.getDriver());

    }

    public BusinessAccountOpenOptionsI getBusinessAccountOpenOptions1() {
        return businessAccountOpenOptionsI = new BusinessAccountOpenOptionsI(DriverManager.getDriver());

    }

    public BusinessAccountOpenOptionsII getBusinessAccountOpenOptions2() {
        return businessAccountOpenOptionsII = new BusinessAccountOpenOptionsII(DriverManager.getDriver());

    }

    public BusinessAccountOpenConfirmation getBusinessAccountOpenConfirmation() {
        return businessAccountOpenConfirmation = new BusinessAccountOpenConfirmation(DriverManager.getDriver());

    }

    public CustomerInformation getCustomerInformation() {
        return customerInformation = new CustomerInformation(DriverManager.getDriver());

    }


    public bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.CustomerInformation getCustomerInformationNonPersonal() {
        return customerInformationnp = new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.CustomerInformation(DriverManager.getDriver());

    }

    public CustomerPreferences getCustomerPreferences() {
        return customerPreferences = new CustomerPreferences(DriverManager.getDriver());

    }

    public ReviewProfile getReviewProfile() {
        return reviewProfile = new ReviewProfile(DriverManager.getDriver());
    }

    public HB100CreditBureauRequest getHB100CreditBureauRequest() {
        return hb100CreditBureauRequest = new HB100CreditBureauRequest(DriverManager.getDriver());
    }

    public ReviewResidentialAddress getReviewResidentialAddress() {
        return reviewResidentialAddress = new ReviewResidentialAddress(DriverManager.getDriver());
    }

    public ReviewEmploymentInformation getReviewEmploymentInformation() {
        return reviewEmploymentInformation = new ReviewEmploymentInformation(DriverManager.getDriver());
    }

    public ReviewAccountIntendedUseInformation getReviewAccountIntendedUseInformation() {
        return reviewAccountIntendedUseInformation = new ReviewAccountIntendedUseInformation(DriverManager.getDriver());
    }

    public FATCA getFATCA() {
        return fatca = new FATCA(DriverManager.getDriver());

    }

    public Preferences getPreferences() {
        return preferences = new Preferences(DriverManager.getDriver());

    }

    public CustomerName getCustomerNamePersonal() {
        return customerNamePersonal = new CustomerName(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.PersonalInformation getPersonalInformationUpdate() {
        return personalInformationUpdate = new bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.PersonalInformation(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.AddressInformation getAddressInformationUpdate() {
        return addressInformationUpdate = new bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.AddressInformation(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerinquiry.AddressInformation getAddressInformationInquiry() {
        return addressInformationInquiry = new bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerinquiry.AddressInformation(DriverManager.getDriver());

    }

    public ResidenceInformation getResidenceInformationUpdate() {
        return residenceInformationUpdate = new ResidenceInformation(DriverManager.getDriver());
    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.ContactInformation getContactInformationUpdate() {
        return contactInformationPersonalUpdate = new
                bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.ContactInformation(DriverManager.getDriver());

    }

    public MotherMaidenName getMothersMaidenName() {
        return motherMaidenName = new
                MotherMaidenName(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.EmploymentAndIncome getEmploymentAndIncomeUpdate() {
        return employmentAndIncomeUpdate = new
                bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.EmploymentAndIncome(DriverManager.getDriver());

    }


    public bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.Identification getIdentificationUpdate() {
        return identificationPersonalUpdate = new
                bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.Identification(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.MulticulturalInformation getMulticulturalInformationUpdate() {
        return multiculturalInformationUpdate = new
                bns.a6.microui.web.pages.bgx4.customerInformation.personal.customerMaintenance.customerInformation.MulticulturalInformation(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.CustomerName getCustomerNameNonPersonal() {
        return customerNameNonPersonal = new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.CustomerName(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessAddress getBusinessAddressMaintenanceNonPersonal() {
        return businessAddressMaintenanceNonPersonal = new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessAddress(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.ContactInformation getContactInformationMaintenanceNonPersonal() {
        return contactInformationMaintenanceNonPersonal = new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.ContactInformation(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessInformation getBusinessInformationMaintenanceNonPersonal() {
        return businessInformationMaintenanceNonPersonal = new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.BusinessInformation(DriverManager.getDriver());

    }

    public bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.LoanAdministration getLoanAdministrationMaintenanceNonPersonal() {
        return loanAdministrationMaintenanceNonPersonal = new bns.a6.microui.web.pages.bgx4.customerInformation.nonpersonal.customerMaintenance.customerinformation.LoanAdministration(DriverManager.getDriver());

    }

    public AccessByAccountNumber getAccessByAccountNumber() {
        return accessByAccountNumber = new AccessByAccountNumber(DriverManager.getDriver());

    }

    public AccountProfile getAccountProfile() {
        return accountProfile = new AccountProfile(DriverManager.getDriver());
    }


    public BusinessAccountProfile getBusinessAccountProfile() {
        return businessAccountProfile = new BusinessAccountProfile(DriverManager.getDriver());

    }

    public AccountLink getAccountLink() {
        return accountLink = new AccountLink(DriverManager.getDriver());

    }

    public static synchronized PageObjectManager getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new PageObjectManager();
        }
        return INSTANCE;
    }

}
