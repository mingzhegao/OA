package com.turing.framework.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
/**
 * 用于文件的上传和删除
 * @author 石洪刚
 *
 */
public class FileUtils {
	/**
	 * 文件上传，保存在本地硬盘，返回文件请求路径
	 * @param picFile
	 * @param request
	 * @return
	 */
	public static String saveFile(CommonsMultipartFile picFile,
			HttpServletRequest request) {
		String location = null;
		if(!picFile.isEmpty()){
			String path = UploadPropertyTools.getValueFromKey("path");
			//得到真实路径
			String realPath = request.getSession().getServletContext().getRealPath(path);
			String fileName = picFile.getOriginalFilename();
			String kzm = fileName.substring(fileName.lastIndexOf("."));
			//要保存的文件名
			String destName = UUID.randomUUID().toString()+kzm;
			//创建虚拟文件
			File destFile = new File(realPath+"/"+destName);
			
			try {
				//文件保存
				picFile.getFileItem().write(destFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			StringBuffer url = request.getRequestURL();
			String projectName = request.getContextPath();
			location = url.substring(0, url.lastIndexOf(projectName)+projectName.length())+"/"+path+"/"+destName;
		}
		return location;
	}
	/**
	 * 根据文件请求路径删除文件
	 * @param url
	 * @param request
	 */
	public static void deleteFileByUrl(String url,HttpServletRequest request){
		if(url!=null){
			String fileName = url.substring(url.lastIndexOf("/"));
			String path = UploadPropertyTools.getValueFromKey("path");
			//得到真实路径
			String realPath = request.getSession().getServletContext().getRealPath(path);
			File file = new File(realPath+"/"+fileName);
			if(file.exists()){
				file.delete();
			}
		}
	}
	
}
