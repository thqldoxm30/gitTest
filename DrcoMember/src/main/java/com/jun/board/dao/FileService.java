package com.jun.board.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	private static final String SAVE_PATH = "D:"; // 파일이 저장될 위치
	private static final String PREFIX_URL = "D:/"; // 저장된 파일을 jsp에서 불러오기 위한 경로

	public String restore(MultipartFile multipartFile) {

		String url = null;
		try {
			String fileName = multipartFile.getOriginalFilename();
			String extName = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			
			
			String saveFileName = genSaveFileName(extName);
			writeFile(multipartFile, saveFileName);
			url = PREFIX_URL + saveFileName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return url;
	}

	// 현재 시간을 기준으로 파일 이름 생성 이름중복으로 덮어쓰기가 될 문제 때문에
	private String genSaveFileName(String extName) {
		String fileName = "";

		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += extName;

		return fileName;
	}

	private boolean writeFile(MultipartFile multipartFile, String saveFileName) throws IOException{
		boolean result = false;
		
		byte[] data = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(data);
		fos.close();
		 
		return result;
	}
}
