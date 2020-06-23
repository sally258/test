package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class DungChung {
	public static Connection cn;
	public void KetNoi() throws Exception {
		//b1: Xác định HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		System.out.println("Đã xác định HQTCSDL");
		
		//b2: Kết nối vào csdl
		String url = "jdbc:sqlserver://DESKTOP-5K2RFED\\SQLEXPRESS:1433;databaseName=JVCanBo;user=sa;password=09112000";
		cn = DriverManager.getConnection(url);
//		System.out.println("OK");
	}
	public ResultSet getBang(String tb) throws Exception {
		//b1: tạo câu lệnh SQL
		String sql = "select * from "+tb;
		//b2: tạo câu lệnh
		PreparedStatement cmd = cn.prepareStatement(sql);
		//b3: thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		return rs;
	}
	public DefaultTableModel napbang(String tb) throws Exception {
		ResultSet rs = getBang(tb);
		//lấy ra bảng mô tả của rs
		ResultSetMetaData mt = rs.getMetaData();
		//lấy ra số cột
		int socot = mt.getColumnCount();
		DefaultTableModel mh = new DefaultTableModel();
		//lấy ra tên cột
		for (int i=1; i<=socot; i++) {
			mh.addColumn(mt.getColumnName(i));
		}
		while (rs.next()) {
			Object[] t = new Object[socot];
			for (int i=1; i<=socot; i++) {
				t[i-1] = rs.getString(i);
			}
			mh.addRow(t);
		}
		return mh;
	}
	public int Them(String macb, String tencb, String diachi, float hsl, String tendonvi) throws Exception {
		//Tạo câu lệnh sql để lấy về tất cả đơn vị
		String sql = "insert into CanBo (MaCB, TenCB, DiaChi, Hsl, TenDonVi) values (?,?,?,?,?)\r\n";
		//Tạo ra câu lệnh PrepareStatement
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		//Truyền tham số vào câu lệnh
		cmd.setString(1, macb);
		cmd.setString(2, tencb);
		cmd.setString(3, diachi);
		cmd.setFloat(4, hsl);
		cmd.setString(5,tendonvi);
		//Cho thực hiện câu lệnh
		return cmd.executeUpdate();
	}
	public DefaultTableModel TimKiem(String key) throws Exception{
		String sql = "select * from CanBo where TenCB like ?";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		cmd.setString(1, "%"+key+"%");
		ResultSet rs = cmd.executeQuery();
		ResultSetMetaData mt = rs.getMetaData();
		//lấy ra số cột
		int socot = mt.getColumnCount();
		DefaultTableModel mh = new DefaultTableModel();
		//lấy ra tên cột
		for (int i=1; i<=socot; i++) {
			mh.addColumn(mt.getColumnName(i));
		}
		while (rs.next()) {
			Object[] t = new Object[socot];
			for (int i=1; i<=socot; i++) {
				t[i-1] = rs.getString(i);
			}
			mh.addRow(t);
		}
		return mh;
	}
	public ArrayList<String[]> naptuSQL() throws Exception{
		ArrayList<String[]> d = new ArrayList<String[]>();
		String sql = "select * from CanBo";
		PreparedStatement cmd = DungChung.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		ResultSetMetaData mt = rs.getMetaData();
		int socot = mt.getColumnCount();
		while (rs.next()) {
			String[] t = new String[socot];
			for (int i=1; i<=socot; i++) {
				t[i-1] = rs.getString(i);
			}
			d.add(t);
		}
		return d;
	}
	public boolean ktra (ArrayList<String[]> a, String key) throws Exception{
		for (int i=0; i<a.size(); i++) {
			if (key.equals(a.get(i)[0]))
				return false;
		}
		return true;
	}
}
