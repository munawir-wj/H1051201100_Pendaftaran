import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class StudentGUI {

	private JFrame frmStudent;
	private JTable table;
	private JTextField txtNama;
	private JTextField txtNIS;
	private JTextField txtTgl;
	private JComboBox<String> cbJK;
	private JTextField txtTempat;
	private JTextField txtAgama;
	private JTextField txtAsal;
	private JTextField txtAlamat;
	private DefaultTableModel model;
	
	int row;
	

	ArrayList<Student> student = new ArrayList<Student>();
	

	public void tampilkanData() {
		model.setRowCount(0);
		for (int i=0; i<student.size(); i++) {
			Object [] obj = {student.get(i).nama, student.get(i).nis,student.get(i).tgl,student.get(i).tempat,student.get(i).jk,student.get(i).agama,student.get(i).asal,student.get(i).alamat};
			model.addRow(obj);
		}
		
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGUI window = new StudentGUI();
					window.frmStudent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public StudentGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudent = new JFrame();
		frmStudent.setIconImage(Toolkit.getDefaultToolkit().getImage(StudentGUI.class.getResource("/image/siswa.png")));
		frmStudent.setFont(new Font("Cambria", Font.BOLD, 17));
		frmStudent.setTitle("STUDENT");
		frmStudent.setBounds(140, 60, 800, 650);
		frmStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudent.getContentPane().setLayout(null);
		
		JButton refresh = new JButton("REFRESH");
		

		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNama.setText("");
				txtNIS.setText("");
				txtTgl.setText("");
				txtTempat.setText("");
				cbJK.setSelectedIndex(0);
				txtAgama.setText("");
				txtAsal.setText("");
				txtAlamat.setText("");
			}
		});
		refresh.setFocusable(false);
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				refresh.setForeground(new Color(0,0,0));
				refresh.setBackground(new Color(224,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				refresh.setForeground(Color.WHITE);
				refresh.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				refresh.setForeground(new Color(0,0,0));
				refresh.setBackground(new Color(224,255,255));
			}
		});
		
		txtTgl = new JTextField();
		txtTgl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtTgl.setColumns(10);
		txtTgl.setBounds(166, 185, 190, 23);
		frmStudent.getContentPane().add(txtTgl);
		
		cbJK = new JComboBox<String>();
		cbJK.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbJK.setModel(new DefaultComboBoxModel<String>(new String[] {"Laki-laki", "Perempuan"}));
		cbJK.setBounds(530, 90, 190, 23);
		frmStudent.getContentPane().add(cbJK);
		
		txtAlamat = new JTextField();
		txtAlamat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtAlamat.setColumns(10);
		txtAlamat.setBounds(530, 236, 190, 23);
		frmStudent.getContentPane().add(txtAlamat);
		
		txtAsal = new JTextField();
		txtAsal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtAsal.setColumns(10);
		txtAsal.setBounds(530, 184, 190, 23);
		frmStudent.getContentPane().add(txtAsal);
		
		txtAgama = new JTextField();
		txtAgama.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtAgama.setColumns(10);
		txtAgama.setBounds(530, 139, 190, 23);
		frmStudent.getContentPane().add(txtAgama);
		
		txtTempat = new JTextField();
		txtTempat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtTempat.setColumns(10);
		txtTempat.setBounds(166, 230, 190, 23);
		frmStudent.getContentPane().add(txtTempat);
		
		txtNIS = new JTextField();
		txtNIS.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		

		txtNIS.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			char karakter = e.getKeyChar();
			if (!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE)))) {
				e.consume();
			}
		}
		});
		txtNIS.setColumns(10);
		txtNIS.setBounds(166, 137, 190, 23);
		frmStudent.getContentPane().add(txtNIS);
		
		txtNama = new JTextField();
		txtNama.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtNama.setBounds(166, 90, 190, 23);
		frmStudent.getContentPane().add(txtNama);
		txtNama.setColumns(10);
		
		JLabel lblAlamatSekolah = new JLabel("Alamat Sekolah");
		lblAlamatSekolah.setForeground(Color.WHITE);
		lblAlamatSekolah.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAlamatSekolah.setBounds(405, 234, 98, 25);
		frmStudent.getContentPane().add(lblAlamatSekolah);
		
		JLabel lblAsalSekolah = new JLabel("Asal Sekolah");
		lblAsalSekolah.setForeground(Color.WHITE);
		lblAsalSekolah.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAsalSekolah.setBounds(405, 184, 84, 25);
		frmStudent.getContentPane().add(lblAsalSekolah);
		
		JLabel lblAgama = new JLabel("Agama");
		lblAgama.setForeground(Color.WHITE);
		lblAgama.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAgama.setBounds(405, 139, 84, 25);
		frmStudent.getContentPane().add(lblAgama);
		
		JLabel lblJK = new JLabel("Jenis Kelamin");
		lblJK.setForeground(Color.WHITE);
		lblJK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblJK.setBounds(405, 92, 98, 25);
		frmStudent.getContentPane().add(lblJK);
		
		JLabel lblTempatLahir = new JLabel("Tempat Lahir");
		lblTempatLahir.setForeground(Color.WHITE);
		lblTempatLahir.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTempatLahir.setBounds(55, 230, 84, 25);
		frmStudent.getContentPane().add(lblTempatLahir);
		
		JLabel lblTglLahir = new JLabel("Tanggal Lahir");
		lblTglLahir.setForeground(Color.WHITE);
		lblTglLahir.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTglLahir.setBounds(55, 182, 84, 25);
		frmStudent.getContentPane().add(lblTglLahir);
		
		JLabel lblNIS = new JLabel("NIS");
		lblNIS.setForeground(Color.WHITE);
		lblNIS.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNIS.setBounds(55, 137, 84, 25);
		frmStudent.getContentPane().add(lblNIS);
		refresh.setForeground(Color.WHITE);
		refresh.setFont(new Font("Times New Roman", Font.BOLD, 12));
		refresh.setBackground(Color.DARK_GRAY);
		refresh.setBounds(602, 296, 98, 31);
		frmStudent.getContentPane().add(refresh);
		
		JButton hapus = new JButton("HAPUS");
		
	
		hapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Hapus Data","Delete this row?",JOptionPane.YES_NO_OPTION);
				int row=table.getSelectedRow();
			 	if (row>=0 && confirm == 0) {
			 		model.removeRow(row);
			 		JOptionPane.showMessageDialog(null, "Data Sudah Terhapus");
			 		txtNama.setText("");
					txtNIS.setText("");
					txtTgl.setText("");
					txtTempat.setText("");
					cbJK.setSelectedIndex(0);
					txtAgama.setText("");
					txtAsal.setText("");
					txtAlamat.setText("");
					txtNama.setFocusable(true);
			 	} else {
			 		JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus");
			 	}
			}
		});
		hapus.setFocusable(false);
		hapus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hapus.setForeground(new Color(0,0,0));
				hapus.setBackground(new Color(224,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hapus.setForeground(Color.WHITE);
				hapus.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				hapus.setForeground(new Color(0,0,0));
				hapus.setBackground(new Color(224,255,255));
			}
		});
		hapus.setForeground(Color.WHITE);
		hapus.setFont(new Font("Times New Roman", Font.BOLD, 12));
		hapus.setBackground(Color.DARK_GRAY);
		hapus.setBounds(428, 296, 98, 31);
		frmStudent.getContentPane().add(hapus);
		
		JButton edit = new JButton("EDIT");
		
		
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(edit, "Lanjut Menyimpan?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
				if (option == 0) {
					if (txtNama.getText().equals("")) {
						JOptionPane.showMessageDialog(edit, "Nama siswa tidak boleh kosong!");
					} else if (txtNIS.getText().equals("")) {
						JOptionPane.showMessageDialog(edit, "NIS tidak boleh kosong!");
					} else if (txtTgl.getText().equals("")) {
						JOptionPane.showMessageDialog(edit, "Tanggal Lahir tidak boleh kosong!");
					} else if (txtTempat.getText().equals("")) {
						JOptionPane.showMessageDialog(edit, "Tempat Lahir tidak boleh kosong!");
					} else if (txtAgama.getText().equals("")) {
						JOptionPane.showMessageDialog(edit, "Agama tidak boleh kosong!");
					} else if (txtAsal.getText().equals("")) {
						JOptionPane.showMessageDialog(edit, "Asal sekolah tidak boleh kosong!");
					} else if (txtAlamat.getText().equals("")) {
						JOptionPane.showMessageDialog(edit, "Alamat sekolah tidak boleh kosong!");
					} else {
						
						student.get(row).nama=txtNama.getText();
						student.get(row).nis=txtNIS.getText();
						student.get(row).tgl=txtTgl.getText();
						student.get(row).tempat=txtTempat.getText();
						student.get(row).jk=String.valueOf(cbJK.getSelectedItem());
						student.get(row).agama=txtAgama.getText();
						student.get(row).asal=txtAsal.getText();
						student.get(row).alamat=txtAlamat.getText();
						
						
						JOptionPane.showMessageDialog(edit, "Data di update");
						tampilkanData();
						
						txtNama.setText("");
						txtNIS.setText("");
						txtTgl.setText("");
						txtTempat.setText("");
						cbJK.setSelectedIndex(0);
						txtAgama.setText("");
						txtAsal.setText("");
						txtAlamat.setText("");
						txtNama.setFocusable(true);
					}
				}
			}
		});
		edit.setFocusable(false);
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				edit.setForeground(new Color(0,0,0));
				edit.setBackground(new Color(224,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				edit.setForeground(Color.WHITE);
				edit.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				edit.setForeground(new Color(0,0,0));
				edit.setBackground(new Color(224,255,255));
			}
		});
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		edit.setBackground(Color.DARK_GRAY);
		edit.setBounds(258, 296, 98, 31);
		frmStudent.getContentPane().add(edit);
		
		JButton simpan = new JButton("SIMPAN");
		

		simpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.add(new Student (txtNama.getText(), txtNIS.getText(), txtTgl.getText(), txtTempat.getText(), cbJK.getSelectedItem().toString(), txtAgama.getText(), txtAsal.getText(), txtAlamat.getText()));
				model = (DefaultTableModel)table.getModel();
				int option = JOptionPane.showConfirmDialog(simpan, "Lanjut Menyimpan?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

			    if (option == 0) {
			    	if (txtNama.getText().equals("")) {
						JOptionPane.showMessageDialog(simpan, "Nama siswa tidak boleh kosong!");
					} else if (txtNIS.getText().equals("")) {
						JOptionPane.showMessageDialog(simpan, "NIS tidak boleh kosong!");
					} else if (txtTgl.getText().equals("")) {
						JOptionPane.showMessageDialog(simpan, "Tanggal Lahir tidak boleh kosong!");
					} else if (txtTempat.getText().equals("")) {
						JOptionPane.showMessageDialog(simpan, "Tempat Lahir tidak boleh kosong!");
					} else if (txtAgama.getText().equals("")) {
						JOptionPane.showMessageDialog(simpan, "Agama tidak boleh kosong!");
					} else if (txtAsal.getText().equals("")) {
						JOptionPane.showMessageDialog(simpan, "Asal sekolah tidak boleh kosong!");
					} else if (txtAlamat.getText().equals("")) {
						JOptionPane.showMessageDialog(simpan, "Alamat sekolah tidak boleh kosong!");
					} else {
						tampilkanData(); 
						JOptionPane.showMessageDialog(simpan, "Data Tersimpan");
					}
			    	
			    	txtNama.setText("");
					txtNIS.setText("");
					txtTgl.setText("");
					txtTempat.setText("");
					cbJK.setSelectedIndex(0);
					txtAgama.setText("");
					txtAsal.setText("");
					txtAlamat.setText("");
					txtNama.setFocusable(true);
			    }
			}
		});
		simpan.setFocusable(false);
		simpan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				simpan.setForeground(new Color(0,0,0));
				simpan.setBackground(new Color(224,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				simpan.setForeground(Color.WHITE);
				simpan.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				simpan.setForeground(new Color(0,0,0));
				simpan.setBackground(new Color(224,255,255));
			}
		});
		simpan.setForeground(Color.WHITE);
		simpan.setBackground(Color.DARK_GRAY);
		simpan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		simpan.setBounds(93, 296, 98, 31);
		frmStudent.getContentPane().add(simpan);
		
		JLabel lblDataSiswaBaru = new JLabel("Data Siswa Baru");
		lblDataSiswaBaru.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDataSiswaBaru.setForeground(new Color(255,255,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDataSiswaBaru.setForeground(Color.WHITE);
			}
		});
		lblDataSiswaBaru.setBackground(Color.WHITE);
		lblDataSiswaBaru.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataSiswaBaru.setForeground(Color.WHITE);
		lblDataSiswaBaru.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblDataSiswaBaru.setBounds(285, 11, 217, 42);
		frmStudent.getContentPane().add(lblDataSiswaBaru);
		
		JPanel panelData = new JPanel();
		panelData.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panelData.setOpaque(false);
		panelData.setBounds(10, 351, 764, 249);
		frmStudent.getContentPane().add(panelData);
		panelData.setLayout(null);
		
		JLabel lblTabel = new JLabel("Tabel Data Siswa");
		lblTabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTabel.setForeground(new Color(255,255,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTabel.setForeground(Color.WHITE);
			}
		});
		lblTabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTabel.setForeground(Color.WHITE);
		lblTabel.setBounds(10, 11, 128, 25);
		panelData.add(lblTabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 744, 191);
		panelData.add(scrollPane);
		
		table = new JTable();
		

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				
				String nama = table.getValueAt(row, 0).toString();
				String nis = table.getValueAt(row, 1).toString();
				String tgl = table.getValueAt(row, 2).toString();
				String tempat = table.getValueAt(row, 3).toString();
				String jk = table.getValueAt(row, 4).toString();
				String agama = table.getValueAt(row, 5).toString();
				String asal = table.getValueAt(row, 6).toString();
				String alamat = table.getValueAt(row, 7).toString();
				
				
				txtNama.setText(String.valueOf(nama));
				txtNIS.setText(String.valueOf(nis));
				txtTgl.setText(String.valueOf(tgl));
				txtTempat.setText(String.valueOf(tempat));
				cbJK.setSelectedItem(String.valueOf(jk));
				txtAgama.setText(String.valueOf(agama));
				txtAsal.setText(String.valueOf(asal));
				txtAlamat.setText(String.valueOf(alamat));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nama Siswa", "NIS", "Tanggal Lahir", "Tempat Lahir", "Jenis Kelamin", "Agama", "Asal Sekolah", "Alamat Sekolah"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		
		JLabel lblNama = new JLabel("Nama Siswa");
		lblNama.setForeground(Color.WHITE);
		lblNama.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNama.setBounds(55, 90, 84, 25);
		frmStudent.getContentPane().add(lblNama);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StudentGUI.class.getResource("/image/green.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 784, 611);
		frmStudent.getContentPane().add(lblNewLabel);
	}
}
