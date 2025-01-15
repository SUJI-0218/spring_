package com.care.root.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	FileMapper mapper; // 여기를 연결했을때 잘 안될 경우에 root-context들어가서 확인할것!

	public void fileProcess(MultipartFile file, String id, String name) {

		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);

		if (!file.isEmpty()) {// file.isEmpty() ==false
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			// sysFileName = 20250113105710-
			String sysFileName = fo.format(new Date());
			// sysFileName = 20250113105710-아리.png
			sysFileName += file.getOriginalFilename();

			dto.setImgFileName(sysFileName);

			File f = new File(IMG_REPO + "/" + sysFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			dto.setImgFileName("nan");
		}
		try {
			mapper.save(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<FileDTO> getList(){
		
		return mapper.getList();
	}
	public void delete(String file, String id) {
		int result = 0;
		try {
			result = mapper.delete( id );
			if( result == 1 ) {
				File d = new File(IMG_REPO + "/" + file );
				if( d.exists() ) {//파일이 존재한다면 그 파일을 삭제를 해라
					d.delete(); 
				}
				d.delete();
			}
		}catch( Exception e ) {
			e.printStackTrace();
		}
	}
	public FileDTO getData(String id) {
		return mapper.getData( id );
	}
	public void modify(MultipartFile file, String origin, FileDTO dto) {
//		System.out.println("file : " + file);
//		System.out.println("origin : " + origin );
//		System.out.println("dto id : " + dto.getId());
//		System.out.println("dto name : " + dto.getName());
		if( file.isEmpty() ) { //사용자가 파일을 선택하지 않았다면 if 실행
			dto.setImgFileName(origin);
			
		}else {//사용자가 파일을 선택했다면 else 실행
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName = fo.format(new Date());
			sysFileName += file.getOriginalFilename();

			dto.setImgFileName(sysFileName);

			File f = new File(IMG_REPO + "/" + sysFileName);
			try {
				file.transferTo(f); //파일로 잘 저장이 됐다면
				File d = new File(IMG_REPO + "/" + origin); //origin은 삭제해야 될 원래 이름
				d.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mapper.modify( dto );
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
