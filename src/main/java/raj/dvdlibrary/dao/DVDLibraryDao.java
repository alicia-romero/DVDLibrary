/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raj.dvdlibrary.dao;

import java.util.List;
import raj.dvdlibrary.dto.DVD;

/**
 *
 * @author romeroalicia
 */
public abstract class DVDLibraryDao {
    public abstract DVD add(String title, DVD dvd);
    
    public abstract DVD remove(String title);
    
    public abstract DVD edit(String title, DVD dvd);
    
    public abstract List<DVD> listAll();
    
    public abstract DVD displayInfo(String title); 
    
    public abstract Boolean findDVD(String title);
    
    public abstract void readFile() throws DVDLibraryException;
    
    public abstract void writeFile() throws DVDLibraryException;
    
    // Find all movies released in the last N years
    public abstract List<DVD> findAllMoviesReleased(int lastNYears);
}
