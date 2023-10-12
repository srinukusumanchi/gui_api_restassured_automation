/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-06-22
 * Created Time: 8:09 a.m.
 */

package service.requests.bfbk.intentofuse.update;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.requests.bfbk.intentofuse.create.IntentOfUseCreate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntentOfUseUpdate extends IntentOfUseCreate {

    //     *********************************** Intent of Use Customer level ******************************************
    public String generateIntentOfUseUpdateRequest(ResultSet resultset) throws SQLException, JsonProcessingException {
        return super.generateIntentOfUseCreateRequest(resultset);
    }
}
