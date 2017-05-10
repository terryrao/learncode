package org.raowei.test.current.threadpool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;

/**
 * Created by Administrator on 2017/5/9.
 */
public class PoolObjectFactory<T extends Runnable> implements PooledObjectFactory<T> {
    @Override
    public PooledObject<T> makeObject() throws Exception {
        return null;
    }

    @Override
    public void destroyObject(PooledObject<T> pooledObject) throws Exception {

    }

    @Override
    public boolean validateObject(PooledObject<T> pooledObject) {
        return false;
    }

    @Override
    public void activateObject(PooledObject<T> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<T> pooledObject) throws Exception {

    }
}
