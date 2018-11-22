package com.cyz.observe;



import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.FileFilter;

public class ObserveImpl {
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ObserveImpl.class);

    private void test() throws Exception{
        String filePath = "D:\\test1";
        FileFilter filter=FileFilterUtils.and(new MyFileFilter());
        FileAlterationObserver filealtertionObserver=new FileAlterationObserver(filePath, filter);
        filealtertionObserver.addListener(new FileAlterationListenerAdaptor() {

            @Override
            public void onDirectoryCreate(File directory) {
                LOGGER.info("onDirectoryCreate");
                super.onDirectoryCreate(directory);
            }

            @Override
            public void onDirectoryDelete(File directory) {
                LOGGER.info("onDirectoryDelete");
                super.onDirectoryDelete(directory);
            }

            @Override
            public void onFileChange(File directory) {
                LOGGER.info("onFileChange");
                super.onFileChange(directory);
            }

            @Override
            public void onFileCreate(File directory) {
                LOGGER.info("onFileCreate");
                super.onFileCreate(directory);
            }

            @Override
            public void onFileDelete(File directory) {
                LOGGER.info("onFileDelete");
                super.onFileDelete(directory);
            }

            @Override
            public void onStart(FileAlterationObserver observer) {
                LOGGER.info("onStart");
                super.onStart(observer);
            }
        });

        FileAlterationMonitor fileAlterationMonitor = new FileAlterationMonitor();
        fileAlterationMonitor.addObserver(filealtertionObserver);
        fileAlterationMonitor.start();
    }

    public static void main(String[] args) throws Exception {
        ObserveImpl impl = new ObserveImpl();
        impl.test();
    }
}
