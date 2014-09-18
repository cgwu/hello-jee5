package com.cg.test.introspector;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtilsDemo {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		Car car = new Car("black", 20);

		// 使用BeanUtils来set/get属性
		String number = BeanUtils.getProperty(car, "number");// 获取car对象color属性的值,注意返回值固定为String
		BeanUtils.setProperty(car, "color", "red");// 设置car对象number属性的值为4
		BeanUtils.setProperty(car, "number", "2");// 传入2(自动装箱,内部需要拆箱)或"2"均可,"2"内部涉及到从String->int转换
		System.out.println(car.getColor() + " " + car.getNumber() + "\n");

		System.out.println("改变之前的时间:"+car.getBirthday());
		// 级联属性设置与获取
		// 在Date类中一个public void setTime(long time)方法->属性time 
		// 通俗例子:设置person.head.face.eye.color
		long newTime =  car.getBirthday().getTime()+1000;
		BeanUtils.setProperty(car, "birthday.time", newTime); //"1000");
		System.out.println(BeanUtils.getProperty(car, "birthday.time") + "\n");

		// JavaBean与Map相互转换
		Map map = BeanUtils.describe(car);// 会将JavaBean中 所有属性值
											// 存入到Map中,前提是该属性值有对应get方法
		System.out.println(map);// 里面还有一个属性为字节码文件对象,也就是指定的JavaBean类
		map = new HashMap();
		map.put("color", "blue");
		map.put("number", 2);
		map.put("birthday.time", 200);
		BeanUtils.populate(car, map);// 填充:将map中key对应javabean中的property,将其value赋给property
		System.out.println(car.getColor() + " " + car.getNumber());
		System.out.println(BeanUtils.getProperty(car, "birthday.time") + "\n");

		// PropertiesUtils工具类
		PropertyUtils.setProperty(car, "number", 13);// 属性值的类型必须和Car中number类型一致均为int
		Object obj = PropertyUtils.getProperty(car, "number");
		System.out.println(obj + " " + obj.getClass().getName());// 说明上面的getProperty以Integer类型返回
	}

}
