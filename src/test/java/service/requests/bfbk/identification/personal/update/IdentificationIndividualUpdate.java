/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-13
 * Created Time: 4:57 p.m.
 */

package service.requests.bfbk.identification.personal.update;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.requests.bfbk.identification.personal.create.IdentificationIndividualCreate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IdentificationIndividualUpdate extends IdentificationIndividualCreate {


    //     *********************************** Identifications ******************************************
    public String generateIdentificationUpdateRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        return super.generateIdentificationCreateRequest(resultset);
    }
}
