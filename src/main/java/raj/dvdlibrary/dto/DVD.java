/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raj.dvdlibrary.dto;

import java.time.LocalDate;

/**
 *
 * @author romeroalicia
 */
public class DVD {
    private String title; // Title is read-only field
    private LocalDate releaseDate;
    private int MPAARating;
    private String directorName;
    private String studio;
    private String userRating;
    
    public DVD() {
    }
    
    public DVD(String title) {
        this.title = title;
    }

    public DVD(String title, LocalDate releaseDate, int MPAARating, String directorName, String studio, String userRating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.MPAARating = MPAARating;
        this.directorName = directorName;
        this.studio = studio;
        this.userRating = userRating;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getMPAARating() {
        return MPAARating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getStudio() {
        return studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMPAARating(int MPAARating) {
        this.MPAARating = MPAARating;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return "DVD{" + "title=" + title + ", releaseDate=" + releaseDate + ", MPAARating=" + MPAARating + ", directorName=" + directorName + ", studio=" + studio + ", userRating=" + userRating + '}';
    }
    
    
    
    
}
