/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raj.dvdlibrary;

import raj.dvdlibrary.controller.DVDLibraryController;
import raj.dvdlibrary.dao.DVDLibraryDao;
import raj.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import raj.dvdlibrary.dao.DVDLibraryException;
import raj.dvdlibrary.ui.DVDLibraryView;
import raj.dvdlibrary.ui.UserIO;
import raj.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author romeroalicia
 */
public class App {
    public static void main(String[] args) throws DVDLibraryException {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(view, dao);
        controller.run();
    }
}
