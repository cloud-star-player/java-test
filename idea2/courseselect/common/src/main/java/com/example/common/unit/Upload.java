package com.example.common.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
/**
 * @author ：huangwei
 * @date ：Created in 2020/4/19 18:28
 */
@Data
public class Upload implements Serializable {
    /**
     * 定义jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * 响应业务状态
     */
    private Integer status;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 文件名称
     */
    private String path;

    public static Upload build(Integer status, String msg) {
        return new Upload(status,msg);
    }   //报异常使用


    public static Upload ok(String path) {                 //无异常使用
        return new Upload(path);
    }

    public static Upload ok() {                 //无异常使用
        return new Upload();
    }
    public Upload(Integer status,String msg){
        this.status=status;
        this.msg=msg;
    }
    public Upload(String path){
        this.status=200;
        this.msg="没有问题";
        this.path=path;
    }
    public Upload(){
        this.status=200;
        this.msg="没有问题";
        this.path= "";
    }

    public static Upload read(HttpServletResponse response,String picName) {
        try {
            String filePath="";
            String suffix = picName.substring(picName.lastIndexOf(".") + 1); //获取后缀
            if(suffix.equals("png")||suffix.equals("PNG")||suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("gif")||suffix.equals("GIF")){
                filePath = "E:\\upload/image/";               //设置读取文件路径
            }
            else{
                return build(500,"不支持文件类型");   //不是相应的后缀直接返回
            }
            String imagePath = filePath + picName;
            response.reset();
            //判断文件是否存在
            File file = new File(imagePath);
            if (!file.exists()) {
                imagePath = filePath + picName;
            }

            FileInputStream is = new FileInputStream(new File(imagePath));
            int i = is.available(); // 得到文件大小
            byte data[] = new byte[i];
            is.read(data); // 读数据
            is.close();
            if(suffix.equals("png")||suffix.equals("PNG")||suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("gif")||suffix.equals("GIF")){
                response.setContentType("image/*");  // 设置返回的文件类型
            }
            OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
            toClient.write(data); // 输出数据
            toClient.close();
            return ok();
        }catch (IOException e){                   //不加会IOException e报错
            return build(500,"可能报错");
        }
    }

    public static Upload uploads(HttpServletResponse response,MultipartFile picName){
        try {
            String filePath="";
            String picNames = picName.getOriginalFilename();
            String suffix = picNames.substring(picNames.lastIndexOf(".") + 1); //获取后缀
            if(suffix.equals("png")||suffix.equals("PNG")||suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("gif")||suffix.equals("GIF")){
                filePath = "E:\\upload/image/";               //设置读取文件路径
            }
            System.out.println(picNames);              //设置读取文件路径
            File filepath = new File(filePath);
            if(!filepath.exists()) {
                filepath.mkdirs();
            }
            String paths= UUID.randomUUID() + picNames;   //得到文件名
            System.out.println(paths);
            File targetFile1 = new File(filePath, paths);
            picName.transferTo(targetFile1);   //文件上传到filePath+paths指定的路径
            return ok(paths);
        }catch (IOException e){
            return build(500,"可能报错");
        }
    }
}
