/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raj.dvdlibrary.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import raj.dvdlibrary.dto.DVD;

/**
 *
 * @author romeroalicia
 */
public class DVDLibraryDaoFileImpl extends DVDLibraryDao {
    private final File DVD_FILE = new File("dvd.txt");
    private final String SEPARATOR = ",";
    private Map<String, DVD> DVDCollection = new HashMap<>();

    @Override
    public DVD add(String title, DVD dvd) {
        DVD newDVD = this.DVDCollection.put(title, dvd);
        return newDVD;
    }

    @Override
    public DVD remove(String title) {
        DVD removedDVD = this.DVDCollection.remove(title);
        return removedDVD;
    }

    @Override
    public DVD edit(String title, DVD dvd) {
        DVD editedDVD = this.DVDCollection.put(title, dvd);
        return editedDVD;
    }

    @Override
    public List<DVD> listAll() {
        return new ArrayList(this.DVDCollection.values());
    }

    @Override
    public DVD displayInfo(String title) {
        DVD choosenDVD = this.DVDCollection.get(title);
        return choosenDVD;
    }
    
    @Override
    public Boolean findDVD(String title) {
        Boolean isDVDFound = this.DVDCollection.containsKey(title);
        return isDVDFound;
    }
    
    
    // File methods
    @Override
    public void readFile() throws DVDLibraryException {
        
        FileReader file = null;
        String[] tempArr = new String[6];
        DVD tempDVD = null;
        
        try {
            file = new FileReader(DVD_FILE);
            BufferedReader lines = new BufferedReader(file);
            
            String currentLine = lines.readLine();
            while (currentLine != null) {
                tempArr = currentLine.split(SEPARATOR);
                
                String title = tempArr[0].trim();
                String releaseDateString = tempArr[1].trim();
                LocalDate releaseDate = LocalDate.parse(releaseDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int MPAARating = Integer.parseInt(tempArr[2].trim());
                String directorName = tempArr[3].trim();
                String studio = tempArr[4].trim();
                String userRating = tempArr[5].trim();
                
                tempDVD = new DVD(title, releaseDate, MPAARating, directorName, studio, userRating);
                this.DVDCollection.put(tempDVD.getTitle(), tempDVD);
                currentLine = lines.readLine();
            }
            file.close();
            
        } catch (FileNotFoundException ex) {
            throw new DVDLibraryException("Could not load DVD data", ex);
        } catch (IOException ex) {
            throw new DVDLibraryException("Could not load DVD data", ex);
        }
    }
    
    @Override
    public void writeFile() throws DVDLibraryException {
        FileWriter file = null;

        try {
            file = new FileWriter(DVD_FILE);
            PrintWriter out = new PrintWriter(file);
         
            Collection<DVD> dvds = this.DVDCollection.values();
            for(DVD dvd : dvds) {
                out.println(dvd.getTitle() + SEPARATOR
                        + dvd.getReleaseDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + SEPARATOR 
                        + dvd.getMPAARating() + SEPARATOR
                        + dvd.getDirectorName() + SEPARATOR
                        + dvd.getStudio() + SEPARATOR
                        + dvd.getUserRating());
                 out.flush();
            }
           
            out.close();
            
        } catch (IOException ex) {
            throw new DVDLibraryException("Could not load DVD data", ex);
        }
        
    }
    
    @Override
    public List<DVD> findAllMoviesReleased(int lastNYears) {
        LocalDate dateToCompare = LocalDate.now().minusYears(lastNYears);
        List<DVD> dvds = new ArrayList(this.DVDCollection.values());
        List<DVD> dvdsReleased = dvds.stream()
                .filter((dvd) -> dvd.getReleaseDate().compareTo(dateToCompare) > 0)
                .collect(Collectors.toList());
        return dvdsReleased;
    }
    
}
