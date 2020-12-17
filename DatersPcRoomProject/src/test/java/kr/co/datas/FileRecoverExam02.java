package kr.co.datas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileRecoverExam02 {

	public static void main(String[] args) {
		// 확장 변형된 bb.jpg를 원래 파일로 복원하는 프로그램
		// aa.jpg 크기가 100일때 변형된 bb.jpg는 100이상의 크기로 변형, 복원을 싴텨보자
		// FileReader | FileInputStream 사용할 건지 결정 텍스트 파일이 아닐때는 FileInputStream를 사용하자
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		//바이트의 배열로의 선언을 고민해볼 것..
		byte[] readData = new byte[10]; //10배 크기로 확장 시키기 위해서 읽은 자료를 배열에 넣는다.
		
		try {
			fis = new FileInputStream("./bbb.jpg"); //읽어서
			fos = new FileOutputStream("./bbbrec.jpg"); //저장하겠다.
			int readCnt = 0;
			while( ( readCnt = fis.read(readData) )!=-1 ) {
				// wData배열에 값을 의미 없는 값으로 채워준다.
				fos.write(readData[4]);
			}
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
