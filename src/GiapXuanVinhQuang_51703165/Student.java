/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GiapXuanVinhQuang_51703165;

/**
 *
 * @author Saito8546
 */
public class Student {
    private String Id;
    private String Name;
    private int BirthYear;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getBirthYear() {
        return BirthYear;
    }

    public void setBirthYear(int BirthYear) {
        this.BirthYear = BirthYear;
    }

    public Student(String Id, String Name, int BirthYear) {
        this.Id = Id;
        this.Name = Name;
        this.BirthYear = BirthYear;
    }
}
