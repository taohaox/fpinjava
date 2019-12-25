package com.gonyb.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Gonyb
 * @date 2019/12/2
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ConvertPdfUtil convertPdfUtil = new ConvertPdfUtil();
        convertPdfUtil.accept(new FileInputStream("d://test.docx"),"d://test.pdf");
    }
}
