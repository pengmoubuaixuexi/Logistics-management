package UI_test;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class Update_member extends JFrame {
	public static Connection dbConn=null;
	static String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Logistics_company";
    static String name = "sa";
    static String passwd = "123";
    public ArrayList<String> bookInfo = new ArrayList<>();
    public PreparedStatement statement = null;
    public ResultSet result = null;
    public int success = 0;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Update_member frame = new Update_member();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Update_member(DefaultTableModel model,Object[] Table_Column) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pp\\Desktop\\\u7269\u6D41\u8F66.jpg"));
		setTitle("\u4FEE\u6539\u5458\u5DE5\u4FE1\u606F");
		ToSQLserver();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 312, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("\u5DE5\u4F5C\u8BC1\u53F7\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		JLabel lblNewLabel_4 = new JLabel("\u5C45\u4F4F\u5730\u5740\uFF1A");
		
		JLabel lblNewLabel_5 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		
		JLabel lblNewLabel_6 = new JLabel("\u6240\u5728\u90E8\u95E8\uFF1A");
		
		textField = new JTextField();
		textField.setToolTipText("\u8BF7\u8F93\u51656\u4F4D\u6570\u5B57\u7684\u5DE5\u53F7");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973", "\u672A\u77E5"}));
		comboBox.setSelectedIndex(2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u672A\u77E5", "\u9500\u552E\u90E8", "\u8D22\u52A1\u90E8", "\u7EF4\u62A4\u90E8", "\u8FD0\u8F93\u90E8", "\u884C\u653F\u90E8"}));
		
		JLabel lblNewLabel_7 = new JLabel("   ");
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					statement = dbConn.prepareStatement("select * from member where Id = "+"'"+textField.getText()+"'");
					result = statement.executeQuery();
					result.next();
					textField_1.setText(result.getString("name"));
					comboBox.setSelectedItem(result.getString("sex"));
					textField_3.setText(result.getString("identyid"));
					textField_4.setText(result.getString("address"));
					textField_5.setText(result.getString("phoneNumber"));
					comboBox_1.setSelectedItem(result.getString("department"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					lblNewLabel_7.setText("查无此人");
				}
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					statement = dbConn.prepareStatement("update member set name='"+textField_1.getText()+"',sex='"+comboBox.getSelectedItem().toString()+"',identyid='"+textField_3.getText()+"',address='"+textField_4.getText()+"',phoneNumber='"+textField_5.getText()+"',department='"+comboBox_1.getSelectedItem().toString()+"' where id ='"+textField.getText()+"'");
					if(statement.executeUpdate()==1) {
						lblNewLabel_7.setText("修改成功");
						model.setDataVector(huoquTable_Content(), Table_Column);
					}
					else {
						lblNewLabel_7.setText("修改失败");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_1, 0, 208, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
										.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
										.addComponent(comboBox, 0, 206, Short.MAX_VALUE))
									.addGap(2))
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
							.addGap(73)))
					.addGap(0))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	public void ToSQLserver() {
        try {
            //1.加载驱动
            //Class.forName方法的作用,就是初始化给定的类.而我们给定的MySQL的Driver类中,
            // 它在静态代码块中通过JDBC的DriverManager注册了一下驱动.我们也可以直接使用JDBC的驱动管理器注册mysql驱动.
            // 从而代替使用Class.forName.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.连接
            dbConn = DriverManager.getConnection(dbURL, name, passwd);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
	public Object[][] huoquTable_Content(){
		ToSQLserver();
		int rowCount = 0,i=0;
		Object[][] Table_Content = null;
		try {
			statement = dbConn.prepareStatement("select * from member");
			result = statement.executeQuery();
			while(result.next()) {
				rowCount++;
			}
			Table_Content = new Object[rowCount][7];
			result = statement.executeQuery();
			while(result.next()) {
				Table_Content[i][0] = result.getString("id");
				Table_Content[i][1] = result.getString("name");
				Table_Content[i][2] = result.getString("sex");
				Table_Content[i][3] = result.getString("identyid");
				Table_Content[i][4] = result.getString("address");
				Table_Content[i][5] = result.getString("phoneNumber");
				Table_Content[i][6] = result.getString("department");
				i++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Table_Content;
	}
}
