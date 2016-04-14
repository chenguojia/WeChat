package com.cardvalue.wechat.web;

import com.cardvalue.wechat.dto.UploadFileModel;
import com.cardvalue.wechat.util.RestfulResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;

/**
 * 通用上传Controller
 * Created by Mr tao on 2015/5/28.
 */
@Controller
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Value("${upload.image.visit.url}")
    private String uploadImageVisitUrl;

    /**
     * 上传BAESE64图片
     *
     * @param imageBase64 图片被压缩的base64
     * @param imageName   图片名称
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult upload(String imageBase64, String imageName, HttpServletRequest request) throws IOException {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        if (StringUtils.isBlank(imageBase64)) {
            result.setResultMsg("图片为空，上传失败!");
            return result;
        }
        logger.info("客户端上传图片的base64为：" + imageBase64);
        //重新命名上传的文件以免重复替换
        imageName =  new Date().getTime() + "-" + imageName;
        //图片最终通过浏览器访问目录URL
        String servicePath = uploadImageVisitUrl + (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        //构建上传到本地目录
        String uploadPath = request.getSession().getServletContext().getRealPath("/") + "resources" + File.separator + "image" + File.separator + "upload" + File.separator + (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date());//上传路径
        //如果本地不存在上传的目录则创建
        File uploadPathFile = new File(uploadPath);
        if (!uploadPathFile.exists()) uploadPathFile.mkdirs();
        //构建上传到本地图片绝对路径
        String filePath = uploadPath + File.separator + imageName;

        //解码BASE64图片并上传
        if (GenerateImage(imageBase64, filePath)) {
            //上传成功
            //服务器访问图片URL
            String fileServicePath = servicePath + "/" + imageName;
            //获取上传到本地的图片
            File localImageFile = new File(filePath);
            BufferedImage localImage = ImageIO.read(new FileInputStream(localImageFile));
            //构建返回文件对象json
            UploadFileModel file = new UploadFileModel(fileServicePath, imageName, imageName.substring(imageName.lastIndexOf(".")), localImage.getWidth(), localImage.getHeight(), localImageFile.length() / 1024.0);
            //设置返回对象及参数
            result.setResultData(file);
            result.setResultCode("1");
            result.setResultMsg("文件上传成功!");
            //打印日志
            logger.info("文件本地上传路径为:" + filePath);
            logger.info("文件网络访问路径为:" + fileServicePath);
        }
        return result;
    }

    /**
     * 将BASE64转换成图片
     *
     * @param imgStr
     * @param imgFilePath
     * @return
     */
    public static boolean GenerateImage(String imgStr, String imgFilePath) {
        if (imgStr == null) return false;//图像数据为空
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(imgStr);  //Base64解码
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            logger.error("客户端上传base64图片解析失败:" + e.getMessage());
            return false;
        }
    }

}
