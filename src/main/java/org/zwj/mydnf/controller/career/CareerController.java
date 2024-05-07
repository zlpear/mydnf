package org.zwj.mydnf.controller.career;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zwj.mydnf.service.career.ICareerService;
import org.zwj.mydnf.vo.ResultVO;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/career")
public class CareerController {

    @Autowired
    private ICareerService careerService;

    @GetMapping("/")
    public ResultVO<?> getCareerList() {
        return ResultVO.success(careerService.getCareerList());
    }

}
