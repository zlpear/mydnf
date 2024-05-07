package org.zwj.mydnf.service.career.impl;

import org.springframework.stereotype.Service;
import org.zwj.mydnf.enums.CareerEnum;
import org.zwj.mydnf.service.career.ICareerService;
import org.zwj.mydnf.vo.career.CareerVo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CareerServiceImpl implements ICareerService {

    @Override
    public List<CareerVo> getCareerList() {
        return Arrays.stream(CareerEnum.values()).filter(CareerEnum::isParent).map(careerEnum ->
            CareerVo.builder()
                    .id(careerEnum.getId())
                    .name(careerEnum.getName())
                    .children(getChildren(careerEnum.getId()))
                    .build()
        ).collect(Collectors.toList());
    }

    private List<CareerVo> getChildren(Integer id) {
        return Arrays.stream(CareerEnum.values()).filter(careerEnum -> careerEnum.getParentId().equals(id)).map(careerEnum ->
                CareerVo.builder()
                        .id(careerEnum.getId())
                        .name(careerEnum.getName())
                        .build()
        ).collect(Collectors.toList());
    }

}
