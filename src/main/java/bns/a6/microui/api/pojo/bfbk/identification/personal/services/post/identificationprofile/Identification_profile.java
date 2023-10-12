/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-04
 * Created Time: 1:06 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identificationprofile;

public class Identification_profile {


    private String id_status;
    private String established_by;
    private String guardianship_paper_filed;
    private String minor_signing_authority;



    public String getId_status() {
        return id_status;
    }

    public void setId_status(String id_status) {
        this.id_status = id_status;
    }

    public String getEstablished_by() {
        return established_by;
    }

    public void setEstablished_by(String established_by) {
        this.established_by = established_by;
    }

    public String getGuardianship_paper_filed() {
        return guardianship_paper_filed;
    }

    public void setGuardianship_paper_filed(String guardianship_paper_filed) {
        this.guardianship_paper_filed = guardianship_paper_filed;
    }

    public String getMinor_signing_authority() {
        return minor_signing_authority;
    }

    public void setMinor_signing_authority(String minor_signing_authority) {
        this.minor_signing_authority = minor_signing_authority;
    }



}
