/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-05
 * Created Time: 6:57 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.employment.mapper.post;

import bns.a6.microui.api.pojo.bfbk.employment.services.post.Employments;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Mapper {

    private String customer_id;
    private List<Employments> employments;
//    private Employments employments;
}
