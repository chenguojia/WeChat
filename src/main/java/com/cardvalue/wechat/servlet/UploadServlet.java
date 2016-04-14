package com.cardvalue.wechat.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

/**
 * 通用上传servlet
 */
public class UploadServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(UploadServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取项目名称
        String appName = "wechat";
        Properties prop = new Properties();
        InputStream is = this.getClass().getResourceAsStream("/environment.properties");
        try {
            prop.load(is);
            appName = prop.getProperty("wechat.app.name").trim();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //打印对象
        PrintWriter out = response.getWriter();
        //上传图片服务器访问路径
        //String servicePath = "http://220.248.19.21/" + appName + "/resources/image/upload/" + (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        String servicePath = "http://192.168.2.100:8080/wechat/resources/image/upload/" + (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        //判断提交过来的表单是否为文件上传
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            //构造一个文件上传处理对象
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            Iterator items;
            try {
                //解析表单中提交的所有文件内容
                items = upload.parseRequest(request).iterator();
                while (items.hasNext()) {
                    FileItem item = (FileItem) items.next();
                    if (!item.isFormField()) {
                        //取出上传文件的文件名称
                        String name = item.getName();
                        //取得上传文件以后的存储路径
                        String fileName = name.substring(name.lastIndexOf('\\') + 1, name.length());
                        //创建上传目录路径
                        String uploadPath = request.getSession().getServletContext().getRealPath("/") + "resources"+File.separator+"image"+File.separator+"upload" +File.separator + (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(new Date());//上传路径
                        File uploadPathFile = new File(uploadPath);
                        if (!uploadPathFile.exists()) uploadPathFile.mkdirs();
                        logger.info("上传目录创建成功，目录为:" + uploadPath);
                        //构建图片上传路径
                        String filePath = uploadPath + File.separator + fileName;

                        //上传文件
                        File uploaderFile = new File(filePath);
                        item.write(uploaderFile);
                        //打印上传成功信息
                        response.setContentType("text/html");
                        //response.setCharacterEncoding("GB2312");

                        //返回图片访问路径
                        String fileServicePath = servicePath + "/" + fileName;
                        System.out.println("文件路径为:" + fileServicePath);
                        logger.info("文件路径为:" + fileServicePath);
                        out.print(fileServicePath);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("上传出现错误:",e.getMessage());
                out.print(e.getMessage());
            }


        }
    }
}
