package com.mycompany.myapplication.dto;

public class Photo {
    private int pno;
    private String pname;
    private int pphoto;
    private int pstar;
    private String pdesc;

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPphoto() {
        return pphoto;
    }

    public void setPphoto(int pphoto) { this.pphoto = pphoto;  }

    public int getPstar() {
        return pstar;
    }

    public void setPstar(int pstar) {
        this.pstar = pstar;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }
}
