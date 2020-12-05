package cn.kgc.smbms.service.impl;

import cn.kgc.smbms.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Service("fileService")
public class FileServiceImpl implements FileService {
    @Override
    public String fileUpload(MultipartFile file,String path){
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        String suffixName =
                originalFilename.substring(originalFilename.lastIndexOf('.')+1,
                originalFilename.length());
        //todo 这里可以根据业务需求来判断相应的后缀名
        if (! suffixName.equals("jpg")){
            return "文件后缀不符合标准";
        }
        //给文件一个新的名字
        String newName = UUID.randomUUID().toString() + "." +suffixName;
        //准备上传
        File uploadFilePath = new File(path);
        //验证上传地址是否存在
        if (! uploadFilePath.exists()){
            //在任何系统中获取最高写入权限
            uploadFilePath.setWritable(true);
            //创建
            uploadFilePath.mkdirs();
        }
        File upload = new File(path , newName);
        try {
            //将文件上传至，tomcat服务器
            file.transferTo(upload);
            //todo 调用文件服务器，将文件上传

            //todo 获取是否成功

            //todo 删除tomcat服务器中文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return upload.getPath();
    }
}
