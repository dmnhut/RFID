/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author langduong
 */
public class Excel {

    public static void importStudentFromxlsx(String pathName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(pathName));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator fm = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : sheet) {
                ArrayList<String> al = new ArrayList();
                for (Cell cell : row) {
                    switch (fm.evaluate(cell).getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            al.add(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            al.add(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                    }
                }
                if (model.Regex.check_Number(al.get(0)) && model.Regex.check_Number(al.get(1))
                        && model.Regex.check_Maso(al.get(2)) && !model.Regex.check_txtNULL(al.get(3))
                        && !model.Regex.check_txtNULL(al.get(4)) && !model.Regex.check_txtNULL(al.get(5))
                        && !model.Regex.check_txtNULL(al.get(6)) && !model.Regex.check_txtNULL(al.get(7))) {
                    model.Student newStudent = new Student(al.get(1), al.get(2), al.get(3), al.get(4), al.get(5), al.get(6), al.get(7));
                    if (newStudent.themTaiKhoan()) {
                    } else {
                        new JOptionPane().showMessageDialog(null, "Việc thêm mới thất bại với SV: " + newStudent.name);
                        
                    }
                }
            }
            wb.close();
            file.close();
        } catch (IOException ex) {
          //  Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void importStudentFromxls(String pathName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(pathName));
            HSSFWorkbook wb = new HSSFWorkbook(file);
            HSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator fm = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : sheet) {
                ArrayList<String> al = new ArrayList();
                for (Cell cell : row) {
                    switch (fm.evaluate(cell).getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            al.add(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            al.add(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                    }
                }
                if (model.Regex.check_Number(al.get(0)) && model.Regex.check_Number(al.get(1))
                        && model.Regex.check_Maso(al.get(2)) && !model.Regex.check_txtNULL(al.get(3))
                        && !model.Regex.check_txtNULL(al.get(4)) && !model.Regex.check_txtNULL(al.get(5))
                        && !model.Regex.check_txtNULL(al.get(6)) && !model.Regex.check_txtNULL(al.get(7))) {
                    model.Student newStudent = new Student(al.get(1), al.get(2), al.get(3), al.get(4), al.get(5), al.get(6), al.get(7));
                    if (newStudent.themTaiKhoan()) {
                    } else {
                        new JOptionPane().showMessageDialog(null, "Việc thêm mới thất bại với SV: " + newStudent.name);
                        
                    }
                }
            }
            wb.close();
            file.close();
        } catch (IOException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void importEmployerFromxlsx(String pathName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(pathName));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator fm = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : sheet) {
                ArrayList<String> al = new ArrayList();
                for (Cell cell : row) {
                    switch (fm.evaluate(cell).getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            al.add(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            al.add(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                    }
                }
                if (model.Regex.check_Number(al.get(0)) && model.Regex.check_Number(al.get(1))
                        && model.Regex.check_Maso(al.get(2)) && !model.Regex.check_txtNULL(al.get(3))
                        && !model.Regex.check_txtNULL(al.get(4)) && !model.Regex.check_txtNULL(al.get(5))
                        && !model.Regex.check_txtNULL(al.get(6))) {
                    model.Employer newEmplpyer = new Employer(al.get(1), al.get(2), al.get(3), al.get(4), al.get(5), al.get(6));
                    if (newEmplpyer.themTaiKhoan()) {
                    } else {
                        new JOptionPane().showMessageDialog(null, "Việc thêm mới thất bại với CB: " + newEmplpyer.name);
                    }
                }
            }
            wb.close();
            file.close();
        } catch (IOException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void importEmployerFromxls(String pathName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(pathName));
            HSSFWorkbook wb = new HSSFWorkbook(file);
            HSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator fm = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : sheet) {
                ArrayList<String> al = new ArrayList();
                for (Cell cell : row) {
                    switch (fm.evaluate(cell).getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            al.add(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            al.add(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                    }
                }
                if (model.Regex.check_Number(al.get(0)) && model.Regex.check_Number(al.get(1))
                        && model.Regex.check_Maso(al.get(2)) && !model.Regex.check_txtNULL(al.get(3))
                        && !model.Regex.check_txtNULL(al.get(4)) && !model.Regex.check_txtNULL(al.get(5))
                        && !model.Regex.check_txtNULL(al.get(6))) {
                    model.Employer newEmplpyer = new Employer(al.get(1), al.get(2), al.get(3), al.get(4), al.get(5), al.get(6));
                    if (newEmplpyer.themTaiKhoan()) {
                    } else {
                        new JOptionPane().showMessageDialog(null, "Việc thêm mới thất bại với CB: " + newEmplpyer.name);
                    }
                }
            }
            wb.close();
            file.close();
        } catch (IOException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void importRegisterEventFromxlsx(String pathName, String EventName) {
        FileInputStream file = null;
        model.Events ev = new Events("", EventName, "", "", "");
        ev.refresh();
        try {
            file = new FileInputStream(new File(pathName));
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator fm = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : sheet) {
                ArrayList<String> al = new ArrayList();
                for (Cell cell : row) {
                    switch (fm.evaluate(cell).getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            al.add(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            al.add(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                    }
                }
                if (model.Regex.check_Number(al.get(0)) && model.Regex.check_Maso(al.get(1)) && !model.Regex.check_txtNULL(al.get(2))) {
                    model.Account newAccount = new Account("", al.get(1), al.get(2));
                    newAccount.refresh();
                    if (!ev.checkRegister(newAccount)) {
                        ev.addRegister(newAccount);
                    }
                }
            }
            wb.close();
            file.close();
        } catch (IOException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void importRegisterEventFromxls(String pathName, String EventName) {
        FileInputStream file = null;
        model.Events ev = new Events("", EventName, "", "", "");
        ev.refresh();
        try {
            file = new FileInputStream(new File(pathName));
            HSSFWorkbook wb = new HSSFWorkbook(file);
            HSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator fm = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : sheet) {
                ArrayList<String> al = new ArrayList();
                for (Cell cell : row) {
                    switch (fm.evaluate(cell).getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            al.add(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            al.add(String.valueOf((int) cell.getNumericCellValue()));
                            break;
                    }
                }
                if (model.Regex.check_Number(al.get(0)) && model.Regex.check_Maso(al.get(1)) && !model.Regex.check_txtNULL(al.get(2))) {
                    model.Account newAccount = new Account("", al.get(1), al.get(2));
                    newAccount.refresh();
                    if (!ev.checkRegister(newAccount)) {
                        ev.addRegister(newAccount);
                    }
                }
            }
            wb.close();
            file.close();
        } catch (IOException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void exportExcel_ThamGia(String pathName, String eventName) {
        File file = new File(pathName);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("DSTG_SK");
        int rownum = 1;
        Row row;
        Cell cell;
        row = sheet.createRow(0);
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Sự Kiện: " + eventName);
        row = sheet.createRow(rownum++);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("MÃ SỐ");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("HỌ VÀ TÊN");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("THỜI GIAN VÀO");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("THỜI GIAN RA");
        String sql = "select codeID,fullName,inputTime,outTime from CHECKIN.dbo.CHECKIN ch, CHECKIN.DBO.EVENTS ev where (ch.codeNo=ev.codeNo) and ev.name=N'" + eventName + "' and (inputTime is not null) and outTime is not null";
        ResultSet rs = model.ConnectToSql.select(sql);
        try {
            while (rs.next()) {
                row = sheet.createRow(rownum++);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(rownum-2);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(rs.getString(1));
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(rs.getString(2));
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(rs.getString(3));
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(rs.getString(4));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        file.getParentFile().mkdirs();
        try {
            FileOutputStream out = new FileOutputStream(file);
            wb.write(out);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
         //   Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void exportExcel_Vang(String pathName, String eventName) {
        File file = new File(pathName);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("DSTG_SK");
        int rownum = 1;
        Row row;
        Cell cell;
        row = sheet.createRow(0);
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Sự Kiện: " + eventName);
        row = sheet.createRow(rownum++);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("MÃ SỐ");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("HỌ VÀ TÊN");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("THỜI GIAN VÀO");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("THỜI GIAN RA");
        String sql = "select codeID,fullName,inputTime,outTime from CHECKIN.dbo.CHECKIN ch, CHECKIN.DBO.EVENTS ev where (ch.codeNo=ev.codeNo) and ev.name=N'" + eventName + "' and ((inputTime is null) or (outTime is  null))";

        ResultSet rs = model.ConnectToSql.select(sql);
        try {
            while (rs.next()) {
                row = sheet.createRow(rownum++);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(rownum-2);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(rs.getString(1));
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(rs.getString(2));
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(rs.getString(3));
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(rs.getString(4));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
        file.getParentFile().mkdirs();
        try {
            FileOutputStream out = new FileOutputStream(file);
            wb.write(out);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void importRegisterEvent(String pathName, String EventName) {
        if(model.Regex.check_excel(pathName)){
            if(model.Regex.check_xls(pathName))
                model.Excel.importRegisterEventFromxls(pathName, EventName);
            else
                model.Excel.importRegisterEventFromxlsx(pathName, EventName);
        }else
            JOptionPane.showMessageDialog(null, "Không đúng định dạng");
    }

    public static void importStudent(String pathName) {
            if(model.Regex.check_excel(pathName)){
            if(model.Regex.check_xls(pathName))
                model.Excel.importStudentFromxls(pathName);
            else
                model.Excel.importStudentFromxlsx(pathName);
        }else
            JOptionPane.showMessageDialog(null, "Không đúng định dạng");
    }

    public static void importEmployer(String pathName) {
                if(model.Regex.check_excel(pathName)){
            if(model.Regex.check_xls(pathName))
                model.Excel.importEmployerFromxls(pathName);
            else
                model.Excel.importEmployerFromxlsx(pathName);
        }else
            JOptionPane.showMessageDialog(null, "Không đúng định dạng");
    }
}