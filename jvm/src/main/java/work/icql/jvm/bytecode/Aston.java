package work.icql.jvm.bytecode;

import work.icql.jvm.Application;

public class Aston {

    private static int cnum;
    private static int cnum1 = 1;
    private static final int cfnum = 1;

    private static String cstr;
    private static String cstr1 = "1";

    private int num;
    private int num1 = 1;
    private String str;
    private String str1 = "1";

    public void test(int param){
        //"cnum"
        int innerParam = param;
        Application a = new Application();
    }
}
