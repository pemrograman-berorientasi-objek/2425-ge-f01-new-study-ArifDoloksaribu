package pbo.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.List;

// 12S23004 - Poppy Sibuea
// 12S23026 - Arif Dololsaribu

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String nim;
    @Column(name = "nama", nullable = false, length = 50)
    private String nama;
    @Column(name = "prodi", nullable = false, length = 30)
    private String prodi;


    //atribut baru untuk relasi m to m
    @ManyToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    @JoinTable(name = "ENROLLMENT", joinColumns = @JoinColumn(name = "nim_mhs", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "matakuliah", referencedColumnName = "kode"))
    private List<Course> courses;


    public Student() {
        //emtpy
    }

    public Student(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    public Student(String nim, String nama, String prodi, List<Course> courses) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.courses = courses;
    }


    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getProdi() {
        return prodi;
    }
    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }   

    @Override
    public String toString() {
        return nim + "|" + nama + "|" + prodi;
    }

}
