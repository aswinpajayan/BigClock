package brunoLowagie.itext;
/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */
 
 
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class MyFirstTable {
 
    /** The resulting PDF file. */
    public static String REPORT
        = "TimingReport";
    public static PdfPTable tableLeft;
    public static PdfPTable tableRight;
    public static PdfPTable tableCombined;
    
 
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException, DocumentException {
    	SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
        new MyFirstTable().createPdf(REPORT + sdf.format(new Date()) + ".pdf");
    }
 
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException {
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
       //createTableHeaders();
        tableCombined = new PdfPTable(11);
        
       
         PdfPCell cell = new PdfPCell(tableLeft);
         cell.setColspan(5);
         tableCombined.addCell(cell);
         cell = new PdfPCell(new Phrase(" "));
         cell.setColspan(1);
         cell.setBorder(0);
         tableCombined.addCell(cell);
         
         cell = new PdfPCell(tableRight);
         cell.setColspan(5);
         tableCombined.addCell(cell);
         
        
        document.add(tableCombined);
        //document.add(tableRight);
        // step 5
        document.close();
    }
 
    /**
     * Creates our first table
     * @return 
     * @return our first table
     */
    public static  void createTableHeaders() {
    	// a table with three columns
    	tableLeft = new PdfPTable(5);
        // the cell object
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Voter",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setRowspan(2);
        tableLeft.addCell(cell);
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("Manual ",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setColspan(2);
        tableLeft.addCell(cell);
        
        cell = new PdfPCell(new Phrase("PADU Print",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setColspan(2);
        
        tableLeft.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Candidate",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        tableLeft.addCell(cell);
        cell = new PdfPCell(new Phrase("Time",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        tableLeft.addCell(cell);
        cell = new PdfPCell(new Phrase("Candidate",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        tableLeft.addCell(cell);
        cell = new PdfPCell(new Phrase("Time",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        tableLeft.addCell(cell);
        // we add the four remaining cells with addCell()
//        tableLeft.addCell(new Phrase("1",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
//        tableLeft.addCell(new Phrase("it1",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
//        tableLeft.addCell("23:00:00");
//        tableLeft.addCell("it_1");
//        tableLeft.addCell("23:30:30");
        
        tableRight = new PdfPTable(5);
        cell = new PdfPCell(new Phrase("Voter",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setRowspan(2);
        tableRight.addCell(cell);
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("Manual ",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setColspan(2);
        tableRight.addCell(cell);
        
        cell = new PdfPCell(new Phrase("PADU Print",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setColspan(2);
        
        tableRight.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Candidate",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        tableRight.addCell(cell);
        cell = new PdfPCell(new Phrase("Time",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        tableRight.addCell(cell);
        cell = new PdfPCell(new Phrase("Candidate",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        tableRight.addCell(cell);
        cell = new PdfPCell(new Phrase("Time",FontFactory.getFont(FontFactory.TIMES_ROMAN, 8f)));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        tableRight.addCell(cell);
        // we add the four remaining cells with addCell()
//        tableRight.addCell("1");
//        tableRight.addCell("it1");
//        tableRight.addCell("23:00:00");
//        tableRight.addCell("it_left_1");
//        tableRight.addCell("23:30:30");
    }
}
