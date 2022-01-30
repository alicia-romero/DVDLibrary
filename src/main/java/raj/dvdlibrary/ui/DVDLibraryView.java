/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raj.dvdlibrary.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import raj.dvdlibrary.dto.DVD;

/**
 *
 * @author romeroalicia
 */
public class DVDLibraryView {
    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuGetUsersSelection() {
        io.print("*** Main Menu of DVD Library ***");
        io.print("1. Add DVD to collection");
        io.print("2. Remove DVD from collection");
        io.print("3. Edit information of DVD in collection");
        io.print("4. List all DVDs in collection");
        io.print("5. Display information of DVD in collection");
        io.print("6. Search for DVD by title");
        io.print("7. Find all movies released in the last N years");
        io.print("8. Exit");
        
        return io.readInt("Please select an option from the Menu.", 1, 8);
    }
    
    public void displayExitMessage() {
        io.print("See you next time :)");
    }
    
    // Methods for adding DVD
    public void displayAddDVDBanner() {
        io.print("** Add DVD **");
    }
    
    public DVD collectInformationOfDVD() {
        String title = io.readString("Please enter the title of DVD.");
        String releaseDateString = io.readString("Please enter the release date of DVD (DD/MM/YYYY)");
        LocalDate releaseDate = LocalDate.parse(releaseDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int MPAARating = io.readInt("Please enter the MPAA Rating of DVD (age)");
        String directorName = io.readString("Please enter the director's name");
        String studio = io.readString("Please enter the studio");
        String userRating = io.readString("Please give a rating of the DVD");
        
        DVD currentDVD = new DVD(title, releaseDate, MPAARating, directorName, studio, userRating);
        return currentDVD;
    }
    
    public String displayAddedDVDBanner() {
        io.print("\n^^ Your DVD has been added. ^^");
        return io.readString("Please hit enter to continue.");
    }
    
    // Methods for removing DVD
    public void displayRemoveDVDBanner() {
        io.print("** Remove DVD **");
    }
    
    public String displayRemovedDVDBanner() {
        io.print("\n^^ DVD has been removed. ^^");
        return io.readString("Please hit enter to continue.");
    }
    
    // Methods for editing DVD
    public void displayEditDVDBanner() {
        io.print("** Edit DVD **");
    }
    
    public DVD collectNewInformationOfDVD(String titleOfDVD) {
        String releaseDateString = io.readString("Please enter the release date of DVD (DD/MM/YYYY)");
        LocalDate releaseDate = LocalDate.parse(releaseDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int MPAARating = io.readInt("Please enter new MPAA Rating of DVD (age)");
        String directorName = io.readString("Please enter new director's name");
        String studio = io.readString("Please enter new studio");
        String userRating = io.readString("Please give a rating of the DVD");
        
        DVD currentDVD = new DVD(titleOfDVD, releaseDate, MPAARating, directorName, studio, userRating);
        return currentDVD;
    }
    
    public String displayEditedDVDBanner() {
        io.print("\n^^ DVD has been edited. ^^");
        return io.readString("Please hit enter to continue.");
    }
    
    
    // Methods for listing DVDs
    public void displayListDVDBanner(List<DVD> dvds) {
        io.print("** List all DVDs **");
        for (DVD dvd : dvds) {
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("MPAA Rating: " + dvd.getMPAARating());
            io.print("Director name: " + dvd.getDirectorName());
            io.print("Studio: " + dvd.getStudio());
            io.print("User Rating: " + dvd.getUserRating());  
            io.print("");
        } 
    }
    
    // Methods for displaying DVDs Information
    public void displayDisplayDVDBanner() {
        io.print("** Display DVDs Information **");
    }
    
    public void displayDisplayDVDInformationBanner(DVD dvd) {
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("MPAA Rating: " + dvd.getMPAARating());
            io.print("Director name: " + dvd.getDirectorName());
            io.print("Studio: " + dvd.getStudio());
            io.print("User Rating: " + dvd.getUserRating());  
            io.print(""); 
    }
    
    // Methods for removing DVD
    public void displayFindDVDBanner() {
        io.print("** Find DVD **");
    }
    
    public String displayFoundDVDBanner() {
        io.print("\n^^ DVD has been found. ^^");
        return io.readString("Please hit enter to continue.");
    }
    
      
    // Methods for listing DVDs released before N years
    public void displayReleasedBanner() {
        io.print("** All DVDs Released Before N years **");
    }
    
    public void displayDVDsReleasedBanner(List<DVD> dvds) {
        for (DVD dvd : dvds) {
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
        } 
    }
    
    // Helper method
    public String displayContinueBanner() {
        return io.readString("Please hit enter to continue.");
    }
    
    
    public String getDVDTitleFromUser() {
        return io.readString("Please enter the title of DVD.");
    }
    
    public void displayDVDNotFound() {
        io.print("Sorry, there is no such a DVD in the Library. -_-");
    }
    
     public int getYearBanner() {
        return io.readInt("Please enter the number of years you want the DVDs to date back");
    }

}
