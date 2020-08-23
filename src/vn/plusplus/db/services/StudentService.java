package vn.plusplus.db.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentService {

    private Connection con;

    public StudentService(Connection con) {
        this.con = con;
    }

    public void getAllStudentFromDB(){
        String query = "SELECT * FROM student WHERE age > 19 ORDER BY `name` DESC";

        try {
            Statement statement = con.createStatement();
            ResultSet data = statement.executeQuery(query);

            while(data.next()){
                String name = data.getString(2);
                String mssv = data.getString(3);
                System.out.println("Sinh viên có tên là: " + name +", MSSV: " +mssv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findStudentByMSSV(String mssvInput){
        String query = "SELECT `name` as `Tên`, mssv as `Ma So SV`, age as `Tuổi` FROM student WHERE mssv='" + mssvInput + "'";

        try {
            Statement statement = con.createStatement();
            ResultSet data = statement.executeQuery(query);

            while(data.next()){
                String name = data.getString("name");
                String mssv = data.getString("mssv");
                int age = data.getInt("age");

                System.out.println("Sinh viên có tên là: " + name +", MSSV: " +mssv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDemo(){
        String query ="INSERT INTO student_class(student_id, class_id) VALUES(5, 4)";

        try {
            Statement statement = con.createStatement();
            Boolean result = statement.execute(query);
            if(result == true){
                System.out.println("Insert thanh cong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
