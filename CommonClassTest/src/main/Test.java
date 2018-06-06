package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {

	//内部类测试Scanner
	//Scanner类可以用来从键盘读取，可以输入任意字符，基本数据类型
	public class ScannerTest{
		int i=10;
		public void test() {
			Scanner sc=new Scanner(System.in);
			String s=sc.nextLine();
			Pattern p=Pattern.compile(s);
			System.out.println("pattern====="+p.toString());
			System.out.println("String===="+sc.match().groupCount());
			System.out.println("p========"+p.pattern());
		}
		public void test1() {
			try {
				Scanner sc1=new Scanner(new File("C:\\Users\\积金汽车\\Desktop\\当前进程.txt"));
				while(sc1.hasNext()) {
					String stxt=sc1.nextLine();
					System.out.println(stxt);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		class Test2{
				int i=100;
				System.out.println("内部类属性==="+this.i);
				System.out.println("外部类属性===="+ScannerTest.this.i);
		}
	}
	
	/***
	 * System类
	 * @param args
	 */
	public class SystemTest{
		//System类中没有公共的构造方法，所以不能直接new
		public void test() {
//			System.arraycopy(ScannerTest.class, 0, SystemTest.class, SystemTest.class.hashCode(), SystemTest.class.getName().length());
			System.out.println(System.console().toString());
		}
	}
	
	/***
	 * Random类
	 * @param args
	 */
	public class RandomTest{
		public void test() {
			//int的取值是2147483648和2147483647
			Random random=new Random();
			System.out.println(random.nextInt());
			System.out.println(random.nextBoolean());
			//保留17位小数
			System.out.println(random.nextDouble());
			//保留8位小数
			System.out.println(random.nextFloat());
			//19位数
			System.out.println(random.nextLong());
			//获取0-10之间的随机数
			System.out.println(random.nextInt(10));
		}
	}
	
	/**
	 * Math类
	 * @param args
	 */
	public class MathTest{
		public void test() {
			//获取绝对值
			System.out.println(Math.abs(10));
			//获取反余弦值，取值范围是0.0到圆周率
			System.out.println(Math.acos(0.234));
			//向上取整；获取一个数值：不管小数后面有几位，整数位进1
			System.out.println(Math.ceil(1.2));
			//向下取整;不管小数后面有几位，小数位都去掉改为0
			System.out.println(Math.floor(2.54));
			//参数分别为底数，次方数，表示为2的3次方
			System.out.println(Math.pow(2,3));
			//四舍五入取整
			System.out.println(Math.round(4.56));
		}
	}
	/**
	 * Arrays类
	 * @param args
	 */
	public class ArraysTest{
		public <T> void test() {
			char[] s= {'a','b','c'};
			//复制一个数组
			System.out.println(Arrays.copyOf(s, s.length));
			//复制数组的一部分
			System.out.println(Arrays.copyOfRange(s, 1, s.length));
			String[] ss= {"我是","初级的"};
			//将数组转变成一个字符串
			System.out.println(Arrays.deepToString(ss));
			//查找某个字符的索引即位置
			System.out.println(Arrays.binarySearch(s, 'a'));
			//将数组转换成一个对象
			System.out.println(Arrays.asList(new Object()));
			//数组排序【默认按照字符升序排列】
			Arrays.sort(s);
			List<char[]> st=Arrays.asList(s);
			//取值打印
			st.forEach(n ->System.out.println(n));
			st.forEach(n ->{
				System.out.println(n);
			});
			st.forEach(System.out::println);//直接打印
			System.out.println(st.stream().findFirst().toString());
			//转换成map对象
			st.stream().map((n)->n).forEach(System.out::println);
			//避免内部类的创建
			Thread t=new Thread(()->{
				System.out.println("hellos");
			});
			t.start();
//			st.stream().filter(st)
			/*filter(st,(str)->{
				((char)str).
			});*/
			System.out.println("jdk8的lambda表达式");
//			System.out.println(st.toString());
			//对数组中的某一个区域进行排序
			Arrays.sort(s, 0, s.length-1);
			//匿名内部类进行排序,这是其中一种方法对对象进行排序，还有一种方法就是对象实现comparable接口，重写compareTo方法
			Arrays.sort((T[]) new Object(), new Comparator<Object>() {
				@Override
				public int compare(Object o1, Object o2) {
					if(o1.hashCode()>o2.hashCode()) {
						return 1;
					}else if(o1.hashCode()<o2.hashCode()) {//此处需要用到的是类中的某一个字段进行比较
						return -1;
					}else if(o1.hashCode()==o2.hashCode()) {
						return 0;
					}
					return 0;
				}
				
			});
			//使用lambda表达式之后()->替代了上面的内部类
			Arrays.sort((T[]) new Object(), (o1,o2)->o1.hashCode()>o2.hashCode()?1:-1);
			
		}
	}
	public static void main(String[] args) {
		Test test=new Test();
		//内部类创建方式
//		ScannerTest scTest=test.new ScannerTest();
//		scTest.test();
//		scTest.test1();
//		SystemTest systemTest=test.new SystemTest();
//		systemTest.test();
//		RandomTest randomTest=test.new RandomTest();
//		randomTest.test();
//		MathTest mathTest=test.new MathTest();
//		mathTest.test();
		ArraysTest arraysTest=test.new ArraysTest();
		arraysTest.test();
	}
	
	
}
