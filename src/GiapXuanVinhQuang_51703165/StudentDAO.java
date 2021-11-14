package GiapXuanVinhQuang_51703165;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Saito8546
 */
public class StudentDAO {
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    public StudentDAO(Connection con) {
        this.con = con;
    }
    
    public void add(Student s) throws SQLException {
        final PreparedStatement stm
                = con.prepareStatement("INSERT INTO Sinhvien VALUES(?, ?, ?)");
        stm.setString(1, s.getId());
        stm.setNString(2, s.getName());
        stm.setInt(3, s.getBirthYear());
        stm.executeUpdate();
        stm.close();
    }
    
    public void delete(String id) throws SQLException {
        final PreparedStatement stm
                = con.prepareStatement("DELETE FROM Sinhvien "
                        + "where MaSV = ?");
        stm.setString(1, id);
        stm.executeUpdate();
        stm.close();
    }
    
    
    // BROKEN //
    public void update(Student s) throws SQLException {
        
        final PreparedStatement stm
                = con.prepareStatement(
                        "UPDATE Sinhvien \n"
                        + "SET Hoten = '" + s.getName() + "', Namsinh = " + s.getBirthYear() + " \n"
                        + "WHERE MaSV = '" + s.getId() + "'");
        stm.executeUpdate();
        stm.close();
    }
    
    public List<Student> getAll() throws SQLException {
        List<Student> ls = new ArrayList<Student>();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT MaSV, Hoten, Namsinh FROM Sinhvien");
        while (rs.next()) {
            Student st = new Student(rs.getString(1), rs.getNString(2), rs.getInt(3));
            ls.add(st);
        }
        rs.close();
        stmt.close();
        return ls;
    }
    
    public Student get(String id) throws SQLException {        
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT MaSV, Hoten, Namsinh FROM Sinhvien WHERE MaSV = '" + id +"'");
        if (rs.next() == false){
            return null;
        }        
        Student st = new Student(rs.getString(1), rs.getNString(2), rs.getInt(3));
        rs.close();
        stmt.close();
        return st;
    }
}
