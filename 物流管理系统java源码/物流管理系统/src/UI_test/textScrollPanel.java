package UI_test;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class textScrollPanel extends JFrame {
	public static Connection dbConn=null;
	static String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Logistics_company";
    static String name = "sa";
    static String passwd = "123";
    public ArrayList<String> bookInfo = new ArrayList<>();
    public PreparedStatement statement = null;
    public ResultSet result = null;
    public int success = 0;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					textScrollPanel frame = new textScrollPanel();
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
	public textScrollPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
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
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(Table_Content,
				new String[] {
					"\u5DE5\u4F5C\u8BC1\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u8EAB\u4EFD\u8BC1\u53F7", "\u5C45\u4F4F\u5730\u5740", "\u8054\u7CFB\u7535\u8BDD", "\u6240\u5728\u90E8\u95E8"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, true, true, true, true, true, true
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		scrollPane.setViewportView(table);
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
        	e.printStackTrace();
        }
    }
}
