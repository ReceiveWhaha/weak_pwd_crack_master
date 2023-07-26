import javax.swing.*;
import java.awt.*;
public class Ui_MainWindow {
 public void setupUi(JFrame MainWindow) {
 MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 MainWindow.setSize(737, 532);
 
 JPanel centralwidget = new JPanel();
 centralwidget.setName("centralwidget");
 BorderLayout centralLayout = new BorderLayout();
 centralwidget.setLayout(centralLayout);
 
 JPanel verticalLayout_2 = new JPanel();
 verticalLayout_2.setName("verticalLayout_2");
 verticalLayout_2.setLayout(new BoxLayout(verticalLayout_2, BoxLayout.Y_AXIS));
 
 JLabel label = new JLabel();
 label.setMinimumSize(new Dimension(0, 80));
 Font font = new Font("微软雅黑", Font.PLAIN, 20);
 label.setFont(font);
 label.setBackground(new Color(0, 0, 127,150));
 label.setForeground(Color.WHITE);
 label.setHorizontalAlignment(SwingConstants.CENTER);
 label.setName("label");
 verticalLayout_2.add(label);
 
 JPanel horizontalLayout = new JPanel();
 horizontalLayout.setName("horizontalLayout");
 BorderLayout horizontalLayout_Layout = new BorderLayout();
 horizontalLayout.setLayout(horizontalLayout_Layout);
 
 JPanel verticalLayout = new JPanel();
 verticalLayout.setName("verticalLayout");
 FlowLayout verticalFlowLayout = new Flowlayout();
 verticalFlowLayout.setVgap(0); // 设置垂直间距为0
 verticalFlowLayout.setAlignment(FlowLayout.CENTER); // 设置对齐方式为居中
 verticalLaout.setLayout(verticalFlowLayout);
 
 JButton button1 = new JButton();
 button1.setMinimumSize(new Dimension(0, 80));
 Font buttonFont1 = new Font("微软雅黑", Font.PLAIN, 10);
 button1.setFont(buttonFont1);
 button1.setCheckable(true);
 button1.setSelected(true); // 设置默认选中
 button1.setName("pushButton");
 verticalLaout.add(button1);

 JButton button2 = new JButton();
 button2.setMinimumSize(new Dimension(0, 80));
 Font buttonFont2 = new Font("微软雅黑", Font.PLAIN, 10);
 button2.setFont(buttonFont2);
 button2.setCheckable(true);
 button2.setName("pushButton_2");
 verticalLaout.add(button2);

 JButton button3 = new JButton();
 button3.setMinimumSize(new Dimension(0, 80));
 Font buttonFont3 = new Font("微软雅黑", Font.PLAIN, 10);
 button3.setFont(buttonFont3);
 button3.setCheckable(true);
 button3.setName("pushButton_3");
 verticalLaout.add(button3);

 JButton button4 = new JButton();
 button4.setMinimumSize(new Dimension(0, 80));
 Font buttonFont4 = new Font("微软雅黑", Font.PLAIN, 10);
 button4.setFont(buttonFont4);
 button4.setCheckable(true);
 btnSsh.setName("pushButton_4");
 verticalLaout.add(button4);

 JButton button5 = new JButton();
 btnLocal.setMinimumSize(new Dimension(0, 80));
 Font btnLocalFont = new Font("微软雅黑", Font.PLAIN, 10);
 btnLocal.setFont(btnLocalFont);
 btnLocal.setCheckable(true);
 bttnLocal.setName("pushButton_5");
 verticalLaout.adetn(button5);

 horizontalLayout.add(verticalLayout, BorderLayout.WEST);

 JPanel stackedWidget = new JPanel();
 stackedWidget.setName("stackedWidget");

 JPanel page = new JPanel();
 page.setName("page");
 QVBoxLayout pageLayout =new QVBoxLayout(page); 
 pageLayout.setSpacing(20); // 设置间距
 QHBoxLayout horizontalLayout_12 =new QHBoxLayout();
 horizontalLayout_12.setName("horizontalLayout_12");

 JPanel verticalLayout_3 =new JPanel();
 verticalLayout_3.setLayout(new BoxLayot(verticalLayout_3, BoxLyot.Y_AXIS));
 
 QHBoxLayout horizontalLoyout_2= new QHBoxLayout();
 horizontalLoyout_2.setLayout(new FlowLayout(FlowLayout.LEFT));
 
 JLabel label2= new JLabel();
 label2.setMinimumSize(new Dimension(120, 0));
 Font labelFont2= new Font("微软雅黑", Font.PLAIN,10);
 label2.setFont(labelFont2);
 label2.setAligment(SwingConstants.CENTER);
 labelLl.setText("label_2");   // 设置标签文本
 horizontalLoyout_2. add(label2);

 JTextField textField = new JTextField();
 textField.setMinimumSize(new Dimension(0, 35));

 horizontalLoyout_2.add(textField);

 verticalLayout_3.add(horizontalLayout_2);
 pageLayout.add(verticalLayout_3);
 stackedWidget.add(page);

 stackedWidget.Adto(panel, BorderLayout.CENTER);
 centralWidget.setLayout(veticalLayout_2);
 MainWindow.setContentPane(centralWidget);
 MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 MainWindow.setSize(737, 532);
 
 JPanel centralwidget = new JPanel();
 centralwidget.setName("centralwidget");
 BorderLayout centralLayout = new BorderLayout();
 centralwidget.setLayout(centralLayout);
 
 JPanel verticalLayout_2 = new JPanel();
 verticalLayout_2.setName("verticalLayout_2");
 verticalLayout_2.setLayout(new BoxLayout(verticalLayout_2, BoxLayout.Y_AXIS));
 
 JLabel label = new JLabel();
 label.setMinimumSize(new Dimension(0, 80));
 Font font = new Font("微软雅黑", Font.PLAIN, 20);
 label.setFont(font);
 label.setBackground(new Color(0, 0, 127,150));
 label.setForeground(Color.WHITE);
 label.setHorizontalAlignment(SwingConstants.CENTER);
 label.setName("label");
 verticalLayout_2.add(label);
 
 JPanel horizontalLayout = new JPanel();
 horizontalLayout.setName("horizontalLayout");
 BorderLayout horizontalLayout_Layout = new BorderLayout();
 horizontalLayout.setLayout(horizontalLayout_Layout);
 
 JPanel verticalLayout = new JPanel();
 verticalLayout.setName("verticalLayout");
 Flowlayout verticalFlowLayout = new Flowlayout();
 verticalFlowLayout.setVgap(0); // 设置垂直间距为0
 verticalFlowLayout.setAlignment(FlowLayout.CENTER); // 设置对齐方式为居中
 verticalLaout.setLayout(verticalFlowLayout);

 // 添加其他 QLineEdit 文本框的代码
 
 horizontalLaout.add(label5);    
 JTextField textField5= new JTextField();
 textField5.setMinimumSize(new Dimension(0, 35));
 horizontalLoyout.add(textField5);   
 vericalLaout.add(horizontalLoayout);

font.setPointSize(10)
self.pushButton_7.setFont(font)
self.pushButton_7.setObjectName("pushButton_7")
self.verticalLayout_6.addWidget(self.pushButton_7)
        self.textEdit = QtWidgets.QTextEdit(self.page_2)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Fixed)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.textEdit.sizePolicy().hasHeightForWidth())
        self.textEdit.setSizePolicy(sizePolicy)
        self.textEdit.setMaximumSize(QtCore.QSize(16777215, 100))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.textEdit.setFont(font)
        self.textEdit.setObjectName("textEdit")
        self.verticalLayout_6.addWidget(self.textEdit)
        spacerItem1 = QtWidgets.QSpacerItem(20, 122, QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Expanding)
        self.verticalLayout_6.addItem(spacerItem1)
        self.stackedWidget.addWidget(self.page_2)
        self.page_3 = QtWidgets.QWidget()
        self.page_3.setObjectName("page_3")
        self.verticalLayout_7 = QtWidgets.QVBoxLayout(self.page_3)
        self.verticalLayout_7.setObjectName("verticalLayout_7")
        self.horizontalLayout_13 = QtWidgets.QHBoxLayout()
        self.horizontalLayout_13.setObjectName("horizontalLayout_13")
        self.label_12 = QtWidgets.QLabel(self.page_3)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Fixed, QtWidgets.QSizePolicy.Preferred)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.label_12.sizePolicy().hasHeightForWidth())
        self.label_12.setSizePolicy(sizePolicy)
        self.label_12.setMinimumSize(QtCore.QSize(50, 0))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.label_12.setFont(font)
        self.label_12.setAlignment(QtCore.Qt.AlignCenter)
        self.label_12.setObjectName("label_12")
        self.horizontalLayout_13.addWidget(self.label_12)
        self.pushButton_8 = QtWidgets.QPushButton(self.page_3)
        self.pushButton_8.setMinimumSize(QtCore.QSize(0, 35))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.pushButton_8.setFont(font)
        self.pushButton_8.setObjectName("pushButton_8")
        self.horizontalLayout_13.addWidget(self.pushButton_8)
        self.verticalLayout_7.addLayout(self.horizontalLayout_13)
        self.textEdit_4 = QtWidgets.QTextEdit(self.page_3)
        self.textEdit_4.setObjectName("textEdit_4")
        self.verticalLayout_7.addWidget(self.textEdit_4)
        self.pushButton_9 = QtWidgets.QPushButton(self.page_3)
        self.pushButton_9.setMinimumSize(QtCore.QSize(0, 35))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.pushButton_9.setFont(font)
        self.pushButton_9.setObjectName("pushButton_9")
        self.verticalLayout_7.addWidget(self.pushButton_9)
        self.textEdit_5 = QtWidgets.QTextEdit(self.page_3)
        self.textEdit_5.setObjectName("textEdit_5")
        self.verticalLayout_7.addWidget(self.textEdit_5)
        self.stackedWidget.addWidget(self.page_3)
        self.page_4 = QtWidgets.QWidget()
        self.page_4.setObjectName("page_4")
        self.verticalLayout_8 = QtWidgets.QVBoxLayout(self.page_4)
        self.verticalLayout_8.setObjectName("verticalLayout_8")
        spacerItem2 = QtWidgets.QSpacerItem(20, 124, QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Expanding)
        self.verticalLayout_8.addItem(spacerItem2)
        self.horizontalLayout_14 = QtWidgets.QHBoxLayout()
        self.horizontalLayout_14.setObjectName("horizontalLayout_14")
        self.label_13 = QtWidgets.QLabel(self.page_4)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Preferred)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.label_13.sizePolicy().hasHeightForWidth())
        self.label_13.setSizePolicy(sizePolicy)
        self.label_13.setMinimumSize(QtCore.QSize(50, 0))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.label_13.setFont(font)
        self.label_13.setAlignment(QtCore.Qt.AlignCenter)
        self.label_13.setObjectName("label_13")
        self.horizontalLayout_14.addWidget(self.label_13)
        self.lineEdit_12 = QtWidgets.QLineEdit(self.page_4)
        self.lineEdit_12.setMinimumSize(QtCore.QSize(0, 35))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.lineEdit_12.setFont(font)
        self.lineEdit_12.setObjectName("lineEdit_12")
        self.horizontalLayout_14.addWidget(self.lineEdit_12)
        self.pushButton_10 = QtWidgets.QPushButton(self.page_4)
        self.pushButton_10.setMinimumSize(QtCore.QSize(0, 35))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.pushButton_10.setFont(font)
        self.pushButton_10.setObjectName("pushButton_10")
        self.horizontalLayout_14.addWidget(self.pushButton_10)
        self.verticalLayout_8.addLayout(self.horizontalLayout_14)
        self.textEdit_2 = QtWidgets.QTextEdit(self.page_4)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Fixed)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.textEdit_2.sizePolicy().hasHeightForWidth())
        self.textEdit_2.setSizePolicy(sizePolicy)
        self.textEdit_2.setMaximumSize(QtCore.QSize(16777215, 100))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.textEdit_2.setFont(font)
        self.textEdit_2.setObjectName("textEdit_2")
        self.verticalLayout_8.addWidget(self.textEdit_2)
        spacerItem3 = QtWidgets.QSpacerItem(20, 123, QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Expanding)
        self.verticalLayout_8.addItem(spacerItem3)
        self.stackedWidget.addWidget(self.page_4)
        self.page_5 = QtWidgets.QWidget()
        self.page_5.setObjectName("page_5")
        self.verticalLayout_9 = QtWidgets.QVBoxLayout(self.page_5)
        self.verticalLayout_9.setObjectName("verticalLayout_9")
        spacerItem4 = QtWidgets.QSpacerItem(20, 124, QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Expanding)
        self.verticalLayout_9.addItem(spacerItem4)
        self.horizontalLayout_15 = QtWidgets.QHBoxLayout()
        self.horizontalLayout_15.setObjectName("horizontalLayout_15")
        self.label_14 = QtWidgets.QLabel(self.page_5)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Preferred)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.label_14.sizePolicy().hasHeightForWidth())
        self.label_14.setSizePolicy(sizePolicy)
        self.label_14.setMinimumSize(QtCore.QSize(50, 0))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.label_14.setFont(font)
        self.label_14.setAlignment(QtCore.Qt.AlignCenter)
        self.label_14.setObjectName("label_14")
        self.horizontalLayout_15.addWidget(self.label_14)
        self.lineEdit_13 = QtWidgets.QLineEdit(self.page_5)
        self.lineEdit_13.setMinimumSize(QtCore.QSize(0, 35))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
   font.setPointSize(10)
        self.lineEdit_13.setFont(font)
        self.lineEdit_13.setObjectName("lineEdit_13")
        self.horizontalLayout_15.addWidget(self.lineEdit_13)
        self.pushButton_11 = QtWidgets.QPushButton(self.page_5)
        self.pushButton_11.setMinimumSize(QtCore.QSize(0, 35))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.pushButton_11.setFont(font)
        self.pushButton_11.setObjectName("pushButton_11")
        self.horizontalLayout_15.addWidget(self.pushButton_11)
        self.verticalLayout_9.addLayout(self.horizontalLayout_15)
        self.textEdit_3 = QtWidgets.QTextEdit(self.page_5)
        sizePolicy = QtWidgets.QSizePolicy(QtWidgets.QSizePolicy.Expanding, QtWidgets.QSizePolicy.Fixed)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(self.textEdit_3.sizePolicy().hasHeightForWidth())
        self.textEdit_3.setSizePolicy(sizePolicy)
        self.textEdit_3.setMaximumSize(QtCore.QSize(16777215, 100))
        font = QtGui.QFont()
        font.setFamily("微软雅黑")
        font.setPointSize(10)
        self.textEdit_3.setFont(font)
        self.textEdit_3.setObjectName("textEdit_3")
        self.verticalLayout_9.addWidget(self.textEdit_3)
        spacerItem5 = QtWidgets.QSpacerItem(20, 123, QtWidgets.QSizePolicy.Minimum, QtWidgets.QSizePolicy.Expanding)
        self.verticalLayout_9.addItem(spacerItem5)
        self.stackedWidget.addWidget(self.page_5)
        self.horizontalLayout.addWidget(self.stackedWidget)
        self.verticalLayout_2.addLayout(self.horizontalLayout)
        MainWindow.setCentralWidget(self.centralwidget)

        self.retranslateUi(MainWindow)
        self.stackedWidget.setCurrentIndex(2)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)
 pagePanel.add(horizontalLayout_12);
 pagePanel.add(line);
 pagePanel.add(verticalLaout_4);
 stackedWidget.ad(page);
 centralwidget.setLayout(verticalLayout_2);
 MainWindow.setContentPane(centralwidget);


 }
}



