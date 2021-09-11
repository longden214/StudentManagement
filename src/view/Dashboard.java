/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CheckForm;
import controller.ClassImp;
import controller.Class_SearchImp;
import controller.CourseImp;
import controller.FacultyImp;
import controller.Faculty_SearchImp;
import controller.MarkImp;
import controller.Mark_TypeImp;
import controller.ScheduleImp;
import controller.SeeMarkImp;
import controller.SemImp;
import controller.StudentImp;
import controller.SubjectImp;
import controller.SubjectSearchImp;
import controller.SystemManage;
import controller.TeacherImp;
import controller.Teacher_ClassImp;
import controller.Teacher_SearchImp;
import controller.Teacher_SubjectImp;
import controller.UserDao;
import controller.WriteFile;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.chart.NumberAxis;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Attendance;
import model.Course;
import model.Faculty;
import model.User;
import model.Class;
import model.ClassSearch;
import model.Faculty_Search;
import model.Mark;
import model.Mark_Type;
import model.Schedule;
import model.SeeMark;
import model.Sem;
import model.Student;
import model.Subject;
import model.Subject_Search;
import model.Teacher;
import model.Teacher_Class;
import model.Teacher_Search;
import model.Teacher_Subject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author admin
 */
public class Dashboard extends javax.swing.JFrame {
    static User user_login;
    private UserDao userDao;
    private CourseImp courseImp;
    private FacultyImp facultyImp;
    private ClassImp classImp;
    private Mark_TypeImp mark_typeImp;
    private TeacherImp tdao;
    private StudentImp stdImp;
    private SubjectImp sbdao;
    private Teacher_ClassImp tcdao;
    private Teacher_SubjectImp tsdao;
    private SemImp semdao;
    private SystemManage systemManage;
    private MarkImp markdao;
    private SeeMarkImp smdao;
    private Teacher_SearchImp teacher_searchdao;
    private Faculty_SearchImp faculty_searchdao;
    private Class_SearchImp csdao;
    private SubjectSearchImp subject_searchdao;
    private ScheduleImp scheduleImp;
    private DefaultPieDataset dataset = new DefaultPieDataset();
    private JFreeChart jfreeChart;
    private ChartPanel chartPanel;
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        
    }
    
    public Dashboard(User u) {
        initComponents();
        setLocationRelativeTo(null);
//        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        user_login = u;
        processLoginSuccessful();

        userDao = new UserDao();
        courseImp = new CourseImp();
        facultyImp = new FacultyImp();
        classImp = new ClassImp();
        mark_typeImp = new Mark_TypeImp();
        tdao = new TeacherImp();
        stdImp = new StudentImp();
        sbdao = new SubjectImp();
        tcdao= new Teacher_ClassImp();
        tsdao = new Teacher_SubjectImp();
        semdao = new SemImp();
        systemManage = new SystemManage();
        markdao = new MarkImp();
        smdao = new SeeMarkImp();
        teacher_searchdao = new Teacher_SearchImp();
        faculty_searchdao = new Faculty_SearchImp();
        csdao = new Class_SearchImp();
        subject_searchdao = new SubjectSearchImp();
        scheduleImp = new ScheduleImp();
        
        tblUsers.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailUser();
            }
        });
        tblCourse.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailCourse();
            }
        });
        
        tblFaculty.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailFaculty();
            }
        });
        
        tblClass.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailClass();
            }
        });
        
        tblMark_Type.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               detailMark_Type();
            }
        });
        tbl_Teacher.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailTeacher();
            }
        });
        
        tblStudent.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailStudent();
            }
        });
        
        tbl_Subject.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailSubject();
            }
        });
        
        tblTeacherClass.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailTeacherClass();
            }
        });
        
        tblTeacherSubject.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailTeacherSubject();
            }
        });
        
        tbl_Sem.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailSem();
            }
        });
        
        tbl_Mark.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailMark();
                
            }
        });
        
        tblSchedule.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailSchedule();
                
            }
        });
        
        tblTodayAttendance.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                detailTodayAttendance();
                
            }
        });
        
        countStudent.setText(systemManage.CountStudent()+"");
        countTeacher.setText(systemManage.CountTeacher()+"");
        countClass.setText(systemManage.CountClass()+"");
        countCourse.setText(systemManage.CountCourse()+"");
        countUser.setText(systemManage.CountUser()+"");
        countSubject.setText(systemManage.CountSubject()+"");
        
        jPanel70.setVisible(false);
        loadCombobox();
        loadUsers(null);
        loadCourse(null);
        loadFaculty(null);
        loadClass(null);
        loadMark_Type(null);
        loadTeacher(null);
        loadStudent(null);
        loadSubject(null);
        loadTeacherClass(null);
        loadTeacherSubject(null);
        loadSem(null);
        loadMark(null);
        loadSeeMark(null,null,null,"",0);
        loadStudent_Search(null);
        loadTeacher_Search(null);
        loadFaculty_Search(null);
        loadClass_Search(null);
        loadSubject_Search(null);
        loadSchedule("");
        loadScheduleToday();
        jPanel148.setVisible(false);
        
    }
    
    public void StatisticalMark(String idsv){
        //Set gia tr cho PieChart
        dataset = new DefaultPieDataset();
        
        int khongDat = systemManage.CountKQ(idsv, "Không Đạt");
        int hocLai = systemManage.CountKQ(idsv, "Học lại");
        int dat = systemManage.CountKQ(idsv, "Đạt");
        
        dataset.setValue("Đạt", dat);
        dataset.setValue("Không Đạt", khongDat);
        dataset.setValue("Học Lại",hocLai);

        jfreeChart = ChartFactory.createPieChart3D("Biểu Đồ Ghi Nhận Kết Qủa Học Tập", dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) jfreeChart.getPlot();

        plot.setForegroundAlpha(0.6f);
        plot.setSectionPaint("Không đạt ", new Color(255, 0, 0)); //Set color cho PieChart
        plot.setSectionPaint("Đạt", new Color(0, 255, 0)); //Set color cho PieChart
        plot.setBackgroundPaint(new Color(255, 255, 255)); //Set background cho PieChart
        
        // add chartPanel PieChart vao panel
        chartPanel = new ChartPanel(jfreeChart);
        chartPanel.setBounds(32, 36, 440, 350); //set size PieChart
        pnlStatisticalMark.add(chartPanel);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setZoomAroundAnchor(true);
        chartPanel.setBackground(SystemColor.menu);

    }
    
    private void processLoginSuccessful(){
        lblUsername.setText(user_login.getUserName());
        
        if (user_login.getRole().equals("Teacher")) {
            btnStudent.removeMouseListener(btnStudent.getMouseListeners()[0]);
            btnTeacher.removeMouseListener(btnTeacher.getMouseListeners()[0]);
            btnUsers.removeMouseListener(btnUsers.getMouseListeners()[0]);
            btnClass.removeMouseListener(btnClass.getMouseListeners()[0]);
            btnSubject.removeMouseListener(btnSubject.getMouseListeners()[0]);
            btnCourse.removeMouseListener(btnCourse.getMouseListeners()[0]);

        }
        if (user_login.getRole().equals("Member")) {
            btnDashboard.removeMouseListener(btnDashboard.getMouseListeners()[0]);
            btnStudent.removeMouseListener(btnStudent.getMouseListeners()[0]);
            btnTeacher.removeMouseListener(btnTeacher.getMouseListeners()[0]);
            btnUsers.removeMouseListener(btnUsers.getMouseListeners()[0]);
            btnMark.removeMouseListener(btnMark.getMouseListeners()[0]);
            btnClass.removeMouseListener(btnClass.getMouseListeners()[0]);
            btnSubject.removeMouseListener(btnSubject.getMouseListeners()[0]);
            btnCourse.removeMouseListener(btnCourse.getMouseListeners()[0]);
            btnAtendances.removeMouseListener(btnAtendances.getMouseListeners()[0]);
            btnSeeMark.removeMouseListener(btnSeeMark.getMouseListeners()[0]);
            btnSearch.removeMouseListener(btnSearch.getMouseListeners()[0]);
        }
        
    }
    
    public void loadUsers(String name){
        loadCombobox();
        List<User> list = new ArrayList<>(userDao.getAllUser(name));
        DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
        model.setRowCount(0);
        for (User u : list) {
            model.addRow(new Object[]{
                u.getId(),u.getUserName(),u.getRole()
            });
        }
        tblUsers.setModel(model);
    }
    
    public void loadCourse(String search){
         loadCombobox();
        List<Course> list = new ArrayList<>(courseImp.getCourse(search));
        
        DefaultTableModel model = (DefaultTableModel) tblCourse.getModel();
        model.setRowCount(0);
        for (Course c : list) {
            model.addRow(new Object[]{
                c.getMaCourse(),c.getStartDate(),c.getEndDate()
            });
        }
        tblCourse.setModel(model);
    }
    
    public void loadFaculty(String search){
        loadCombobox();
        List<Faculty> list = new ArrayList<>(facultyImp.getFaculty(search));
        
        DefaultTableModel model = (DefaultTableModel) tblFaculty.getModel();
        model.setRowCount(0);
        for (Faculty f : list) {
            model.addRow(new Object[]{
                f.getId(),f.getName(),f.getYear()
            });
        }
        tblFaculty.setModel(model);
    }
    
    public void loadScheduleToday(){
        List<Schedule> list = new ArrayList<>(systemManage.getListSchedule());
        
        DefaultTableModel model = (DefaultTableModel) tblTodayAttendance.getModel();
        model.setRowCount(0);
        for (Schedule s : list) {
            model.addRow(new Object[]{
                s.getId(),s.getIdClass(),s.getNameSubject(),s.getNameTeacher()
            });
        }
        tblTodayAttendance.setModel(model);
    }
    
    public void loadCombobox(){
        cbbFacultyClass.removeAllItems();
        cbbCourseClass.removeAllItems();
        cbbClassStd.removeAllItems();
        cbbFacultySubject.removeAllItems();
        combo_TeacherClass.removeAllItems();
        cbbTeacherSubject.removeAllItems();
        comboFaculty_Sem.removeAllItems();
        comboSubject_Sem.removeAllItems();
        cbbSubjectMark.removeAllItems();
        comboType_Mark.removeAllItems();
        combomon_SeeMark.removeAllItems();
        combolop_SeeMark.removeAllItems();
        combokhoa_SeeMark.removeAllItems();
        cbbSubjectSchedule.removeAllItems();
        cbbClassSchedule.removeAllItems();
        
        for (Faculty f : facultyImp.getFaculty(null)) {
            cbbFacultyClass.addItem(f);
        }
        
        for (Course c : courseImp.getCourse(null)) {
            cbbCourseClass.addItem(c);
        }
        
        for (Class c : classImp.getClass(null)) {
            cbbClassStd.addItem(c);
        }
        
        for (Faculty f  : facultyImp.getFaculty(null)) {
            cbbFacultySubject.addItem(f);
        }
        
        for (Class c : classImp.getClass(null)) {
            combo_TeacherClass.addItem(c);
        }
        
        for (Subject sb : sbdao.getSubject(null)) {
            cbbTeacherSubject.addItem(sb);
        }
        
        for (Faculty f  : facultyImp.getFaculty(null)) {
            comboFaculty_Sem.addItem(f);
        }
        for (Subject sb : sbdao.getSubject(null)) {
            comboSubject_Sem.addItem(sb);
        }
        
        
        for (Subject sb : sbdao.getSubject(null)) {
            cbbSubjectMark.addItem(sb);
        }
        for(Mark_Type mt :mark_typeImp.getMark_Type(null)){
            comboType_Mark.addItem(mt);
        }
        for (Subject sb : sbdao.getSubject(null)) {
            combomon_SeeMark.addItem(sb);
        }
        for (Class c : classImp.getClass(null)) {
            combolop_SeeMark.addItem(c);
        }
        for (Faculty f  : facultyImp.getFaculty(null)) {
            combokhoa_SeeMark.addItem(f);
        }
        
        for (Subject sb : sbdao.getSubject(null)) {
            cbbSubjectSchedule.addItem(sb);
        }
        for (Class c : classImp.getClass(null)) {
            cbbClassSchedule.addItem(c);
        }
    }
    
    public void loadClass(String search){
        loadCombobox();
        List<Class> list = new ArrayList<>(classImp.getClass(search));
        
        DefaultTableModel model = (DefaultTableModel) tblClass.getModel();
        model.setRowCount(0);
        for (Class c : list) {
            model.addRow(new Object[]{
                c.getClassName(),c.getCourse(),c.getFacultyName()
            });
        }
        tblClass.setModel(model);
        
    }
    
    public void loadMark_Type(String name){
        loadCombobox();
        List<Mark_Type> list = mark_typeImp.getMark_Type(name);
        DefaultTableModel model = (DefaultTableModel) tblMark_Type.getModel();
        model.setRowCount(0);
        for (Mark_Type mt : list) {
            model.addRow(new Object[]{mt.getId(),mt.getName()});
        }
        tblMark_Type.setModel(model);
    }
    
    public void loadTeacher(String name){
        loadCombobox();
        List<Teacher> list = tdao.getTeacher(name);
        DefaultTableModel model = (DefaultTableModel) tbl_Teacher.getModel();
        model.setRowCount(0);
        for (Teacher t : list) {
            model.addRow(new Object[]{
                t.getIdgv(),t.getHoten(),t.getNgaysinh(),t.getPhone(),t.getEmail(),t.getGender()?"Male":"Female"
            });
        }
        tbl_Teacher.setModel(model);
    }
    
    public void loadStudent(String name){
        loadCombobox();
        List<Student> list = stdImp.getStudent(name);
        DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
        model.setRowCount(0);
        for (Student s : list) {
            model.addRow(new Object[]{
                s.getId(),s.getName(),s.getBirthday(),s.getPhone(),s.getEmail(),s.getClass_name(),s.isGender()?"Male":"Female",s.getAddress()
            });
        }
        tblStudent.setModel(model);
    }
    
    public void loadSubject(String mon){
        loadCombobox();
        List<Subject> list = sbdao.getSubject(mon);
        DefaultTableModel model = (DefaultTableModel) tbl_Subject.getModel();
        model.setRowCount(0);
        for (Subject sb : list) {
            model.addRow(new Object[]{sb.getId(),sb.getMon(),sb.getTen_Faculty()});
        }
        tbl_Subject.setModel(model);
    }
    
    public void loadTeacherClass(String search){
        loadCombobox();
        List<Teacher_Class> list = tcdao.getTeacher_Class(search);
        DefaultTableModel model = (DefaultTableModel) tblTeacherClass.getModel();
        model.setRowCount(0);
        for (Teacher_Class tc : list) {
            model.addRow(new Object[]{
                tc.getName_Class(),tc.getNameGV()
            });
        }
        tblTeacherClass.setModel(model);
    }
    
    public void loadTeacherSubject(String search){
        loadCombobox();
        List<Teacher_Subject> list = tsdao.getTeacher_Subject(search);
        DefaultTableModel model = (DefaultTableModel) tblTeacherSubject.getModel();
        model.setRowCount(0);
        for (Teacher_Subject ts : list) {
            model.addRow(new Object[]{
                ts.getName_Subject(),ts.getNameGV()
            });
            
        }
        tblTeacherSubject.setModel(model);
        
    }
    
    public void loadSem(String idmon){
        loadCombobox();
        List<Sem> list = semdao.getSem(idmon);
        DefaultTableModel model = (DefaultTableModel) tbl_Sem.getModel();
        model.setRowCount(0);
        for (Sem s : list) {
            model.addRow(new Object[]{s.getName_Faculty(),s.getName_mon(),s.getSem(),s.getYear(),s.getSoTinchi()});
        }
        tbl_Sem.setModel(model);
    }
    
    public void loadMark(String search){
        loadCombobox();
        List<Mark> list = markdao.getMark(search);
        DefaultTableModel model = (DefaultTableModel) tbl_Mark.getModel();
        model.setRowCount(0);
        for (Mark m : list) {
            model.addRow(new Object[]{m.getId_sv(),m.getMon(),m.getName(),m.getLop(),m.getType_mark(),m.getDiem(),m.getLanthi(),m.getKetqua()});
        }
        tbl_Mark.setModel(model);
    }
    
    public void loadAttendance(int idSchedule,String idClass){
        List<Attendance> list = systemManage.findAttendance(idSchedule);
        
        TableColumn sportColumn5 = tblAttendance.getColumnModel().getColumn(5);
        
            JComboBox comboBox = new JComboBox();
            comboBox.addItem("P");
            comboBox.addItem("PA");
            comboBox.addItem("A");

            sportColumn5.setCellEditor(new DefaultCellEditor(comboBox));

            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setToolTipText("Click for combo box");
            sportColumn5.setCellRenderer(renderer);
            
            DefaultTableModel model = (DefaultTableModel) tblAttendance.getModel();
            model.setRowCount(0);
        if (list.size() == 0) {
            List<Attendance> list2 = systemManage.getInfoStudent(idClass);
            
            for (Attendance a : list2) {
                model.addRow(new Object[]{
                    idSchedule,a.getClassName(),a.getIdStudent(),a.getStudentName(),null,"P",null
                });
            }
        }else{
            List<Attendance> list3 = systemManage.findAttendance(idSchedule);
            
            for (Attendance a : list3) {
                model.addRow(new Object[]{
                    idSchedule,idClass,a.getIdStudent(),a.getStudentName(),a.getUpdatedDate(),a.getStatus(),a.getNote()
                });
            }
            
        }
        tblAttendance.setModel(model);
    }
    
    public void loadSeeMark(String idkhoa,String className,String idSubject,String search,int sort){
        loadCombobox();
        List<SeeMark> list = smdao.getSeeMark(idkhoa, className,idSubject, search,sort);
        DefaultTableModel model = (DefaultTableModel) tbl_SeeMark.getModel();
        model.setRowCount(0);
        for (SeeMark sm : list) {
            model.addRow(new Object[]{sm.getIdFaculty(),sm.getLop(),sm.getTen(),sm.getIdsv(),sm.getName(),sm.getMon(),sm.getDiem(),sm.getType_mark(),sm.getLanthi(),sm.getKetqua()});
        }
        tbl_SeeMark.setModel(model);
    }
    
    public void loadStudent_Search(String name){
        List<Student> list = stdImp.getStudent(name);
        DefaultTableModel model = (DefaultTableModel) tblStudent_Search.getModel();
        model.setRowCount(0);
        for (Student s : list) {
            model.addRow(new Object[]{
                s.getId(),s.getName(),s.getBirthday(),s.getPhone(),s.getEmail(),s.getClass_name(),s.isGender()?"Male":"Female",s.getAddress()
            });
        }
        tblStudent.setModel(model);
    }
    
    public void loadTeacher_Search(String name){
        List<Teacher_Search> list = teacher_searchdao.getTeacher_Search(name);
        DefaultTableModel model = (DefaultTableModel) tblTeacher_Search.getModel();
        model.setRowCount(0);
        for (Teacher_Search t : list) {
            model.addRow(new Object[]{
                t.getIdgv(),t.getHoten(),t.getNgaysinh(),t.getPhone(),t.getEmail(),t.getGender()?"Male":"Female",t.getNumber_Class()
            });
        }
        tblTeacher_Search.setModel(model);
    }
    
    public void loadClass_Search(String name){
        List<ClassSearch> list = csdao.getClassSearch(name);
        DefaultTableModel model = (DefaultTableModel) tblClass_Search.getModel();
        model.setRowCount(0);
        for (ClassSearch cs : list) {
            model.addRow(new Object[]{cs.getClassName(),cs.getFaculty_Name(),cs.getCourse(),cs.getKhoa(),cs.getMa()});
        }
        tblClass_Search.setModel(model);
    }
    
    public void loadFaculty_Search(String name){
        List<Faculty_Search> list = faculty_searchdao.getFaculty_Search(name);
        DefaultTableModel model = (DefaultTableModel) tblFaculty_Search.getModel();
        model.setRowCount(0);
        for (Faculty_Search fs : list) {
            model.addRow(new Object[]{fs.getId(),fs.getkhoa(),fs.getYear(),fs.getNumber_Teacher()});
        }
        tblFaculty_Search.setModel(model);
    }
    
    public void loadSubject_Search(String name){
        List<Subject_Search> list = subject_searchdao.getSubject_Search(name);
        DefaultTableModel model = (DefaultTableModel) tblSubject_Search.getModel();
        model.setRowCount(0);
        for (Subject_Search ss : list) {
            model.addRow(new Object[]{ss.getId(),ss.getMon(),ss.getTen_Faculty(),ss.getNumber()});
        }
        tblSubject_Search.setModel(model);
    }
    
    public void loadSchedule(String search){
        loadCombobox();
        List<Schedule> list = scheduleImp.getSchedule(search);
        DefaultTableModel model = (DefaultTableModel) tblSchedule.getModel();
        model.setRowCount(0);
        for (Schedule s : list) {
            model.addRow(new Object[]{
                s.getId(),s.getIdClass(),s.getNameTeacher(),s.getNameSubject(),s.isFrametime()?"3,5,7":"2,4,6",s.getStartTime(),s.getEndTime(),s.getStartDate(),s.getEndDate(),s.getNote()
            });
        }
        tblSchedule.setModel(model);
    }
   

    public void detailUser(){
        int selectRow = tblUsers.getSelectedRow();
        if (selectRow >= 0) {
            int id = (int) tblUsers.getValueAt(selectRow, 0);
            User u = userDao.findUser(id);
            txtIdUser.setText(u.getId()+"");
            txtUsername.setText(u.getUserName());
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbUserRole.getModel();
            for (int i = 0; i < cbbModel.getSize(); i++) {
                if (cbbModel.getElementAt(i).equals(u.getRole())) {
                    cbbUserRole.setSelectedItem(cbbModel.getElementAt(i));
                }
            }
            cbbUserRole.setModel(cbbModel);
        }
    }
    
    public void detailSchedule(){
        int selectRow = tblSchedule.getSelectedRow();
        if (selectRow >= 0) {
            int id = (int) tblSchedule.getValueAt(selectRow, 0);
            Schedule s = scheduleImp.find(id);
            txtIdSchedule.setText(s.getId()+"");
            
            DefaultComboBoxModel cbbSubject = (DefaultComboBoxModel) cbbSubjectSchedule.getModel();
            for (int i = 0; i < cbbSubject.getSize(); i++) {
                if (((Subject)cbbSubject.getElementAt(i)).getId() == s.getIdSubject()) {
                    cbbSubjectSchedule.setSelectedItem(cbbSubject.getElementAt(i));
                }
            }
            cbbSubjectSchedule.setModel(cbbSubject);
            
            DefaultComboBoxModel cbbClass = (DefaultComboBoxModel) cbbClassSchedule.getModel();
            for (int i = 0; i < cbbClass.getSize(); i++) {
                if (((Class)cbbClass.getElementAt(i)).getClassName().equals(s.getIdClass())) {
                    cbbClassSchedule.setSelectedItem(cbbClass.getElementAt(i));
                }
            }
            cbbClassSchedule.setModel(cbbClass);
            
            txtIdTeacherSchedule.setText(s.getIdTeacher()+"");
            if (s.isFrametime()) {
                rdoframetime0.setSelected(true);
            } else {
                rdoframetime1.setSelected(true);
            }
            
            startTimeSchedule.setValue(s.getStartTime());
            endTimeSchedule.setValue(s.getEndTime());
            startDateSchedule.setDate(s.getStartDate());
            endDateSchedule.setDate(s.getEndDate());
            txtNodeSchedule.setText(s.getNote());
        }
    }
    
    
    public void detailTodayAttendance(){
        int selectRow = tblTodayAttendance.getSelectedRow();
        if (selectRow >= 0) {
            int id = (int) tblTodayAttendance.getValueAt(selectRow, 0);
            String idClass = (String) tblTodayAttendance.getValueAt(selectRow, 1);
            
            Schedule s = scheduleImp.find(id);
            if (s!=null) {
                jPanel148.setVisible(true);
                loadAttendance(id,idClass);
            }
        }
    }
    
    public void detailCourse(){
        int selectRow = tblCourse.getSelectedRow();
        if (selectRow >= 0) {
            String id = (String) tblCourse.getValueAt(selectRow, 0);
            Course u = courseImp.find(id);
            txtIdCourse.setText(u.getMaCourse());
            startDateCourse.setDate(u.getStartDate());
            endDateCourse.setDate(u.getEndDate());
        }
    }
    
    public void detailFaculty(){
        int selectRow = tblFaculty.getSelectedRow();
        if (selectRow >= 0) {
            int id = (int) tblFaculty.getValueAt(selectRow, 0);
            Faculty f = facultyImp.find(id);
            txtIdFaculty.setText(f.getId() + "");
            txtNameFaculty.setText(f.getName());
            txtYearFaculty.setText(f.getYear()+"");
        }
    }
    
    public void detailClass(){
        int selectRow = tblClass.getSelectedRow();
        if (selectRow >= 0) {
            String id = (String) tblClass.getValueAt(selectRow, 0);
            Class c = classImp.find(id);
            txtIdClass.setText(c.getClassName());
            DefaultComboBoxModel modelFaculty = (DefaultComboBoxModel) cbbFacultyClass.getModel();
            for (int i = 0; i < modelFaculty.getSize(); i++) {
                if (((Faculty) modelFaculty.getElementAt(i)).getId() == c.getFacultyId()) {
                    cbbFacultyClass.setSelectedItem(modelFaculty.getElementAt(i));
                }
            }
            
            DefaultComboBoxModel modelCourse = (DefaultComboBoxModel) cbbCourseClass.getModel();
            for (int j = 0; j < modelCourse.getSize(); j++) {
                if (((Course) modelCourse.getElementAt(j)).getMaCourse().equalsIgnoreCase(c.getCourse())) {
                    cbbCourseClass.setSelectedItem(modelCourse.getElementAt(j));
                }
            }
            cbbFacultyClass.setModel(modelFaculty);
            cbbCourseClass.setModel(modelCourse);
        }
    }
    
    public void detailMark_Type(){
        int selectRow = tblMark_Type.getSelectedRow();
        if(selectRow>=0){
            int id = (int) tblMark_Type.getValueAt(selectRow, 0);
            Mark_Type mt = mark_typeImp.find(id);
            txtIdMark_Type.setText(mt.getId()+"");
            txtnameMark_Type.setText(mt.getName());
        }
    }
    public void detailTeacher(){
        int selectRow = tbl_Teacher.getSelectedRow();
        if(selectRow>=0){
            int idgv = (int) tbl_Teacher.getValueAt(selectRow, 0);
            Teacher t = tdao.find(idgv);
            txtId_Teacher.setText(t.getIdgv()+"");
            txtname_Teacher.setText(t.getHoten());
            txtphone_Teacher.setText(t.getPhone());
            txtemail_Teacher.setText(t.getEmail());
            date_Teacher.setDate(t.getNgaysinh());
            if (t.getGender()) {
                rdoMaleTeacher.setSelected(true);
            } else {
                rdoFemaleTeacher.setSelected(true);
            }
        }
    }
    
    public void detailStudent(){
        int selectRow = tblStudent.getSelectedRow();
        if(selectRow>=0){
            String idsv = (String) tblStudent.getValueAt(selectRow, 0);
            Student s = stdImp.find(idsv);
            txtIdStd.setText(s.getId());
            txtNameStd.setText(s.getName());
            dateStd.setDate(s.getBirthday());
            txtPhoneStd.setText(s.getPhone());
            txtEmailStd.setText(s.getEmail());
            txtAddressStd.setText(s.getAddress());
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbbClassStd.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                if (((Class) model.getElementAt(i)).getClassName().equalsIgnoreCase(s.getClass_id())) {
                    cbbClassStd.setSelectedItem(model.getElementAt(i));
                }
            }
            cbbClassStd.setModel(model);
            
            if (s.isGender()) {
                rdoMaleStudent.setSelected(true);
            } else {
                rdoFemaleStudent.setSelected(true);
            }
        }
    }
    
    public void detailSubject(){
        int selectRow = tbl_Subject.getSelectedRow();
        if(selectRow>=0){
            int id = (int) tbl_Subject.getValueAt(selectRow, 0);
            Subject sb = sbdao.find(id);
            txtIdSubject.setText(sb.getId()+"");
            txtnameSubject.setText(sb.getMon());

            DefaultComboBoxModel model = (DefaultComboBoxModel) cbbFacultySubject.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                if (((Faculty) model.getElementAt(i)).getId() == sb.getIdFaculty()) {
                    cbbFacultySubject.setSelectedItem(model.getElementAt(i));
                }
            }
            cbbFacultySubject.setModel(model);
        }
    }

    public void detailTeacherClass(){
        int selectRow = tblTeacherClass.getSelectedRow();
        if(selectRow>=0){
            String idgv = (String) tblTeacherClass.getValueAt(selectRow, 1);
            String idClass = (String) tblTeacherClass.getValueAt(selectRow, 0);
            
            Teacher_Class tc = tcdao.find(idgv,idClass);
            txtNameTeacher_Class.setText(tc.getIdgv()+"");
            
            DefaultComboBoxModel model = (DefaultComboBoxModel) combo_TeacherClass.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                if (((Class) model.getElementAt(i)).getClassName().equalsIgnoreCase(tc.getName_Class())) {
                    combo_TeacherClass.setSelectedItem(model.getElementAt(i));
                }
            }
            combo_TeacherClass.setModel(model);
        }
    }
        
        public void detailTeacherSubject(){
            int selectRow = tblTeacherSubject.getSelectedRow();
            if(selectRow>=0){
                String idgv = (String) tblTeacherSubject.getValueAt(selectRow, 1);
                String idSubject = (String) tblTeacherSubject.getValueAt(selectRow, 0);

                Teacher_Subject ts = tsdao.find(idgv, idSubject);
                txtIdTeacherSubject.setText(ts.getIdgv()+"");
                
                DefaultComboBoxModel model = (DefaultComboBoxModel) cbbTeacherSubject.getModel();
                for (int i = 0; i < model.getSize(); i++) {
                    if (((Subject) model.getElementAt(i)).getId() == ts.getIdsb()) {
                        cbbTeacherSubject.setSelectedItem(model.getElementAt(i));
                    }
                }
                cbbTeacherSubject.setModel(model);
            }  
        }
        
        public void detailSem(){
        int selectRow = tbl_Sem.getSelectedRow();
        if(selectRow>=0){
            String idmon = (String) tbl_Sem.getValueAt(selectRow, 1);
            String idFaculty = (String) tbl_Sem.getValueAt(selectRow, 0);
            Sem s = semdao.find(idmon,idFaculty);
            DefaultComboBoxModel model =  (DefaultComboBoxModel) comboFaculty_Sem.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                if (((Faculty) model.getElementAt(i)).getId() == s.getIdFaculty()) {
                    comboFaculty_Sem.setSelectedItem(model.getElementAt(i));
                }
            }
            
            DefaultComboBoxModel modelSubject =  (DefaultComboBoxModel) comboSubject_Sem.getModel();
            for (int i = 0; i < modelSubject.getSize(); i++) {
                if (((Subject) modelSubject.getElementAt(i)).getId() == s.getIdmon()) {
                    comboSubject_Sem.setSelectedItem(modelSubject.getElementAt(i));
                }
            }

            txtSem.setText(s.getSem()+"");
            txtyear_Sem.setText(s.getYear()+"");
            txtCredits.setText(s.getSoTinchi()+"");
        }
    }
        
        public void detailMark(){
        int selectRow = tbl_Mark.getSelectedRow();
        if(selectRow>=0){
            String idsv = (String) tbl_Mark.getValueAt(selectRow, 0);
            String idmon = (String) tbl_Mark.getValueAt(selectRow, 1);
            String type = (String) tbl_Mark.getValueAt(selectRow, 4);
            int lanthi = (int) tbl_Mark.getValueAt(selectRow, 6);
            Mark m = markdao.find(idsv, idmon, type,lanthi);
            
            txtIdSTD_Mark.setText(m.getIdsv());
            txtdiem_Mark.setText(m.getDiem()+"");
            DefaultComboBoxModel modelMark =  (DefaultComboBoxModel) combonumber_Mark.getModel();
            for (int i = 0; i < modelMark.getSize(); i++) {
                if ((modelMark.getElementAt(i)).equals(m.getLanthi()+"")) {
                    combonumber_Mark.setSelectedItem(modelMark.getElementAt(i));
                }
            }
            
            DefaultComboBoxModel model =  (DefaultComboBoxModel) comboType_Mark.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                if (((Mark_Type) model.getElementAt(i)).getId() == m.getType()) {
                    comboType_Mark.setSelectedItem(model.getElementAt(i));
                }
            }
            comboType_Mark.setModel(model);

            DefaultComboBoxModel modelSubject =  (DefaultComboBoxModel) cbbSubjectMark.getModel();
            for (int i = 0; i < modelSubject.getSize(); i++) {
                if (((Subject) modelSubject.getElementAt(i)).getId()==m.getIdmon()) {
                    cbbSubjectMark.setSelectedItem(modelSubject.getElementAt(i));
                }
            }
            cbbSubjectMark.setModel(modelSubject);
        }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        buttonGroup3 = new javax.swing.ButtonGroup();
        sidePane = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        btnSubject = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        btnSetting = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel51 = new javax.swing.JLabel();
        btnMark = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        btnTeacher = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        btnClass = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        btnStudent = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        btnCourse = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        btnSeeMark = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        btnUsers = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        btnAtendances = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        btnStatistical = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        pnlContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();
        pnlDashborad = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        countStudent = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel110 = new javax.swing.JLabel();
        countClass = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jPanel132 = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        countTeacher = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        countSubject = new javax.swing.JLabel();
        jPanel133 = new javax.swing.JPanel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jLabel101 = new javax.swing.JLabel();
        countUser = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jLabel105 = new javax.swing.JLabel();
        countCourse = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        pnlStudent = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        txtSearchStd = new javax.swing.JTextField();
        btnSearchStd = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtIdStd = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNameStd = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dateStd = new com.toedter.calendar.JDateChooser();
        jPanel21 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPhoneStd = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbbClassStd = new javax.swing.JComboBox<>();
        jPanel23 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtEmailStd = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        rdoMaleStudent = new javax.swing.JRadioButton();
        rdoFemaleStudent = new javax.swing.JRadioButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtAddressStd = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        btnAddStd = new javax.swing.JButton();
        btnDelStd = new javax.swing.JButton();
        btnEditStd = new javax.swing.JButton();
        btnResetStd = new javax.swing.JButton();
        btnCancelStd = new javax.swing.JButton();
        pnlTeacher = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel75 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtId_Teacher = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtname_Teacher = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtemail_Teacher = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtphone_Teacher = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        rdoMaleTeacher = new javax.swing.JRadioButton();
        rdoFemaleTeacher = new javax.swing.JRadioButton();
        jPanel34 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        date_Teacher = new com.toedter.calendar.JDateChooser();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Teacher = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        search_Teacher = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel76 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtNameTeacher_Class = new javax.swing.JTextField();
        jPanel79 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        combo_TeacherClass = new javax.swing.JComboBox<>();
        jPanel81 = new javax.swing.JPanel();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jPanel82 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblTeacherClass = new javax.swing.JTable();
        jPanel88 = new javax.swing.JPanel();
        Seacher_TeacherClass = new javax.swing.JTextField();
        jButton40 = new javax.swing.JButton();
        jPanel77 = new javax.swing.JPanel();
        jPanel89 = new javax.swing.JPanel();
        jPanel90 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        txtIdTeacherSubject = new javax.swing.JTextField();
        jPanel91 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        cbbTeacherSubject = new javax.swing.JComboBox<>();
        jPanel92 = new javax.swing.JPanel();
        jButton41 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jPanel93 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblTeacherSubject = new javax.swing.JTable();
        jPanel94 = new javax.swing.JPanel();
        txtSearchTeacherSubject = new javax.swing.JTextField();
        jButton50 = new javax.swing.JButton();
        jPanel134 = new javax.swing.JPanel();
        jPanel135 = new javax.swing.JPanel();
        jPanel136 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        txtIdSchedule = new javax.swing.JTextField();
        jPanel137 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        cbbSubjectSchedule = new javax.swing.JComboBox<>();
        jPanel138 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        cbbClassSchedule = new javax.swing.JComboBox<>();
        jPanel139 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        txtIdTeacherSchedule = new javax.swing.JTextField();
        jPanel140 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        rdoframetime0 = new javax.swing.JRadioButton();
        rdoframetime1 = new javax.swing.JRadioButton();
        jPanel141 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        startTimeSchedule = new javax.swing.JSpinner();
        endTimeSchedule = new javax.swing.JSpinner();
        jPanel145 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        startDateSchedule = new com.toedter.calendar.JDateChooser();
        jPanel146 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        endDateSchedule = new com.toedter.calendar.JDateChooser();
        jPanel147 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        txtNodeSchedule = new javax.swing.JTextField();
        jPanel142 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();
        jPanel143 = new javax.swing.JPanel();
        txtsearchSchedule = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jPanel144 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        pnlUsers = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtIdUser = new javax.swing.JTextField();
        jPanel63 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jPanel64 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        cbbUserRole = new javax.swing.JComboBox<>();
        jPanel72 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txtAddPassAdmin = new javax.swing.JPasswordField();
        jPanel9 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        btnAddUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        btnResetUser = new javax.swing.JButton();
        btnCancelUser = new javax.swing.JButton();
        jPanel66 = new javax.swing.JPanel();
        txtSearchUser = new javax.swing.JTextField();
        btnSearchUser = new javax.swing.JButton();
        jPanel67 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        pnlMark = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel83 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        search_Mark = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Mark = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtIdSTD_Mark = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cbbSubjectMark = new javax.swing.JComboBox<>();
        jPanel42 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtdiem_Mark = new javax.swing.JTextField();
        jPanel121 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        comboType_Mark = new javax.swing.JComboBox<>();
        jPanel122 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        combonumber_Mark = new javax.swing.JComboBox<>();
        jPanel45 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel84 = new javax.swing.JPanel();
        jPanel85 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        txtIdMark_Type = new javax.swing.JTextField();
        jPanel87 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtnameMark_Type = new javax.swing.JTextField();
        jPanel95 = new javax.swing.JPanel();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jPanel96 = new javax.swing.JPanel();
        searchMark_Type = new javax.swing.JTextField();
        jButton51 = new javax.swing.JButton();
        jPanel97 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblMark_Type = new javax.swing.JTable();
        pnlClass = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtIdClass = new javax.swing.JTextField();
        jPanel43 = new javax.swing.JPanel();
        jPanel113 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        cbbFacultyClass = new javax.swing.JComboBox<>();
        jPanel44 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        cbbCourseClass = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        btnAddClass = new javax.swing.JButton();
        btnDelClass = new javax.swing.JButton();
        btnEditClass = new javax.swing.JButton();
        btnResetClass = new javax.swing.JButton();
        btnCancelClass = new javax.swing.JButton();
        jPanel48 = new javax.swing.JPanel();
        txtSearchClass = new javax.swing.JTextField();
        btnSearchClass = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblClass = new javax.swing.JTable();
        pnlSubject = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel108 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtIdSubject = new javax.swing.JTextField();
        jPanel52 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtnameSubject = new javax.swing.JTextField();
        jPanel110 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        cbbFacultySubject = new javax.swing.JComboBox<>();
        jPanel50 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jPanel54 = new javax.swing.JPanel();
        seacher_Subject = new javax.swing.JTextField();
        jButton30 = new javax.swing.JButton();
        jPanel55 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_Subject = new javax.swing.JTable();
        jPanel109 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        jPanel112 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        comboSubject_Sem = new javax.swing.JComboBox<>();
        jPanel114 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        comboFaculty_Sem = new javax.swing.JComboBox<>();
        jPanel118 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        txtSem = new javax.swing.JTextField();
        jPanel119 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        txtyear_Sem = new javax.swing.JTextField();
        jPanel120 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        txtCredits = new javax.swing.JTextField();
        jPanel115 = new javax.swing.JPanel();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jPanel116 = new javax.swing.JPanel();
        seacher_Sem = new javax.swing.JTextField();
        jButton63 = new javax.swing.JButton();
        jPanel117 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tbl_Sem = new javax.swing.JTable();
        pnlCourse = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel98 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtIdFaculty = new javax.swing.JTextField();
        jPanel58 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtNameFaculty = new javax.swing.JTextField();
        jPanel107 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        txtYearFaculty = new javax.swing.JTextField();
        jPanel53 = new javax.swing.JPanel();
        btnAddFaculty = new javax.swing.JButton();
        btnDelFaculty = new javax.swing.JButton();
        btnEditFaculty = new javax.swing.JButton();
        btnResetFaculty = new javax.swing.JButton();
        btnCancelFaculty = new javax.swing.JButton();
        jPanel59 = new javax.swing.JPanel();
        txtSearchFaculty = new javax.swing.JTextField();
        btnSearchFaculty = new javax.swing.JButton();
        jPanel60 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblFaculty = new javax.swing.JTable();
        jPanel99 = new javax.swing.JPanel();
        jPanel100 = new javax.swing.JPanel();
        jPanel101 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        txtIdCourse = new javax.swing.JTextField();
        jPanel102 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        startDateCourse = new com.toedter.calendar.JDateChooser();
        jPanel106 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        endDateCourse = new com.toedter.calendar.JDateChooser();
        jPanel103 = new javax.swing.JPanel();
        btnAddCourse = new javax.swing.JButton();
        btnDeleteCourse = new javax.swing.JButton();
        btnEditCourse = new javax.swing.JButton();
        btnResetCourse = new javax.swing.JButton();
        btnCancelCourse = new javax.swing.JButton();
        jPanel104 = new javax.swing.JPanel();
        txtSearchCourse = new javax.swing.JTextField();
        btnSearchCourse = new javax.swing.JButton();
        jPanel105 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblCourse = new javax.swing.JTable();
        pnlSearch = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel131 = new javax.swing.JPanel();
        combo_Search = new javax.swing.JComboBox<>();
        timkem = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jTabbeSearch = new javax.swing.JTabbedPane();
        pnlStudentSearch = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblStudent_Search = new javax.swing.JTable();
        pnlTeacherSearch = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblTeacher_Search = new javax.swing.JTable();
        pnlFacultySearch = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblFaculty_Search = new javax.swing.JTable();
        pnlClassSearch = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblClass_Search = new javax.swing.JTable();
        pnlSubjectSearch = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblSubject_Search = new javax.swing.JTable();
        pnlSetting = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel123 = new javax.swing.JPanel();
        jPanel124 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtIdAdmin = new javax.swing.JTextField();
        jPanel126 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        txtNameAdmin = new javax.swing.JTextField();
        jPanel128 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        txtRoleAdmin = new javax.swing.JTextField();
        jPanel125 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        passEditUser = new javax.swing.JPasswordField();
        jPanel127 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        confirmPassEditUser = new javax.swing.JPasswordField();
        jButton64 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnlSeeMark = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        cbxSubject = new javax.swing.JCheckBox();
        combomon_SeeMark = new javax.swing.JComboBox<>();
        jPanel74 = new javax.swing.JPanel();
        cbxClass = new javax.swing.JCheckBox();
        combolop_SeeMark = new javax.swing.JComboBox<>();
        jPanel129 = new javax.swing.JPanel();
        cbxFaculty = new javax.swing.JCheckBox();
        combokhoa_SeeMark = new javax.swing.JComboBox<>();
        jPanel130 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        search_SeeMark = new javax.swing.JTextField();
        cbxAll = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbl_SeeMark = new javax.swing.JTable();
        pnlAttendances = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jPanel148 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblAttendance = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tblTodayAttendance = new javax.swing.JTable();
        pnlStatistical = new javax.swing.JPanel();
        jPanel149 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jPanel150 = new javax.swing.JPanel();
        searchStstistical = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        lblStatisticalIDSV = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        lblStatisticalNAMESV = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        lblStatisticalCLASS = new javax.swing.JLabel();
        lblStatisticalAddress = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        pnlStatisticalMark = new javax.swing.JPanel();
        jPanel152 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tblMark_Type1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management");

        sidePane.setBackground(new java.awt.Color(51, 27, 91));
        sidePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDashboard.setBackground(new java.awt.Color(85, 55, 118));
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
        });

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_home_24px.png"))); // NOI18N

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(204, 204, 204));
        jLabel43.setText("Dashboard");

        javax.swing.GroupLayout btnDashboardLayout = new javax.swing.GroupLayout(btnDashboard);
        btnDashboard.setLayout(btnDashboardLayout);
        btnDashboardLayout.setHorizontalGroup(
            btnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnDashboardLayout.setVerticalGroup(
            btnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDashboardLayout.createSequentialGroup()
                .addGroup(btnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btnDashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel43)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePane.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 300, 50));

        btnSubject.setBackground(new java.awt.Color(64, 43, 100));
        btnSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubjectMouseClicked(evt);
            }
        });

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_math_book_24px.png"))); // NOI18N

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(204, 204, 204));
        jLabel45.setText("Subject");

        javax.swing.GroupLayout btnSubjectLayout = new javax.swing.GroupLayout(btnSubject);
        btnSubject.setLayout(btnSubjectLayout);
        btnSubjectLayout.setHorizontalGroup(
            btnSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSubjectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnSubjectLayout.setVerticalGroup(
            btnSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSubjectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(btnSubjectLayout.createSequentialGroup()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePane.add(btnSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 300, 50));

        btnSearch.setBackground(new java.awt.Color(64, 43, 100));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_24px.png"))); // NOI18N

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(204, 204, 204));
        jLabel47.setText("Search");

        javax.swing.GroupLayout btnSearchLayout = new javax.swing.GroupLayout(btnSearch);
        btnSearch.setLayout(btnSearchLayout);
        btnSearchLayout.setHorizontalGroup(
            btnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnSearchLayout.setVerticalGroup(
            btnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSearchLayout.createSequentialGroup()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        sidePane.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 300, 50));

        btnSetting.setBackground(new java.awt.Color(64, 43, 100));
        btnSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSettingMouseClicked(evt);
            }
        });

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_settings_24px.png"))); // NOI18N

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(204, 204, 204));
        jLabel49.setText("Setting");

        javax.swing.GroupLayout btnSettingLayout = new javax.swing.GroupLayout(btnSetting);
        btnSetting.setLayout(btnSettingLayout);
        btnSettingLayout.setHorizontalGroup(
            btnSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSettingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnSettingLayout.setVerticalGroup(
            btnSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSettingLayout.createSequentialGroup()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnSettingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        sidePane.add(btnSetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 770, 300, 50));

        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));
        sidePane.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 20));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(204, 204, 204));
        jLabel51.setText(" University");
        sidePane.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 200, 25));

        btnMark.setBackground(new java.awt.Color(64, 43, 100));
        btnMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMarkMouseClicked(evt);
            }
        });

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_exam_24px.png"))); // NOI18N

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(204, 204, 204));
        jLabel53.setText("Mark");

        javax.swing.GroupLayout btnMarkLayout = new javax.swing.GroupLayout(btnMark);
        btnMark.setLayout(btnMarkLayout);
        btnMarkLayout.setHorizontalGroup(
            btnMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMarkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnMarkLayout.setVerticalGroup(
            btnMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMarkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(btnMarkLayout.createSequentialGroup()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePane.add(btnMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 300, 50));

        btnTeacher.setBackground(new java.awt.Color(64, 43, 100));
        btnTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTeacherMouseClicked(evt);
            }
        });

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_teacher_24px.png"))); // NOI18N

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(204, 204, 204));
        jLabel55.setText("Teacher");

        javax.swing.GroupLayout btnTeacherLayout = new javax.swing.GroupLayout(btnTeacher);
        btnTeacher.setLayout(btnTeacherLayout);
        btnTeacherLayout.setHorizontalGroup(
            btnTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTeacherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnTeacherLayout.setVerticalGroup(
            btnTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTeacherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(btnTeacherLayout.createSequentialGroup()
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePane.add(btnTeacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 300, 50));

        btnClass.setBackground(new java.awt.Color(64, 43, 100));
        btnClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClassMouseClicked(evt);
            }
        });

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_class_24px.png"))); // NOI18N

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(204, 204, 204));
        jLabel57.setText("Class");

        javax.swing.GroupLayout btnClassLayout = new javax.swing.GroupLayout(btnClass);
        btnClass.setLayout(btnClassLayout);
        btnClassLayout.setHorizontalGroup(
            btnClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnClassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnClassLayout.setVerticalGroup(
            btnClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnClassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(btnClassLayout.createSequentialGroup()
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePane.add(btnClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 300, 50));

        btnStudent.setBackground(new java.awt.Color(64, 43, 100));
        btnStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStudentMouseClicked(evt);
            }
        });

        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_student_male_24px.png"))); // NOI18N

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(204, 204, 204));
        jLabel59.setText("Student");

        javax.swing.GroupLayout btnStudentLayout = new javax.swing.GroupLayout(btnStudent);
        btnStudent.setLayout(btnStudentLayout);
        btnStudentLayout.setHorizontalGroup(
            btnStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnStudentLayout.setVerticalGroup(
            btnStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(btnStudentLayout.createSequentialGroup()
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePane.add(btnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 300, 50));

        btnCourse.setBackground(new java.awt.Color(64, 43, 100));
        btnCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCourseMouseClicked(evt);
            }
        });

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_course_assign_24px.png"))); // NOI18N

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(204, 204, 204));
        jLabel61.setText("Course");

        javax.swing.GroupLayout btnCourseLayout = new javax.swing.GroupLayout(btnCourse);
        btnCourse.setLayout(btnCourseLayout);
        btnCourseLayout.setHorizontalGroup(
            btnCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnCourseLayout.setVerticalGroup(
            btnCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(btnCourseLayout.createSequentialGroup()
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePane.add(btnCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 300, 50));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(204, 204, 204));
        jLabel62.setText(" University");
        sidePane.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 218, 25));

        btnSeeMark.setBackground(new java.awt.Color(64, 43, 100));
        btnSeeMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeeMarkMouseClicked(evt);
            }
        });

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_eye_24px.png"))); // NOI18N

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(204, 204, 204));
        jLabel73.setText("See test scores");

        javax.swing.GroupLayout btnSeeMarkLayout = new javax.swing.GroupLayout(btnSeeMark);
        btnSeeMark.setLayout(btnSeeMarkLayout);
        btnSeeMarkLayout.setHorizontalGroup(
            btnSeeMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSeeMarkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnSeeMarkLayout.setVerticalGroup(
            btnSeeMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSeeMarkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(btnSeeMarkLayout.createSequentialGroup()
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePane.add(btnSeeMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 300, 50));

        btnUsers.setBackground(new java.awt.Color(64, 43, 100));
        btnUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsersMouseClicked(evt);
            }
        });

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_staff_24px.png"))); // NOI18N

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(204, 204, 204));
        jLabel68.setText("Users");

        javax.swing.GroupLayout btnUsersLayout = new javax.swing.GroupLayout(btnUsers);
        btnUsers.setLayout(btnUsersLayout);
        btnUsersLayout.setHorizontalGroup(
            btnUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnUsersLayout.setVerticalGroup(
            btnUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(btnUsersLayout.createSequentialGroup()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePane.add(btnUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 300, 50));

        btnAtendances.setBackground(new java.awt.Color(64, 43, 100));
        btnAtendances.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtendancesMouseClicked(evt);
            }
        });

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_attendance_24px.png"))); // NOI18N

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(204, 204, 204));
        jLabel82.setText("Attendances");

        javax.swing.GroupLayout btnAtendancesLayout = new javax.swing.GroupLayout(btnAtendances);
        btnAtendances.setLayout(btnAtendancesLayout);
        btnAtendancesLayout.setHorizontalGroup(
            btnAtendancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAtendancesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAtendancesLayout.setVerticalGroup(
            btnAtendancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAtendancesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(btnAtendancesLayout.createSequentialGroup()
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePane.add(btnAtendances, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 300, 50));

        btnStatistical.setBackground(new java.awt.Color(64, 43, 100));
        btnStatistical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatisticalMouseClicked(evt);
            }
        });

        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_statistics_24px.png"))); // NOI18N

        jLabel130.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(204, 204, 204));
        jLabel130.setText("Statistical");

        javax.swing.GroupLayout btnStatisticalLayout = new javax.swing.GroupLayout(btnStatistical);
        btnStatistical.setLayout(btnStatisticalLayout);
        btnStatisticalLayout.setHorizontalGroup(
            btnStatisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnStatisticalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnStatisticalLayout.setVerticalGroup(
            btnStatisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnStatisticalLayout.createSequentialGroup()
                .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnStatisticalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel130, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        sidePane.add(btnStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 300, 50));

        getContentPane().add(sidePane, java.awt.BorderLayout.LINE_START);

        pnlContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnlContainer.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-menu-24.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(54, 33, 89));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(54, 33, 89));
        jLabel3.setText("Hi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 780, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlContainer.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pnlCenter.setLayout(new java.awt.CardLayout());

        pnlDashborad.setAutoscrolls(true);
        pnlDashborad.setPreferredSize(new java.awt.Dimension(1055, 904));

        jPanel2.setBackground(new java.awt.Color(110, 89, 222));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(204, 204, 204));
        jLabel50.setText("Student management data statistics _______________________");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(204, 204, 204));
        jLabel63.setText("Adminstrations");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel50)
                .addGap(38, 38, 38))
        );

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 255, 255));
        kGradientPanel1.setkGradientFocus(400);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 102, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Student");

        countStudent.setBackground(new java.awt.Color(255, 255, 255));
        countStudent.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        countStudent.setForeground(new java.awt.Color(255, 255, 255));
        countStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countStudent.setText("400");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_student_male_80px.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(countStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(countStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        kGradientPanel3.setkEndColor(new java.awt.Color(102, 255, 102));
        kGradientPanel3.setkGradientFocus(200);
        kGradientPanel3.setkStartColor(new java.awt.Color(102, 255, 255));

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(204, 204, 204));
        jLabel110.setText("Class");

        countClass.setBackground(new java.awt.Color(255, 255, 255));
        countClass.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        countClass.setForeground(new java.awt.Color(255, 255, 255));
        countClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countClass.setText("400");

        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_class_80px.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(countClass, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel110)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(countClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 51, 51));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 153, 153));

        countTeacher.setBackground(new java.awt.Color(255, 255, 255));
        countTeacher.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        countTeacher.setForeground(new java.awt.Color(255, 255, 255));
        countTeacher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countTeacher.setText("400");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_teacher_80px.png"))); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setText("Teacher");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(countTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(countTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        kGradientPanel4.setkEndColor(new java.awt.Color(255, 102, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(255, 204, 102));

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_return_book_80px.png"))); // NOI18N

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(204, 204, 204));
        jLabel107.setText("Subject");

        countSubject.setBackground(new java.awt.Color(255, 255, 255));
        countSubject.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        countSubject.setForeground(new java.awt.Color(255, 255, 255));
        countSubject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countSubject.setText("400");

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kGradientPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel108)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(countSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel107)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel132Layout = new javax.swing.GroupLayout(jPanel132);
        jPanel132.setLayout(jPanel132Layout);
        jPanel132Layout.setHorizontalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel132Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanel132Layout.setVerticalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel132Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        kGradientPanel5.setkEndColor(new java.awt.Color(0, 255, 51));
        kGradientPanel5.setkStartColor(new java.awt.Color(204, 255, 51));

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(204, 204, 204));
        jLabel101.setText("Users");

        countUser.setBackground(new java.awt.Color(255, 255, 255));
        countUser.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        countUser.setForeground(new java.awt.Color(255, 255, 255));
        countUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countUser.setText("400");

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_user_account_80px.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addGap(18, 18, 18)
                        .addComponent(countUser, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel101)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(countUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        kGradientPanel6.setkEndColor(new java.awt.Color(255, 153, 102));
        kGradientPanel6.setkStartColor(new java.awt.Color(204, 51, 255));

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_course_80px.png"))); // NOI18N

        countCourse.setBackground(new java.awt.Color(255, 255, 255));
        countCourse.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        countCourse.setForeground(new java.awt.Color(255, 255, 255));
        countCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countCourse.setText("400");

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(204, 204, 204));
        jLabel104.setText("Course");

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(countCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel104)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(countCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel133Layout = new javax.swing.GroupLayout(jPanel133);
        jPanel133.setLayout(jPanel133Layout);
        jPanel133Layout.setHorizontalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel133Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        jPanel133Layout.setVerticalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel133Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kGradientPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDashboradLayout = new javax.swing.GroupLayout(pnlDashborad);
        pnlDashborad.setLayout(pnlDashboradLayout);
        pnlDashboradLayout.setHorizontalGroup(
            pnlDashboradLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDashboradLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jPanel132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(jPanel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDashboradLayout.setVerticalGroup(
            pnlDashboradLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboradLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlDashboradLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(326, Short.MAX_VALUE))
        );

        pnlCenter.add(pnlDashborad, "card2");

        pnlStudent.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(122, 72, 221));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(204, 204, 204));
        jLabel64.setText("Student management _______________________");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel64)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        txtSearchStd.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSearchStd.setText("Search...");

        btnSearchStd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearchStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        btnSearchStd.setText("Search");
        btnSearchStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchStdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchStd, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchStd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchStd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchStd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Student list"));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblStudent.setAutoCreateRowSorter(true);
        tblStudent.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblStudent.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Birthday", "Phone", "Email", "Class", "Gender", "Address"
            }
        ));
        tblStudent.setGridColor(new java.awt.Color(255, 255, 255));
        tblStudent.setRowHeight(25);
        tblStudent.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane1.setViewportView(tblStudent);
        if (tblStudent.getColumnModel().getColumnCount() > 0) {
            tblStudent.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblStudent.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblStudent.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblStudent.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblStudent.getColumnModel().getColumn(5).setPreferredWidth(10);
            tblStudent.getColumnModel().getColumn(6).setResizable(false);
            tblStudent.getColumnModel().getColumn(6).setPreferredWidth(10);
            tblStudent.getColumnModel().getColumn(6).setHeaderValue("Gender");
            tblStudent.getColumnModel().getColumn(7).setHeaderValue("Address");
        }

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Id");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdStd, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("Name");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNameStd)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNameStd, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setText("Birthday");

        dateStd.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateStd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setText("Phone");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPhoneStd)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setText("Class");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbClassStd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbClassStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setText("Email");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailStd))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmailStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel12.setText("Gender");

        rdoMaleStudent.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoMaleStudent);
        rdoMaleStudent.setText("Male");

        rdoFemaleStudent.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoFemaleStudent);
        rdoFemaleStudent.setText("Female");
        rdoFemaleStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemaleStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoMaleStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoFemaleStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(rdoMaleStudent)
                    .addComponent(rdoFemaleStudent))
                .addGap(5, 5, 5))
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel13.setText("Address");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddressStd)
                .addGap(2, 2, 2))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddressStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        btnAddStd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAddStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        btnAddStd.setText("Add new");
        btnAddStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStdActionPerformed(evt);
            }
        });

        btnDelStd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDelStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        btnDelStd.setText("Delete");
        btnDelStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelStdActionPerformed(evt);
            }
        });

        btnEditStd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnEditStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_24px_1.png"))); // NOI18N
        btnEditStd.setText("Edit");
        btnEditStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditStdActionPerformed(evt);
            }
        });

        btnResetStd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnResetStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        btnResetStd.setText("Reset");
        btnResetStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetStdActionPerformed(evt);
            }
        });

        btnCancelStd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancelStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        btnCancelStd.setText("Cancel");
        btnCancelStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelStdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetStd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelStd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelStd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditStd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddStd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnResetStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelStd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout pnlStudentLayout = new javax.swing.GroupLayout(pnlStudent);
        pnlStudent.setLayout(pnlStudentLayout);
        pnlStudentLayout.setHorizontalGroup(
            pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlStudentLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlStudentLayout.setVerticalGroup(
            pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCenter.add(pnlStudent, "card3");

        pnlTeacher.setBackground(new java.awt.Color(255, 255, 255));
        pnlTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManage10MouseClicked(evt);
            }
        });

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel15.setText("Id");

        txtId_Teacher.setEditable(false);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtId_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtId_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel16.setText("Name");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtname_Teacher)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtname_Teacher, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel18.setText("Email");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtemail_Teacher, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel20.setText("Phone");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtphone_Teacher, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtphone_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel22.setText("Gender");

        rdoMaleTeacher.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdoMaleTeacher);
        rdoMaleTeacher.setText("Male");

        rdoFemaleTeacher.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdoFemaleTeacher);
        rdoFemaleTeacher.setText("Female");
        rdoFemaleTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemaleTeacherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoMaleTeacher)
                .addGap(35, 35, 35)
                .addComponent(rdoFemaleTeacher)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoMaleTeacher)
                    .addComponent(rdoFemaleTeacher))
                .addGap(5, 5, 5))
        );

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Birthday");

        date_Teacher.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date_Teacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date_Teacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(121, 121, 121))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Student list"));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tbl_Teacher.setAutoCreateRowSorter(true);
        tbl_Teacher.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl_Teacher.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_Teacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Birthday", "Phone", "Email", "Gender"
            }
        ));
        tbl_Teacher.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Teacher.setRowHeight(25);
        tbl_Teacher.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane2.setViewportView(tbl_Teacher);
        if (tbl_Teacher.getColumnModel().getColumnCount() > 0) {
            tbl_Teacher.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_Teacher.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl_Teacher.getColumnModel().getColumn(2).setPreferredWidth(40);
            tbl_Teacher.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        search_Teacher.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        search_Teacher.setText("Search...");

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_Teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        jButton8.setText("Add new");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        jButton9.setText("Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_24px_1.png"))); // NOI18N
        jButton10.setText("Edit");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        jButton11.setText("Reset");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        jButton12.setText("Cancel");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Teacher", jPanel75);

        jPanel76.setBackground(new java.awt.Color(255, 255, 255));

        jPanel78.setBackground(new java.awt.Color(255, 255, 255));
        jPanel78.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel80.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel38.setText("TeacherID");

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNameTeacher_Class)
                .addContainerGap())
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNameTeacher_Class, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel79.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel37.setText("Class");

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo_TeacherClass, 0, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(combo_TeacherClass, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel79, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel81.setBackground(new java.awt.Color(255, 255, 255));
        jPanel81.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        jButton38.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        jButton38.setText("Add new");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        jButton39.setText("Delete");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton42.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        jButton42.setText("Cancel");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel82.setBackground(new java.awt.Color(255, 255, 255));
        jPanel82.setBorder(javax.swing.BorderFactory.createTitledBorder("Teach class list"));

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblTeacherClass.setAutoCreateRowSorter(true);
        tblTeacherClass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblTeacherClass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblTeacherClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ClassName", "TeacherName"
            }
        ));
        tblTeacherClass.setGridColor(new java.awt.Color(255, 255, 255));
        tblTeacherClass.setRowHeight(25);
        tblTeacherClass.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane9.setViewportView(tblTeacherClass);
        if (tblTeacherClass.getColumnModel().getColumnCount() > 0) {
            tblTeacherClass.getColumnModel().getColumn(0).setResizable(false);
            tblTeacherClass.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblTeacherClass.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel82Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel88.setBackground(new java.awt.Color(255, 255, 255));
        jPanel88.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        Seacher_TeacherClass.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Seacher_TeacherClass.setText("Search...");

        jButton40.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        jButton40.setText("Search");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Seacher_TeacherClass, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton40)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Seacher_TeacherClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton40))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel76Layout.createSequentialGroup()
                        .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel78, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel76Layout.createSequentialGroup()
                        .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Teach class", jPanel76);

        jPanel77.setBackground(new java.awt.Color(255, 255, 255));

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));
        jPanel89.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel90.setBackground(new java.awt.Color(255, 255, 255));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel41.setText("TeacherID");

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdTeacherSubject)
                .addContainerGap())
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdTeacherSubject, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel91.setBackground(new java.awt.Color(255, 255, 255));

        jLabel69.setBackground(new java.awt.Color(255, 255, 255));
        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel69.setText("Subject");

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbTeacherSubject, 0, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addGroup(jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTeacherSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel91, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel89Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel90, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel92.setBackground(new java.awt.Color(255, 255, 255));
        jPanel92.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        jButton41.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        jButton41.setText("Add new");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton48.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        jButton48.setText("Delete");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton49.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        jButton49.setText("Cancel");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel93.setBackground(new java.awt.Color(255, 255, 255));
        jPanel93.setBorder(javax.swing.BorderFactory.createTitledBorder("Teach subject list"));

        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblTeacherSubject.setAutoCreateRowSorter(true);
        tblTeacherSubject.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblTeacherSubject.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblTeacherSubject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SubjectName", "TeacherName"
            }
        ));
        tblTeacherSubject.setGridColor(new java.awt.Color(255, 255, 255));
        tblTeacherSubject.setRowHeight(25);
        tblTeacherSubject.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane11.setViewportView(tblTeacherSubject);
        if (tblTeacherSubject.getColumnModel().getColumnCount() > 0) {
            tblTeacherSubject.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel93Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel94.setBackground(new java.awt.Color(255, 255, 255));
        jPanel94.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        txtSearchTeacherSubject.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSearchTeacherSubject.setText("Search...");

        jButton50.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        jButton50.setText("Search");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchTeacherSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton50)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchTeacherSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton50))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addComponent(jPanel89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel94, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel89, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addComponent(jPanel92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Teach subject", jPanel77);

        jPanel134.setBackground(new java.awt.Color(255, 255, 255));

        jPanel135.setBackground(new java.awt.Color(255, 255, 255));
        jPanel135.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel136.setBackground(new java.awt.Color(255, 255, 255));

        jLabel113.setBackground(new java.awt.Color(255, 255, 255));
        jLabel113.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel113.setText("Id");

        txtIdSchedule.setEditable(false);

        javax.swing.GroupLayout jPanel136Layout = new javax.swing.GroupLayout(jPanel136);
        jPanel136.setLayout(jPanel136Layout);
        jPanel136Layout.setHorizontalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel136Layout.createSequentialGroup()
                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel136Layout.setVerticalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel136Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel137.setBackground(new java.awt.Color(255, 255, 255));

        jLabel114.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel114.setText("Subject");

        javax.swing.GroupLayout jPanel137Layout = new javax.swing.GroupLayout(jPanel137);
        jPanel137.setLayout(jPanel137Layout);
        jPanel137Layout.setHorizontalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel137Layout.createSequentialGroup()
                .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbSubjectSchedule, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel137Layout.setVerticalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel137Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSubjectSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel138.setBackground(new java.awt.Color(255, 255, 255));

        jLabel115.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel115.setText("Class");

        javax.swing.GroupLayout jPanel138Layout = new javax.swing.GroupLayout(jPanel138);
        jPanel138.setLayout(jPanel138Layout);
        jPanel138Layout.setHorizontalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel138Layout.createSequentialGroup()
                .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbClassSchedule, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel138Layout.setVerticalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel138Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbClassSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel139.setBackground(new java.awt.Color(255, 255, 255));

        jLabel116.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel116.setText("TeacherId");

        javax.swing.GroupLayout jPanel139Layout = new javax.swing.GroupLayout(jPanel139);
        jPanel139.setLayout(jPanel139Layout);
        jPanel139Layout.setHorizontalGroup(
            jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel139Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtIdTeacherSchedule)
                .addContainerGap())
        );
        jPanel139Layout.setVerticalGroup(
            jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel139Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdTeacherSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel140.setBackground(new java.awt.Color(255, 255, 255));

        jLabel117.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel117.setText("Frametime");

        rdoframetime0.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(rdoframetime0);
        rdoframetime0.setText("2,4,6");
        rdoframetime0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoframetime0ActionPerformed(evt);
            }
        });

        rdoframetime1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(rdoframetime1);
        rdoframetime1.setText("3,5,7");
        rdoframetime1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoframetime1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel140Layout = new javax.swing.GroupLayout(jPanel140);
        jPanel140.setLayout(jPanel140Layout);
        jPanel140Layout.setHorizontalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel140Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoframetime0)
                .addGap(106, 106, 106)
                .addComponent(rdoframetime1)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel140Layout.setVerticalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel140Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel140Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(rdoframetime1)
                        .addContainerGap())
                    .addGroup(jPanel140Layout.createSequentialGroup()
                        .addGroup(jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoframetime0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5))))
        );

        jPanel141.setBackground(new java.awt.Color(255, 255, 255));

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel118.setText("StartTime");

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel119.setText("EndTime");

        startTimeSchedule.setModel(new javax.swing.SpinnerDateModel());
        startTimeSchedule.setEditor(new javax.swing.JSpinner.DateEditor(startTimeSchedule, "HH:mm"));

        endTimeSchedule.setModel(new javax.swing.SpinnerDateModel());
        endTimeSchedule.setEditor(new javax.swing.JSpinner.DateEditor(endTimeSchedule, "HH:mm"));

        javax.swing.GroupLayout jPanel141Layout = new javax.swing.GroupLayout(jPanel141);
        jPanel141.setLayout(jPanel141Layout);
        jPanel141Layout.setHorizontalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel141Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel118)
                .addGap(18, 18, 18)
                .addComponent(startTimeSchedule)
                .addGap(18, 18, 18)
                .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(endTimeSchedule)
                .addGap(18, 18, 18))
        );
        jPanel141Layout.setVerticalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel141Layout.createSequentialGroup()
                .addGroup(jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startTimeSchedule, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel141Layout.createSequentialGroup()
                        .addGroup(jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endTimeSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(7, 7, 7))
        );

        jPanel145.setBackground(new java.awt.Color(255, 255, 255));

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel120.setText("StartDate");

        startDateSchedule.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel145Layout = new javax.swing.GroupLayout(jPanel145);
        jPanel145.setLayout(jPanel145Layout);
        jPanel145Layout.setHorizontalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel145Layout.createSequentialGroup()
                .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startDateSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel145Layout.setVerticalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(startDateSchedule, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel146.setBackground(new java.awt.Color(255, 255, 255));

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel121.setText("EndDate");

        endDateSchedule.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel146Layout = new javax.swing.GroupLayout(jPanel146);
        jPanel146.setLayout(jPanel146Layout);
        jPanel146Layout.setHorizontalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel146Layout.createSequentialGroup()
                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endDateSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel146Layout.setVerticalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(endDateSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel147.setBackground(new java.awt.Color(255, 255, 255));

        jLabel122.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel122.setText("Note");

        javax.swing.GroupLayout jPanel147Layout = new javax.swing.GroupLayout(jPanel147);
        jPanel147.setLayout(jPanel147Layout);
        jPanel147Layout.setHorizontalGroup(
            jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel147Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNodeSchedule)
                .addContainerGap())
        );
        jPanel147Layout.setVerticalGroup(
            jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel147Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNodeSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel135Layout = new javax.swing.GroupLayout(jPanel135);
        jPanel135.setLayout(jPanel135Layout);
        jPanel135Layout.setHorizontalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel135Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel138, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel135Layout.createSequentialGroup()
                        .addComponent(jPanel136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(jPanel137, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel135Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel145, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel146, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel135Layout.createSequentialGroup()
                        .addGroup(jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel140, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel135Layout.createSequentialGroup()
                        .addComponent(jPanel147, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel135Layout.setVerticalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel135Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel136, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel139, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel137, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel140, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel138, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel141, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel135Layout.createSequentialGroup()
                        .addComponent(jPanel145, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel146, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel147, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel142.setBackground(new java.awt.Color(255, 255, 255));
        jPanel142.setBorder(javax.swing.BorderFactory.createTitledBorder("List"));

        jScrollPane20.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblSchedule.setAutoCreateRowSorter(true);
        tblSchedule.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblSchedule.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Class", "Teacher", "Subject", "FrameTime", "StartTime", "EndTime", "StartDate", "EndDate", "Note"
            }
        ));
        tblSchedule.setGridColor(new java.awt.Color(255, 255, 255));
        tblSchedule.setRowHeight(25);
        tblSchedule.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane20.setViewportView(tblSchedule);
        if (tblSchedule.getColumnModel().getColumnCount() > 0) {
            tblSchedule.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblSchedule.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblSchedule.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblSchedule.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel142Layout = new javax.swing.GroupLayout(jPanel142);
        jPanel142.setLayout(jPanel142Layout);
        jPanel142Layout.setHorizontalGroup(
            jPanel142Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel142Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane20)
                .addContainerGap())
        );
        jPanel142Layout.setVerticalGroup(
            jPanel142Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel142Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel143.setBackground(new java.awt.Color(255, 255, 255));
        jPanel143.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        txtsearchSchedule.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtsearchSchedule.setText("Search...");

        jButton20.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        jButton20.setText("Search");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel143Layout = new javax.swing.GroupLayout(jPanel143);
        jPanel143.setLayout(jPanel143Layout);
        jPanel143Layout.setHorizontalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel143Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtsearchSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel143Layout.setVerticalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel143Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearchSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel144.setBackground(new java.awt.Color(255, 255, 255));

        jButton21.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        jButton21.setText("Add new");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        jButton22.setText("Delete");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_24px_1.png"))); // NOI18N
        jButton23.setText("Edit");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        jButton24.setText("Reset");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton31.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        jButton31.setText("Cancel");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel144Layout = new javax.swing.GroupLayout(jPanel144);
        jPanel144.setLayout(jPanel144Layout);
        jPanel144Layout.setHorizontalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel144Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel144Layout.setVerticalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel144Layout.createSequentialGroup()
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel134Layout = new javax.swing.GroupLayout(jPanel134);
        jPanel134.setLayout(jPanel134Layout);
        jPanel134Layout.setHorizontalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel134Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel143, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel142, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel134Layout.createSequentialGroup()
                        .addComponent(jPanel135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel134Layout.setVerticalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel134Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel135, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Schedule", jPanel134);

        jPanel26.setBackground(new java.awt.Color(122, 72, 221));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(204, 204, 204));
        jLabel72.setText("Teacher management _______________________");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel72)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTeacherLayout = new javax.swing.GroupLayout(pnlTeacher);
        pnlTeacher.setLayout(pnlTeacherLayout);
        pnlTeacherLayout.setHorizontalGroup(
            pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTeacherLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1)
                    .addContainerGap()))
        );
        pnlTeacherLayout.setVerticalGroup(
            pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTeacherLayout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(775, Short.MAX_VALUE))
            .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTeacherLayout.createSequentialGroup()
                    .addGap(141, 141, 141)
                    .addComponent(jTabbedPane1)
                    .addContainerGap()))
        );

        pnlCenter.add(pnlTeacher, "card4");

        pnlUsers.setBackground(new java.awt.Color(255, 255, 255));

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));
        jPanel61.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel30.setText("Id");

        txtIdUser.setEditable(false);

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdUser)
                .addContainerGap())
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel31.setText("Name");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsername)
                .addContainerGap())
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel32.setText("Role");

        cbbUserRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selected", "Admin", "Teacher", "Member" }));

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel33.setText("Password");

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAddPassAdmin)
                .addContainerGap())
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddPassAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel62, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(122, 72, 221));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(204, 204, 204));
        jLabel77.setText("User management _______________________");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel77)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        btnAddUser.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        btnAddUser.setText("Add new");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnDeleteUser.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        btnDeleteUser.setText("Delete");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnResetUser.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnResetUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        btnResetUser.setText("Reset");
        btnResetUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetUserActionPerformed(evt);
            }
        });

        btnCancelUser.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        btnCancelUser.setText("Cancel");
        btnCancelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResetUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));
        jPanel66.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        txtSearchUser.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSearchUser.setText("Search...");

        btnSearchUser.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearchUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        btnSearchUser.setText("Search");
        btnSearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(txtSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setBorder(javax.swing.BorderFactory.createTitledBorder("User list"));

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblUsers.setAutoCreateRowSorter(true);
        tblUsers.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblUsers.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Role"
            }
        ));
        tblUsers.setGridColor(new java.awt.Color(255, 255, 255));
        tblUsers.setRowHeight(25);
        tblUsers.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane7.setViewportView(tblUsers);
        if (tblUsers.getColumnModel().getColumnCount() > 0) {
            tblUsers.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblUsers.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlUsersLayout = new javax.swing.GroupLayout(pnlUsers);
        pnlUsers.setLayout(pnlUsersLayout);
        pnlUsersLayout.setHorizontalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsersLayout.createSequentialGroup()
                        .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlUsersLayout.setVerticalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlUsersLayout.createSequentialGroup()
                        .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlCenter.add(pnlUsers, "card11");

        pnlMark.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(122, 72, 221));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(204, 204, 204));
        jLabel65.setText("Mark management _______________________");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel65)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        search_Mark.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        search_Mark.setText("Search...");

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        jButton13.setText("Search");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(search_Mark, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addContainerGap(649, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_Mark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Student list"));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tbl_Mark.setAutoCreateRowSorter(true);
        tbl_Mark.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl_Mark.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_Mark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Subject", "Student", "Class", "Mark type", "Mark", "Number of exams", "Result"
            }
        ));
        tbl_Mark.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Mark.setRowHeight(25);
        tbl_Mark.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane3.setViewportView(tbl_Mark);
        if (tbl_Mark.getColumnModel().getColumnCount() > 0) {
            tbl_Mark.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_Mark.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbl_Mark.getColumnModel().getColumn(5).setPreferredWidth(40);
            tbl_Mark.getColumnModel().getColumn(6).setPreferredWidth(30);
            tbl_Mark.getColumnModel().getColumn(7).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel17.setText("Student ID");

        txtIdSTD_Mark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdSTD_MarkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdSTD_Mark, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdSTD_Mark, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel23.setText("Subject");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbSubjectMark, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbSubjectMark, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel24.setText("Mark");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdiem_Mark))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiem_Mark, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel121.setBackground(new java.awt.Color(255, 255, 255));

        jLabel93.setBackground(new java.awt.Color(255, 255, 255));
        jLabel93.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel93.setText("Mark type");

        comboType_Mark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboType_MarkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel121Layout = new javax.swing.GroupLayout(jPanel121);
        jPanel121.setLayout(jPanel121Layout);
        jPanel121Layout.setHorizontalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboType_Mark, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel121Layout.setVerticalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel121Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboType_Mark, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel122.setBackground(new java.awt.Color(255, 255, 255));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel94.setText("Number of exams");

        combonumber_Mark.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        javax.swing.GroupLayout jPanel122Layout = new javax.swing.GroupLayout(jPanel122);
        jPanel122.setLayout(jPanel122Layout);
        jPanel122Layout.setHorizontalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel122Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel94)
                .addGap(18, 18, 18)
                .addComponent(combonumber_Mark, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel122Layout.setVerticalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel122Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combonumber_Mark)
                    .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));

        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        jButton14.setText("Add new");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_24px_1.png"))); // NOI18N
        jButton16.setText("Edit");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        jButton17.setText("Reset");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        jButton18.setText("Cancel");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel83Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Mark", jPanel83);

        jPanel84.setBackground(new java.awt.Color(255, 255, 255));

        jPanel85.setBackground(new java.awt.Color(255, 255, 255));
        jPanel85.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel39.setText("Id");

        txtIdMark_Type.setEditable(false);

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdMark_Type, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdMark_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel87.setBackground(new java.awt.Color(255, 255, 255));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel40.setText("Name");

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnameMark_Type)
                .addContainerGap())
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnameMark_Type, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel85Layout.createSequentialGroup()
                .addComponent(jPanel86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel87, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
        );

        jPanel95.setBackground(new java.awt.Color(255, 255, 255));

        jButton43.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        jButton43.setText("Add new");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        jButton44.setText("Delete");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_24px_1.png"))); // NOI18N
        jButton45.setText("Edit");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton46.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        jButton46.setText("Reset");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton47.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        jButton47.setText("Cancel");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel96.setBackground(new java.awt.Color(255, 255, 255));
        jPanel96.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        searchMark_Type.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        searchMark_Type.setText("Search...");
        searchMark_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMark_TypeActionPerformed(evt);
            }
        });

        jButton51.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        jButton51.setText("Search");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(searchMark_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton51)
                .addContainerGap(649, Short.MAX_VALUE))
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchMark_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton51))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel97.setBackground(new java.awt.Color(255, 255, 255));
        jPanel97.setBorder(javax.swing.BorderFactory.createTitledBorder("Mark type list"));

        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblMark_Type.setAutoCreateRowSorter(true);
        tblMark_Type.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblMark_Type.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblMark_Type.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name"
            }
        ));
        tblMark_Type.setGridColor(new java.awt.Color(255, 255, 255));
        tblMark_Type.setRowHeight(25);
        tblMark_Type.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane10.setViewportView(tblMark_Type);
        if (tblMark_Type.getColumnModel().getColumnCount() > 0) {
            tblMark_Type.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel97Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel96, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addComponent(jPanel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel96, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel84Layout.createSequentialGroup()
                        .addComponent(jPanel95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel84Layout.createSequentialGroup()
                        .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel97, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))))
        );

        jTabbedPane2.addTab("Mark type", jPanel84);

        javax.swing.GroupLayout pnlMarkLayout = new javax.swing.GroupLayout(pnlMark);
        pnlMark.setLayout(pnlMarkLayout);
        pnlMarkLayout.setHorizontalGroup(
            pnlMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMarkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addGap(15, 15, 15))
        );
        pnlMarkLayout.setVerticalGroup(
            pnlMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMarkLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        pnlCenter.add(pnlMark, "card5");

        pnlClass.setBackground(new java.awt.Color(255, 255, 255));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel21.setText("Id");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdClass)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        jPanel113.setBackground(new java.awt.Color(255, 255, 255));

        jLabel88.setBackground(new java.awt.Color(255, 255, 255));
        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel88.setText("Faculty");

        javax.swing.GroupLayout jPanel113Layout = new javax.swing.GroupLayout(jPanel113);
        jPanel113.setLayout(jPanel113Layout);
        jPanel113Layout.setHorizontalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbFacultyClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel113Layout.setVerticalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel113Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbFacultyClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel113, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jPanel113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel25.setText("Course");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbCourseClass, 0, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbCourseClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(122, 72, 221));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(204, 204, 204));
        jLabel74.setText("Class management _______________________");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel74)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        btnAddClass.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAddClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        btnAddClass.setText("Add new");
        btnAddClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClassActionPerformed(evt);
            }
        });

        btnDelClass.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDelClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        btnDelClass.setText("Delete");
        btnDelClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelClassActionPerformed(evt);
            }
        });

        btnEditClass.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnEditClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_24px_1.png"))); // NOI18N
        btnEditClass.setText("Edit");
        btnEditClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditClassActionPerformed(evt);
            }
        });

        btnResetClass.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnResetClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        btnResetClass.setText("Reset");
        btnResetClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetClassActionPerformed(evt);
            }
        });

        btnCancelClass.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancelClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        btnCancelClass.setText("Cancel");
        btnCancelClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelClassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnResetClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        txtSearchClass.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSearchClass.setText("Search...");

        btnSearchClass.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearchClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        btnSearchClass.setText("Search");
        btnSearchClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchClassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(txtSearchClass, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchClass)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchClass))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder("List"));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblClass.setAutoCreateRowSorter(true);
        tblClass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblClass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Course", "Faculty"
            }
        ));
        tblClass.setGridColor(new java.awt.Color(255, 255, 255));
        tblClass.setRowHeight(25);
        tblClass.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane4.setViewportView(tblClass);
        if (tblClass.getColumnModel().getColumnCount() > 0) {
            tblClass.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblClass.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlClassLayout = new javax.swing.GroupLayout(pnlClass);
        pnlClass.setLayout(pnlClassLayout);
        pnlClassLayout.setHorizontalGroup(
            pnlClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlClassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlClassLayout.createSequentialGroup()
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlClassLayout.setVerticalGroup(
            pnlClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClassLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClassLayout.createSequentialGroup()
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCenter.add(pnlClass, "card6");

        pnlSubject.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(122, 72, 221));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(204, 204, 204));
        jLabel75.setText("Subject management _______________________");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel75)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel108.setBackground(new java.awt.Color(255, 255, 255));

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel26.setText("Id");

        txtIdSubject.setEditable(false);

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdSubject, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel27.setText("Name");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnameSubject)
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnameSubject, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel110.setBackground(new java.awt.Color(255, 255, 255));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel86.setText("Faculty");

        javax.swing.GroupLayout jPanel110Layout = new javax.swing.GroupLayout(jPanel110);
        jPanel110.setLayout(jPanel110Layout);
        jPanel110Layout.setHorizontalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbFacultySubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel110Layout.setVerticalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbFacultySubject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel110, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        jButton25.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        jButton25.setText("Add new");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        jButton26.setText("Delete");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_24px_1.png"))); // NOI18N
        jButton27.setText("Edit");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        jButton28.setText("Reset");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        jButton29.setText("Cancel");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        seacher_Subject.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        seacher_Subject.setText("Search...");

        jButton30.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        jButton30.setText("Search");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(seacher_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton30)
                .addContainerGap(652, Short.MAX_VALUE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seacher_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder("Subject list"));

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tbl_Subject.setAutoCreateRowSorter(true);
        tbl_Subject.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl_Subject.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_Subject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Faculty"
            }
        ));
        tbl_Subject.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Subject.setRowHeight(25);
        tbl_Subject.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane5.setViewportView(tbl_Subject);
        if (tbl_Subject.getColumnModel().getColumnCount() > 0) {
            tbl_Subject.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel108Layout = new javax.swing.GroupLayout(jPanel108);
        jPanel108.setLayout(jPanel108Layout);
        jPanel108Layout.setHorizontalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel108Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel108Layout.createSequentialGroup()
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel108Layout.setVerticalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel108Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel108Layout.createSequentialGroup()
                        .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Subject", jPanel108);

        jPanel109.setBackground(new java.awt.Color(255, 255, 255));

        jPanel111.setBackground(new java.awt.Color(255, 255, 255));
        jPanel111.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel112.setBackground(new java.awt.Color(255, 255, 255));

        jLabel87.setBackground(new java.awt.Color(255, 255, 255));
        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel87.setText("Subject");

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSubject_Sem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboSubject_Sem, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        jPanel114.setBackground(new java.awt.Color(255, 255, 255));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel89.setText("Faculty");

        javax.swing.GroupLayout jPanel114Layout = new javax.swing.GroupLayout(jPanel114);
        jPanel114.setLayout(jPanel114Layout);
        jPanel114Layout.setHorizontalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboFaculty_Sem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel114Layout.setVerticalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFaculty_Sem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel118.setBackground(new java.awt.Color(255, 255, 255));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel90.setText("Sem");

        javax.swing.GroupLayout jPanel118Layout = new javax.swing.GroupLayout(jPanel118);
        jPanel118.setLayout(jPanel118Layout);
        jPanel118Layout.setHorizontalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSem)
                .addContainerGap())
        );
        jPanel118Layout.setVerticalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel119.setBackground(new java.awt.Color(255, 255, 255));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel91.setText("Year");

        txtyear_Sem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyear_SemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel119Layout = new javax.swing.GroupLayout(jPanel119);
        jPanel119.setLayout(jPanel119Layout);
        jPanel119Layout.setHorizontalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtyear_Sem, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel119Layout.setVerticalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtyear_Sem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel120.setBackground(new java.awt.Color(255, 255, 255));

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel92.setText(" Credits");

        txtCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel120Layout = new javax.swing.GroupLayout(jPanel120);
        jPanel120.setLayout(jPanel120Layout);
        jPanel120Layout.setHorizontalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCredits, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel120Layout.setVerticalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel111Layout = new javax.swing.GroupLayout(jPanel111);
        jPanel111.setLayout(jPanel111Layout);
        jPanel111Layout.setHorizontalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel111Layout.setVerticalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel111Layout.createSequentialGroup()
                .addComponent(jPanel112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel114, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel118, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel119, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel120, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel115.setBackground(new java.awt.Color(255, 255, 255));
        jPanel115.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        jButton58.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        jButton58.setText("Add new");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jButton59.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        jButton59.setText("Delete");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jButton60.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_24px_1.png"))); // NOI18N
        jButton60.setText("Edit");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jButton61.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        jButton61.setText("Reset");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        jButton62.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        jButton62.setText("Cancel");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel115Layout = new javax.swing.GroupLayout(jPanel115);
        jPanel115.setLayout(jPanel115Layout);
        jPanel115Layout.setHorizontalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel115Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel115Layout.setVerticalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel115Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanel116.setBackground(new java.awt.Color(255, 255, 255));
        jPanel116.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        seacher_Sem.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        seacher_Sem.setText("Search...");

        jButton63.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        jButton63.setText("Search");
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel116Layout = new javax.swing.GroupLayout(jPanel116);
        jPanel116.setLayout(jPanel116Layout);
        jPanel116Layout.setHorizontalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel116Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(seacher_Sem, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton63)
                .addContainerGap(652, Short.MAX_VALUE))
        );
        jPanel116Layout.setVerticalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel116Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seacher_Sem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton63))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel117.setBackground(new java.awt.Color(255, 255, 255));
        jPanel117.setBorder(javax.swing.BorderFactory.createTitledBorder("List"));

        jScrollPane13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tbl_Sem.setAutoCreateRowSorter(true);
        tbl_Sem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl_Sem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_Sem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Faculty", "Subject", "Sem", "Year", "Credits"
            }
        ));
        tbl_Sem.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Sem.setRowHeight(25);
        tbl_Sem.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane13.setViewportView(tbl_Sem);
        if (tbl_Sem.getColumnModel().getColumnCount() > 0) {
            tbl_Sem.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel117Layout = new javax.swing.GroupLayout(jPanel117);
        jPanel117.setLayout(jPanel117Layout);
        jPanel117Layout.setHorizontalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel117Layout.setVerticalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel117Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel116, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel109Layout.createSequentialGroup()
                        .addComponent(jPanel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel116, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel109Layout.createSequentialGroup()
                        .addComponent(jPanel115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Lecture", jPanel109);

        javax.swing.GroupLayout pnlSubjectLayout = new javax.swing.GroupLayout(pnlSubject);
        pnlSubject.setLayout(pnlSubjectLayout);
        pnlSubjectLayout.setHorizontalGroup(
            pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSubjectLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane4)
                    .addContainerGap()))
        );
        pnlSubjectLayout.setVerticalGroup(
            pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubjectLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(775, Short.MAX_VALUE))
            .addGroup(pnlSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSubjectLayout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addComponent(jTabbedPane4)
                    .addContainerGap()))
        );

        pnlCenter.add(pnlSubject, "card7");

        pnlCourse.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(122, 72, 221));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(204, 204, 204));
        jLabel76.setText("Course management _______________________");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel76)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel98.setBackground(new java.awt.Color(255, 255, 255));

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel28.setText("Id");

        txtIdFaculty.setEditable(false);

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel29.setText("Name");

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNameFaculty)
                .addContainerGap())
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNameFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel107.setBackground(new java.awt.Color(255, 255, 255));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel85.setText("Year");

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtYearFaculty)
                .addContainerGap())
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtYearFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        btnAddFaculty.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAddFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        btnAddFaculty.setText("Add new");
        btnAddFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFacultyActionPerformed(evt);
            }
        });

        btnDelFaculty.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDelFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        btnDelFaculty.setText("Delete");
        btnDelFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelFacultyActionPerformed(evt);
            }
        });

        btnEditFaculty.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnEditFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_24px_1.png"))); // NOI18N
        btnEditFaculty.setText("Edit");
        btnEditFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditFacultyActionPerformed(evt);
            }
        });

        btnResetFaculty.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnResetFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        btnResetFaculty.setText("Reset");
        btnResetFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetFacultyActionPerformed(evt);
            }
        });

        btnCancelFaculty.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancelFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        btnCancelFaculty.setText("Cancel");
        btnCancelFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelFacultyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddFaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnResetFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        txtSearchFaculty.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSearchFaculty.setText("Search...");
        txtSearchFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchFacultyActionPerformed(evt);
            }
        });

        btnSearchFaculty.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearchFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        btnSearchFaculty.setText("Search");
        btnSearchFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFacultyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(txtSearchFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchFaculty)
                .addContainerGap(652, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchFaculty))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setBorder(javax.swing.BorderFactory.createTitledBorder("Faculty list"));

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblFaculty.setAutoCreateRowSorter(true);
        tblFaculty.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblFaculty.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblFaculty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Year"
            }
        ));
        tblFaculty.setGridColor(new java.awt.Color(255, 255, 255));
        tblFaculty.setRowHeight(25);
        tblFaculty.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane6.setViewportView(tblFaculty);
        if (tblFaculty.getColumnModel().getColumnCount() > 0) {
            tblFaculty.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel98Layout.createSequentialGroup()
                        .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel98Layout.createSequentialGroup()
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Faculty", jPanel98);

        jPanel99.setBackground(new java.awt.Color(255, 255, 255));

        jPanel100.setBackground(new java.awt.Color(255, 255, 255));
        jPanel100.setBorder(javax.swing.BorderFactory.createTitledBorder("Deatils"));

        jPanel101.setBackground(new java.awt.Color(255, 255, 255));

        jLabel79.setBackground(new java.awt.Color(255, 255, 255));
        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel79.setText("Id");

        javax.swing.GroupLayout jPanel101Layout = new javax.swing.GroupLayout(jPanel101);
        jPanel101.setLayout(jPanel101Layout);
        jPanel101Layout.setHorizontalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel101Layout.createSequentialGroup()
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel101Layout.setVerticalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel101Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel102.setBackground(new java.awt.Color(255, 255, 255));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel83.setText("StartDate");

        startDateCourse.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startDateCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startDateCourse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel102Layout.createSequentialGroup()
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel106.setBackground(new java.awt.Color(255, 255, 255));

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel84.setText("EndDate");

        endDateCourse.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endDateCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endDateCourse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel106Layout.createSequentialGroup()
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel100Layout.createSequentialGroup()
                .addComponent(jPanel101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel102, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel106, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel103.setBackground(new java.awt.Color(255, 255, 255));
        jPanel103.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        btnAddCourse.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAddCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_24px.png"))); // NOI18N
        btnAddCourse.setText("Add new");
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });

        btnDeleteCourse.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDeleteCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_cancel_24px.png"))); // NOI18N
        btnDeleteCourse.setText("Delete");
        btnDeleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCourseActionPerformed(evt);
            }
        });

        btnEditCourse.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnEditCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_24px_1.png"))); // NOI18N
        btnEditCourse.setText("Edit");
        btnEditCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCourseActionPerformed(evt);
            }
        });

        btnResetCourse.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnResetCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_reset_24px.png"))); // NOI18N
        btnResetCourse.setText("Reset");
        btnResetCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetCourseActionPerformed(evt);
            }
        });

        btnCancelCourse.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancelCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        btnCancelCourse.setText("Cancel");
        btnCancelCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResetCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnResetCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel104.setBackground(new java.awt.Color(255, 255, 255));
        jPanel104.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        txtSearchCourse.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtSearchCourse.setText("Search...");
        txtSearchCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchCourseActionPerformed(evt);
            }
        });

        btnSearchCourse.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearchCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        btnSearchCourse.setText("Search");
        btnSearchCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(txtSearchCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchCourse)
                .addContainerGap(652, Short.MAX_VALUE))
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCourse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel105.setBackground(new java.awt.Color(255, 255, 255));
        jPanel105.setBorder(javax.swing.BorderFactory.createTitledBorder("Course list"));

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblCourse.setAutoCreateRowSorter(true);
        tblCourse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblCourse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDCourse", "StartDate", "EndDate"
            }
        ));
        tblCourse.setGridColor(new java.awt.Color(255, 255, 255));
        tblCourse.setRowHeight(25);
        tblCourse.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane12.setViewportView(tblCourse);
        if (tblCourse.getColumnModel().getColumnCount() > 0) {
            tblCourse.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel105Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel99Layout.createSequentialGroup()
                        .addComponent(jPanel100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel99Layout.createSequentialGroup()
                        .addComponent(jPanel103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Course", jPanel99);

        javax.swing.GroupLayout pnlCourseLayout = new javax.swing.GroupLayout(pnlCourse);
        pnlCourse.setLayout(pnlCourseLayout);
        pnlCourseLayout.setHorizontalGroup(
            pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        pnlCourseLayout.setVerticalGroup(
            pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane3)
                .addGap(10, 10, 10))
        );

        pnlCenter.add(pnlCourse, "card8");

        pnlSearch.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(110, 89, 222));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(204, 204, 204));
        jLabel70.setText("Search management _______________________");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel70)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel131.setBackground(new java.awt.Color(255, 255, 255));

        combo_Search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Teacher", "Faculty", "Class", "Subject" }));
        combo_Search.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                combo_SearchPopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        combo_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_SearchMouseClicked(evt);
            }
        });
        combo_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_SearchActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        jButton15.setText("Search");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel131Layout = new javax.swing.GroupLayout(jPanel131);
        jPanel131.setLayout(jPanel131Layout);
        jPanel131Layout.setHorizontalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel131Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(combo_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timkem, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton15)
                .addGap(323, 323, 323))
        );
        jPanel131Layout.setVerticalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel131Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timkem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnlStudentSearch.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane15.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblStudent_Search.setAutoCreateRowSorter(true);
        tblStudent_Search.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblStudent_Search.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblStudent_Search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Birthday", "Phone", "Email", "Class", "Gender", "Address"
            }
        ));
        tblStudent_Search.setGridColor(new java.awt.Color(255, 255, 255));
        tblStudent_Search.setRowHeight(25);
        tblStudent_Search.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane15.setViewportView(tblStudent_Search);
        if (tblStudent_Search.getColumnModel().getColumnCount() > 0) {
            tblStudent_Search.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pnlStudentSearchLayout = new javax.swing.GroupLayout(pnlStudentSearch);
        pnlStudentSearch.setLayout(pnlStudentSearchLayout);
        pnlStudentSearchLayout.setHorizontalGroup(
            pnlStudentSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlStudentSearchLayout.setVerticalGroup(
            pnlStudentSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStudentSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbeSearch.addTab("Student", pnlStudentSearch);

        pnlTeacherSearch.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane16.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblTeacher_Search.setAutoCreateRowSorter(true);
        tblTeacher_Search.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblTeacher_Search.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblTeacher_Search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Birthday", "Gender", "Email", "Phone", "Number of Class"
            }
        ));
        tblTeacher_Search.setGridColor(new java.awt.Color(255, 255, 255));
        tblTeacher_Search.setRowHeight(25);
        tblTeacher_Search.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane16.setViewportView(tblTeacher_Search);
        if (tblTeacher_Search.getColumnModel().getColumnCount() > 0) {
            tblTeacher_Search.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pnlTeacherSearchLayout = new javax.swing.GroupLayout(pnlTeacherSearch);
        pnlTeacherSearch.setLayout(pnlTeacherSearchLayout);
        pnlTeacherSearchLayout.setHorizontalGroup(
            pnlTeacherSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTeacherSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTeacherSearchLayout.setVerticalGroup(
            pnlTeacherSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTeacherSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbeSearch.addTab("Teacher", pnlTeacherSearch);

        pnlFacultySearch.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane17.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblFaculty_Search.setAutoCreateRowSorter(true);
        tblFaculty_Search.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblFaculty_Search.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblFaculty_Search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Year", "Number of Class"
            }
        ));
        tblFaculty_Search.setGridColor(new java.awt.Color(255, 255, 255));
        tblFaculty_Search.setRowHeight(25);
        tblFaculty_Search.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane17.setViewportView(tblFaculty_Search);
        if (tblFaculty_Search.getColumnModel().getColumnCount() > 0) {
            tblFaculty_Search.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pnlFacultySearchLayout = new javax.swing.GroupLayout(pnlFacultySearch);
        pnlFacultySearch.setLayout(pnlFacultySearchLayout);
        pnlFacultySearchLayout.setHorizontalGroup(
            pnlFacultySearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFacultySearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFacultySearchLayout.setVerticalGroup(
            pnlFacultySearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFacultySearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbeSearch.addTab("Faculty", pnlFacultySearch);

        pnlClassSearch.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane18.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblClass_Search.setAutoCreateRowSorter(true);
        tblClass_Search.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblClass_Search.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblClass_Search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Faculty", "Course", "Number of Student", "Number of Teacher"
            }
        ));
        tblClass_Search.setGridColor(new java.awt.Color(255, 255, 255));
        tblClass_Search.setRowHeight(25);
        tblClass_Search.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane18.setViewportView(tblClass_Search);
        if (tblClass_Search.getColumnModel().getColumnCount() > 0) {
            tblClass_Search.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pnlClassSearchLayout = new javax.swing.GroupLayout(pnlClassSearch);
        pnlClassSearch.setLayout(pnlClassSearchLayout);
        pnlClassSearchLayout.setHorizontalGroup(
            pnlClassSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClassSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlClassSearchLayout.setVerticalGroup(
            pnlClassSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClassSearchLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbeSearch.addTab("Class", pnlClassSearch);

        pnlSubjectSearch.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane19.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblSubject_Search.setAutoCreateRowSorter(true);
        tblSubject_Search.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblSubject_Search.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblSubject_Search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Faculty", "Number of Teacher"
            }
        ));
        tblSubject_Search.setGridColor(new java.awt.Color(255, 255, 255));
        tblSubject_Search.setRowHeight(25);
        tblSubject_Search.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane19.setViewportView(tblSubject_Search);
        if (tblSubject_Search.getColumnModel().getColumnCount() > 0) {
            tblSubject_Search.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pnlSubjectSearchLayout = new javax.swing.GroupLayout(pnlSubjectSearch);
        pnlSubjectSearch.setLayout(pnlSubjectSearchLayout);
        pnlSubjectSearchLayout.setHorizontalGroup(
            pnlSubjectSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubjectSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSubjectSearchLayout.setVerticalGroup(
            pnlSubjectSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubjectSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbeSearch.addTab("Subject", pnlSubjectSearch);

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbeSearch)
                    .addComponent(jPanel131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel131, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbeSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCenter.add(pnlSearch, "card9");

        pnlSetting.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(110, 89, 222));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(204, 204, 204));
        jLabel71.setText("Setting management _______________________");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel71)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel123.setBackground(new java.awt.Color(255, 255, 255));
        jPanel123.setBorder(javax.swing.BorderFactory.createTitledBorder("Info admin"));

        jPanel124.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel19.setText("ADMIN ID");

        txtIdAdmin.setEditable(false);

        javax.swing.GroupLayout jPanel124Layout = new javax.swing.GroupLayout(jPanel124);
        jPanel124.setLayout(jPanel124Layout);
        jPanel124Layout.setHorizontalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel124Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(58, 58, 58)
                .addComponent(txtIdAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel124Layout.setVerticalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel124Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtIdAdmin)
                .addGap(10, 10, 10))
            .addGroup(jPanel124Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel126.setBackground(new java.awt.Color(255, 255, 255));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel96.setText("NameUser");

        javax.swing.GroupLayout jPanel126Layout = new javax.swing.GroupLayout(jPanel126);
        jPanel126.setLayout(jPanel126Layout);
        jPanel126Layout.setHorizontalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel126Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtNameAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel126Layout.setVerticalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel126Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNameAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel128.setBackground(new java.awt.Color(255, 255, 255));

        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel98.setText("Role");

        txtRoleAdmin.setEditable(false);
        txtRoleAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoleAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel128Layout = new javax.swing.GroupLayout(jPanel128);
        jPanel128.setLayout(jPanel128Layout);
        jPanel128Layout.setHorizontalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtRoleAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel128Layout.setVerticalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRoleAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel125.setBackground(new java.awt.Color(255, 255, 255));

        jLabel95.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel95.setText("Password");

        javax.swing.GroupLayout jPanel125Layout = new javax.swing.GroupLayout(jPanel125);
        jPanel125.setLayout(jPanel125Layout);
        jPanel125Layout.setHorizontalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel125Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel125Layout.setVerticalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel125Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel127.setBackground(new java.awt.Color(255, 255, 255));

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel97.setText("Confirm Password");

        javax.swing.GroupLayout jPanel127Layout = new javax.swing.GroupLayout(jPanel127);
        jPanel127.setLayout(jPanel127Layout);
        jPanel127Layout.setHorizontalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel127Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPassEditUser)
                .addContainerGap())
        );
        jPanel127Layout.setVerticalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel127Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPassEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton64.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton64.setText("Update");
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel123Layout = new javax.swing.GroupLayout(jPanel123);
        jPanel123.setLayout(jPanel123Layout);
        jPanel123Layout.setHorizontalGroup(
            jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel123Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel123Layout.createSequentialGroup()
                        .addComponent(jPanel124, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel123Layout.createSequentialGroup()
                        .addGroup(jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel126, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel127, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel125, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel128, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel123Layout.setVerticalGroup(
            jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel123Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel123Layout.createSequentialGroup()
                        .addComponent(jPanel124, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel126, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel128, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel125, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel127, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_shutdown_24px.png"))); // NOI18N
        jButton4.setText("LogOut");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSettingLayout = new javax.swing.GroupLayout(pnlSetting);
        pnlSetting.setLayout(pnlSettingLayout);
        pnlSettingLayout.setHorizontalGroup(
            pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSettingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSettingLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlSettingLayout.setVerticalGroup(
            pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel123, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 300, Short.MAX_VALUE))
        );

        pnlCenter.add(pnlSetting, "card10");

        pnlSeeMark.setBackground(new java.awt.Color(255, 255, 255));

        jPanel71.setBackground(new java.awt.Color(122, 72, 221));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(204, 204, 204));
        jLabel80.setText("Student transcripts _______________________");

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel80)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));

        cbxSubject.setBackground(new java.awt.Color(255, 255, 255));
        cbxSubject.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbxSubject.setText("Theo môn");
        cbxSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSubjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxSubject)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combomon_SeeMark, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combomon_SeeMark, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel74.setBackground(new java.awt.Color(255, 255, 255));

        cbxClass.setBackground(new java.awt.Color(255, 255, 255));
        cbxClass.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbxClass.setText("Theo lớp");
        cbxClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxClass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combolop_SeeMark, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combolop_SeeMark, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel74Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxClass)
                .addGap(16, 16, 16))
        );

        jPanel129.setBackground(new java.awt.Color(255, 255, 255));

        cbxFaculty.setBackground(new java.awt.Color(255, 255, 255));
        cbxFaculty.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbxFaculty.setText("Theo khoa");

        javax.swing.GroupLayout jPanel129Layout = new javax.swing.GroupLayout(jPanel129);
        jPanel129.setLayout(jPanel129Layout);
        jPanel129Layout.setHorizontalGroup(
            jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel129Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxFaculty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combokhoa_SeeMark, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel129Layout.setVerticalGroup(
            jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel129Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combokhoa_SeeMark, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-sort-alpha-up-reversed-24.png"))); // NOI18N
        jButton2.setText("A - Z");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-sort-alpha-up-24.png"))); // NOI18N
        jButton3.setText("Z - A");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-microsoft-excel-24.png"))); // NOI18N
        jButton5.setText("Export");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-print-24.png"))); // NOI18N
        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel130Layout = new javax.swing.GroupLayout(jPanel130);
        jPanel130.setLayout(jPanel130Layout);
        jPanel130Layout.setHorizontalGroup(
            jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel130Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(search_SeeMark)
                .addGap(55, 55, 55)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel130Layout.setVerticalGroup(
            jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel130Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_SeeMark, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        cbxAll.setBackground(new java.awt.Color(255, 255, 255));
        cbxAll.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbxAll.setText("Tất cả");
        cbxAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAllActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-eye-24.png"))); // NOI18N
        jButton1.setText("Xem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tbl_SeeMark.setAutoCreateRowSorter(true);
        tbl_SeeMark.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl_SeeMark.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_SeeMark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Faculty", "Class", "Teacher", "RollNo", "StudentName", "Subject", "Mark", "Mark type", "Number of exams", "Result"
            }
        ));
        tbl_SeeMark.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_SeeMark.setRowHeight(25);
        tbl_SeeMark.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane14.setViewportView(tbl_SeeMark);
        if (tbl_SeeMark.getColumnModel().getColumnCount() > 0) {
            tbl_SeeMark.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pnlSeeMarkLayout = new javax.swing.GroupLayout(pnlSeeMark);
        pnlSeeMark.setLayout(pnlSeeMarkLayout);
        pnlSeeMarkLayout.setHorizontalGroup(
            pnlSeeMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel130, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSeeMarkLayout.createSequentialGroup()
                .addGroup(pnlSeeMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSeeMarkLayout.createSequentialGroup()
                        .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel129, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(47, 47, 47)
                        .addComponent(cbxAll)
                        .addGap(85, 85, 85)
                        .addComponent(jButton1))
                    .addGroup(pnlSeeMarkLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlSeeMarkLayout.setVerticalGroup(
            pnlSeeMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeeMarkLayout.createSequentialGroup()
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlSeeMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSeeMarkLayout.createSequentialGroup()
                        .addGroup(pnlSeeMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel129, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlSeeMarkLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(15, 15, 15)))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSeeMarkLayout.createSequentialGroup()
                        .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlCenter.add(pnlSeeMark, "card12");

        pnlAttendances.setBackground(new java.awt.Color(255, 255, 255));

        jPanel68.setBackground(new java.awt.Color(122, 72, 221));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(204, 204, 204));
        jLabel78.setText("Attendances management _______________________");

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel78)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel148.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblAttendance.setAutoCreateRowSorter(true);
        tblAttendance.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblAttendance.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule", "Class", "RollNo", "Student", "CheckIn", "Attendances", "Note"
            }
        ));
        tblAttendance.setGridColor(new java.awt.Color(255, 255, 255));
        tblAttendance.setRowHeight(25);
        tblAttendance.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane8.setViewportView(tblAttendance);
        if (tblAttendance.getColumnModel().getColumnCount() > 0) {
            tblAttendance.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Điểm Danh");

        jButton37.setBackground(new java.awt.Color(255, 204, 0));
        jButton37.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton37.setText("SAVE");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel148Layout = new javax.swing.GroupLayout(jPanel148);
        jPanel148.setLayout(jPanel148Layout);
        jPanel148Layout.setHorizontalGroup(
            jPanel148Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel148Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel148Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel148Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel148Layout.setVerticalGroup(
            jPanel148Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel148Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Today Điểm Danh");

        jScrollPane21.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblTodayAttendance.setAutoCreateRowSorter(true);
        tblTodayAttendance.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblTodayAttendance.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblTodayAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Class", "Subject", "Teacher"
            }
        ));
        tblTodayAttendance.setGridColor(new java.awt.Color(255, 255, 255));
        tblTodayAttendance.setRowHeight(25);
        tblTodayAttendance.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane21.setViewportView(tblTodayAttendance);
        if (tblTodayAttendance.getColumnModel().getColumnCount() > 0) {
            tblTodayAttendance.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblTodayAttendance.getColumnModel().getColumn(2).setHeaderValue("SubjectName");
        }

        javax.swing.GroupLayout pnlAttendancesLayout = new javax.swing.GroupLayout(pnlAttendances);
        pnlAttendances.setLayout(pnlAttendancesLayout);
        pnlAttendancesLayout.setHorizontalGroup(
            pnlAttendancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel148, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlAttendancesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAttendancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane21))
                .addContainerGap())
        );
        pnlAttendancesLayout.setVerticalGroup(
            pnlAttendancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAttendancesLayout.createSequentialGroup()
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel99)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel148, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCenter.add(pnlAttendances, "card13");

        pnlStatistical.setBackground(new java.awt.Color(255, 255, 255));

        jPanel149.setBackground(new java.awt.Color(110, 89, 222));

        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(204, 204, 204));
        jLabel100.setText("Statistical _______________________");

        javax.swing.GroupLayout jPanel149Layout = new javax.swing.GroupLayout(jPanel149);
        jPanel149.setLayout(jPanel149Layout);
        jPanel149Layout.setHorizontalGroup(
            jPanel149Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel149Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel149Layout.setVerticalGroup(
            jPanel149Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel149Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel100)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel150.setBackground(new java.awt.Color(228, 228, 228));

        searchStstistical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStstisticalActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        jButton19.setText("Search");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel6.setText("StudentID");

        javax.swing.GroupLayout jPanel150Layout = new javax.swing.GroupLayout(jPanel150);
        jPanel150.setLayout(jPanel150Layout);
        jPanel150Layout.setHorizontalGroup(
            jPanel150Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel150Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchStstistical, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton19)
                .addContainerGap(550, Short.MAX_VALUE))
        );
        jPanel150Layout.setVerticalGroup(
            jPanel150Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel150Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel150Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchStstistical, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));

        jLabel106.setBackground(new java.awt.Color(110, 89, 222));
        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setText("THÔNG TIN SINH VIÊN");
        jLabel106.setOpaque(true);

        jLabel103.setText("Mã sinh viên : ");
        jLabel103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblStatisticalIDSV.setText("jLabel109");
        lblStatisticalIDSV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel112.setText("Họ tên sinh viên : ");
        jLabel112.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblStatisticalNAMESV.setText("jLabel109");
        lblStatisticalNAMESV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel124.setText("Lớp học : ");
        jLabel124.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblStatisticalCLASS.setText("jLabel109");
        lblStatisticalCLASS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblStatisticalAddress.setText("jLabel109");
        lblStatisticalAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel127.setText("Tỉnh / Thành phố :");
        jLabel127.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        pnlStatisticalMark.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlStatisticalMarkLayout = new javax.swing.GroupLayout(pnlStatisticalMark);
        pnlStatisticalMark.setLayout(pnlStatisticalMarkLayout);
        pnlStatisticalMarkLayout.setHorizontalGroup(
            pnlStatisticalMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlStatisticalMarkLayout.setVerticalGroup(
            pnlStatisticalMarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel152.setBackground(new java.awt.Color(255, 255, 255));
        jPanel152.setAutoscrolls(true);
        jPanel152.setComponentPopupMenu(jPopupMenu1);

        jLabel129.setBackground(new java.awt.Color(51, 255, 51));
        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("DANH SÁCH ĐIỂM SINH VIÊN");
        jLabel129.setOpaque(true);

        jScrollPane22.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblMark_Type1.setAutoCreateRowSorter(true);
        tblMark_Type1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblMark_Type1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblMark_Type1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Môn thi", "Điểm thi", "Loại điểm", "Lần thi", "Nhận xét"
            }
        ));
        tblMark_Type1.setGridColor(new java.awt.Color(255, 255, 255));
        tblMark_Type1.setRowHeight(25);
        tblMark_Type1.setSelectionBackground(new java.awt.Color(122, 72, 221));
        jScrollPane22.setViewportView(tblMark_Type1);
        if (tblMark_Type1.getColumnModel().getColumnCount() > 0) {
            tblMark_Type1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel152Layout = new javax.swing.GroupLayout(jPanel152);
        jPanel152.setLayout(jPanel152Layout);
        jPanel152Layout.setHorizontalGroup(
            jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel129, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel152Layout.setVerticalGroup(
            jPanel152Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel152Layout.createSequentialGroup()
                .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlStatisticalMark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel152, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel70Layout.createSequentialGroup()
                .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblStatisticalIDSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblStatisticalNAMESV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel70Layout.createSequentialGroup()
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatisticalAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatisticalCLASS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(lblStatisticalIDSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatisticalNAMESV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatisticalCLASS, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatisticalAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlStatisticalMark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel152, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlStatisticalLayout = new javax.swing.GroupLayout(pnlStatistical);
        pnlStatistical.setLayout(pnlStatisticalLayout);
        pnlStatisticalLayout.setHorizontalGroup(
            pnlStatisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel149, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStatisticalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel150, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlStatisticalLayout.setVerticalGroup(
            pnlStatisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatisticalLayout.createSequentialGroup()
                .addComponent(jPanel149, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel150, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCenter.add(pnlStatistical, "card9");

        pnlContainer.add(pnlCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlContainer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManage10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManage10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnManage10MouseClicked
    
    boolean check = true;
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (check) {
            sidePane.setVisible(false);
            check = false;
        } else {
            sidePane.setVisible(true);
            check = true;
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
            pnlDashborad.setVisible(true);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
             pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnAtendances.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(85,55,118));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudentMouseClicked
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(true);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
            pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(85,55,118));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnStudentMouseClicked

    private void btnTeacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTeacherMouseClicked
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(true);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
             pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(85,55,118));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnTeacherMouseClicked

    private void btnMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarkMouseClicked
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(true);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
             pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(85,55,118));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnMarkMouseClicked

    private void btnClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClassMouseClicked
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(true);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
             pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(85,55,118));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnClassMouseClicked

    private void btnSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubjectMouseClicked
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(true);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
             pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(85,55,118));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnSubjectMouseClicked

    private void btnCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseMouseClicked
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(true);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
             pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(85,55,118));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnCourseMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(true);
            pnlSetting.setVisible(false);
             pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(85,55,118));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSettingMouseClicked
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(true);
            pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(85,55,118));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
            
            txtIdAdmin.setText(user_login.getId()+"");
            txtNameAdmin.setText(user_login.getUserName());
            txtRoleAdmin.setText(user_login.getRole());
    }//GEN-LAST:event_btnSettingMouseClicked

    private void btnResetStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetStdActionPerformed
        // TODO add your handling code here:
            txtIdStd.setText("");
            txtNameStd.setText("");
            dateStd.setCalendar(null);
            txtPhoneStd.setText("");
            txtEmailStd.setText("");
            txtAddressStd.setText("");
            cbbClassStd.setSelectedIndex(0);
            rdoMaleStudent.setSelected(true);
            loadStudent(null);
            
    }//GEN-LAST:event_btnResetStdActionPerformed

    private void btnEditStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditStdActionPerformed
        // TODO add your handling code here:
        
        String tb = "";
        if(txtIdStd.getText().length() == 0 || txtNameStd.getText().length() == 0){
            tb += "Vui lòng điền đầy đủ thông tin!\n";
        }
        
        if(!CheckForm.checkIdStudent(txtIdStd.getText())){
            tb += "Id phải theo định dạng Bxxxx!\n";
        }
        
        if (!CheckForm.isName(txtNameStd.getText())) {
            tb += "Tên không chứa ký tự đặc biệt!\n";
        }
        
        if (!CheckForm.checkPhoneNumber(txtPhoneStd.getText())) {
            tb += "Phone bắt đầu bằng 0 và chứa 10 số!\n";
        }
        
        if (!CheckForm.checkEmail(txtEmailStd.getText())) {
            tb += "Email phải đúng định dạng!\n";
        }
        if (CheckForm.getAge(dateStd.getDate()) < 18 || CheckForm.getAge(dateStd.getDate()) >= 100) {
            tb += "Tuổi không hợp lệ!";
        }  
        if(txtIdStd.getText().length()>0 && txtNameStd.getText().length() > 0 && CheckForm.checkIdStudent(txtIdStd.getText()) ==true && CheckForm.isName(txtNameStd.getText()) == true && CheckForm.checkPhoneNumber(txtPhoneStd.getText()) ==true &&CheckForm.checkEmail(txtEmailStd.getText()) == true && CheckForm.getAge(dateStd.getDate()) >= 18 || CheckForm.getAge(dateStd.getDate()) < 100 ){
            Student s = new Student();
                
            s.setId(txtIdStd.getText());
            s.setName(txtNameStd.getText());
            s.setBirthday(new java.sql.Date(dateStd.getDate().getTime()));
            s.setPhone(txtPhoneStd.getText());
            s.setEmail(txtEmailStd.getText());
            s.setGender(rdoMaleStudent.isSelected()?true:false);
            s.setClass_id(((Class)cbbClassStd.getSelectedItem()).getClassName());
            s.setAddress(txtAddressStd.getText());

            stdImp.update(s);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb, "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadStudent(null);
    }//GEN-LAST:event_btnEditStdActionPerformed

    private void rdoFemaleStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemaleStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoFemaleStudentActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String tb = "";
        if (!CheckForm.isName(txtname_Teacher.getText())) {
            tb += "Tên tối thiểu 3 , tối đa 70 ký tự và không chứa ký tự đặc biệt!\n";
        }
        
        if (!CheckForm.checkEmail(txtemail_Teacher.getText())) {
            tb += "Email phải đúng định dạng!\n";
        }
        
        if (!CheckForm.checkPhoneNumber(txtphone_Teacher.getText())) {
            tb += "Phone bắt đầu bằng 0 và chứa 10 số!\n";
        }
        if (CheckForm.getAge(date_Teacher.getDate()) < 18 || CheckForm.getAge(date_Teacher.getDate()) >= 100) {
            tb += "Tuổi không hợp lệ!";
        }  
        
        if(txtname_Teacher.getText().length()>0 && CheckForm.isName(txtname_Teacher.getText()) == true && CheckForm.checkEmail(txtemail_Teacher.getText()) == true && CheckForm.checkPhoneNumber(txtphone_Teacher.getText()) == true && CheckForm.getAge(date_Teacher.getDate()) >= 18 && CheckForm.getAge(date_Teacher.getDate()) < 100){
            Teacher t = new Teacher();
            t.setIdgv(Integer.parseInt(txtId_Teacher.getText()));
            t.setHoten(txtname_Teacher.getText());
            t.setPhone(txtphone_Teacher.getText());
            t.setEmail(txtemail_Teacher.getText());
            t.setGender(rdoMaleTeacher.isSelected()?true:false);
            t.setNgaysinh(new java.sql.Date(date_Teacher.getDate().getTime()));
            
            tdao.updateTeacher(t);

        }else{
            JOptionPane.showMessageDialog(rootPane, tb, "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadTeacher(null);
            
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        txtId_Teacher.setText("");
        txtname_Teacher.setText("");
        txtphone_Teacher.setText("");
        txtemail_Teacher.setText("");
        rdoMaleTeacher.setSelected(true);
        date_Teacher.setCalendar(null);
        loadTeacher(null);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        if(txtdiem_Mark.getText().length()>0 && txtIdSTD_Mark.getText().length()>0){
            if(stdImp.find(txtIdSTD_Mark.getText())!=null){
                Mark m = new Mark();
                Subject sb = cbbSubjectMark.getItemAt(cbbSubjectMark.getSelectedIndex());
                m.setIdmon(sb.getId());
                Mark_Type mt = comboType_Mark.getItemAt(comboType_Mark.getSelectedIndex());
                m.setType(mt.getId());
                m.setIdsv(txtIdSTD_Mark.getText());
                m.setDiem(Float.parseFloat(txtdiem_Mark.getText()));
                m.setLanthi(Integer.parseInt(combonumber_Mark.getSelectedItem().toString()));
                if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())==3 && Float.parseFloat(txtdiem_Mark.getText())<10 && mt.getId()==2){
                    m.setKetqua("Học lại");
                    JOptionPane.showMessageDialog(rootPane, "Bạn đã thi lại quá số làn quy định.Bạn cần hoc lại!!!");
                }
                if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())==3 && Float.parseFloat(txtdiem_Mark.getText())<8 && mt.getId()==1){
                    m.setKetqua("Học lại");
                    JOptionPane.showMessageDialog(rootPane, "Bạn đã thi lại quá số làn quy định.Bạn cần hoc lại!!!");
                }if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())<=3 && Float.parseFloat(txtdiem_Mark.getText())>=10 && mt.getId()==2){
                    m.setKetqua("Đạt");
                }
                if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())<=3 && Float.parseFloat(txtdiem_Mark.getText())>=8 && mt.getId()==1){
                    m.setKetqua("Đạt");
                }if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())<3 && Float.parseFloat(txtdiem_Mark.getText())<10 && mt.getId()==2){
                    m.setKetqua("Không Đạt");
                }
                if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())<3 && Float.parseFloat(txtdiem_Mark.getText())<8 && mt.getId()==1){
                    m.setKetqua("Không Đạt");
                }
                markdao.updateMark(m);
                loadMark(null);
                jButton17ActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Mã sinh viên không tồn tại","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
         txtIdSTD_Mark.setText("");
        txtdiem_Mark.setText("");
        combonumber_Mark.setSelectedIndex(0);
        cbbSubjectMark.setSelectedIndex(0);
        comboType_Mark.setSelectedIndex(0);
        search_Mark.setText("Search ...");
        loadMark(null);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void btnSeeMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeeMarkMouseClicked
        // TODO add your handling code here:
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
            pnlSeeMark.setVisible(true);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(85,55,118));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnSeeMarkMouseClicked

    private void btnEditClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditClassActionPerformed
        String tb = "";
        
        if (txtIdClass.getText().length()==0) {
            tb += "Vui lòng điền đày đủ thông tin!\n";
        }
        
        if (!CheckForm.checkIdClass(txtIdClass.getText())) {
            tb += "ID phải theo định dạng C1xxxIx (x là số từ 0-9)!\n";
        }
        
        if (txtIdClass.getText().length()>0 && CheckForm.checkIdClass(txtIdClass.getText()) == true) {
            Class c = new Class();
            c.setClassName(txtIdClass.getText());
            c.setFacultyId(((Faculty) cbbFacultyClass.getSelectedItem()).getId());
            c.setCourse(((Course) cbbCourseClass.getSelectedItem()).getMaCourse());
            
            classImp.editClass(c);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb, "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadClass(null);
    }//GEN-LAST:event_btnEditClassActionPerformed

    private void btnResetClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetClassActionPerformed
        txtIdClass.setText("");
        cbbFacultyClass.setSelectedIndex(0);
        cbbCourseClass.setSelectedIndex(0);
        loadClass(null);
    }//GEN-LAST:event_btnResetClassActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        if(txtnameSubject.getText().length()>0){
            Subject sb = new Subject();
            sb.setId(Integer.parseInt(txtIdSubject.getText()));
            sb.setMon(txtnameSubject.getText());
            Faculty f = cbbFacultySubject.getItemAt(cbbFacultySubject.getSelectedIndex());
            sb.setIdFaculty(f.getId());
            
            sbdao.updateSubject(sb);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Chỉnh sửa thất bại!","WARNING", JOptionPane.WARNING_MESSAGE);
        }
        loadSubject(null);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        txtIdSubject.setText("");
        txtnameSubject.setText("");
        cbbFacultySubject.setSelectedIndex(0);
        loadSubject(null);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void btnEditFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditFacultyActionPerformed
        
        String tb = "";
        if(txtNameFaculty.getText().length() == 0 && txtYearFaculty.getText().length() == 0){
            tb += "Vui lòng điền đầy đủ thông tin!\n";
        }
        if(!CheckForm.isYear(txtYearFaculty.getText())){
            tb += "Year phải bao gồm 4 số!\n";
        }
        
        if (txtIdFaculty.getText().length() > 0 && txtNameFaculty.getText().length()>0 && txtYearFaculty.getText().length() > 0 && CheckForm.isYear(txtYearFaculty.getText()) == true) {
            Faculty f = new Faculty();
            f.setId(Integer.parseInt(txtIdFaculty.getText()));
            f.setName(txtNameFaculty.getText());
            f.setYear(Integer.parseInt(txtYearFaculty.getText()));
        
            facultyImp.editCourse(f);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb,"WARNING", JOptionPane.WARNING_MESSAGE);
        }
        loadFaculty(null);
    }//GEN-LAST:event_btnEditFacultyActionPerformed

    private void btnResetFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetFacultyActionPerformed
        txtIdFaculty.setText("");
        txtNameFaculty.setText("");
        txtYearFaculty.setText("");
        loadFaculty(null);
    }//GEN-LAST:event_btnResetFacultyActionPerformed

    private void btnUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsersMouseClicked
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
            pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(true);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100)); 
            btnUsers.setBackground(new Color(85,55,118)); 
    }//GEN-LAST:event_btnUsersMouseClicked

    private void btnResetUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetUserActionPerformed
        txtUsername.setText("");
        txtIdUser.setText("");
        txtAddPassAdmin.setText("");
        cbbUserRole.setSelectedIndex(0);
        loadUsers(null);
    }//GEN-LAST:event_btnResetUserActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        String tb = "";
        
        if (txtUsername.getText().length() == 0 || txtAddPassAdmin.getText().length() == 0 || cbbUserRole.getSelectedItem().toString()=="Selected") {
            tb += "Vui lòng điền đầy đủ thông tin!\n";
        }
        
        if (!CheckForm.isName(txtUsername.getText())) {
            tb += "Tên tối thiểu 3 , tối đa 70 ký tự và không chứa ký tự đặc biệt!\n";
        }
        
        if (!CheckForm.checkPassword(txtAddPassAdmin.getText())) {
            tb += "Password phải chứa bảng chữ cái hoa, chữ thường, các ký tự đặc biệt và 8 ký tự.\n";
        }
        
        if (cbbUserRole.getSelectedItem().toString() != "Selected" && CheckForm.isName(txtUsername.getText()) == true && CheckForm.checkPassword(txtAddPassAdmin.getText()) == true) {
            User u = new User();
            u.setUserName(txtUsername.getText());
            u.setRole(cbbUserRole.getSelectedItem().toString());
            u.setPassword(txtAddPassAdmin.getText());
            
            userDao.addUser(u);
            btnResetUserActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb, "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadUsers(null);
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        if (txtIdUser.getText().length() > 0) {
            if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không !" ) == JOptionPane.YES_OPTION) {
                userDao.removeUser(Integer.parseInt(txtIdUser.getText()));
                btnResetUserActionPerformed(evt);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
        loadUsers(null);
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnCancelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUserActionPerformed
            pnlDashborad.setVisible(true);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
            pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(85,55,118));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnCancelUserActionPerformed

    private void btnSearchFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFacultyActionPerformed
        loadFaculty(txtSearchFaculty.getText());
    }//GEN-LAST:event_btnSearchFacultyActionPerformed

    private void btnSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUserActionPerformed
        loadUsers(txtSearchUser.getText());
    }//GEN-LAST:event_btnSearchUserActionPerformed

    private void txtSearchFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchFacultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchFacultyActionPerformed

    private void btnAtendancesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtendancesMouseClicked
            pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
            pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(true);
            btnAtendances.setBackground(new Color(85,55,118));
            pnlStatistical.setVisible(false);
            btnStatistical.setBackground(new Color(64,43,100));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnAtendancesMouseClicked

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
        if(txtnameMark_Type.getText().length()>0){
            Mark_Type mt = new Mark_Type();
            mt.setId(Integer.parseInt(txtIdMark_Type.getText()));
            mt.setName(txtnameMark_Type.getText());
            
            mark_typeImp.update(mt);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Chỉnh sửa thất bại","Error",JOptionPane.ERROR_MESSAGE);
        }
        loadMark_Type(null);
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        // TODO add your handling code here:
        txtIdMark_Type.setText("");
        txtnameMark_Type.setText("");
        loadMark_Type(null);
    }//GEN-LAST:event_jButton46ActionPerformed

    private void searchMark_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMark_TypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchMark_TypeActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        loadMark_Type(searchMark_Type.getText());
    }//GEN-LAST:event_jButton51ActionPerformed

    private void btnEditCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCourseActionPerformed
        
        String tb = "";
        if(txtIdCourse.getText().length() == 0){
            tb += "Vui lòng điền đầy đủ thông tin!\n";
        }
        
        if(!CheckForm.checkIdCourse(txtIdCourse.getText())){
            tb += "ID phải theo định dạng Kxxx (x tối đa 3 chữ số)\n";
        }
        
        if (txtIdCourse.getText().length() > 0 && CheckForm.checkIdCourse(txtIdCourse.getText()) == true) {
            Course c = new Course();
            c.setMaCourse(txtIdCourse.getText());
            c.setStartDate(new java.sql.Date(startDateCourse.getDate().getTime()));
            c.setEndDate(new java.sql.Date(endDateCourse.getDate().getTime()));
            
            courseImp.editCourse(c);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb,"Error",JOptionPane.ERROR_MESSAGE);
        }
        loadCourse(null);
    }//GEN-LAST:event_btnEditCourseActionPerformed

    private void btnResetCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetCourseActionPerformed
        txtIdCourse.setText("");
        startDateCourse.setCalendar(null);
        endDateCourse.setCalendar(null);
        loadCourse(null);
    }//GEN-LAST:event_btnResetCourseActionPerformed

    private void txtSearchCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchCourseActionPerformed

    private void btnSearchCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCourseActionPerformed
        loadCourse(txtSearchCourse.getText());
    }//GEN-LAST:event_btnSearchCourseActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        // TODO add your handling code here:
        String tb = "";
        if(txtyear_Sem.getText().length() == 0 && txtSem.getText().length() == 0 && txtCredits.getText().length() == 0){
            tb += "Vui lòng điền đầy đủ thông tin!\n";
        }
        if(!CheckForm.isYear(txtyear_Sem.getText())){
            tb += "Year phải bao gồm 4 số!\n";
        }
        
        if(txtyear_Sem.getText().length()>0 && txtSem.getText().length() > 0 && txtCredits.getText().length() > 0 && CheckForm.isYear(txtyear_Sem.getText()) == true){
            Sem s = new Sem();
            Faculty f = comboFaculty_Sem.getItemAt(comboFaculty_Sem.getSelectedIndex());
            s.setIdFaculty(f.getId());
            Subject sb = comboSubject_Sem.getItemAt(comboSubject_Sem.getSelectedIndex());
            s.setIdmon(sb.getId());
            s.setSem(Integer.parseInt(txtSem.getText()));
            s.setYear(Integer.parseInt(txtyear_Sem.getText()));
            s.setSoTinchi(Integer.parseInt(txtCredits.getText()));
            
            semdao.updateSem(s);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb ,"Error",JOptionPane.ERROR_MESSAGE);
        }
        loadSem(null);
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
        txtSem.setText("");
        txtCredits.setText("");
        txtyear_Sem.setText("");
        comboFaculty_Sem.setSelectedIndex(0);
        comboSubject_Sem.setSelectedIndex(0);
        loadSem(null);
    }//GEN-LAST:event_jButton61ActionPerformed

    private void txtyear_SemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyear_SemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyear_SemActionPerformed

    private void txtCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreditsActionPerformed

    private void rdoFemaleTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemaleTeacherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoFemaleTeacherActionPerformed

    private void txtRoleAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoleAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoleAdminActionPerformed

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
        String tb = "";
        if(txtIdCourse.getText().length() == 0){
            tb += "Vui lòng điền đầy đủ thông tin!\n";
        }
        
        if(!CheckForm.checkIdCourse(txtIdCourse.getText())){
            tb += "ID phải theo định dạng Kxxx (x là số)\n";
        }
        
        if (txtIdCourse.getText().length() > 0 && CheckForm.checkIdCourse(txtIdCourse.getText()) == true) {
            Course c = new Course();
            c.setMaCourse(txtIdCourse.getText());
            c.setStartDate(new java.sql.Date(startDateCourse.getDate().getTime()));
            c.setEndDate(new java.sql.Date(endDateCourse.getDate().getTime()));
            
            courseImp.addCourse(c);
            btnResetCourseActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb ,"Error",JOptionPane.ERROR_MESSAGE);
        }
        loadCourse(null);
    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void btnDeleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCourseActionPerformed
        if (txtIdCourse.getText().length() > 0) {
            if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không !" ) == JOptionPane.YES_OPTION) {
                courseImp.remove(txtIdCourse.getText());
                btnResetCourseActionPerformed(evt);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!" ,"Error",JOptionPane.ERROR_MESSAGE);
        }
                
        loadCourse(null);
    }//GEN-LAST:event_btnDeleteCourseActionPerformed

    private void btnCancelCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelCourseActionPerformed
            btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_btnCancelCourseActionPerformed

    private void btnAddFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFacultyActionPerformed
        String tb = "";
        if(txtNameFaculty.getText().length() == 0 && txtYearFaculty.getText().length() == 0){
            tb += "Vui lòng điền đầy đủ thông tin!\n";
        }
        if(!CheckForm.isYear(txtYearFaculty.getText())){
            tb += "Year phải bao gồm 4 số!\n";
        }
        
        if (txtNameFaculty.getText().length()>0 && txtYearFaculty.getText().length() > 0 && CheckForm.isYear(txtYearFaculty.getText()) == true) {
            Faculty f = new Faculty();
            f.setName(txtNameFaculty.getText());
            f.setYear(Integer.parseInt(txtYearFaculty.getText()));
            
            facultyImp.addCourse(f);
            btnResetFacultyActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb ,"Error",JOptionPane.ERROR_MESSAGE);
        }
        loadFaculty(null);
    }//GEN-LAST:event_btnAddFacultyActionPerformed

    private void btnDelFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelFacultyActionPerformed
        if (txtIdFaculty.getText().length() > 0) {
            if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không !" ) == JOptionPane.YES_OPTION) {
                facultyImp.remove(Integer.parseInt(txtIdFaculty.getText()));
                btnResetFacultyActionPerformed(evt);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!" ,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        loadFaculty(null);
    }//GEN-LAST:event_btnDelFacultyActionPerformed

    private void btnCancelFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelFacultyActionPerformed
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_btnCancelFacultyActionPerformed

    private void btnAddClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClassActionPerformed
        String tb = "";
        
        if (txtIdClass.getText().length()==0) {
            tb += "Vui lòng điền đày đủ thông tin!\n";
        }
        
        if (!CheckForm.checkIdClass(txtIdClass.getText())) {
            tb += "ID phải theo định dạng C1xxxIx (x là số từ 0-9)!\n";
        }
        
        if (txtIdClass.getText().length()>0 && CheckForm.checkIdClass(txtIdClass.getText()) == true) {
            Class c = new Class();
            c.setClassName(txtIdClass.getText());
            c.setFacultyId(((Faculty) cbbFacultyClass.getSelectedItem()).getId());
            c.setCourse(((Course) cbbCourseClass.getSelectedItem()).getMaCourse());
            
            classImp.addClass(c);
            btnResetClassActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb, "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadClass(null);
    }//GEN-LAST:event_btnAddClassActionPerformed

    private void btnDelClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelClassActionPerformed
        if (txtIdClass.getText().length() > 0) {
            if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không !" ) == JOptionPane.YES_OPTION) {
                classImp.removeClass(txtIdClass.getText());
                btnResetClassActionPerformed(evt);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        loadClass(null);
    }//GEN-LAST:event_btnDelClassActionPerformed

    private void btnCancelClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelClassActionPerformed
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_btnCancelClassActionPerformed

    private void btnSearchClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchClassActionPerformed
        loadClass(txtSearchClass.getText());
    }//GEN-LAST:event_btnSearchClassActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String tb = "";
        if (!CheckForm.isName(txtname_Teacher.getText())) {
            tb += "Tên tối thiểu 3 , tối đa 70 ký tự và không chứa ký tự đặc biệt!\n";
        }
        
        if (!CheckForm.checkEmail(txtemail_Teacher.getText())) {
            tb += "Email phải đúng định dạng!\n";
        }
        
        if (!CheckForm.checkPhoneNumber(txtphone_Teacher.getText())) {
            tb += "Phone bắt đầu bằng 0 và chứa 10 số!\n";
        }
        if (CheckForm.getAge(date_Teacher.getDate()) < 18 || CheckForm.getAge(date_Teacher.getDate()) >= 100) {
            tb += "Tuổi không hợp lệ!";
        }  
        
        if(txtname_Teacher.getText().length()>0 && CheckForm.isName(txtname_Teacher.getText()) == true && CheckForm.checkEmail(txtemail_Teacher.getText()) == true && CheckForm.checkPhoneNumber(txtphone_Teacher.getText()) == true && CheckForm.getAge(date_Teacher.getDate()) >= 18 && CheckForm.getAge(date_Teacher.getDate()) < 100){
            Teacher t = new Teacher();
            t.setHoten(txtname_Teacher.getText());
            t.setPhone(txtphone_Teacher.getText());
            t.setEmail(txtemail_Teacher.getText());
            t.setGender(rdoMaleTeacher.isSelected()?true:false);
            t.setNgaysinh(new java.sql.Date(date_Teacher.getDate().getTime()));
            
            tdao.insertTeacher(t);
            jButton11ActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb, "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadTeacher(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if(txtId_Teacher.getText().length() > 0){
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa không?")==JOptionPane.YES_OPTION){
                tdao.delete(Integer.parseInt(txtId_Teacher.getText()));
                jButton11ActionPerformed(evt);
            }
            loadTeacher(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        loadTeacher(search_Teacher.getText());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
        if(txtnameMark_Type.getText().length()>0){
            Mark_Type mt = new Mark_Type();
            mt.setName(txtnameMark_Type.getText());
            
            mark_typeImp.insert(mt);
            jButton46ActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Thêm mới thất bại","Error",JOptionPane.ERROR_MESSAGE);
        }
        loadMark_Type(null);
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        if(txtIdMark_Type.getText().length()>0){
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa không?")==JOptionPane.YES_OPTION){
               
                     mark_typeImp.delete(Integer.parseInt(txtIdMark_Type.getText()));
                     jButton46ActionPerformed(evt);
               
               
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
        loadMark_Type(null);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
        if(txtIdAdmin.getText().length()>0 && passEditUser.getText().length() == confirmPassEditUser.getText().length()){
            User u = new User();
            u.setId(Integer.parseInt(txtIdAdmin.getText()));
            u.setUserName(txtNameAdmin.getText());
            u.setRole(txtRoleAdmin.getText());
            if (passEditUser.getText().length()>0 && confirmPassEditUser.getText().length()>0) {
                u.setPassword(confirmPassEditUser.getText());
            }else{
                u.setPassword(user_login.getPassword());
            }
            
            userDao.editUser(u);
            user_login=u;
            lblUsername.setText(user_login.getUserName());
            txtNameAdmin.setText(user_login.getUserName());
        }else{
            JOptionPane.showMessageDialog(rootPane, "Chỉnh sửa thất bại");
        }
        
        passEditUser.setText("");
        confirmPassEditUser.setText("");
    }//GEN-LAST:event_jButton64ActionPerformed

    private void btnAddStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStdActionPerformed
        // TODO add your handling code here:
        String tb = "";
        if(txtIdStd.getText().length() == 0 || txtNameStd.getText().length() == 0){
            tb += "Vui lòng điền đầy đủ thông tin!\n";
        }
        
        if(!CheckForm.checkIdStudent(txtIdStd.getText())){
            tb += "Id phải theo định dạng Bxxxx!\n";
        }
        
        if (!CheckForm.isName(txtNameStd.getText())) {
            tb += "Tên không chứa ký tự đặc biệt!\n";
        }
        
        if (!CheckForm.checkPhoneNumber(txtPhoneStd.getText())) {
            tb += "Phone bắt đầu bằng 0 và chứa 10 số!\n";
        }
        
        if (!CheckForm.checkEmail(txtEmailStd.getText())) {
            tb += "Email phải đúng định dạng!\n";
        }
        if (CheckForm.getAge(dateStd.getDate()) < 18 || CheckForm.getAge(dateStd.getDate()) >= 100) {
            tb += "Tuổi không hợp lệ!";
        }  
        if(txtIdStd.getText().length()>0 && txtNameStd.getText().length() > 0 && CheckForm.checkIdStudent(txtIdStd.getText()) ==true && CheckForm.isName(txtNameStd.getText()) == true && CheckForm.checkPhoneNumber(txtPhoneStd.getText()) ==true &&CheckForm.checkEmail(txtEmailStd.getText()) == true && CheckForm.getAge(dateStd.getDate()) >= 18 && CheckForm.getAge(dateStd.getDate()) < 100 ){
            Student s = new Student();
                if (stdImp.find(txtIdStd.getText()) != null) {
                    JOptionPane.showMessageDialog(rootPane, "ID sinh viên đã tồn tại!", "WARNING", JOptionPane.WARNING_MESSAGE);
                }else{
                    s.setId(txtIdStd.getText());
                    s.setName(txtNameStd.getText());
                    s.setBirthday(new java.sql.Date(dateStd.getDate().getTime()));
                    s.setPhone(txtPhoneStd.getText());
                    s.setEmail(txtEmailStd.getText());
                    s.setGender(rdoMaleStudent.isSelected()?true:false);
                    s.setClass_id(((Class)cbbClassStd.getSelectedItem()).getClassName());
                    s.setAddress(txtAddressStd.getText());

                    stdImp.insert(s);
                    btnResetStdActionPerformed(evt);
                }
        }else{
            JOptionPane.showMessageDialog(rootPane, tb, "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadStudent(null);
    }//GEN-LAST:event_btnAddStdActionPerformed

    private void btnDelStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelStdActionPerformed
        // TODO add your handling code here:
        if(txtIdStd.getText().length()>0){
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa không?")==JOptionPane.YES_OPTION){
                stdImp.delete(txtIdStd.getText());
                btnResetStdActionPerformed(evt);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
        loadStudent(null);
    }//GEN-LAST:event_btnDelStdActionPerformed

    private void btnCancelStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelStdActionPerformed
        // TODO add your handling code here:
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_btnCancelStdActionPerformed

    private void btnSearchStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStdActionPerformed
        // TODO add your handling code here:
        loadStudent(txtSearchStd.getText());
    }//GEN-LAST:event_btnSearchStdActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        
        if(txtnameSubject.getText().length()>0){
            Subject sb = new Subject();
            sb.setMon(txtnameSubject.getText());
            Faculty f = cbbFacultySubject.getItemAt(cbbFacultySubject.getSelectedIndex());
            sb.setIdFaculty(f.getId());
            
            sbdao.insertSubject(sb);
            jButton28ActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Thêm mới thất bại", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        loadSubject(null);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        if(txtIdSubject.getText().length() > 0){
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa không?")==JOptionPane.YES_OPTION){
                sbdao.deleteSubject(Integer.parseInt(txtIdSubject.getText()));
                jButton28ActionPerformed(evt);
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
        loadSubject(null);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        loadSubject(seacher_Subject.getText());
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
        if(txtNameTeacher_Class.getText().length()>0){
            if(tdao.find(Integer.parseInt(txtNameTeacher_Class.getText()))!=null){
                Teacher_Class tc = new Teacher_Class();
                tc.setIdgv(Integer.parseInt(txtNameTeacher_Class.getText()));
                Class c = combo_TeacherClass.getItemAt(combo_TeacherClass.getSelectedIndex());
                tc.setName_Class(c.getClassName());
                tcdao.insertTeacher_Class(tc);
                
                txtNameTeacher_Class.setText("");
                combo_TeacherClass.setSelectedIndex(0);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Mã giá viên không tồn tại!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Thêm mới thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
        loadTeacherClass(null);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
        if(txtNameTeacher_Class.getText().length()>0){
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa không?")==JOptionPane.YES_OPTION){
                tcdao.deleteTeacher_Class(Integer.parseInt(txtNameTeacher_Class.getText()),((Class)combo_TeacherClass.getSelectedItem()).getClassName());
                
                txtNameTeacher_Class.setText("");
                combo_TeacherClass.setSelectedIndex(0);
            }
            loadTeacherClass(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
        loadTeacherClass(Seacher_TeacherClass.getText());
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        if(txtIdTeacherSubject.getText().length()>0){
            if(tdao.find(Integer.parseInt(txtIdTeacherSubject.getText()))!=null){
                Teacher_Subject ts = new Teacher_Subject();
                
                ts.setIdgv(Integer.parseInt(txtIdTeacherSubject.getText()));
                ts.setIdsb(((Subject) cbbTeacherSubject.getSelectedItem()).getId());
                
                tsdao.insertTeacher_Subject(ts);
                
                txtIdTeacherSubject.setText("");
                cbbTeacherSubject.setSelectedIndex(0);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Mã giáo viên không tồn tại!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Thêm mới thất bại","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        loadTeacherSubject(null);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        if(txtIdTeacherSubject.getText().length() > 0){
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa không?")==JOptionPane.YES_OPTION){
                tsdao.deleteTeacher_Subject(Integer.parseInt(txtIdTeacherSubject.getText()),((Subject)cbbTeacherSubject.getSelectedItem()).getId());
                
                txtIdTeacherSubject.setText("");
                cbbTeacherSubject.setSelectedIndex(0);
            }
            loadTeacherSubject(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        // TODO add your handling code here:
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        // TODO add your handling code here:
        loadTeacherSubject(txtSearchTeacherSubject.getText());
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        // TODO add your handling code here:
        String tb = "";
        if(txtyear_Sem.getText().length() == 0 && txtSem.getText().length() == 0 && txtCredits.getText().length() == 0){
            tb += "Vui lòng điền đầy đủ thông tin!\n";
        }
        if(!CheckForm.isYear(txtyear_Sem.getText())){
            tb += "Year phải bao gồm 4 số!\n";
        }
        
        if(txtyear_Sem.getText().length()>0 && txtSem.getText().length() > 0 && txtCredits.getText().length() > 0 && CheckForm.isYear(txtyear_Sem.getText()) == true){
            Sem s = new Sem();
            
            Faculty f = comboFaculty_Sem.getItemAt(comboFaculty_Sem.getSelectedIndex());
            s.setIdFaculty(f.getId());
            Subject sb = comboSubject_Sem.getItemAt(comboSubject_Sem.getSelectedIndex());
            s.setIdmon(sb.getId());
            s.setSem(Integer.parseInt(txtSem.getText()));
            s.setYear(Integer.parseInt(txtyear_Sem.getText()));
            s.setSoTinchi(Integer.parseInt(txtCredits.getText()));
            
            semdao.insertSem(s);
            jButton61ActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(rootPane, tb,"Error",JOptionPane.ERROR_MESSAGE);
        }
        loadSem(null);
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        // TODO add your handling code here:
        if(txtSem.getText().length() > 0 ){
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa không?")==JOptionPane.YES_OPTION){
                semdao.deleteSem(((Subject)comboSubject_Sem.getSelectedItem()).getId(),((Faculty)comboFaculty_Sem.getSelectedItem()).getId());
                jButton61ActionPerformed(evt);
            }
            loadSem(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        // TODO add your handling code here:
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        // TODO add your handling code here:
        loadSem(seacher_Sem.getText());
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        
        for (int i = 0; i < tblAttendance.getRowCount(); i++) {
            Attendance a = new Attendance();
                
            a.setIdSchedule((int) tblAttendance.getValueAt(i, 0));
            a.setIdStudent((String) tblAttendance.getValueAt(i, 2));
            a.setCreatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
            a.setUpdatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
            a.setStatus((String) tblAttendance.getValueAt(i, 5));
            a.setNote((String) tblAttendance.getValueAt(i,6));
            if (systemManage.findAttendance((int) tblAttendance.getValueAt(i, 0)).size() > 0) {
                systemManage.updateAttendance(a);
            }else{
                systemManage.addAttendance(a);
            }
        }
    }//GEN-LAST:event_jButton37ActionPerformed

    private void comboType_MarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboType_MarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboType_MarkActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if(txtdiem_Mark.getText().length()>0 && txtIdSTD_Mark.getText().length()>0){
            if(stdImp.find(txtIdSTD_Mark.getText())!=null){
                Mark m = new Mark();
                Subject sb = cbbSubjectMark.getItemAt(cbbSubjectMark.getSelectedIndex());
                m.setIdmon(sb.getId());
                Mark_Type mt = comboType_Mark.getItemAt(comboType_Mark.getSelectedIndex());
                m.setType(mt.getId());
                m.setIdsv(txtIdSTD_Mark.getText());
                m.setDiem(Float.parseFloat(txtdiem_Mark.getText()));
                m.setLanthi(Integer.parseInt(combonumber_Mark.getSelectedItem().toString()));
                if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())==3 && Float.parseFloat(txtdiem_Mark.getText())<10 && mt.getId()==2){
                    m.setKetqua("Học lại");
                    JOptionPane.showMessageDialog(rootPane, "Bạn đã thi lại quá số làn quy định.Bạn cần hoc lại!!!");
                }
                if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())==3 && Float.parseFloat(txtdiem_Mark.getText())<8 && mt.getId()==1){
                    m.setKetqua("Học lại");
                    JOptionPane.showMessageDialog(rootPane, "Bạn đã thi lại quá số làn quy định.Bạn cần hoc lại!!!");
                }if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())<=3 && Float.parseFloat(txtdiem_Mark.getText())>=10 && mt.getId()==2){
                    m.setKetqua("Đạt");
                }
                if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())<=3 && Float.parseFloat(txtdiem_Mark.getText())>=8 && mt.getId()==1){
                    m.setKetqua("Đạt");
                }if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())<3 && Float.parseFloat(txtdiem_Mark.getText())<10 && mt.getId()==2){
                    m.setKetqua("Không Đạt");
                }
                if(Integer.parseInt(combonumber_Mark.getSelectedItem().toString())<3 && Float.parseFloat(txtdiem_Mark.getText())<8 && mt.getId()==1){
                    m.setKetqua("Không Đạt");
                }
                if( mt.getId()>=2 && Float.parseFloat(txtdiem_Mark.getText())<10){
                    m.setKetqua("Không Đạt");
                }
                if( mt.getId()>=2 && Float.parseFloat(txtdiem_Mark.getText())>=10){
                    m.setKetqua("Đạt");
                }
                markdao.insertMark(m);
                loadMark(null);
                jButton17ActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Mã sinh viên không tồn tại!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Thêm mới thất bại","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        loadMark(search_Mark.getText());
    }//GEN-LAST:event_jButton13ActionPerformed

    private void txtIdSTD_MarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdSTD_MarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdSTD_MarkActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        List<SeeMark> list = new ArrayList<>();
        
        for (int i = 0; i < tbl_SeeMark.getRowCount(); i++) {
            SeeMark sm = new SeeMark();
            
            sm.setIdFaculty((String) tbl_SeeMark.getValueAt(i,0));
            sm.setLop((String) tbl_SeeMark.getValueAt(i,1));
            sm.setTen((String) tbl_SeeMark.getValueAt(i,2));
            sm.setIdsv((String) tbl_SeeMark.getValueAt(i,3));
            sm.setName((String) tbl_SeeMark.getValueAt(i,4));
            sm.setMon((String) tbl_SeeMark.getValueAt(i,5));
            sm.setDiem((float) tbl_SeeMark.getValueAt(i,6));
            sm.setType_mark((String) tbl_SeeMark.getValueAt(i,7));
            sm.setLanthi((int) tbl_SeeMark.getValueAt(i,8));
            sm.setKetqua((String) tbl_SeeMark.getValueAt(i,9));
        
            list.add(sm);
        }
        if (WriteFile.WriteFileExcel(list)) {
            JOptionPane.showMessageDialog(rootPane, "Write File is successful!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Write File is error!");
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbxAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAllActionPerformed

    private void cbxClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxClassActionPerformed

    private void cbxSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSubjectActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String facultyName = null;
        String subjectName = null;
        String idClass = null;
        String search = "";
        
        if (cbxSubject.isSelected()) {
            subjectName = ((Subject)combomon_SeeMark.getSelectedItem()).getMon().toString();
        }
        
        if (cbxClass.isSelected()) {
            idClass = ((Class)combolop_SeeMark.getSelectedItem()).getClassName().toString();
        }
        
        if (cbxFaculty.isSelected()) {
            facultyName = ((Faculty)combokhoa_SeeMark.getSelectedItem()).getName().toString();
        }
        
        if (search_SeeMark.getText().length() > 0) {
            search = search_SeeMark.getText();
        }
         
        if(cbxAll.isSelected()){
            loadSeeMark(null,null,null,search,0);
        }else{
            loadSeeMark(facultyName,idClass,subjectName,search,0);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        if(combo_Search.getSelectedItem().toString()=="Student"){
            jTabbeSearch.setSelectedIndex(0);
            loadStudent_Search(timkem.getText());
            loadFaculty_Search(null);
            loadClass_Search(null);
            loadTeacher_Search(null);
            loadSubject_Search(null);
        }
        if(combo_Search.getSelectedItem().toString()=="Teacher"){
            jTabbeSearch.setSelectedIndex(1);
            loadTeacher_Search(timkem.getText());
            loadStudent_Search(null);
            loadFaculty_Search(null);
            loadClass_Search(null);
            loadSubject_Search(null);
        }
        
        if(combo_Search.getSelectedItem().toString()=="Faculty"){
            jTabbeSearch.setSelectedIndex(2);
            loadFaculty_Search(timkem.getText());
            loadTeacher_Search(null);
            loadStudent_Search(null);
            loadClass_Search(null);
            loadSubject_Search(null);
        }
        
        if(combo_Search.getSelectedItem().toString()=="Class"){
            jTabbeSearch.setSelectedIndex(3);
            loadStudent_Search(null);
            loadFaculty_Search(null);
            loadClass_Search(timkem.getText());
            loadTeacher_Search(null);
            loadSubject_Search(null);
        }
        
        if(combo_Search.getSelectedItem().toString()=="Subject"){
            jTabbeSearch.setSelectedIndex(4);
            loadStudent_Search(null);
            loadFaculty_Search(null);
            loadClass_Search(null);
            loadTeacher_Search(null);
            loadSubject_Search(timkem.getText());
        }
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void combo_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_SearchActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        List<SeeMark> list = new ArrayList<>();
        
        for (int i = 0; i < tbl_SeeMark.getRowCount(); i++) {
            SeeMark sm = new SeeMark();
            
            sm.setIdFaculty((String) tbl_SeeMark.getValueAt(i,0));
            sm.setLop((String) tbl_SeeMark.getValueAt(i,1));
            sm.setTen((String) tbl_SeeMark.getValueAt(i,2));
            sm.setIdsv((String) tbl_SeeMark.getValueAt(i,3));
            sm.setName((String) tbl_SeeMark.getValueAt(i,4));
            sm.setMon((String) tbl_SeeMark.getValueAt(i,5));
            sm.setDiem((float) tbl_SeeMark.getValueAt(i,6));
            sm.setType_mark((String) tbl_SeeMark.getValueAt(i,7));
            sm.setLanthi((int) tbl_SeeMark.getValueAt(i,8));
            sm.setKetqua((String) tbl_SeeMark.getValueAt(i,9));
        
            list.add(sm);
        }
        
        if (WriteFile.WriteFileTXT(list)) {
            JOptionPane.showMessageDialog(rootPane, "Write File is successful!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Write File is error!");
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        loadSeeMark(null,null,null,"",1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        loadSeeMark(null,null,null,"",2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void combo_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_SearchMouseClicked
     
    }//GEN-LAST:event_combo_SearchMouseClicked

    private void combo_SearchPopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_SearchPopupMenuCanceled
       
    }//GEN-LAST:event_combo_SearchPopupMenuCanceled

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        SignIn si =  new SignIn();
        this.dispose();
        si.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rdoframetime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoframetime1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoframetime1ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        loadSchedule(txtsearchSchedule.getText());
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        if(txtIdTeacherSchedule.getText().length()>0){
            
            if (tdao.find(Integer.parseInt(txtIdTeacherSchedule.getText())) != null) {
                Schedule s = new Schedule();
                s.setIdSubject(((Subject)cbbSubjectSchedule.getSelectedItem()).getId());
                s.setIdTeacher(Integer.parseInt(txtIdTeacherSchedule.getText()));
                s.setIdClass(((Class)cbbClassSchedule.getSelectedItem()).getClassName());
                if (rdoframetime0.isSelected()) {
                    s.setFrametime(false);
                }
                if (rdoframetime1.isSelected()) {
                    s.setFrametime(true);
                }
                s.setStartTime(new java.sql.Time(((Date) startTimeSchedule.getValue()).getTime()));
                s.setEndTime(new java.sql.Time(((Date) endTimeSchedule.getValue()).getTime()));
                s.setStartDate(new java.sql.Date(startDateSchedule.getDate().getTime()));
                s.setEndDate(new java.sql.Date(endDateSchedule.getDate().getTime()));
                s.setNote(txtNodeSchedule.getText());
                
                scheduleImp.add(s);
                jButton24ActionPerformed(evt);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Mã giáo viên không tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Thêm mới thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadSchedule("");
        loadScheduleToday();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        if(txtIdTeacherSchedule.getText().length() > 0){
            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa không?")==JOptionPane.YES_OPTION){
                scheduleImp.delete(Integer.parseInt(txtIdTeacherSchedule.getText()));
                jButton24ActionPerformed(evt);
            }
            loadSchedule("");
            loadScheduleToday();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        if(txtIdTeacherSchedule.getText().length()>0){
            
            if (tdao.find(Integer.parseInt(txtIdTeacherSchedule.getText())) != null) {
                Schedule s = new Schedule();
                s.setId(Integer.parseInt(txtIdSchedule.getText()));
                s.setIdSubject(((Subject)cbbSubjectSchedule.getSelectedItem()).getId());
                s.setIdTeacher(Integer.parseInt(txtIdTeacherSchedule.getText()));
                s.setIdClass(((Class)cbbClassSchedule.getSelectedItem()).getClassName());
                if (rdoframetime0.isSelected()) {
                    s.setFrametime(false);
                }
                if (rdoframetime1.isSelected()) {
                    s.setFrametime(true);
                }
                s.setStartTime(new java.sql.Time(((Date) startTimeSchedule.getValue()).getTime()));
                s.setEndTime(new java.sql.Time(((Date) endTimeSchedule.getValue()).getTime()));
                s.setStartDate(new java.sql.Date(startDateSchedule.getDate().getTime()));
                s.setEndDate(new java.sql.Date(endDateSchedule.getDate().getTime()));
                s.setNote(txtNodeSchedule.getText());
                
                scheduleImp.update(s);

            }else{
                JOptionPane.showMessageDialog(rootPane, "Mã giáo viên không tồn tại!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Chỉnh sửa thất bại!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        loadSchedule("");
        loadScheduleToday();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
            txtIdSchedule.setText("");
            cbbSubjectSchedule.setSelectedIndex(0);
            cbbClassSchedule.setSelectedIndex(0);
            txtIdTeacherSchedule.setText("");
            rdoframetime0.setSelected(true);
            startTimeSchedule.setValue(new Date());
            endTimeSchedule.setValue(new Date());
            startDateSchedule.setCalendar(null);
            endDateSchedule.setCalendar(null);
            txtNodeSchedule.setText("");
            loadSchedule("");
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        btnCancelUserActionPerformed(evt);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void rdoframetime0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoframetime0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoframetime0ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        if (stdImp.find(searchStstistical.getText()) != null) {
            jPanel70.setVisible(true);
            Student std = stdImp.find(searchStstistical.getText());
            lblStatisticalIDSV.setText(std.getId());
            lblStatisticalNAMESV.setText(std.getName());
            lblStatisticalCLASS.setText(std.getClass_id());
            lblStatisticalAddress.setText(std.getAddress());
            
            StatisticalMark(searchStstistical.getText());
            
            List<Mark> list = systemManage.getMarkStudent(searchStstistical.getText());
            DefaultTableModel model = (DefaultTableModel) tblMark_Type1.getModel();
            model.setRowCount(0);
            for (Mark m : list) {
                model.addRow(new Object[]{
                    m.getMon(),m.getDiem(),m.getType_mark(),m.getLanthi(),m.getKetqua()
                });
            }
            tblMark_Type1.setModel(model);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Not Found!");
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void searchStstisticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStstisticalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchStstisticalActionPerformed

    private void btnStatisticalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisticalMouseClicked
        // TODO add your handling code here:
        pnlDashborad.setVisible(false);
            pnlStudent.setVisible(false);
            pnlTeacher.setVisible(false);
            pnlMark.setVisible(false);
            pnlClass.setVisible(false);
            pnlSubject.setVisible(false);
            pnlCourse.setVisible(false);
            pnlSearch.setVisible(false);
            pnlSetting.setVisible(false);
            pnlSeeMark.setVisible(false);
            pnlUsers.setVisible(false);
            pnlAttendances.setVisible(false);
            btnAtendances.setBackground(new Color(64,43,100));
            pnlStatistical.setVisible(true);
            
            btnStatistical.setBackground(new Color(85,55,118));
            btnDashboard.setBackground(new Color(64,43,100));
            btnStudent.setBackground(new Color(64,43,100));
            btnTeacher.setBackground(new Color(64,43,100));
            btnMark.setBackground(new Color(64,43,100));
            btnClass.setBackground(new Color(64,43,100));
            btnSubject.setBackground(new Color(64,43,100));
            btnCourse.setBackground(new Color(64,43,100));
            btnSearch.setBackground(new Color(64,43,100));
            btnSetting.setBackground(new Color(64,43,100));
            btnSeeMark.setBackground(new Color(64,43,100));
            btnUsers.setBackground(new Color(64,43,100));
    }//GEN-LAST:event_btnStatisticalMouseClicked

 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Seacher_TeacherClass;
    private javax.swing.JButton btnAddClass;
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnAddFaculty;
    private javax.swing.JButton btnAddStd;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JPanel btnAtendances;
    private javax.swing.JButton btnCancelClass;
    private javax.swing.JButton btnCancelCourse;
    private javax.swing.JButton btnCancelFaculty;
    private javax.swing.JButton btnCancelStd;
    private javax.swing.JButton btnCancelUser;
    private javax.swing.JPanel btnClass;
    private javax.swing.JPanel btnCourse;
    private javax.swing.JPanel btnDashboard;
    private javax.swing.JButton btnDelClass;
    private javax.swing.JButton btnDelFaculty;
    private javax.swing.JButton btnDelStd;
    private javax.swing.JButton btnDeleteCourse;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditClass;
    private javax.swing.JButton btnEditCourse;
    private javax.swing.JButton btnEditFaculty;
    private javax.swing.JButton btnEditStd;
    private javax.swing.JPanel btnMark;
    private javax.swing.JButton btnResetClass;
    private javax.swing.JButton btnResetCourse;
    private javax.swing.JButton btnResetFaculty;
    private javax.swing.JButton btnResetStd;
    private javax.swing.JButton btnResetUser;
    private javax.swing.JPanel btnSearch;
    private javax.swing.JButton btnSearchClass;
    private javax.swing.JButton btnSearchCourse;
    private javax.swing.JButton btnSearchFaculty;
    private javax.swing.JButton btnSearchStd;
    private javax.swing.JButton btnSearchUser;
    private javax.swing.JPanel btnSeeMark;
    private javax.swing.JPanel btnSetting;
    private javax.swing.JPanel btnStatistical;
    private javax.swing.JPanel btnStudent;
    private javax.swing.JPanel btnSubject;
    private javax.swing.JPanel btnTeacher;
    private javax.swing.JPanel btnUsers;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<Class> cbbClassSchedule;
    private javax.swing.JComboBox<Class> cbbClassStd;
    private javax.swing.JComboBox<Course> cbbCourseClass;
    private javax.swing.JComboBox<Faculty> cbbFacultyClass;
    private javax.swing.JComboBox<Faculty> cbbFacultySubject;
    private javax.swing.JComboBox<Subject> cbbSubjectMark;
    private javax.swing.JComboBox<Subject> cbbSubjectSchedule;
    private javax.swing.JComboBox<Subject> cbbTeacherSubject;
    private javax.swing.JComboBox<String> cbbUserRole;
    private javax.swing.JCheckBox cbxAll;
    private javax.swing.JCheckBox cbxClass;
    private javax.swing.JCheckBox cbxFaculty;
    private javax.swing.JCheckBox cbxSubject;
    private javax.swing.JComboBox<Faculty> comboFaculty_Sem;
    private javax.swing.JComboBox<Subject> comboSubject_Sem;
    private javax.swing.JComboBox<Mark_Type> comboType_Mark;
    private javax.swing.JComboBox<String> combo_Search;
    private javax.swing.JComboBox<Class> combo_TeacherClass;
    private javax.swing.JComboBox<Faculty> combokhoa_SeeMark;
    private javax.swing.JComboBox<Class> combolop_SeeMark;
    private javax.swing.JComboBox<Subject> combomon_SeeMark;
    private javax.swing.JComboBox<String> combonumber_Mark;
    private javax.swing.JPasswordField confirmPassEditUser;
    private javax.swing.JLabel countClass;
    private javax.swing.JLabel countCourse;
    private javax.swing.JLabel countStudent;
    private javax.swing.JLabel countSubject;
    private javax.swing.JLabel countTeacher;
    private javax.swing.JLabel countUser;
    private com.toedter.calendar.JDateChooser dateStd;
    private com.toedter.calendar.JDateChooser date_Teacher;
    private com.toedter.calendar.JDateChooser endDateCourse;
    private com.toedter.calendar.JDateChooser endDateSchedule;
    private javax.swing.JSpinner endTimeSchedule;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel148;
    private javax.swing.JPanel jPanel149;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel150;
    private javax.swing.JPanel jPanel152;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbeSearch;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private javax.swing.JLabel lblStatisticalAddress;
    private javax.swing.JLabel lblStatisticalCLASS;
    private javax.swing.JLabel lblStatisticalIDSV;
    private javax.swing.JLabel lblStatisticalNAMESV;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField passEditUser;
    private javax.swing.JPanel pnlAttendances;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlClass;
    private javax.swing.JPanel pnlClassSearch;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlCourse;
    private javax.swing.JPanel pnlDashborad;
    private javax.swing.JPanel pnlFacultySearch;
    private javax.swing.JPanel pnlMark;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlSeeMark;
    private javax.swing.JPanel pnlSetting;
    private javax.swing.JPanel pnlStatistical;
    private javax.swing.JPanel pnlStatisticalMark;
    private javax.swing.JPanel pnlStudent;
    private javax.swing.JPanel pnlStudentSearch;
    private javax.swing.JPanel pnlSubject;
    private javax.swing.JPanel pnlSubjectSearch;
    private javax.swing.JPanel pnlTeacher;
    private javax.swing.JPanel pnlTeacherSearch;
    private javax.swing.JPanel pnlUsers;
    private javax.swing.JRadioButton rdoFemaleStudent;
    private javax.swing.JRadioButton rdoFemaleTeacher;
    private javax.swing.JRadioButton rdoMaleStudent;
    private javax.swing.JRadioButton rdoMaleTeacher;
    private javax.swing.JRadioButton rdoframetime0;
    private javax.swing.JRadioButton rdoframetime1;
    private javax.swing.JTextField seacher_Sem;
    private javax.swing.JTextField seacher_Subject;
    private javax.swing.JTextField searchMark_Type;
    private javax.swing.JTextField searchStstistical;
    private javax.swing.JTextField search_Mark;
    private javax.swing.JTextField search_SeeMark;
    private javax.swing.JTextField search_Teacher;
    private javax.swing.JPanel sidePane;
    private com.toedter.calendar.JDateChooser startDateCourse;
    private com.toedter.calendar.JDateChooser startDateSchedule;
    private javax.swing.JSpinner startTimeSchedule;
    private javax.swing.JTable tblAttendance;
    private javax.swing.JTable tblClass;
    private javax.swing.JTable tblClass_Search;
    private javax.swing.JTable tblCourse;
    private javax.swing.JTable tblFaculty;
    private javax.swing.JTable tblFaculty_Search;
    private javax.swing.JTable tblMark_Type;
    private javax.swing.JTable tblMark_Type1;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTable tblStudent_Search;
    private javax.swing.JTable tblSubject_Search;
    private javax.swing.JTable tblTeacherClass;
    private javax.swing.JTable tblTeacherSubject;
    private javax.swing.JTable tblTeacher_Search;
    private javax.swing.JTable tblTodayAttendance;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTable tbl_Mark;
    private javax.swing.JTable tbl_SeeMark;
    private javax.swing.JTable tbl_Sem;
    private javax.swing.JTable tbl_Subject;
    private javax.swing.JTable tbl_Teacher;
    private javax.swing.JTextField timkem;
    private javax.swing.JPasswordField txtAddPassAdmin;
    private javax.swing.JTextField txtAddressStd;
    private javax.swing.JTextField txtCredits;
    private javax.swing.JTextField txtEmailStd;
    private javax.swing.JTextField txtIdAdmin;
    private javax.swing.JTextField txtIdClass;
    private javax.swing.JTextField txtIdCourse;
    private javax.swing.JTextField txtIdFaculty;
    private javax.swing.JTextField txtIdMark_Type;
    private javax.swing.JTextField txtIdSTD_Mark;
    private javax.swing.JTextField txtIdSchedule;
    private javax.swing.JTextField txtIdStd;
    private javax.swing.JTextField txtIdSubject;
    private javax.swing.JTextField txtIdTeacherSchedule;
    private javax.swing.JTextField txtIdTeacherSubject;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JTextField txtId_Teacher;
    private javax.swing.JTextField txtNameAdmin;
    private javax.swing.JTextField txtNameFaculty;
    private javax.swing.JTextField txtNameStd;
    private javax.swing.JTextField txtNameTeacher_Class;
    private javax.swing.JTextField txtNodeSchedule;
    private javax.swing.JTextField txtPhoneStd;
    private javax.swing.JTextField txtRoleAdmin;
    private javax.swing.JTextField txtSearchClass;
    private javax.swing.JTextField txtSearchCourse;
    private javax.swing.JTextField txtSearchFaculty;
    private javax.swing.JTextField txtSearchStd;
    private javax.swing.JTextField txtSearchTeacherSubject;
    private javax.swing.JTextField txtSearchUser;
    private javax.swing.JTextField txtSem;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtYearFaculty;
    private javax.swing.JTextField txtdiem_Mark;
    private javax.swing.JTextField txtemail_Teacher;
    private javax.swing.JTextField txtnameMark_Type;
    private javax.swing.JTextField txtnameSubject;
    private javax.swing.JTextField txtname_Teacher;
    private javax.swing.JTextField txtphone_Teacher;
    private javax.swing.JTextField txtsearchSchedule;
    private javax.swing.JTextField txtyear_Sem;
    // End of variables declaration//GEN-END:variables
}
