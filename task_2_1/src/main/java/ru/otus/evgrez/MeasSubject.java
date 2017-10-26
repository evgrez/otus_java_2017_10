package ru.otus.evgrez;

import ru.otus.evgrez.ExCopyObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MeasSubject implements Measurable {
    Class vClassName;
    Class[] argsClass;
    Object[] args = new Object[0];

    public MeasSubject(Class klass) {
        this.vClassName = klass;
    }

    public MeasSubject(Class klass, Object[] args) {
        this.vClassName = klass;
        this.args=args;
        argsClass = new Class[args.length];
        for (int i = 0; i < this.args.length; i++) {
            argsClass[i]=args[i].getClass();
        }
    }

    @Override
    public Object copyObject() throws ExCopyObject
    {
        try {
            if (this.args.length==0){
                return vClassName.newInstance();
            }else {
                Constructor constructor = vClassName.getConstructor(this.argsClass);
                return constructor.newInstance(args);
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new ExCopyObject(e);
        }
    }
}