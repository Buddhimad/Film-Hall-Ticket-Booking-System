package edu.ijse.ftb.dto;

import java.io.Serializable;

public class MovieDTO  extends SuperDTO{
  private  String moid,name,language,availableTime,startDate,endDate,videoQuality,duration;
  private MovieDTO moviedto;

    public MovieDTO() {
    }

    public MovieDTO(String moid, String name, String language, String availableTime, String startDate, String endDate, String videoQuality, String duration) {
        this.moid = moid;
        this.name = name;
        this.language = language;
        this.availableTime = availableTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.videoQuality = videoQuality;
        this.duration = duration;
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(String availableTime) {
        this.availableTime = availableTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getVideoQuality() {
        return videoQuality;
    }

    public void setVideoQuality(String videoQuality) {
        this.videoQuality = videoQuality;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public MovieDTO getMoviedto() {
        return moviedto;
    }

    public void setMoviedto(MovieDTO moviedto) {
        this.moviedto = moviedto;
    }
  
}
