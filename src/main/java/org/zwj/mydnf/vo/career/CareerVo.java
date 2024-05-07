package org.zwj.mydnf.vo.career;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CareerVo {

    private Integer id;
    private String name;
    private List<CareerVo> children;

}
