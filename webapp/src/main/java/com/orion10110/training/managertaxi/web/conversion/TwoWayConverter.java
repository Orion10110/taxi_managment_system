package com.orion10110.training.managertaxi.web.conversion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

public class TwoWayConverter<S, T> implements GenericConverter {

	private Class<S> classOfS;
	private Class<T> classOfT;

	protected TwoWayConverter() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.classOfS = (Class) pt.getActualTypeArguments()[0];
		this.classOfT = (Class) pt.getActualTypeArguments()[1];
	}

	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<ConvertiblePair>();
		convertiblePairs.add(new ConvertiblePair(classOfS, classOfT));
		convertiblePairs.add(new ConvertiblePair(classOfT, classOfS));
		return convertiblePairs;
	}

	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		if (classOfS.equals(sourceType.getType())) {
			return this.converse(classOfS, classOfT, source);
		} else {
			return this.converse(classOfT, classOfS, source);
		}
	}

//	public T convert(S source) {
//		T ret = classOfT.newInstance();
//		List<Method> methodsOfT = Arrays.asList(classOfT.getMethods());
//		List<Method> methodsOfS = Arrays.asList(classOfS.getMethods());
//		List<Method> commonMethods = new ArrayList();
//		for (Method methodOfT : methodsOfT) {
//			for (Method methodOfS : methodsOfS) {
//				if (methodOfT.getName() == methodOfS.getName() && methodOfT.getName().startsWith("set")) {
//					commonMethods.add(methodOfT);
//					break;
//				}
//			}
//		}
//		for (Method methodSetT : commonMethods) {
//			String metNameForGet = methodSetT.getName().replaceFirst("^set", "get");
//			Method getMethod = classOfS.getMethod(metNameForGet);
//			Object val = getMethod.invoke(source);
//			methodSetT.invoke(ret, val);
//		}
//		return ret;
//	}

	public Object converse(Class getFrom, Class setTo, Object source) {
		Object ret = null;
		try {
			ret = setTo.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Method> methodsGet = Arrays.asList(getFrom.getMethods());
		List<Method> methodsSet = Arrays.asList(setTo.getMethods());
		List<Method> commonMethods = new ArrayList();
		for (Method methodOfSet : methodsSet) {
			for (Method methodOfGet : methodsGet) {
				if (methodOfSet.getName() == methodOfGet.getName() && methodOfSet.getName().startsWith("set")) {
					commonMethods.add(methodOfSet);
					break;
				}
			}
		}
		for (Method methodSet : commonMethods) {

			String metNameForGet = methodSet.getName().replaceFirst("^set", "get");
			Method getMethod = null;
			try {
				getMethod = getFrom.getMethod(metNameForGet);
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Object val = null;
			try {
				val = getMethod.invoke(source);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				methodSet.invoke(ret, val);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}

//	public S convertBack(T source) {
//		S ret = classOfS.newInstance();
//		List<Method> methodsOfT = Arrays.asList(classOfT.getMethods());
//		List<Method> methodsOfS = Arrays.asList(classOfS.getMethods());
//		List<Method> commonMethods = new ArrayList();
//		for (Method methodOfT : methodsOfT) {
//			for (Method methodOfS : methodsOfS) {
//				if (methodOfT.getName() == methodOfS.getName() && methodOfT.getName().startsWith("set")) {
//					commonMethods.add(methodOfS);
//					break;
//				}
//			}
//		}
//		for (Method methodSetS : commonMethods) {
//
//			String metNameForGet = methodSetS.getName().replaceFirst("^set", "get");
//			Method getMethod = classOfT.getMethod(metNameForGet);
//
//			Object val = getMethod.invoke(source);
//			methodSetS.invoke(ret, val);
//		}
//		return ret;
//	}
}
