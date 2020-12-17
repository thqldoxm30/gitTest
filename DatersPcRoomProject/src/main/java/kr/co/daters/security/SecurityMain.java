package kr.co.daters.security;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class SecurityMain {
	int Ransu = 50;
	
	public String insertPassword(String pwd) {
		String ran = pwd;
		String Down = ran.substring(ran.length()/2);
		String Up = ran.substring(0, Down.length()-ran.length()%2);
		
		String result = randomChar() + Up + randomChar() + Down + randomChar();
		return reverseString(result);
	}

	public String restorationPassword(String pwd) {
		int Up;
		int Down;
		String UpChar ="";
		String DownChar = "";
		String result = reverseString(pwd);
		
		result = result.substring(Ransu);
		result = result.substring(0 ,result.length()-Ransu);
		
		Down = ((result.length()-Ransu)/2)+(result.length()%2);
		Up = Down-(result.length()%2);
		
		UpChar = result.substring(0, Up);
		DownChar = result.substring(Up+Ransu);
		
		return UpChar+DownChar;
	}
	
	public static String reverseString(String s){
	    return (new StringBuffer(s)).reverse().toString();
	}
	
	public String randomChar() {
		String wData = "";
		String ranChar = "";
		Random nan = new Random();
		for(int i = 0; i<Ransu; i++) {
			ranChar = String.valueOf((char)((int)(nan.nextInt(26))+97));
			wData += ranChar;
		}
		
		return wData;
	}

}
