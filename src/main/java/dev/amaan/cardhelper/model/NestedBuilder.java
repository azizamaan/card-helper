package dev.amaan.cardhelper.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class NestedBuilder<T, V> {
    protected T parent;

    /**
     * To get the parent builder
     *
     * @return T the instance of the parent builder
     */
    public T done() {
        Class<?> parentClass = parent.getClass();
        try {
            V build = this.build();
            String methodname = "with" + build.getClass().getSimpleName();
            Method method = parentClass.getDeclaredMethod(methodname, build.getClass());
            method.invoke(parent, build);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return parent;
    }

    public abstract V build();

    /**
     * @param parent
     * @return
     */
    public <P extends NestedBuilder<T, V>> P withParentBuilder(T parent) {
        this.parent = parent;
        return (P) this;
    }
}