/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-04
 * Created Time: 2:13 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identifications;

public class Identification_source {

    private String source_provider;
    private String source_name;
    private String reference_id;
    private String details;


    public String getSource_provider() {
        return source_provider;
    }

    public void setSource_provider(String source_provider) {
        this.source_provider = source_provider;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getReference_id() {
        return reference_id;
    }

    public void setReference_id(String reference_id) {
        this.reference_id = reference_id;
    }


}
