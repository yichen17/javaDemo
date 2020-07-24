package promote;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class 代理 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProxyHandler handler=new ProxyHandler();
		Print printer=(Print) handler.newProxyInstance(new Printer());
		printer.print();
	}

}

interface Print{
	void print();
}

class Printer implements Print{
	public Printer() {}
	public void print() {
		System.out.println("升高：170cm");
		System.out.println("体重：60kg");
	}
}

class ProxyHandler implements InvocationHandler{
	
	private Object targetObject;
	public Object newProxyInstance(Object targetObject) {
		System.out.println("this: "+this);
		this.targetObject=targetObject;
//		第一个参数  被代理对象的类加载机制
//		第二个参数  被代理对象的全部接口
//		实现InvocationHandler 接口的对象
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
	}
	
	
	// 第一个参数 ：被代理的对象   它的作用1、	可以使用反射获取代理对象的信息 2、 可以进行连续调用
//	第二个参数：被调用的方法
//	第三个参数：方法调用时所需的参数
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
//		System.out.println("proxy:"+proxy.toString());
//		System.out.println("targetObject:"+targetObject.toString());
//		System.out.println(proxy==targetObject);
		System.out.println(Proxy.class);
//		System.out.println(this==proxy.getClass());
		System.out.println(proxy.getClass());
		System.out.println(proxy.getClass().getName());
		System.out.println(this);
		System.out.println("记录日志");
		return method.invoke(targetObject, args);
//		return method.invoke(proxy, args);
	}
}