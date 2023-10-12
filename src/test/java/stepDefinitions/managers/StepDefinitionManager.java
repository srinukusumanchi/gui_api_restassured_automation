/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-11-28
 * Created Time: 9:07 p.m.
 */

package stepDefinitions.managers;

import stepDefinitions.web.a6.ProductsAndServices;
import stepDefinitions.web.accountmaintenance.AccountMaintenance;
import stepDefinitions.web.accountsetup.BusinessAccountWithoutCreditBureau;
import stepDefinitions.web.customerlocateorsetup.CustomerLocateOrSetup;
import stepDefinitions.web.intralink.BNSEmployeeApplicationAccessSteps;
import stepDefinitions.web.involvedparty.InvolvedParty;
import stepDefinitions.web.personal.customerinformation.PersonalCustomer;

import java.util.Objects;

public final class StepDefinitionManager {
    private static StepDefinitionManager INSTANCE = null;

    private PersonalCustomer personalCustomer;
    private stepDefinitions.web.customerlocateorsetup.CustomerLocateOrSetup customerLocateOrSetup;
    private BNSEmployeeApplicationAccessSteps bnsEmployeeApplicationAccessSteps;
    private InvolvedParty involvedParty;
    private ProductsAndServices cs4ProductsAndServices;
    private AccountMaintenance accountMaintenance;
    private BusinessAccountWithoutCreditBureau businessAccountWithoutCreditBureau;
    public PersonalCustomer getPersonalCustomer() {
        return personalCustomer == null ?
                personalCustomer = new PersonalCustomer()
                : personalCustomer;
    }

    public CustomerLocateOrSetup getCustomerLocateOrSetup() {
        return customerLocateOrSetup == null ?
                customerLocateOrSetup = new stepDefinitions.web.customerlocateorsetup.CustomerLocateOrSetup()
                : customerLocateOrSetup;
    }

    public BNSEmployeeApplicationAccessSteps getBNSEmployeeApplicationAccessSteps() {
        return bnsEmployeeApplicationAccessSteps == null ?
                bnsEmployeeApplicationAccessSteps = new BNSEmployeeApplicationAccessSteps()
                : bnsEmployeeApplicationAccessSteps;
    }

    public InvolvedParty getInvolvedParty() {
        return involvedParty == null ?
                involvedParty = new InvolvedParty()
                : involvedParty;
    }

    public ProductsAndServices getCs4ProductsAndServices() {
        return cs4ProductsAndServices == null ?
                cs4ProductsAndServices = new ProductsAndServices()
                : cs4ProductsAndServices;
    }

    public AccountMaintenance getAccountMaintenance() {
        return accountMaintenance == null ?
                accountMaintenance = new AccountMaintenance()
                : accountMaintenance;
    }

    public BusinessAccountWithoutCreditBureau getBusinessAccountWithoutCreditBureau() {
        return businessAccountWithoutCreditBureau == null ?
                businessAccountWithoutCreditBureau = new BusinessAccountWithoutCreditBureau()
                : businessAccountWithoutCreditBureau;
    }

    public static synchronized StepDefinitionManager getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new StepDefinitionManager();
        }
        return INSTANCE;
    }
}
