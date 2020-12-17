package kr.co.datas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileConversionExam {

	public static void main(String[] args) {
		//aa.jpg 파일을 읽어서 확장 변형된 bb.jpg를 만들어보자
		//aa.jpg 크기가 100일때 변형된 bb.jpg는 100이상의 크기로 변형, 복원을 싴텨보자
		
		// FileReader | FileInputStream 사용할 건지 결정 텍스트 파일이 아닐때는 FileInputStream를 사용하자
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		int[] wData = new int[10]; //10배 크기로 확장 시키기 위해서 읽은 자료를 배열에 넣는다.
		Random rdm = new Random(); //난수를 이용해서 쓰레기 값을 만들기 위함
		
		try {
			fis = new FileInputStream("./aaa.txt"); //읽어서
			int srcReadData = 0;
			while( ( srcReadData = fis.read() )!=-1 ) {
				// wData배열에 값을 의미 없는 값으로 채워준다.
				System.out.print("쓰레기 정보 [쓰레기] : ");
				for(int i = 0; i<wData.length; i++) {
					wData[i] = rdm.nextInt(270)+16;
					System.out.printf("%02X ",wData[i]);
				}
				System.out.println();
				System.out.print("실제 정보 [5번째] :   ");
				wData[4] = srcReadData;
				for(int i = 0; i<wData.length; i++) {
					if(i == 4) {
						System.out.print((char)wData[i]+" ");
						continue;
					}
					System.out.printf("%02X ",wData[i]);
					
				}
				System.out.println();
				System.out.println("===============================================");
				
				
			}
			fis.close();
//			fos = new FileOutputStream("./bbb.jpg"); //저장하겠다.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
