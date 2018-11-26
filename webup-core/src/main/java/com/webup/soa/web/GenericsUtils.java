package com.webup.soa.web;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.webup.soa.exception.ApplicationException;


/**
 * 泛型工具类
 * 
 * @author CGB
 * 
 */
public class GenericsUtils {

	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			throw new ApplicationException("index out of bound");
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	//@SuppressWarnings("unchecked")
	public static Class<Object> getMethodGenericReturnType(Method method, int index) {
		Type returnType = method.getGenericReturnType();
		if (returnType instanceof ParameterizedType) {
			ParameterizedType type = (ParameterizedType) returnType;
			Type[] typeArguments = type.getActualTypeArguments();
			if (index >= typeArguments.length || index < 0) {
				throw new ApplicationException("index out of bound");
			}
			return (Class) typeArguments[index];
		}
		return Object.class;
	}

	//@SuppressWarnings("unchecked")
	public static Class<Object> getMethodGenericReturnType(Method method) {
		return getMethodGenericReturnType(method, 0);
	}

	@SuppressWarnings("unchecked")
	public static List<Class> getMethodGenericParameterTypes(Method method,
			int index) {
		List<Class> results = new ArrayList<Class>();
		Type[] genericParameterTypes = method.getGenericParameterTypes();
		if (index >= genericParameterTypes.length || index < 0) {
			throw new ApplicationException("index out of bound");
		}
		Type genericParameterType = genericParameterTypes[index];
		if (genericParameterType instanceof ParameterizedType) {
			ParameterizedType aType = (ParameterizedType) genericParameterType;
			Type[] parameterArgTypes = aType.getActualTypeArguments();
			for (Type parameterArgType : parameterArgTypes) {
				Class parameterArgClass = (Class) parameterArgType;
				results.add(parameterArgClass);
			}
			return results;
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	public static List<Class> getMethodGenericParameterTypes(Method method) {
		return getMethodGenericParameterTypes(method, 0);
	}

	@SuppressWarnings("unchecked")
	public static Class getFieldGenericType(Field field, int index) {
		Type genericFieldType = field.getGenericType();

		if (genericFieldType instanceof ParameterizedType) {
			ParameterizedType aType = (ParameterizedType) genericFieldType;
			Type[] fieldArgTypes = aType.getActualTypeArguments();
			if (index >= fieldArgTypes.length || index < 0) {
				throw new ApplicationException("index out of bound");
			}
			return (Class) fieldArgTypes[index];
		}
		return Object.class;
	}

	@SuppressWarnings("unchecked")
	public static Class getFieldGenericType(Field field) {
		return getFieldGenericType(field, 0);
	}
	
	public static  Object  instanceOf(ParameterizedType type) throws Exception{
		
		Class 	clazz=(Class<?>)type.getRawType();
		
		Constructor  constructor=clazz.getConstructors()[0];
		Object o=constructor.newInstance();
		Type[]   types=type.getActualTypeArguments();
		
		for(Type t:types){
			
		}
		
		
		return 0;
		
	}
	
	static abstract class TypeReference<T> implements Comparable<TypeReference<T>> { 
        final Type _type; 
  
        protected TypeReference() { 
            Type superClass = getClass().getGenericSuperclass(); 
            if (superClass instanceof Class<?>) { // sanity check, should never happen 
                throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information"); 
            } 
            /* 22-Dec-2008, tatu: Not sure if this case is safe -- I suspect 
             *   it is possible to make it fail? 
             *   But let's deal with specifc 
             *   case when we know an actual use case, and thereby suitable 
             *   work arounds for valid case(s) and/or error to throw 
             *   on invalid one(s). 
             */ 
            _type = ((ParameterizedType) superClass).getActualTypeArguments()[0]; 
        } 
  
        public Type getType() { return _type; } 
  
        /** 
         * The only reason we define this method (and require implementation 
         * of <code>Comparable</code>) is to prevent constructing a 
         * reference without type information. 
         */
        @Override
        public int compareTo(TypeReference<T> o) { 
            // just need an implementation, not a good one... hence: 
            return 0; 
        }  
    } 
	
	
}