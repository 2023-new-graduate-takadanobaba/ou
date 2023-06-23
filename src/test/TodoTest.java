package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TodoTest {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Please input the test number. (Integer Only)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		chooseTset(Integer.parseInt(str));
	}
	
	private static void chooseTset (int i) throws IOException {
		switch (i) {
			case 1: {
				convert2Number();
				break;
			}
			case 2:{
				multiOf3();
				break;
			}
			case 3:{
                sum();
                break;
            }
		default: System.out.println("The number is unavailable.");
		
		}
	}
	
	
	
	
	private static void convert2Number() throws IOException {
		System.out.println("convert2Number() started. Please input >");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numStr = br.readLine();
		
		if (numStr.matches("[-+]?\\d+")) {
			System.out.println(Integer.parseInt(numStr));
		} else if (numStr.matches("[-+]?\\d+\\.\\d+")) {
			System.out.println(Double.parseDouble(numStr));
		} else {
			System.out.println("数字ではありません");
		}
	}
	
	private static void multiOf3() throws IOException {
		System.out.println("multiOf3() started. Please input >");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numStr = br.readLine();
		
		int len = 0;		
		if (numStr.matches("[-+]?\\d+\\.\\d+")) {
			String s = numStr.split("\\.")[1];
			len = s.length();
		}
		
		if (len>2) {
			System.out.println("小数点以下第2位までのみです。");
		} else {
			// 小数点以下第2位まで
			try {
				double d = Double.parseDouble(numStr);
				if (d/3*3 == d) {
					System.out.println("3の倍数です");
				} else {
					System.out.println("3の倍数ではありません");
					System.out.println(d/3*3);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("数字ではありません");
			}
		}				
	}
	
	private static void sum() throws IOException {
        System.out.println("sum() started. Please input >");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isStop = false;
        List<Double> dArr = new ArrayList<>();

        while (!isStop) {
            String str = br.readLine();
            if (str.equals("end")) {
                isStop = true;
                continue;
            }
            try {
                dArr.add(Double.parseDouble(str));
            } catch (Exception e) {
                System.out.println("数字ではありません");
            }
        }

        System.out.println("sum:"+dArr.stream().mapToDouble(d->d).sum());
    }
}
