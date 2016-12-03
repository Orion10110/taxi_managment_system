package com.orion10110.training.managertaxi.web.conversion;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class TwoWayConverter <S, T> implements GenericConverter {

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
            return this.convert((S) source);
        } else {
            return this.convertBack((T) source);
        }
    }

    protected T convert(S source){
    	
    };

    protected S convertBack(T target){
    	
    };

}
