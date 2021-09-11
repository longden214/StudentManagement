/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.sun.javafx.tk.FileChooserType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.SeeMark;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class WriteFile {
    public static boolean WriteFileExcel(List<SeeMark> data){
            
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Student Mark Management");
            
            XSSFRow row = null;
            Cell cell = null;
            
            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH ĐIỂM HỌC VIÊN");
            
            row = spreadsheet.createRow((short) 3);
            row.setHeight((short) 500);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Faculty");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Class");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Teacher");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("RollName");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("StudentName");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Subject");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Mark");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Mark_Type");
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Number or exams");
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Result");
            
            List<SeeMark> list = new ArrayList<>(data);
            
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    SeeMark sm = list.get(i);
                    row = spreadsheet.createRow((short) 4 + i);
                    row.setHeight((short) 400);
                    
                    row.createCell(0).setCellValue(sm.getIdFaculty());
                    row.createCell(1).setCellValue(sm.getLop());
                    row.createCell(2).setCellValue(sm.getTen());
                    row.createCell(3).setCellValue(sm.getIdsv());
                    row.createCell(4).setCellValue(sm.getName());
                    row.createCell(5).setCellValue(sm.getMon());
                    row.createCell(6).setCellValue(sm.getDiem());
                    row.createCell(7).setCellValue(sm.getType_mark());
                    row.createCell(8).setCellValue(sm.getLanthi());
                    row.createCell(9).setCellValue(sm.getKetqua());
                }
                
                JFileChooser fs = new JFileChooser(".");
                fs.setDialogTitle("Save a file");
                int result = fs.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File myFile = new File(fs.getSelectedFile()+".xlsx");
                        FileOutputStream out= new FileOutputStream(myFile);
                        workbook.write(out);
                        out.close();
                        
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        return false;
    }
    
    public static boolean WriteFileTXT(List<SeeMark> data) {
        PrintWriter pw = null;
        try {
            List<SeeMark> list = new ArrayList<>(data);
            if (list != null) {
                JFileChooser fs = new JFileChooser(new File("c:\\"));
                fs.setDialogTitle("Save a file");
                int result = fs.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = new File(fs.getSelectedFile()+".txt");
                    pw = new PrintWriter(file);

                    pw.printf("+------------------------+------------+-------------------+-----------+----------------------+------------------+----------+---------------+-----------------+--------------+%n");
                    pw.printf("| Faculty                | Class      | Teacher           | RollNo    | StudentName          | Subject          | Mark     | Mark Type     | Number of exams | Result       |%n");
                    pw.printf("+------------------------+------------+-------------------+-----------+----------------------+------------------+----------+---------------+-----------------+--------------+%n");
                    for (SeeMark sm : list) {
                        pw.printf("| %-22s | %-10s | %-17s | %-9s | %-20s | %-16s | %-8.2f | %-13s | %-15d | %-12s |%n",sm.getIdFaculty(),sm.getLop(),sm.getTen(),sm.getIdsv(),sm.getName(),sm.getMon(),sm.getDiem(),sm.getType_mark(),sm.getLanthi(),sm.getKetqua());
                    }   
                    pw.printf("+------------------------+------------+-------------------+-----------+----------------------+------------------+----------+---------------+-----------------+--------------+%n");

                    pw.flush();
                    pw.close();
                    return true;
                }
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }
}
