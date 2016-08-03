package com.wanpin.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.wanpin.common.constants.StatusCodes;

/**
 * 文件上传工具类
 * 
 * @author yangdc
 * @date Apr 18, 2012
 * 
 * <pre>
 * </pre>
 */
public class UploadUtils {
	/**
	 * 表单字段常量
	 */
	public static final String FORM_FIELDS = "form_fields";
	/**
	 * 文件域常量
	 */
	public static final String FILE_FIELDS = "file_fields";

	// 最大文件大小
	private long maxSize = 3145728;
	// 定义允许上传的文件扩展名
	private Map<String, String> extMap = new HashMap<String, String>();
	// 文件保存目录相对路径
	private String basePath = "wp";
	// 文件的目录名
	private String dirName = "images";
	// 上传临时路径
	private static final String TEMP_PATH = "/temp";
	private String tempPath = basePath + TEMP_PATH;
	// 若不指定则文件名默认为 UUID生成
	private String fileName;

	// 文件保存目录路径
	private String savePath = "heads";
	// 文件保存目录url
	private String saveUrl;
	// 文件最终的url包括文件名
	private String fileUrl;
	
	private String[] uploadFileNames;

	public UploadUtils() {
		// 其中images,flashs,medias,files,对应文件夹名称,对应dirName
		// key文件夹名称
		// value该文件夹内可以上传文件的后缀名
		extMap.put("images", "gif,jpg,jpeg,png,bmp");
		extMap.put("flashs", "swf,flv");
		extMap.put("medias", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("files", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
	}

	/**
	 * <p>用一句话描述这个方法的作用</p>
	 * @author litr 2016年7月13日
	 * @param file
	 * @param request
	 * @return
	 * @throws FileUploadException 
	 */
	public String uploadFile(CommonsMultipartFile file, HttpServletRequest request, Map<String, Object> model) throws FileUploadException {
		if (file == null || file.isEmpty()) {
			WanpinUtils.organizeData(model, StatusCodes.UPLOAD_FILE_NULL);
			return null;
		}
		
		// 判断上传文件大小是否超过限制
		long fileSize = file.getSize();
		if (maxSize < fileSize) {
			WanpinUtils.organizeData(model, StatusCodes.UPLOAD_FILE_GT_MAXSIZE, "上传文件大于"+ (maxSize/1024/1024) +"M");
			return null;
		}
		
		// 上传的文件名
		String fileName = file.getOriginalFilename();
		// 上传的文件扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		// 判断上传文件后缀是否支持
		if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
			WanpinUtils.organizeData(model, StatusCodes.UPLOAD_FILE_SUFFIX_UNSUPPORT, "上传文件扩展名是不允许的扩展名");
			return null;
		}
		
		// 获取webapps绝对路径
		// String realPath = request.getSession().getServletContext().getRealPath("/").replaceAll("\\\\", "/");
		// String webapps = realPath.substring(0, realPath.indexOf(request.getContextPath()));
		String webapps = request.getSession().getServletContext().getRealPath("../");
		String saveUrl = "/" + basePath + "/" + savePath + "/" + DateUtils.getCurrentDate("yyyy/MM");
		
		if (StringUtils.isEmpty(this.fileName)) {
			this.fileName = UUID.randomUUID().toString() + "." + fileExt;
		}
		
		// 判断
		File targetFile = new File(webapps + saveUrl, this.fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.UPLOAD_FILE_FAIL);
			throw new FileUploadException();
		}
		
		return saveUrl + "/" + this.fileName;
	}
	
	public String uploadFile(HttpServletRequest request, Map<String, Object> model) throws FileUploadException {
		// 获取内容类型
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if (!multipartResolver.isMultipart(request)) {
			
		} else {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			if (this.uploadFileNames != null && this.uploadFileNames.length > 0) {
				for (String ufn : uploadFileNames) {
					List<MultipartFile> fileList = multiRequest.getFiles(ufn);
					StringBuffer sb = new StringBuffer();
					if (fileList != null && fileList.size() > 0) {
						for (MultipartFile multipartFile : fileList) {
							if (multipartFile != null && !multipartFile.isEmpty()) {
								
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * <p>用一句话描述这个方法的作用</p>
	 * @author litr 2016年7月27日
	 * @param inputStream 文件流
	 * @param fileExt 文件扩展名
	 * @param request 
	 * @param model
	 * @return
	 * @throws FileUploadException
	 */
	public String uploadFile(InputStream inputStream, String fileExt, HttpServletRequest request, Map<String, Object> model) throws FileUploadException {
		
		if (inputStream == null) {
			WanpinUtils.organizeData(model, StatusCodes.UPLOAD_FILE_NULL);
			return null;
		}
		
		// 判断上传文件大小是否超过限制
		long fileSize = 0;
		try {
			fileSize = inputStream.available();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (maxSize < fileSize) {
			WanpinUtils.organizeData(model, StatusCodes.UPLOAD_FILE_GT_MAXSIZE, "上传文件大于"+ (maxSize/1024/1024) +"M");
			return null;
		}
		
		// 判断上传文件后缀是否支持
		if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
			WanpinUtils.organizeData(model, StatusCodes.UPLOAD_FILE_SUFFIX_UNSUPPORT, "上传文件扩展名是不允许的扩展名");
			return null;
		}
		
		// 获取webapps绝对路径
		String webapps = request.getSession().getServletContext().getRealPath("../");
		String saveUrl = "/" + basePath + "/" + savePath + "/" + DateUtils.getCurrentDate("yyyy/MM");
		
		if (StringUtils.isEmpty(this.fileName)) {
			this.fileName = UUID.randomUUID().toString() + "." + fileExt;
		}
		
		// 判断
		File targetFile = new File(webapps + saveUrl);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		
		targetFile = new File(targetFile, this.fileName);
		
		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream(targetFile);
			byte[] bytes = new byte[1024];
			int end = 0;
			while ((end = inputStream.read(bytes)) > 0) {
				fo.write(bytes, 0, end);
				fo.flush();
			}
			
			return saveUrl + "/" + this.fileName;
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.UPLOAD_FILE_FAIL);
			e.printStackTrace();
		} finally {
			if (fo != null) {
				try {
					fo.close();
				} catch (IOException e) {
					WanpinUtils.organizeData(model, StatusCodes.UPLOAD_FILE_FAIL);
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	/** **********************get/set方法********************************* */

	public String getSavePath() {
		return savePath;
	}

	public String getSaveUrl() {
		return saveUrl;
	}

	public long getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	public Map<String, String> getExtMap() {
		return extMap;
	}

	public void setExtMap(Map<String, String> extMap) {
		this.extMap = extMap;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
		tempPath = basePath + TEMP_PATH;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public String getTempPath() {
		return tempPath;
	}

	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String[] getUploadFileNames() {
		return uploadFileNames;
	}

	public void setUploadFileNames(String... uploadFileNames) {
		this.uploadFileNames = uploadFileNames;
	}

}
