package com.huluohu.learning.springmvc.controller.demo3;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by huluohu on 2016/5/18.
 */
@Controller
@RequestMapping("/upload/")
public class UploadController {

    @RequestMapping("start")
    @ResponseBody
    public String doUpload(MultipartFile file){
        try {
            FileUtils.writeByteArrayToFile(new File("g:/upload/" + file.getOriginalFilename()),file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
