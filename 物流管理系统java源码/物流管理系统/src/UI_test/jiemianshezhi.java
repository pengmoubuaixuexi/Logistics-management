package UI_test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class jiemianshezhi extends JFrame {
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
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jiemianshezhi frame = new jiemianshezhi();
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
	public jiemianshezhi() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setPreferredSize(new Dimension (500,500));
		splitPane.setDividerLocation(233);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		
		JLabel lblNewLabel_7 = new JLabel("     ");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(splitPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(177)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(183))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(204)
					.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(207))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 8, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		JLabel lblNewLabel = new JLabel("\u4E14\u6761\u4EF6\u67E5\u8BE2\u9009\u62E9");
		
		textField = new JTextField();
		textField.setToolTipText("\u8BF7\u8F93\u51656\u4F4D\u6570\u5B57\u7684\u5DE5\u53F7");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5DE5\u4F5C\u8BC1\u53F7\uFF1A");
		
		JLabel lblNewLabel_1_1 = new JLabel("\u59D3\u540D\uFF1A");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\u672A\u77E5", "\u7537", "\u5973"}));
		comboBox.setSelectedIndex(0);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "\u672A\u77E5", "\u9500\u552E\u90E8", "\u8D22\u52A1\u90E8", "\u7EF4\u62A4\u90E8", "\u8FD0\u8F93\u90E8", "\u884C\u653F\u90E8"}));
		comboBox_1.setSelectedIndex(0);
		
		JLabel lblNewLabel_6 = new JLabel("\u6240\u5728\u90E8\u95E8\uFF1A");
		
		JLabel lblNewLabel_4 = new JLabel("\u5C45\u4F4F\u5730\u5740\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		JLabel lblNewLabel_5 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		
		JLabel lblNewLabel_2_1 = new JLabel("\u6027\u522B\uFF1A");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox_1, 0, 113, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_4, 113, 113, 113))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_3, 113, 113, 113))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_2, 113, 113, 113))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(comboBox, 0, 113, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
							.addGap(31))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(138))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
					.addGap(51)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNewLabel_4))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNewLabel_5))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblNewLabel_6))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(58))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(500, 500));
		splitPane.setRightComponent(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u6216\u6761\u4EF6\u67E5\u8BE2\u9009\u62E9");
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("\u8BF7\u8F93\u51656\u4F4D\u6570\u5B57\u7684\u5DE5\u53F7");
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u5DE5\u4F5C\u8BC1\u53F7\uFF1A");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u59D3\u540D\uFF1A");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "\u672A\u77E5", "\u7537", "\u5973"}));
		comboBox_2.setSelectedIndex(0);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"", "\u672A\u77E5", "\u9500\u552E\u90E8", "\u8D22\u52A1\u90E8", "\u7EF4\u62A4\u90E8", "\u8FD0\u8F93\u90E8", "\u884C\u653F\u90E8"}));
		comboBox_1_1.setSelectedIndex(0);
		
		JLabel lblNewLabel_6_1 = new JLabel("\u6240\u5728\u90E8\u95E8\uFF1A");
		
		JLabel lblNewLabel_4_1 = new JLabel("\u5C45\u4F4F\u5730\u5740\uFF1A");
		
		JLabel lblNewLabel_3_1 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		JLabel lblNewLabel_5_1 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\u6027\u522B\uFF1A");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_6_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_1_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_2))
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1_1))
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_1_1))
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3_1))
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_4_1))
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5_1))
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_6_1))
						.addComponent(comboBox_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(59))
		);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id1 = textField.getText();
				String id2 = textField_5.getText();
				String id=null;
				if(id1.equals("")&&id2!="") {
					id = id2;
				}
				else {
					id = id1;
				}
				String name1 = textField_1.getText();
				String name2 = textField_6.getText();
				String name=null;
				String a1=" and ";
				if(name1.equals("")&&name2.equals("")==false) {
					name = name2;
					a1=" or ";
				}
				else {
					name = name1;
				}
				String sex1 = comboBox.getSelectedItem().toString();
				String sex2 = comboBox_1_1.getSelectedItem().toString();
				String sex=null;
				String a2=" and ";
				if(sex1.equals("")&&sex2.equals("")==false) {
					sex = sex2;
					a2=" or ";
				}
				else {
					sex = sex1;
				}
				String identyid1 = textField_2.getText();
				String identyid2 = textField_7.getText();
				String identyid=null;
				String a3=" and ";
				if(identyid1.equals("")&&identyid2.equals("")==false) {
					identyid = identyid2;
					a3=" or ";
				}
				else {
					identyid = identyid1;
				}
				String address1 = textField_3.getText();
				String address2 = textField_8.getText();
				String address=null;
				String a4=" and ";
				if(address1.equals("")&&address2.equals("")==false) {
					address = address2;
					a4=" or ";
				}
				else {
					address = address1;
				}
				String phoneNumber1 = textField_4.getText();
				String phoneNumber2 = textField_9.getText();
				String phoneNumber=null;
				String a5=" and ";
				if(phoneNumber1.equals("")&&phoneNumber2.equals("")==false) {
					phoneNumber = phoneNumber2;
					a5=" or ";
				}
				else {
					phoneNumber = phoneNumber1;
				}
				String department1 = comboBox_1.getSelectedItem().toString();
				String department2 = comboBox_2.getSelectedItem().toString();
				String department=null;
				String a6=" and ";
				if(department1.equals("")&&department2.equals("")==false) {
					department = department2;
					a6=" or ";
				}
				else {
					department = department1;
				}
				String Select = juzi(id,name,a1,sex,a2,identyid,a3,address,a4,phoneNumber,a5,department,a6);
				System.out.println(Select);
				Object[][] Table_Content=huoquTable_Content(Select);
				
			}
		});
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
	public String juzi(String id,String name,String a1,String sex,String a2,String identyid,String a3,String address,String a4,String phoneNumber,String a5,String department,String a6) {
		String jichu = "select * from member where ";
		String houmian = "id like '%"+id+"%'"+a1+"name like '%"+name+"%'"+a2+"sex like '%"+sex+"%'"+a3+"identyid like '%"+identyid+"%'"+a4+"address like '%"+address+"%'"+a5+"phoneNumber like '%"+phoneNumber+"%'"+a6+"department like '%"+department+"%'";
		return jichu+houmian;
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
	public Object[][] huoquTable_Content(String Select){
		ToSQLserver();
		int rowCount = 0,i=0;
		Object[][] Table_Content = null;
		try {
			statement = dbConn.prepareStatement(Select);
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
