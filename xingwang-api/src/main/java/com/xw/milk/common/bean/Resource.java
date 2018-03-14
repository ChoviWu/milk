package com.xw.milk.common.bean;

import org.springframework.core.io.InputStreamSource;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public interface Resource extends InputStreamSource {

    String PATH = "classpath:";

    URL getURL() throws Exception;

    Object getResource() throws IOException;

    File getFile() throws IOException;

}
