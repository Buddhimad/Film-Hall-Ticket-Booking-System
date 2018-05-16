package edu.ijse.ftb.dto;

public class ReservationDTO extends SuperDTO {

    private String rid, cid, sid, moid, rdate, rtime, Mdate, Mtime;
    private double seatQ;
    private int noAudults, noChild;
    private ReservationDTO reservationdto;

    public ReservationDTO() {
    }

    public ReservationDTO(String rid, String cid, String sid, String moid, String date, String time, String Mdate, String Mtime, double seatQ, int noAudults, int noChild) {
        this.rid = rid;
        this.cid = cid;
        this.sid = sid;
        this.moid = moid;
        this.seatQ = seatQ;
        this.rdate = date;
        this.rtime = time;
        this.Mdate = Mdate;
        this.Mtime = Mtime;
        this.noAudults = noAudults;
        this.noChild = noChild;
    }

    public int getNoAudults() {
        return noAudults;
    }

    public void setNoAudults(int noAudults) {
        this.noAudults = noAudults;
    }

    public int getNoChild() {
        return noChild;
    }

    public void setNoChild(int noChild) {
        this.noChild = noChild;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getDate() {
        return rdate;
    }

    public String getMdate() {
        return Mdate;
    }

    public void setMdate(String Mdate) {
        this.Mdate = Mdate;
    }

    public String getMtime() {
        return Mtime;
    }

    public void setMtime(String Mtime) {
        this.Mtime = Mtime;
    }

    public void setDate(String date) {
        this.rdate = date;
    }

    public String getTime() {
        return rtime;
    }

    public void setTime(String time) {
        this.rtime = time;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid;
    }

    public double getSeatQ() {
        return seatQ;
    }

    public void setSeatQ(double seatQ) {
        this.seatQ = seatQ;
    }

    public ReservationDTO getReservationdto() {
        return reservationdto;
    }

    public void setReservationdto(ReservationDTO reservationdto) {
        this.reservationdto = reservationdto;
    }

}
