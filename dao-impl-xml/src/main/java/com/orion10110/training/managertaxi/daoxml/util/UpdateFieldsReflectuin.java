package com.orion10110.training.managertaxi.daoxml.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class UpdateFieldsReflectuin<T> {
	public void UpdateFields(T get, T set) {

		Class classType = get.getClass();
		Method[] methods = classType.getMethods();
		List<String> setList = new ArrayList();
		List<String> getList = new ArrayList();
		for (Method method : methods) {

			if ((method.getName().startsWith("set"))) {
				// if
				// (method.getName().toLowerCase().endsWith(field.getName().toLowerCase()))
				// {
				// // MZ: Method found, run it
				// try
				// {
				// return method.invoke(o);
				// }
				// catch (IllegalAccessException e)
				// {
				// Logger.fatal("Could not determine method: " +
				// method.getName());
				// }
				// catch (InvocationTargetException e)
				// {
				// Logger.fatal("Could not determine method: " +
				// method.getName());
				// }
				//
				// }
				System.out.println(method.getName());
				setList.add(method.getName());
				// System.out.println(method.getName().replaceFirst("^set",
				// "get"));
				Method getMethod = null;
				String met =method.getName().replaceFirst("^set", "get");
				try {
					getMethod=classType.getMethod(met, null);
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Object val = new Object();
				try {
					 val = getMethod.invoke(get);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					method.invoke(set, val);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

//			Object[] args = new Object[] { new String("First Calculate"), new Integer(10) };
//			Double d = (Double) method.invoke(obj, args);

		}

	}
}
