package promote;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ���� {

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
		System.out.println("���ߣ�170cm");
		System.out.println("���أ�60kg");
	}
}

class ProxyHandler implements InvocationHandler{
	
	private Object targetObject;
	public Object newProxyInstance(Object targetObject) {
		System.out.println("this: "+this);
		this.targetObject=targetObject;
//		��һ������  ��������������ػ���
//		�ڶ�������  ����������ȫ���ӿ�
//		ʵ��InvocationHandler �ӿڵĶ���
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
	}
	
	
	// ��һ������ ��������Ķ���   ��������1��	����ʹ�÷����ȡ����������Ϣ 2�� ���Խ�����������
//	�ڶ��������������õķ���
//	��������������������ʱ����Ĳ���
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
		System.out.println("��¼��־");
		return method.invoke(targetObject, args);
//		return method.invoke(proxy, args);
	}
}