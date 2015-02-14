package georgep.pokuit.test.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * todo File Description
 * <p>
 * <p>
 * Latest Change:
 * <p>
 *
 * @author george2
 * @since 14/02/2015
 */
public class IsProperties {

    private final Map<String, Object> properties = new HashMap<>();

    private final String __EXCEPTION_FORMAT__ = "%s is not a %s property. IsProperties.java";

    public final IsProperties setProperty(String key, Object val) {
        properties.put(key, val);
        return this;
    }

    public final IsProperties removeProperty(String key) {
        properties.remove(key);
        return this;
    }

    public final boolean containsKey(String key) {
        return properties.containsKey(key);
    }

    public final Object getProperty(String key) {
        return properties.get(key);
    }

    public final <T> T getProperty(String key, Class<T> type) throws IsPropertyException {
        Object obj = properties.get(key);

        if(obj != null && type.isAssignableFrom(obj.getClass())) {
            //noinspection unchecked
            return (T) obj;
        }

        throw new IsPropertyException(String.format(__EXCEPTION_FORMAT__, key, type.toString()));
    }

    public final Boolean getBoolean(String key) throws IsPropertyException {
        return getProperty(key, Boolean.class);
    }

    public final String getString(String key) throws IsPropertyException {
        return getProperty(key, String.class);
    }

    public final Integer getInteger(String key) throws IsPropertyException {
        return getProperty(key, Integer.class);
    }

    public final Float getFloat(String key) throws IsPropertyException {
        return getProperty(key, Float.class);
    }

    public final Map<String, Object> __PROPERTIES__() {
        return properties;
    }

    private class IsPropertyException extends Exception {
        public IsPropertyException(String s) {
            super(s);
        }
    }
}
