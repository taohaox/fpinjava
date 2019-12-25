package com.gonyb.util;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Gonyb
 * @date 2019/12/2
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ConvertPdfUtil convertPdfUtil = new ConvertPdfUtil();
//        System.setProperty("fontPath",Main.class.getClassLoader().getResource("font/simfang.ttf").getPath());
//        convertPdfUtil.accept(new FileInputStream("C:\\Users\\admin-002\\Desktop\\work\\海豚网FMS功能数据权限隔离方案.docx"),
//                "d://test1.pdf");
        new Main().getPathPrintln();
    }

    public void getPathPrintln(){
        System.out.println(this.getClass().getClassLoader().getResource(""));
        System.out.println(new File(this.getClass().getResource("/").getFile()).getParent());
        System.out.println(System.getProperty("user.dir"));
    }
}
