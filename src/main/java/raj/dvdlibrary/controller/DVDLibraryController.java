/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raj.dvdlibrary.controller;

import java.util.List;
import raj.dvdlibrary.dao.DVDLibraryDao;
import raj.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import raj.dvdlibrary.dao.DVDLibraryException;
import raj.dvdlibrary.dto.DVD;
import raj.dvdlibrary.ui.DVDLibraryView;

/**
 *
 * @author romeroalicia
 */
public class DVDLibraryController {
    private DVDLibraryView view;
    private DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryView view, DVDLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }
    
    public void run() throws DVDLibraryException {
        readFile();
        boolean exit = false;
        int menuSelection = 0;
        
        while (!exit) {
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    addDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    displayDVD();
                    break;
                case 6:
                    findDVD();
                    break;
                case 7:
                    listReleasedDVDs();
                    break;
                case 8:
                    exit = true;
                    break;
            }
        }
        writeFile();
        exitMessage();
        
    }
    
    private void readFile() throws DVDLibraryException {
        dao.readFile();
    }
    
    public void writeFile() throws DVDLibraryException {
        dao.writeFile();
    }
    
    private int getMenuSelection() {
        return view.printMenuGetUsersSelection();
    }
    
    private void exitMessage() {
        view.displayExitMessage();
    }
    
    private void addDVD() {
        view.displayAddDVDBanner();
        DVD currentDVD = view.collectInformationOfDVD();
        dao.add(currentDVD.getTitle(), currentDVD);
        view.displayAddedDVDBanner();
    }
    
    private void removeDVD() {
        view.displayRemoveDVDBanner();
        String titleToBeRemoved = view.getDVDTitleFromUser();
        DVD removedDVD = dao.remove(titleToBeRemoved);
        if (removedDVD != null) {
            view.displayRemovedDVDBanner();
        } else {
            view.displayDVDNotFound();
            view.displayContinueBanner();
        }
    }
    
    private void editDVD() {
        view.displayEditDVDBanner();
        String title = view.getDVDTitleFromUser();
        Boolean isDVDFound = dao.findDVD(title);
        
        if (isDVDFound) {
            DVD currentDVD = view.collectNewInformationOfDVD(title);
            DVD editedDVD = dao.edit(title, currentDVD);
            view.displayEditedDVDBanner();
        } else {
            view.displayDVDNotFound();
            view.displayContinueBanner();
        }
    }
    
    private void listDVDs() {
        view.displayListDVDBanner(dao.listAll());
        view.displayContinueBanner();
    }
    
    private void displayDVD() {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitleFromUser();
        Boolean isDVDFound = dao.findDVD(title);
        
        if (isDVDFound) {
            DVD currentDVD = dao.displayInfo(title);
            view.displayDisplayDVDInformationBanner(currentDVD);
        } else {
            view.displayDVDNotFound();
        }
        view.displayContinueBanner();
    }
    
    private void findDVD() {
        view.displayFindDVDBanner();
        String title = view.getDVDTitleFromUser();
        Boolean isDVDFound = dao.findDVD(title);
        
        if (isDVDFound) {
            view.displayFoundDVDBanner();
        } else {
            view.displayDVDNotFound();
            view.displayContinueBanner();
        } 
    }
    
    private void listReleasedDVDs() {
        view.displayReleasedBanner();
        int lastNYears = view.getYearBanner();
        view.displayDVDsReleasedBanner(dao.findAllMoviesReleased(lastNYears));
        view.displayContinueBanner();
    }
    
    
}
