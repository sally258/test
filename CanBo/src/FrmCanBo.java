import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DungChung;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FrmCanBo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCanBo frame = new FrmCanBo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	DungChung dc = new DungChung();
	public ArrayList<String[]> cb = new ArrayList<String[]>();
	public ArrayList<String[]> sql;
	
	private JTextField txttim;
	public FrmCanBo() {
		try {
			dc.KetNoi();
			sql = dc.naptuSQL();
		//	table.setModel(dc.napbang("CanBo"));
		} catch (Exception e2) {
			e2.printStackTrace();
			// TODO: handle exception
		}
		/*
		for (int i=0; i<sql.size(); i++)
		{
			for (int j=0; j<sql.get(i).length; j++)
				System.out.print(sql.get(i)[j]+" ");
			System.out.println();
		} */
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 678, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 193, 662, 155);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNpDLiu = new JButton("Đọc file");
		btnNpDLiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader f = new FileReader("canbo.txt");
					BufferedReader r = new BufferedReader(f);
					DefaultTableModel mh = new DefaultTableModel();
					mh.addColumn("Mã cán bộ");
					mh.addColumn("Tên cán bộ");
					mh.addColumn("Địa chỉ");
					mh.addColumn("Hệ số lương");
					mh.addColumn("Tên đơn vị");
					while (true) {
						String st = r.readLine();
						if (st == "" || st == null) break;
						String[] t = st.split("[;]");
						mh.addRow(t);
					}
					r.close();
					table.setModel(mh);
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
		});
		btnNpDLiu.setBounds(476, 23, 151, 23);
		contentPane.add(btnNpDLiu);
		
		JButton btnHinThDng = new JButton("Hiển thị dòng hợp lệ");
		btnHinThDng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader f = new FileReader("canbo.txt");
					BufferedReader r = new BufferedReader(f);
					DefaultTableModel mh = new DefaultTableModel();
					mh.addColumn("Mã cán bộ");
					mh.addColumn("Tên cán bộ");
					mh.addColumn("Địa chỉ");
					mh.addColumn("Hệ số lương");
					mh.addColumn("Tên đơn vị");
					while (true) {
						String st = r.readLine();
						if (st == "" || st == null) break;
						String[] t = st.split("[;]");
						KiemTraHopLe kt = new KiemTraHopLe();
						if (kt.SoThongTin(t, 5)==true && kt.MaHopLe(t[0]) == true) {
							mh.addRow(t);
						}
					}
					table.setModel(mh);
					r.close();
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
		});
		
		btnHinThDng.setBounds(476, 57, 151, 23);
		contentPane.add(btnHinThDng);
		
		JButton btnNewButton = new JButton("Hiển thị ArrLst");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mh = new DefaultTableModel();
				mh.addColumn("Mã cán bộ");
				mh.addColumn("Tên cán bộ");
				mh.addColumn("Địa chỉ");
				mh.addColumn("Hệ số lương");
				mh.addColumn("Tên đơn vị");
				for (String[] s: cb) {
					mh.addRow(s);
				}
				table.setModel(mh);
			}
		});
		btnNewButton.setBounds(476, 91, 151, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Đọc file không hợp lệ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader f = new FileReader("khonghople.txt");
					BufferedReader r = new BufferedReader(f);
					DefaultTableModel mh = new DefaultTableModel();
					mh.addColumn("Dòng không hợp lệ");
					mh.addColumn("Lỗi 1");
					mh.addColumn("Lỗi 2");
					while (true) {
						String st = r.readLine();
						if (st == "" || st == null) break;
						String[] t = st.split("[;]");
						mh.addRow(t);
					}
					r.close();
					table.setModel(mh);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setBounds(476, 125, 151, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btncBngT = new JButton("Đọc bảng từ SQL");
		btncBngT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btncBngT.setBounds(476, 159, 151, 23);
		contentPane.add(btncBngT);
		
		JButton btnLuVoCsdl = new JButton("Lưu vào CSDL");
		btnLuVoCsdl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sql = dc.naptuSQL();
					for (int i=0; i<cb.size(); i++) {
						if (dc.ktra(sql, cb.get(i)[0]))
							dc.Them(cb.get(i)[0], cb.get(i)[1], cb.get(i)[2], Float.parseFloat(cb.get(i)[3]), cb.get(i)[4]);
					
					}
					JOptionPane.showMessageDialog(null, "Dữ liệu đã được nạp");
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
		});
		btnLuVoCsdl.setBounds(35, 23, 143, 23);
		contentPane.add(btnLuVoCsdl);
		
		JButton btnHinThT = new JButton("Hiển thị từ CSDL");
		btnHinThT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.setModel(dc.napbang("CanBo"));
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}
		});
		btnHinThT.setBounds(35, 57, 143, 23);
		contentPane.add(btnHinThT);
		
		txttim = new JTextField();
		txttim.setBounds(23, 109, 183, 20);
		contentPane.add(txttim);
		txttim.setColumns(10);
		
		JButton btnTmKim = new JButton("Tìm Kiếm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.setModel(dc.TimKiem(txttim.getText()));
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
				
			}
		});
		btnTmKim.setBounds(226, 108, 89, 23);
		contentPane.add(btnTmKim);
		
		try {
			FileReader f = new FileReader("canbo.txt");
			BufferedReader r = new BufferedReader(f);
			FileWriter ff = new FileWriter("khonghople.txt");
			PrintWriter w = new PrintWriter(ff);
			int count = 0;
			while (true) {
				String st = r.readLine();
				if (st == "" || st == null) break;
				String[] t = st.split("[;]");
				KiemTraHopLe kt = new KiemTraHopLe();
				if (kt.SoThongTin(t, 5)==true && kt.MaHopLe(t[0]) == true) {
					cb.add(t);
					++count;
				} else {
					String k = "Dong " + String.valueOf(++count);
					if (!kt.SoThongTin(t, 5)) {
						k = k + ";Loi so thong tin khac 5";
					}
					if (!kt.MaHopLe(t[0])) {
						k = k + ";Loi ma cb khong hop le";
					}
					w.println(k);
				}
			}
			r.close();
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
}
