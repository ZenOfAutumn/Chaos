package com.zen.autumn.learn.base.generics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class MixinProxy implements InvocationHandler {

	Map<String, Object> delegatesByMethod;

	public MixinProxy(@SuppressWarnings("unchecked") TwoTuple<Object, Class<?>>... pairs) {
		delegatesByMethod = new HashMap<String, Object>();
		for (TwoTuple<Object, Class<?>> pair : pairs) {
			for (Method method : pair.second.getMethods()) {
				String methodName = method.getName();
				if (delegatesByMethod.containsKey(methodName)) {
					continue;
				}
				delegatesByMethod.put(methodName, pair.first);
			}
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		Object delegate = delegatesByMethod.get(methodName);
		return method.invoke(delegate, args);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object newInstance(TwoTuple... pairs) {
		Class[] interfaces = new Class[pairs.length];
		for (int i = 0; i < pairs.length; i++) {
			interfaces[i] = (Class) pairs[i].second;
		}

		ClassLoader classloader = pairs[0].first.getClass().getClassLoader();
		return Proxy.newProxyInstance(classloader, interfaces, new MixinProxy(pairs));
	}

}

public class DynamicProxyMixin {

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		Object mixin = MixinProxy.newInstance(new TwoTuple(new BasicImpl(),Basic.class),new TwoTuple(new TimeStampedImpl(),TimeStamped.class));
									
	}
}
