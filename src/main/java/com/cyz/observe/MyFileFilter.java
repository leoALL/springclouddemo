package com.cyz.observe;

import org.apache.commons.io.filefilter.IOFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MyFileFilter implements IOFileFilter {
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(MyFileFilter.class);
    @Override
    public boolean accept(File file) {
        LOGGER.info("accept file");
        return true;
    }

    @Override
    public boolean accept(File dir, String name) {
        LOGGER.info("accept dir , name");
        return true;
    }
}
