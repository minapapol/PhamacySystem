/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class PrinterService implements Printable {
    
    ArrayList<String> al = new ArrayList();
     DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      DateFormat timeFormat = new SimpleDateFormat("HH:mm");
      //get current date time with Date()
      Date date = new Date();
      Date time = new Date();
      String Date = dateFormat.format(date);
      String Time = timeFormat.format(time);
      String Header = 
            "          ****สหสามหาฟารมาซ****             \n"
            + "Date: "+Date+"     Time: "+Time+"         \n"
            + "------------------------------------------\n"
            + "                          Price     Total \n"
            + "------------------------------------------\n";
      String newline = "\n\n\n\n";
      String detail;
      String bill = Header;
      

      public void pustAl(ArrayList<String> ar){
      al = ar;
      }
      
      public void setdetail(){
          int i;
          int sum = 0;
          String list = "";
           int rdsum = 0;
      for(i = 0;i<al.size();i++){
      String[] data = al.get(i).split(",");
      int amt = 0;
      int amt2 = 0;
      if(Float.parseFloat(data[3])>0){
        if(Float.parseFloat(data[4])==1){     // 0 -> %, 1 -> บาท
        amt = (int) ((Float.parseFloat(data[1])* (Float.parseFloat(data[2])-Float.parseFloat(data[3]))));
        amt2 = (int) ((Float.parseFloat(data[1])* Float.parseFloat(data[3])));
        rdsum = (int) (rdsum+amt2);
         }else{
        amt = (int) ((Float.parseFloat(data[1])* Float.parseFloat(data[2]))*((100-Float.parseFloat(data[3]))/100));
        amt2 = (int) ((Float.parseFloat(data[1])* Float.parseFloat(data[2]))*((Float.parseFloat(data[3]))/100));
        rdsum = (int) (rdsum+amt2);    
        }
      }else{
      amt = (int) (Float.parseFloat(data[1])* Float.parseFloat(data[2]));
      }
      sum = sum+amt;
      if(Float.parseFloat(data[4])==0){ 
        bill = bill+list+data[0]+"\n"+"x "+data[1]+new String(new char[15-4-data[1].length()]).replace("\0"," ")+"ลด "+data[3]+"% "+new String(new char[12-data[2].length()-data[3].length()+1]).replace("\0"," ")+data[2]+new String(new char[10-Integer.toString(amt).length()]).replace("\0"," ")+Integer.toString(amt)+"\n";
      }else{
         bill = bill+list+data[0]+"\n"+"x "+data[1]+new String(new char[15-4-data[1].length()]).replace("\0"," ")+"ลด "+data[3]+" บาท "+new String(new char[9-data[2].length()-data[3].length()+1]).replace("\0"," ")+data[2]+new String(new char[10-Integer.toString(amt).length()]).replace("\0"," ")+Integer.toString(amt)+"\n";
      }
      }
      bill = bill+"------------------------------------------\n";
      bill = bill+new String(new char[7]).replace("\0"," ")+"ลด "+rdsum+" บาท"+new String(new char[9]).replace("\0"," ")+"Total"+new String(new char[10-Integer.toString(sum).length()]).replace("\0"," ")+Integer.toString(sum)+"\n";
      bill = bill+"------------------------------------------\n"+newline;
      System.out.println("sum : "+sum);
      }

      
    public List<String> getPrinters(){

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printServices[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);

        List<String> printerList = new ArrayList<String>();
        for(PrintService printerService: printServices){
            printerList.add( printerService.getName());
        }

        return printerList;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page)
            throws PrinterException {
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /*
         * User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        /* Now we perform our rendering */

        return PAGE_EXISTS;
    }

    public void printString(String printerName) {

        // find the printService of name printerName
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printService[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);
        PrintService service = findPrintService(printerName, printService);

        DocPrintJob job = service.createPrintJob();
//System.out.println("test02");
        try {

            byte[] bytes;

            // important for umlaut chars
            bytes = bill.getBytes("TIS-620");

            Doc doc = new SimpleDoc(bytes, flavor, null);


            job.print(doc, null);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
         byte[] cutP = new byte[] { 0x1d, 'V', 1 };
        printBytes("EPSON TM-T88IV Receipt", cutP);
        byte[] openP = new byte[] {27,112,48,55,121};
        //27,112,48,55,121
        printBytes("EPSON TM-T88IV Receipt", openP);

    }
    
     public void printBytes(String printerName, byte[] bytes) {

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printService[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);
        PrintService service = findPrintService(printerName, printService);

        DocPrintJob job = service.createPrintJob();

        try {

            Doc doc = new SimpleDoc(bytes, flavor, null);
            job.print(doc,null);    

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
      public void printsomething() throws PrinterException
    {
        //find the printService of name printerName
        PrintService ps = findPrintService("EPSON TM-T88IV Receipt");                                    
        //create a printerJob
        PrinterJob job = PrinterJob.getPrinterJob();            
        //set the printService found (should be tested)
        job.setPrintService(ps);      
        //set the printable (an object with the print method that can be called by "job.print")
        job.setPrintable(this);                
        //call je print method of the Printable object
        job.print();
    }
      
      public PrintService findPrintService(String printerName)
    {
        for (PrintService service : PrinterJob.lookupPrintServices())
        {
            if (service.getName().equalsIgnoreCase(printerName))
                return service;
        }

        return null;
    }

    private PrintService findPrintService(String printerName,
            PrintService[] services) {
        for (PrintService service : services) {
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }

        return null;
    }
    
}