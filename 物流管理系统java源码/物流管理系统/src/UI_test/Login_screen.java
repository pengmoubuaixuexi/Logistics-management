package UI_test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;

public class Login_screen extends JFrame {
	public static Connection dbConn=null;
	static String dbURL = "jdbc:sqlserver://localhost;DatabaseName=Logistics_company";
    static String name = "sa";
    static String passwd = "123";
    public ArrayList<String> bookInfo = new ArrayList<>();
    public PreparedStatement statement = null;
    public ResultSet result = null;
	private JPanel contentPane;
	private JTextField zhanghaotextField;
	private JTextField mimatextField;
    private JLabel databasetishi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_screen frame = new Login_screen();
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
	public Login_screen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pp\\Desktop\\\u7B2C1\u7EC4\u8F6F\u4EF6\u5DE5\u7A0B\u56FE\u6807.jpg"));
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		zhanghaotextField = new JTextField();
		zhanghaotextField.setToolTipText("\u6D4B\u8BD5\u8D26\u53F7\uFF1Adiyizu");
		zhanghaotextField.setColumns(10);
		
		mimatextField = new JTextField();
		mimatextField.setToolTipText("\u521D\u59CB\u5BC6\u7801\uFF1A123456");
		mimatextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("\u7B2C1\u7EC4\u7269\u6D41\u7CFB\u7EDF");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String zhanghao = zhanghaotextField.getText();
				String mima = mimatextField.getText();
				try {
					ToSQLserver();
					if(exitTable("admin")==false) {
						addTable("admin");
					}
					else {
						statement = dbConn.prepareStatement("select * from admin where adminId = 'diyizu'");
						result = statement.executeQuery();
						if(result.next()) {
							statement = dbConn.prepareStatement("select * from admin where adminId = 'diyizu' and password = '123456'");
							result = statement.executeQuery();
							if(result.next()==false) {
								statement = dbConn.prepareStatement("update admin set password='123456',status='管理员' where adminId = 'diyizu'");
								statement.execute();
							}
						}
						else {
							statement = dbConn.prepareStatement("insert into admin values('diyizu','123456','管理员')");
							statement.execute();
						}
					}
					statement = dbConn.prepareStatement("select * from admin where adminId = "+"'"+zhanghao+"'");
					result = statement.executeQuery();
					result.next();
					if (mima.equals(result.getString("password"))) {
						//if分支，admin表再加一列表示身份的，用于不同的登录界面。
						databasetishi.setText("登录成功");
						if(result.getString("status").equals("管理员")) {
							new Main_Interface(zhanghao);
						}
						else if(result.getString("status").equals("顾客")) 
						{
							new Customer_interface();
						}
						else 
						{
							
						}
						dispose();
					}
					else {
						databasetishi.setText("账号或密码错误");
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		databasetishi = new JLabel(" ");
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ToSQLserver();
				new register();
				list.clearSelection();
			}
		});
		list.setBackground(new Color(240, 240, 240));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"\u6CE8\u518C"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(mimatextField)
											.addComponent(zhanghaotextField, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))
								.addComponent(databasetishi, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(180)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(list)))
					.addContainerGap(76, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel_2)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(zhanghaotextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(mimatextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(databasetishi)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(list))
					.addGap(55))
		);
		contentPane.setLayout(gl_contentPane);
		
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
        	try {
				dbConn = DriverManager.getConnection("jdbc:sqlserver://localhost;DatabaseName=master", name, passwd);
				statement = dbConn.prepareStatement("create database Logistics_company");
				statement.executeUpdate();
				dbConn = DriverManager.getConnection(dbURL, name, passwd);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				databasetishi.setText("连接数据库失败");
			}
        }
    }
	public boolean exitTable(String Table_name) throws SQLException {
		DatabaseMetaData meta = dbConn.getMetaData();
		ResultSet result = meta.getTables(null, null, Table_name, null);
		if(result.next()) {
			return true;
		}
		else {
			return false;
		}
	}
	public void addTable(String Table_name) throws SQLException {
		String admin="create table admin("
				+"adminId varchar(50) not null,"
				+"password varchar(50) not null,"
				+ "status varchar(30) not null,"
				+"primary key (adminId)"
				+")";
		if(Table_name.equals("admin")) {
			statement = dbConn.prepareStatement(admin);
			statement.execute();
			statement = dbConn.prepareStatement("insert into admin values('diyizu','123456','管理员')");
			statement.execute();
		}
	}
}
