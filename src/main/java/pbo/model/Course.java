package pbo.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;

// 12S23004 - Poppy Sibuea
// 12S23026 - Arif Doloksaribu

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "kode", nullable = false, length = 10)
    private String kode;
    @Column(name = "nama", nullable = false, length = 50)
    private String nama;
    @Column(name = "semester", nullable = false, length = 4)
    private String semester;
    @Column(name = "kredit", nullable = false)
    private int kredit;

    //atribut baru untuk relasi m to m
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Student> students;

    public Course (){
        //emtpy
    }

    public Course(String kode, String nama, String semester, int kredit) {
        this.kode = kode;
        this.nama = nama;
        this.semester = semester;
        this.kredit = kredit;
    }

    public Course(String kode, String nama, String semester, int kredit, List<Student> students) {
        this.kode = kode;
        this.nama = nama;
        this.semester = semester;
        this.kredit = kredit;
        this.students = students;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getKredit() {
        return kredit;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }    

    @Override
    public String toString() {
        return kode + "|" + nama + "|" + semester + "|" + kredit ;
    }
    
}