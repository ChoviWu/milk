package com.xw.milk.common.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public abstract class BeanResource implements Resource {

    private Class<BeanResource> clazz;
    private BeanResource resource;
    @Override
    public Object getResource() throws IOException{
        InputStream is ;
        is = getInputStream();
        return is;
    }

    @Override
    public InputStream getInputStream() throws IOException {

        return this.getClass().getResourceAsStream("/");
    }

    public BeanResource(){
        newInstance();
    }

    /**
     * 单利
     * @return
     */
    public BeanResource newInstance(){
        if(this.clazz==null){
            try {
                resource= clazz.newInstance();
                return resource;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public abstract Object parseXml();
}
