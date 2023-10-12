/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-04
 * Created Time: 4:29 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identificationinfo;

import bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identificationprofile.Identification_profile;
import bns.a6.microui.api.pojo.bfbk.identification.personal.services.post.identifications.Identifications;

import java.util.List;


public class Identification_info {


    private Identification_profile identification_profile;
    private List<Identifications> identifications;

    public Identification_profile getIdentification_profile() {
        return identification_profile;
    }

    public void setIdentification_profile(Identification_profile identification_profile) {
        this.identification_profile = identification_profile;
    }

    public List<Identifications> getIdentifications() {
        return identifications;
    }

    public void setIdentifications(List<Identifications> identifications) {
        this.identifications = identifications;
    }
}
