package com.gonyb.util;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.BiConsumer;

/**
 * @author Gonyb
 * @date 2019/12/2
 */
public class ConvertPdfUtil implements BiConsumer<InputStream, String> {

    @Override
    public void accept(InputStream docInput, String pdfPath) {
        try (OutputStream pdf = new FileOutputStream(pdfPath)){
            XWPFDocument xwpfDocument = new XWPFDocument(docInput);
            PdfOptions pdfOptions = PdfOptions.create();

            String font = System.getProperty("fontPath");
            if(font!=null&& !font.isEmpty()){
                pdfOptions.fontProvider((familyName, encoding, size, style, color) -> {
                    try {
                        BaseFont bfChinese = BaseFont.createFont(font, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
                        Font fontChinese = new Font(bfChinese, size, style, color);
                        if (familyName != null){
                            fontChinese.setFamily(familyName);
                        }
                        return fontChinese;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                });
            }
            PdfConverter.getInstance().convert(xwpfDocument,pdf,pdfOptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
