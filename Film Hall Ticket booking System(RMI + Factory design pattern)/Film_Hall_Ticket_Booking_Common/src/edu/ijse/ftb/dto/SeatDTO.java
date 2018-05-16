package edu.ijse.ftb.dto;

import java.io.Serializable;

public class SeatDTO extends SuperDTO{
    private String sid,section;
    private SeatDTO seatdto;

    public SeatDTO() {
    }

    public SeatDTO(String sid, String section) {
        this.sid = sid;
        this.section = section;
        
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public SeatDTO getSeatdto() {
        return seatdto;
    }

    public void setSeatdto(SeatDTO seatdto) {
        this.seatdto = seatdto;
    }
    
    
}