import javax.swing.*;
import java.awt.*;
public class Main {
 public static void main(String[] args) {
 SwingUtilities.invokeLater(() -> createAndShowGUI());
 }
 private static void createAndShowGUI() {
 JFrame frame = new JFrame("检测系统");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 JPanel panel = new JPanel();
 panel.setLayout(new BorderLayout());
 
 JLabel label = new JLabel();
 label.setMinimumSize(new Dimension(0, 80));
 Font font = new Font("微软雅黑", Font.PLAIN, 20);
 label.setFont(font);
 label.setText("弱口令检测系统");
 label.setHorizontalAlignment(SwingConstants.CENTER);
 panel.add(label, BorderLayout.NORTH);
 
 JPanel buttonPanel = new JPanel();
 buttonPanel.setLayout(new GridLayout(5, 1));
 
 JButton button1 = new JButton("弱口令字典生成器");
 button1.setMinimumSize(new Dimension(0, 80));
 Font buttonFont = new Font("微软雅黑", Font.PLAIN, 10);
 button1.setFont(buttonFont);
 JRadioButton radioButton1 = new JRadioButton();
 JButton button2 = new JButton("MySQL数据库弱口令检测");
 button2.setMinimumSize(new Dimension(0, 80));
 button2.setFont(buttonFont);
 JRadioButton radioButton2 = new JRadioButton();
 JButton button3 = new JButton("HTTP协议的Web应用弱口令检测");
 button3.setMinimumSize(new Dimension(0, 80));
 button3.setFont(buttonFont);
 JRadioButton radioButton3 = new JRadioButton();
 JButton button4 = new JButton("SSH服务弱口令检测");
 button4.setMinimumSize(new Dimension(0, 80));
 button4.setFont(buttonFont);
 JRadioButton radioButton4 = new JRadioButton();
 JButton button5 = new JButton("本地弱口令检测");
 button5.setMinimumSize(new Dimension(0, 80));
 button5.setFont(buttonFont);
 JRadioButton radioButton5 = new JRadioButton();
 
 ButtonGroup buttonGroup = new ButtonGroup();
 buttonGroup.add(radioButton1);
 buttonGroup.add(radioButton2);
 buttonGroup.add(radioButton3);
 buttonGroup.add(radioButton4);
 buttonGroup.add(radioButton5);
 
 buttonPanel.add(button1);
 buttonPanel.add(button2);
 buttonPanel.add(button3);
 buttonPanel.add(button4);
 buttonPanel.add(button5);
 panel.add(buttonPanel, BorderLayout.WEST);

 JPanel pagePanel = new JPanel();
 pagePanel.setLayout(new BorderLayout());

 JPanel inputPanel = new JPanel();
 inputPanel.setLayout(new GridLayout(11, 2));

 JLabel label1 = new JLabel("账户名:");
 label1.setMinimumSize(new Dimension(120, 0));
 label1.setFont(font);

 JTextField textField1 = new JTextField();
 textField1.setMinimumSize(new Dimension(0,35));
 textField1.setFont(font);

 JLabel label2 = new JLabel("姓名拼音:");
 label2.setMinimumSize(new Dimension(120, 0));
 label2.setFont(font);

 JTextField textField2 = new JTextField();
 textField2.setMinimumSize(new Dimension(0,35));
 textField2.setFont(font);

 // 继续添加其他的标签和文本框

 inputPanel.add(label1);
 inputPanel.add(textField1);
 inputPanel.add(label2);
 inputPanel.add(textField2);

 // 添加其他的标签和文本框

 pagePanel.add(inputPanel, BorderLayout.NORTH);

 JTabbedPane tabbedPane = new JTabbedPane();
 tabbedPane.addTab("Page", pagePanel);

 panel.setOpaque(true);
 frame.setContentPane(panel);
 frame.pack();
 frame.setVisible(true);
 }
}
