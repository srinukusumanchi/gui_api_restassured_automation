/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-13
 * Created Time: 4:57 p.m.
 */

package service.requests.bfbk.identification.personal.create;

import bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identificationinfo.Identification_info;
import bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identificationprofile.Identification_profile;
import bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identifications.Identification_source;
import bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identifications.Identifications;
import bns.a6.microui.api.pojo.bfbk.identification.personal.utility.Identification;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class IdentificationIndividualCreate {


    //     *********************************** Identifications ******************************************
    public String generateIdentificationCreateRequest(ResultSet resultset) throws SQLException, JsonProcessingException {

        //        Identification_Profile block
        Identification_profile identification_profile = new Identification_profile();
        identification_profile.setId_status(resultset.getString("id_status"));

        if (resultset.getString("established_by") != null) {
            identification_profile.setEstablished_by(resultset.getString("established_by"));
        }
        if (resultset.getString("guardianship_paper_filed") != null) {
            identification_profile.setGuardianship_paper_filed(resultset.getString("guardianship_paper_filed"));
        }
        if (resultset.getString("minor_signing_authority") != null) {
            identification_profile.setMinor_signing_authority(resultset.getString("minor_signing_authority"));
        }


//                identifications block
        Identifications identifications = new Identifications();
        identifications.setConfirmed_date(resultset.getString("confirmed_date"));
        identifications.setCountry_of_issue(resultset.getString("country_of_issue"));
        identifications.setProv_state_of_issue(resultset.getString("prov_state_of_issue"));
        identifications.setCaptured_date(resultset.getString("captured_date"));
        identifications.setIdentification_number(resultset.getString("identification_number"));
        identifications.setIdentification_type(resultset.getString("identification_type"));
        if (resultset.getString("expiry_date") != null) {
            identifications.setExpiry_date(resultset.getString("expiry_date"));
        }
        if (resultset.getString("place_of_birth") != null) {
            identifications.setPlace_of_birth(resultset.getString("place_of_birth"));
        }
        identifications.setSource_name(resultset.getString("source_name_identifications"));
        identifications.setSource_other_desc(resultset.getString("source_other_desc"));
        identifications.setSource_method(resultset.getString("source_method"));
        if (resultset.getString("parent_guardian_cid") != null) {
            identifications.setParent_guardian_cid(resultset.getString("parent_guardian_cid"));
        }


        //                Identification Source block
        Identification_source identification_source = new Identification_source();
        identification_source.setSource_provider(resultset.getString("source_provider"));
        if (resultset.getString("source_name_identification_source") != null) {
            identification_source.setSource_name(resultset.getString("source_name_identification_source"));
        }
        identification_source.setReference_id(resultset.getString("reference_id"));
        identification_source.setDetails(resultset.getString("details"));

        identifications.setIdentification_source(identification_source);

        List<Identifications> identificationsList = new LinkedList<>();
        identificationsList.add(identifications);

        //  identification_info block
        Identification_info identification_info = new Identification_info();
        identification_info.setIdentification_profile(identification_profile);
        identification_info.setIdentifications(identificationsList);


//        Mapper
        bns.a6.microui.api.pojo.bfbk.identification.personal.post.mapper.Mapper mapper = new bns.a6.microui.api.pojo.bfbk.identification.personal.post.mapper.Mapper();
        mapper.setIdentification_info(identification_info);
        mapper.setCustomer_id(resultset.getString("customer_id"));

        Identification identification = new Identification();
        return identification.getIdentificationRequest(mapper);

    }
}
