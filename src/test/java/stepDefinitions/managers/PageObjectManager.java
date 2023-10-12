/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-13
 * Created Time: 2:13 p.m.
 */

package stepDefinitions.managers;

import service.requests.bf9k.customerlookup.inquiry.CustomerLookUpGet;
import service.requests.bf9k.customersearch.inquiry.CustomerSearchUsingGet;
import service.requests.bfbk.customerprofileservice.contactmethod.update.ContactMethodUpdate;
import service.requests.bfbk.customerprofileservice.individual.create.CustomerProfileIndividualCreate;
import service.requests.bfbk.customerprofileservice.individual.inquiry.CustomerProfileIndividualInquiry;
import service.requests.bfbk.customerprofileservice.individual.update.CustomerProfileIndividualUpdate;
import service.requests.bfbk.customerprofileservice.institution.create.CustomerProfileInstitutionCreate;
import service.requests.bfbk.customertoaccountrelationship.create.CustomerToAccountRelationshipCreate;
import service.requests.bfbk.customertoaccountrelationship.delete.CustomerToAccountRelationshipDelete;
import service.requests.bfbk.customertoaccountrelationship.inquiry.CustomerToAccountRelationshipGet;
import service.requests.bfbk.customertoaccountrelationship.update.CustomerToAccountRelationshipUpdate;
import service.requests.bfbk.employment.create.EmploymentCreate;
import service.requests.bfbk.employment.update.EmploymentUpdate;
import service.requests.bfbk.identification.personal.create.IdentificationIndividualCreate;
import service.requests.bfbk.identification.personal.update.IdentificationIndividualUpdate;
import service.requests.bfbk.intentofuse.create.IntentOfUseCreate;
import service.requests.bfbk.intentofuse.inquiry.IntentOfUseInquiry;
import service.requests.bfbk.intentofuse.update.IntentOfUseUpdate;
import service.requests.bfqj.accountprofile.create.AccountProfileCreate;
import service.requests.bfqj.accountprofile.inquiry.AccountProfileGet;
import service.requests.bfqj.accountprofile.update.AccountProfileUpdate;

import java.util.Objects;

public class PageObjectManager {

    private static PageObjectManager INSTANCE = null;

    private CustomerProfileIndividualCreate customerProfileIndividualCreate;
    private CustomerProfileIndividualUpdate customerProfileIndividualUpdate;
    private CustomerProfileIndividualInquiry customerProfileIndividualInquiry;
    private CustomerProfileInstitutionCreate customerProfileInstitutionCreate;
    private ContactMethodUpdate contactMethodUpdate;
    private CustomerSearchUsingGet customerSearchUsingGet;
    private AccountProfileGet accountProfileGet;
    private AccountProfileCreate accountProfileCreate;
    private AccountProfileUpdate accountProfileUpdate;
    private CustomerToAccountRelationshipGet customerToAccountRelationshipGet;
    private CustomerToAccountRelationshipCreate customerToAccountRelationshipCreate;
    private CustomerToAccountRelationshipUpdate customerToAccountRelationshipUpdate;
    private CustomerToAccountRelationshipDelete customerToAccountRelationshipDelete;
    private CustomerLookUpGet customerLookUpGet;
    private IdentificationIndividualCreate identificationIndividualCreate;
    private IdentificationIndividualUpdate identificationIndividualUpdate;
    private EmploymentCreate employmentCreate;
    private EmploymentUpdate employmentUpdate;
    private IntentOfUseUpdate intentOfUseUpdate;
    private IntentOfUseInquiry intentOfUseInquiry;
    private IntentOfUseCreate intentOfUseCreate;

    private PageObjectManager() {

    }

    //    Customer Profile - Personal
    public CustomerProfileIndividualCreate getCustomerProfileIndividualCreate() {
        return customerProfileIndividualCreate = new CustomerProfileIndividualCreate();
    }

    public CustomerProfileIndividualUpdate getCustomerProfileIndividualUpdate() {
        return customerProfileIndividualUpdate = new CustomerProfileIndividualUpdate();
    }

    public CustomerProfileIndividualInquiry getCustomerProfileIndividualInquiry() {
        return customerProfileIndividualInquiry = new CustomerProfileIndividualInquiry();
    }

    //    Customer Profile - Non-Personal
    public CustomerProfileInstitutionCreate getCustomerProfileInstitutionCreate() {
        return customerProfileInstitutionCreate = new CustomerProfileInstitutionCreate();
    }

    //  ---End of  Customer Profile---

    public ContactMethodUpdate getCustomerProfileContactMethodUpdate() {
        return contactMethodUpdate = new ContactMethodUpdate();
    }

    public CustomerSearchUsingGet getCustomerSearchUsingAccountGet() {
        return customerSearchUsingGet = new CustomerSearchUsingGet();
    }

    public AccountProfileGet getAccountProfileGet() {
        return accountProfileGet = new AccountProfileGet();
    }

    public CustomerToAccountRelationshipGet getCustomerRelatiionShipGet() {
        return customerToAccountRelationshipGet = new CustomerToAccountRelationshipGet();
    }

    public CustomerToAccountRelationshipCreate getCustomerRelationShipCreate() {
        return customerToAccountRelationshipCreate = new CustomerToAccountRelationshipCreate();
    }

    public CustomerToAccountRelationshipUpdate getCustomerRelationShipUpdate() {
        return customerToAccountRelationshipUpdate = new CustomerToAccountRelationshipUpdate();
    }

    public CustomerToAccountRelationshipDelete getCustomerRelationShipDelete() {
        return customerToAccountRelationshipDelete = new CustomerToAccountRelationshipDelete();
    }

    public CustomerLookUpGet getCustomerLookUpGet() {
        return customerLookUpGet = new CustomerLookUpGet();
    }

    public IdentificationIndividualCreate getIdentificationIndividualCreate() {
        return identificationIndividualCreate = new IdentificationIndividualCreate();
    }

    public IdentificationIndividualUpdate getIdentificationIndividualUpdate() {
        return identificationIndividualUpdate = new IdentificationIndividualUpdate();
    }

    public EmploymentCreate getEmploymentCreate() {
        return employmentCreate = new EmploymentCreate();
    }

    public EmploymentUpdate getEmploymentUpdate() {
        return employmentUpdate = new EmploymentUpdate();
    }

    public IntentOfUseCreate getIntentOfUseCreate() {
        return intentOfUseCreate = new IntentOfUseCreate();
    }

    public IntentOfUseUpdate getIntentOfUseUpdate() {
        return intentOfUseUpdate = new IntentOfUseUpdate();
    }

    public AccountProfileCreate getAccountProfileCreate() {
        return accountProfileCreate = new AccountProfileCreate();
    }

    public AccountProfileUpdate getAccountProfileUpdate() {
        return accountProfileUpdate = new AccountProfileUpdate();
    }


    public IntentOfUseInquiry getIntentOfUseInquiry() {
        return intentOfUseInquiry = new IntentOfUseInquiry();
    }

    public static synchronized PageObjectManager getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new PageObjectManager();
        }
        return INSTANCE;
    }

}
