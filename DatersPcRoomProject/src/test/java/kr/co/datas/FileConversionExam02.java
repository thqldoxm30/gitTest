package kr.co.datas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileConversionExam02 {

	public static void main(String[] args) {
		//aa.jpg 파일을 읽어서 확장 변형된 bb.jpg를 만들어보자
		//aa.jpg 크기가 100일때 변형된 bb.jpg는 100이상의 크기로 변형, 복원을 싴텨보자
		
		// FileReader | FileInputStream 사용할 건지 결정 텍스트 파일이 아닐때는 FileInputStream를 사용하자
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		//바이트의 배열로의 선언을 고민해볼 것..
		int[] wData = new int[10]; //10배 크기로 확장 시키기 위해서 읽은 자료를 배열에 넣는다.
		Random rdm = new Random(); //난수를 이용해서 쓰레기 값을 만들기 위함
		
		try {
			fis = new FileInputStream("./aaa.jpg"); //읽어서
			fos = new FileOutputStream("./bbb.jpg"); //저장하겠다.
			int srcReadData = 0;
			while( ( srcReadData =  fis.read() )!=-1 ) {
				// wData배열에 값을 의미 없는 값으로 채워준다.
				System.out.print((char)srcReadData);
				for(int i = 0; i<wData.length; i++) {
					wData[i] = (rdm.nextInt(270)+17);
					//위의 난수 생성시 바이트 범위를 넘는 숫자로 생성될경우 데이타 왜곡이 일어날 수 있다.
					if(i == 4) {
						wData[4] =  srcReadData;
					}
					fos.write(wData[i]);
				}
			}
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
