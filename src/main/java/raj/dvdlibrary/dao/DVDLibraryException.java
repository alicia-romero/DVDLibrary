/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raj.dvdlibrary.dao;

/**
 *
 * @author romeroalicia
 */
public class DVDLibraryException extends Exception {
    // catches unchecked exceptions with an error message
    public DVDLibraryException(String message) {
        super(message);
    }
    
    // checked exceptions get wrapped into an applicaion specific exception message
    public DVDLibraryException(String message, Throwable cause) {
        super(message, cause);
    }
}
