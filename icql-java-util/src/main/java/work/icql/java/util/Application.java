package work.icql.java.util;

import work.icql.java.util.pdf.PdfMergeUtils;

import java.util.concurrent.locks.LockSupport;

public class Application {

    public static void main(String[] args) throws Exception {

        LockSupport.parkUntil(System.currentTimeMillis()+1000*60*10);
//        PdfMergeUtils.merge("C:\\Users\\Casstime\\Desktop\\test", "C:\\Users\\Casstime\\Desktop\\test11");
    }
}