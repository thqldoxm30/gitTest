package kr.co.datas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FileConversionExam03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("1.암호화     2.암호파일복구화 3.종료");
		System.out.println("어떠한 작업을 수행 하시겠어요?");
		System.out.print("=>");
		int userChoiceNum = sc.nextInt();
		if(userChoiceNum == 1) {
			FileInputStream fis = null;
			FileOutputStream fos = null;
			int[] wData = new int[4];
			Random nan = new Random();
			System.out.print("암호화 하실 파일의 이름 : ");
			String userData = sc.next();
			System.out.print("암호된 파일을 저장할 이름 : ");
			String userData2 = sc.next();
			try {
				fis = new FileInputStream(userData);
				fos = new FileOutputStream(userData2);
				int readCnt = 0;
				int secuNan = nan.nextInt(100);
				while( (readCnt = fis.read())!=-1 ) {
					for(int i = 0; i<wData.length; i++) {
						wData[i] = nan.nextInt(1)+16;
						if(i == secuNan) {
							wData[i] = readCnt;
							}
						System.out.printf("%02X ",wData[i]);
						fos.write(wData[i]);
					}
					System.out.println();
				}
				System.out.println(userData2+" 이름의 파일로 암호화된 파일이 생성되었습니다.");
				System.out.println("암호 코드 : "+secuNan);
				System.out.println("암호파일을 복구 할때 사용해주세요.");
				System.out.println("======================================");
				
			} catch (IOException e) {
				System.err.println("파일이름을 찾을 수 없습니다.");
				e.printStackTrace();
			}
		}else if(userChoiceNum == 2) {
			FileInputStream fis = null;
			FileOutputStream fos = null;
			System.out.print("암호화된 파일의 이름을 입력해주세요. : ");
			String userItem = sc.next();
			System.out.print("저장할 이름을 정해주세요 : ");
			String userItem2 = sc.next();
			//바이트의 배열로의 선언을 고민해볼 것..
			byte[] readData = new byte[100]; //10배 크기로 확장 시키기 위해서 읽은 자료를 배열에 넣는다.
			
			try {
				fis = new FileInputStream(userItem); //읽어서
				fos = new FileOutputStream(userItem2); //저장하겠다.
				System.out.println("암호 코드를 입력해주세요");
				System.out.print("=>");
				int secuCode = sc.nextInt();
				
				int readCnt = 0;
				while( ( readCnt = fis.read(readData) )!=-1 ) {
					fos.write(readData[secuCode]);
				}
				System.out.println("암호가 해독되었습니다.");
				System.out.println("암호가 해독된 파일의 이름은 "+userItem2+"로 저장되었습니다.");
				fis.close();
				fos.close();
			} catch (IOException e) {
				System.err.println("찾을 수 없는 파일입니다.");
				e.printStackTrace();
			}
		}else if(userChoiceNum == 3) {
			System.out.println("프로그램을 종료합니다.");
			break;
		}else {
			System.out.println("그런 메뉴는 없습니다.");
		}
		
		}
	}

}
