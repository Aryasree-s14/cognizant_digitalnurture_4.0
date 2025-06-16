package test;

import document.Document;
import factory.*;

public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory word = new WordDocumentFactory();
        Document wordDocu = word.createdocument();
        wordDocu.open();

        DocumentFactory pdf = new PdfDocumentFactory();
        Document pdfDocu = pdf.createdocument();
        pdfDocu.open();

        DocumentFactory excel = new ExcelDocumentFactory();
        Document excelDocu = excel.createdocument();
        excelDocu.open();
    }
}
