package com.webup.soa.utils;

//import org.apache.log4j.Logger;

import java.io.*;
import java.util.Calendar;

/**
 * 文件IO相关的类
 *
 * @author denghua
 * @create 2017-08-29 14:55
 */
public class FileUtils {

    private FileUtils(){}

//    private static Logger log = Logger.getLogger(FileUtils.class);

    /**
     * 判断文件是否存在
     * @param filepath 文件保存路径
     * @return 存在返回true，不存在返回false
     */
    public static boolean isGenerated(String filepath){
        boolean flag = false;
        File sourceName = new File(filepath);
        long length = sourceName.length();
        if(length>0){
            flag = true;
        }
        return flag;
    }

    /**
     * 根据文件路径生成相应文件
     * @param fileName 待生成的文件名
     * @param suffix 待生成文件后缀
     * @param dirpath 待生成文件存储目录
     * @return 创建成功返回文件全路径名，失败返回""
     */
    public static String createFile(String fileName, String suffix, String dirpath){
        boolean flag = false;
        String filePath = dirpath + fileName + "." + suffix;//目录 + 文件名 + 文件后缀
        File dir = new File(dirpath);
        File file = new File(filePath);
        try{
            if(!dir.exists()){
                dir.mkdirs();
            }
            //文件不存在则创建新文件
            if(!file.exists()){
                file.createNewFile();
                flag = true;
            }
        }catch (Exception e){
//            log.error(e.getMessage());
        }
        return flag?filePath:"";
    }

    /**
     * 将内容写入相应文件中
     * @param filePath 文件全路径
     * @param content 文件内容
     * @return 写入结果 true为写入成功，false为写入失败
     */
    public static boolean writeFileContent(String filePath, String content){
        boolean flag = false;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            try {
                bos.write(content.getBytes("utf-8"));
                bos.flush();
                flag = true;
            } finally {
                bos.close();
                fos.close();
            }
        } catch (FileNotFoundException e) {
//            log.error(e.getMessage());
            flag = false;
        } catch (IOException e) {
//            log.error(e.getMessage());
            flag = false;
        }
        return flag;
    }
    /**
     * 使用PrintWriter往文件中写入字符串内容
     * @param filepath
     * @param content
     */
    public static boolean  fileWrite1(String filepath, String content) {
        boolean flag = false;
        try {
            PrintWriter printWriter = new PrintWriter(new File(filepath));
            try {
                printWriter.print(content);
                flag = true;
            }finally {
                printWriter.close();
            }
        } catch (FileNotFoundException e) {
            flag = false;
//            log.error(e.getMessage());
        }
        return flag;
    }

    /**
     * 使用OutputStreamWriter往文件写入字符串内容
     * @param filepath
     * @param content
     */
    public static boolean  fileWrite2(String filepath, String content) {
        boolean flag = false;
        try {
            FileOutputStream fos = new FileOutputStream(filepath);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
            try {
                osw.write(content);
                osw.flush();
                flag = true;
            }finally {
                osw.close();
                fos.close();
            }
        } catch (FileNotFoundException e) {
//            log.error(e.getMessage());
            flag = false;
        } catch (UnsupportedEncodingException e) {
//            log.error(e.getMessage());
            flag = false;
        } catch (IOException e) {
//            log.error(e.getMessage());
            flag = false;
        }
        return flag;
    }

    /**
     * 生成当前时间，以"/"分隔
     * @return 当前时间的字符串，型如：2017/2/3
     */
    public static String getStorageFolder() {
        Calendar cal = Calendar.getInstance();
        StringBuffer relativePath = new StringBuffer();
        relativePath.append(cal.get(Calendar.YEAR)).append(File.separator).append((cal.get(Calendar.MONTH) + 1)).append(File.separator)
                .append(cal.get(Calendar.DAY_OF_MONTH));
        return relativePath.toString();
    }

    /**
     * 将文件从一个目录移动到另一个目录
     * @param sourcePath 源文件所在的目录
     * @param fileName 源文件的文件名
     * @param targetPath 目录文件所在的目录
     * @return 移动是否成功，成功为true，失败为false
     */
    private static boolean moveFileToDir(String sourcePath, String fileName, String targetPath){
        boolean flag = false;
        try {
            File targetDir = new File(targetPath);
            if(!targetDir.exists()){
                targetDir.mkdirs();
//                log.info("目录文件夹" + targetDir + "创建成功!");
            }
//            log.info("目录文件夹" + targetDir + "已存在!");
            File sourceFile = new File(sourcePath + fileName);
            File targetFile = new File(targetPath + fileName);
            if(targetFile.exists() && targetFile.delete()){
//                log.info("文件存在，并已删除成功！");
            }
            flag = sourceFile.renameTo(targetFile);
            if(flag){
//                log.info("File is moved successful!");
            }else {
//                log.error("File is failed to move!");
            }
        } catch (Exception e) {
//            log.error("文件移动异常，异常信息为："+e.getMessage());
        }
        return flag;
    }

}
