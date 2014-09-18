/*
From: http://www.tuicool.com/articles/AbUfIn

JavaBean与内省(Introspector):
1.JavaBean是一种特殊的Java类,主要用于传递数据信息,这种Java类中的方法
   主要用于访问私有字段,且方法名符合某种命名规则.
2.如果在两个模块之间传递多个信息,可以将这些信息封装到一个JavaBean中,这种JavaBean的实例
通常称之为值对象(Value Object).这些信息在类中用私有字段来存储,如果读取货设置这些字段的值
则需要通过一些相应的方法来访问,这些方法该如何命名?
 JavaBean的属性是根据其中的setter和getter方法来确定的,而不是根据其中的成员变量.如果方法
名为setId,意为设置id,至于你存到哪个变量上,用管吗?getId意为获取id,至于从哪个变量上得到的,用管吗?
去掉set前缀后,剩余部分就是属性名,如果剩余部分的第二个字母是小写的,则把剩余部分的首字母改成小写.
   setId属性名->id
   isLast属性名->last
   setCPU属性名->CPU     
总而言之:一个类被当做JavaBean使用时,JavaBean的属性是根据方法名推断出来的
        它根本看不到java类内部的成员变量

一个符合JavaBean特点的类可以被当做普通类一样进行使用,但把它当做JavaBean用肯定需要带来一些额外的好处
好处:
1.在JavaEE开发中,经常使用JavaBean.很多环境要求按JavaBean方式进行操作
2.JDK提供了对JavaBean进行操作的一些API,这套API就称为内省(Introspector).
*/
package com.cg.test.introspector;

import java.lang.reflect.Method;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.springframework.beans.BeanUtils;

public class IntrospectorDemo {


    public static void main(String[] args)throws Exception{
        // TODO 自动生成的方法存根
        //方式一:使用反射操作JavaBean
        //获取颜色->color->color有一个单词第二个字母小写->推断出方法名getColor
        Car car=new Car("红色",4);
        Method method=car.getClass().getMethod("getColor");
        Object retVal=method.invoke(car);
        System.out.println("Method:"+retVal);//"红色"
        
        //方式二:使用内省操作JavaBean->不用再推断方法名
        PropertyDescriptor pd=new PropertyDescriptor("color",car.getClass());//第一个参数属性名,第二个参数把哪一个类当成JavaBean类
        method=pd.getReadMethod();//将获取到的getColor方法封装成Method对象
        retVal=method.invoke(car);
        System.out.println("PropertyDescriptor:"+retVal);//"红色"
        
        method=pd.getWriteMethod();//将获取到的setColor方法封装成Method对象
        method.invoke(car,"黑色");
        System.out.println(car.getColor());//验证是否改掉//"黑色"
        
        //测试封装后的方法
       System.out.println(getProperty("number",car));//4
       setProperty("number",car,10);
       System.out.println(car.getNumber());//10
       
       System.out.println("**********************");
       
       BeanInfo bi=Introspector.getBeanInfo(car.getClass());	//在 Java Bean 上进行内省，了解其所有属性、公开的方法和事件,描述目标 bean 的 BeanInfo 对象。 
       PropertyDescriptor[] pdArrs=bi.getPropertyDescriptors();	//获取到该JavaBean中所有属性信息,BeanInfo没有获取单个属性的方法
		for (PropertyDescriptor pdArr : pdArrs) {
			Method m = pdArr.getReadMethod();
			System.out.println(m.getName() + ":" + m.invoke(car)); // 输入get方法返回值
		}
		
     }	// end main
   
    
    //对上面的操作步骤进行封装提高复用性
    public static Object getProperty(String property,Object obj) throws Exception{//获取指定对象的属性值
       PropertyDescriptor pd=new PropertyDescriptor(property,obj.getClass());
        Method method=pd.getReadMethod();
        return method.invoke(obj);
    
    /*//方法二:
          BeanInfo bi=Introspector.getBeanInfo(obj.getClass());//在 Java Bean 上进行内省，了解其所有属性、公开的方法和事件,描述目标 bean 的 BeanInfo 对象。 
          PropertyDescriptor[] pdArrs=bi.getPropertyDescriptors();//获取到该JavaBean中所有属性信息,BeanInfo没有获取单个属性的方法
          for(PropertyDescriptor pdArr : pdArrs)
            if(pdArr.getName().equals(property)){//获取到属性描述的属性名称(getName),遍历
              Method method=pdArr.getReadMethod();
              return method.invoke(obj);
            }
           return null;*/
      
    }
   public static void setProperty(String Property,Object obj,Object value)throws Exception{
        PropertyDescriptor pd=new PropertyDescriptor(Property,obj.getClass());
        Method method=pd.getWriteMethod();
        method.invoke(obj,value);
   }
   
}
