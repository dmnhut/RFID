package model;

import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class Events {

    private String codeNo;
    private String name;
    private String date;
    private String beginTime;
    private String endTime;

    public Events(String codeNo, String name, String date, String beginTime, String endTime) {
        this.codeNo = codeNo;
        this.name = name;
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getCodeNo() {
        return this.codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

//    public boolean registerEvents( sinhVien) {
//        /* Can co bang Chi Tiet Su Kien */
//        String sql = "INSERT INTO DangKySuKien VALUES ('" + this.getId() + "', '" + sinhVien.getRFID() + "')";
//        return ConnectToSql.update(sql);
//    }
//    public boolean deleteEvents() {
//        String sql = "Delete FROM SuKien WHERE IdSukien='" + this.getId() + "'";
//        return ConnectToSql.update(sql);
//    }
    public boolean addEvents() {
        String sql = "INSERT INTO EVENTS VALUES ('" + this.getCodeNo() + "', '" + this.getName() + "', '" + this.getDate()
                + "', '" + this.getBeginTime() + "', '" + this.getEndTime() + "')";
        return ConnectToSql.update(sql);
    }

    public static void listen2Update(JTable tbl, String where) {
        try {
            form.frmMain.TableModel = new DefaultTableModel();
            String[] colsName = {"MÃ SỐ", "TÊN SỰ KIỆN", "NGÀY TỔ CHỨC", "THỜI GIAN BẮT ĐẦU", "THỜI GIAN KẾT THÚC"};
            form.frmMain.TableModel.setColumnIdentifiers(colsName);
            tbl.setModel(form.frmMain.TableModel);
            String sql = "SELECT * FROM EVENTS" + where;
            System.out.println(sql);
            ResultSet rs = model.ConnectToSql.select(sql);
            while (rs.next()) {
                Object rows[] = new Object[5];
                rows[0] = rs.getString(1);
                rows[1] = rs.getString(2);
                rows[2] = rs.getString(3);
                rows[3] = rs.getString(4);
                rows[4] = rs.getString(5);
                form.frmMain.TableModel.addRow(rows);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void edit2SaveEvents(JTable tbl) {
        try {
            for (int i = 0; i < tbl.getRowCount(); i++) {
                Object codeNo = form.frmMain.TableModel.getValueAt(i, 0);
                Object name = form.frmMain.TableModel.getValueAt(i, 1);
                Object date = form.frmMain.TableModel.getValueAt(i, 2);
                Object beginTime = form.frmMain.TableModel.getValueAt(i, 3);
                Object endTime = form.frmMain.TableModel.getValueAt(i, 4);
                String sql = "UPDATE EVENTS SET codeNo = '" + codeNo.toString() + "', name = '" + name + "', date = '" + date + "', beginTime = '" + beginTime + "', endTime = '" + endTime + "' WHERE codeNo = '" + codeNo + "'";
                ConnectToSql.update(sql);
            }
        } catch (Exception ex) {
            System.out.println("LỖI KHI XÓA SỰ KIỆN");
            ex.printStackTrace();
        }
    }

    public static void deleteEvents(JTable tbl) {
        try {
            int r = tbl.getSelectedRow();
            Object id = form.frmMain.TableModel.getValueAt(r, 0);
            String sql = "DELETE FROM EVENTS WHERE codeNo='" + id + "'";
            ConnectToSql.update(sql);
        } catch (Exception ex) {
            System.out.println("LỖI KHI CẬP NHẬT SỰ KIỆN");
            ex.printStackTrace();
        }
    }

    //   public boolean daDangKy(String RFID) {
    // Co ten trong danh sach ky
    // Da dang ky truoc
    // Nhung phai thu truy van lan luot tu 2 bang trong co so du lieu
    // Truy van tu Sinh vien hoac Can bo
    // Thu truy van tu Bang Sinh vien truoc
//       
//        String codeNo, name, timeIn, timeOut, sql;
//        Account_SV sinhVien = new Account_SV(RFID, "", "", "", "", "", "");
//        sinhVien.refresh();
//        if (sinhVien.getMasoID().equals("")) {
//            // Khi khong tim thay o bang sinh vien chuyen sang truy van tu Bang can bo
//            Account_CB canBo = new Account_CB(RFID, "", "", "", "", "");
//            canBo.refresh();
//            if (canBo.getMasoID().equals("")) {
//                return false;
//            } else {
//                codeNo = canBo.getMasoID();
//                name = canBo.getName();
//            }
//        } else {
//            codeNo = sinhVien.getMasoID();
//            name = sinhVien.getName();
//        }
//
//        // Lay thoi gian
//        models.Date date = new models.Date();
//        timeIn = date.getTimeAndDate();
//        timeOut = "unknow";
    // Thuc hien ghi nhan diem danh bang lenh truy van Insert
    // Can co Bang Diem Danh trong CSDL
//        sql = "INSERT INTO BangDiemDanh VALUES ('" + this.getId() + "', '" + codeNo + "', '" + name + "', '" + timeIn
//                + "', '" + timeOut + "')";
//        return ConnectToSql.update(sql);
//    }
//    public int diemDanh(String RFID) {
//        // // Lay thoi gian
//        // long milliseconds = System.currentTimeMillis();
//        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        // Date resultdate = new Date(milliseconds);
//        // timeIn = sdf.format(resultdate).toString();
//        // timeOut = "unknow";
//
//        // Can co bang dk su kien trong excel da dang ky diem danh truoc
//        String sql = "SELECT MSSV, HOvaTen FROM DaDangKy WHERE RFID='" + RFID + "'";
//        ResultSet result = ConnectToSql.select(sql);
//        if (result.equals(null)) {
//            // Chua dk su kien. Nhung co tham du su kien nay
//            // He thong yeu cau nhap MSSV / MSCB
//            // Bat dau ghi: se select thong tin lan luot tu 2 bang SV va CB
//            // Neu co thi Insert, ko co thi {
//            // vua diem danh
//            // vua them moi 2 thuoc tinh RFID VS MS
//            // }
//            if (!daDangKy(RFID)) {
//                // Tao moi tai khoan
//                return -1;
//            }
//            // cho phep dang ky su kien tai cho
//            daDangKy(RFID);
//            return 0;
//        } else {
//            daDangKy(RFID);
//            return 1;
//        }
//    }
}
