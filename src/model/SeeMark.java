/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class SeeMark {
    private String idsv;
    private int idmon;
    private float diem;
    private int lanthi;
    private int type;
    private String ketqua;
    private String id_sv;
    private String mon;
    private String name;
    private String type_mark;
    private String lop;
    private String idFaculty;
    private String ten;

    public SeeMark() {
    }
    
    public SeeMark(String idsv, int idmon, float diem, int lanthi, int type, String ketqua) {
        this.idsv = idsv;
        this.idmon = idmon;
        this.diem = diem;
        this.lanthi = lanthi;
        this.type = type;
        this.ketqua = ketqua;
    }
    
    public SeeMark(String idsv,int idmon,int type, String idFaculty,String lop,String ten,String id_sv,String name, String mon,String type_mark,float diem, int lanthi, String ketqua) {
        this.idsv = idsv;
        this.idmon = idmon;
        this.type = type;
        this.idFaculty=idFaculty;
        this.lop=lop;
        this.ten=ten;
        this.id_sv = id_sv;
        this.name=name;
        this.mon = mon;
         this.type_mark = type_mark;
        this.diem = diem;
        this.lanthi = lanthi;
        this.ketqua = ketqua;
    }
   

    public String getIdsv() {
        return idsv;
    }

    public void setIdsv(String idsv) {
        this.idsv = idsv;
    }

    public int getIdmon() {
        return idmon;
    }

    public void setIdmon(int idmon) {
        this.idmon = idmon;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public int getLanthi() {
        return lanthi;
    }

    public void setLanthi(int lanthi) {
        this.lanthi = lanthi;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public String getId_sv() {
        return id_sv;
    }

    public void setId_sv(String id_sv) {
        this.id_sv = id_sv;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_mark() {
        return type_mark;
    }

    public void setType_mark(String type_mark) {
        this.type_mark = type_mark;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    
    
    
}
