package com.webup.soa.web;

import com.webup.soa.utils.ValidatorUtil;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

/**
 * @author: xiaobei
 * @createTime: 2017-10-10 20:31
 * @since: JDK 1.5
 * @description: 文件下载Controller
 */
@Controller
@RequestMapping("common")
public class FileDownloadController {

//    private static Logger log = Logger.getLogger(FileDownloadController.class);

    @RequestMapping(value="downloadfile")
    public String downloadFile(String downloadUrl, String realFileName,String typeId, HttpServletRequest request, HttpServletResponse response) {
        try {
            if(null==downloadUrl) {
                return null;
            }
            boolean isBeginUploadFile = downloadUrl.toLowerCase().startsWith("/uploadfile");
            if(!isBeginUploadFile){
                return null;
            }
            if(ValidatorUtil.isEmpty(realFileName)){
                realFileName="文件";
            }
            realFileName = URLDecoder.decode(realFileName,"UTF-8");
//            log.info("下载文件的名称为："+realFileName);
            //获取当前请求的URL地址http://localhost:8080/api/downloadfile
            StringBuffer requestURL = request.getRequestURL();
//            log.info("访问当前接口的url为："+requestURL);
            String urlHead = requestURL.toString().split("api")[0];
            if(null!=typeId){
                String[] urlHeads = requestURL.toString().split(":");
                urlHead=urlHeads[0]+":"+urlHeads[1]+"/";
            }
            if(downloadUrl.startsWith("/")){
                downloadUrl=downloadUrl.substring(1);
            }
            String downLoadPath = urlHead + downloadUrl;

            response.setContentType("application/octet-stream");
            response.reset();//清除response中的缓存
            //根据网络文件地址创建URL
            URL url = new URL(downLoadPath);
//            log.info("网络文件的地址为："+url);
            //获取此路径的连接
            URLConnection conn = url.openConnection();
//            Long fileLength = conn.getContentLengthLong();//获取文件大小
            int fileLength = conn.getContentLength();//.getContentLengthLong();//获取文件大小
            //设置reponse响应头，真实文件名重命名，就是在这里设置，设置编码
            response.setHeader("Content-disposition", "attachment; filename=" + new String(realFileName.getBytes("utf-8"), "ISO8859-1"));
            response.setHeader("Content-Length", String.valueOf(fileLength));
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());//构造读取流
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());//构造输出流
            byte[] buff = new byte[1024];
            int bytesRead;
            //每次读取缓存大小的流，写到输出流
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            response.flushBuffer();//将所有的读取的流返回给客户端
            bis.close();
            bos.close();
//            log.info("文件下载成功");

        } catch (IOException e) {
//            log.error("下载出现异常："+e.getMessage());
        }
        return null;
    }

}
