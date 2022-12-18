package UI_test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Window.Type;

public class textmain extends JFrame {
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
					textmain frame = new textmain();
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
	public textmain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pp\\Desktop\\\u7269\u6D41\u8F66.jpg"));
		setTitle("\u7269\u6D41\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 550);
		contentPane = new JPanel();
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 487, Short.MAX_VALUE)
		);
		
		/*
		 * 加入检查各个数据库的表是否存在，不存在的话创建表
		 */
		ToSQLserver();
		try {
			if(exitTable("member")==false) {
				addTable("member");
			}
			//剩下的表全都这样，还要再addTable添加对应的创建表的程序。
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(100, 100));
		panel.setPreferredSize(new Dimension(120, 120));
		tabbedPane.addTab("\u4EBA\u4E8B\u4FE1\u606F\u7BA1\u7406", null, panel, null);
		
		JLabel lblNewLabel = new JLabel("\u4ECA\u65E5\u8F89\u714C\u7269\u6D41\u516C\u53F8");
		
		JLabel lblNewLabel_1 = new JLabel("操作员：");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("\u589E\u52A0\u5458\u5DE5\u4FE1\u606F");
		
		Object[][] Table_Content = huoquTable_Content();
		Object[] Table_Column = new String[] {
				"\u5DE5\u4F5C\u8BC1\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u8EAB\u4EFD\u8BC1\u53F7", "\u5C45\u4F4F\u5730\u5740", "\u8054\u7CFB\u7535\u8BDD", "\u6240\u5728\u90E8\u95E8"
			};
		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		DefaultTableModel model = new DefaultTableModel(Table_Content,Table_Column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		tabbedPane.addTab("\u8BA2\u5355\u7BA1\u7406", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u8D27\u7269\u4FE1\u606F\u7BA1\u7406", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("\u8D39\u7528\u7EDF\u8BA1", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("\u5BA2\u6237\u4FE1\u606F\u7BA1\u7406", null, panel_4, null);
		contentPane.setLayout(gl_contentPane);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Add_member(model,Table_Column);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u5458\u5DE5\u4FE1\u606F");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Delect_mumber(model,Table_Column);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u5458\u5DE5\u4FE1\u606F");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Update_member(model,Table_Column);
			}
		});
		
		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2\u5458\u5DE5\u4FE1\u606F");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Select_member(model,Table_Column);
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Help();
				list.clearSelection();
			}
		});
		list.setBackground(new Color(240, 240, 240));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"\u5E2E\u52A9\u6587\u6863"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
									.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
									.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
								.addGap(17))
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 691, Short.MAX_VALUE)
								.addComponent(list)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(separator, GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
								.addGap(2)))
						.addGap(0))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(14)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
								.addGap(27)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
								.addGap(18)
								.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
						.addGap(9)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(list))
						.addGap(14))
			);
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
		String member="create table member("
				+"id nchar(10) not null,"
				+"name varchar(20) not null,"
				+"sex varchar(10) not null,"
				+"identyid nchar(20),"
				+"address varchar(100),"
				+"phoneNumber nchar(11) not null,"
				+"department varchar(30) not null,"
				+"primary key (adminId)"
				+")";
		if(Table_name.equals("member")) {
			statement = dbConn.prepareStatement(member);
			statement.execute();
		}
	}
	
}
