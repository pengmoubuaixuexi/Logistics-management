package UI_test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class register extends JFrame {
	public static Connection dbConn=null;
	static String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Logistics_company";
    static String name = "sa";
    static String passwd = "123";
    public ArrayList<String> bookInfo = new ArrayList<>();
    public PreparedStatement statement = null;
    public ResultSet result = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setToolTipText("\u6D4B\u8BD5\u8D26\u53F7\uFF1Adiyizu");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("\u521D\u59CB\u5BC6\u7801\uFF1A123456");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8D26\u53F7\u6CE8\u518C");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("\u6FC0\u6D3B\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("\u987E\u5BA2\u6CE8\u518C\u53EF\u4E0D\u586B\u5199");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ToSQLserver();
				try {
				statement = dbConn.prepareStatement("select * from admin where adminId ='"+textField.getText()+"'");
				result = statement.executeQuery();
				
				if(result.next()==false) {
					lblNewLabel_4.setText("注册成功");
					statement = dbConn.prepareStatement("insert into admin values('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"')");
					statement.execute();
				}
				else {
					lblNewLabel_4.setText("账号已存在，请更换账号");
				}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(32))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(18)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField_2, Alignment.TRAILING)
							.addComponent(textField_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
					.addGap(102))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(183)
					.addComponent(lblNewLabel_4)
					.addContainerGap(279, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(172)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addGap(159))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(20))
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
}
