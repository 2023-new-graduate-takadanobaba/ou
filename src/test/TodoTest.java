package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			case 4:{
				cal();
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

	private static void cal() throws IOException {
		System.out.println("cal() started. Please input >");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		class Calculator {
			String sign;
			Double num;

			public Calculator(String sign, Double num) {
				this.sign = sign;
				this.num = num;
			}

			public Calculator() {
			}

			public String getSign() {
				return sign;
			}

			public void setSign(String sign) {
				this.sign = sign;
			}

			public Double getNum() {
				return num;
			}

			public void setNum(Double num) {
				this.num = num;
			}
		}

		List<Calculator> calList = new ArrayList<>();

		boolean isStop = false;
		double d = 0.0;

		while (!isStop) {
			String str = br.readLine();
			if (str.equals("end")) {
				isStop = true;
				break;
			}

			if (str.matches("[-+*/]?(\\d+|\\d+\\.+\\d+)")) {
				String[] strTem = str.split("(?<=[-+*/])");
//              System.out.println(strTem[0]+","+strTem[1]);
				calList.add(new Calculator(strTem[0], Double.parseDouble(strTem[1])));
			} else {
				System.out.println("Illegal input.");
			}
		}

		for (Calculator c : calList) {
			switch (c.getSign()) {
				case "-": {
					d -= c.getNum();
					break;
				}
				case "+": {
					d += c.getNum();
					break;
				}
				case "*": {
					d = d * c.getNum();
					break;
				}
				case "/": {
					d = d / c.getNum();
					break;
				}

			}
//			System.out.println("sum_: " + d);
		}

		System.out.println("sum: " + d);
	}
}
