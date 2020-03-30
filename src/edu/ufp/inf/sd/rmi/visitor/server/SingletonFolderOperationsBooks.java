/**
 * <p>Title: Projecto SD</p>
 *
 * <p>Description: Projecto apoio aulas SD</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: UFP & INESC Porto</p>
 *
 * @author Rui Moreira
 * @version 1.0
 */
package edu.ufp.inf.sd.rmi.visitor.server;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonFolderOperationsBooks implements SingletonFoldersOperationsI {
    
    private static SingletonFolderOperationsBooks singletonFolderOperationsBooks;
    private final File folderBooks;

    /** private - Avoid direct instantiation */
    private SingletonFolderOperationsBooks(String folder) {
        folderBooks = new File(folder);
    }
    
    public synchronized static SingletonFolderOperationsBooks createSingletonFolderOperationsBooks(String folder){
        if (singletonFolderOperationsBooks==null){
            singletonFolderOperationsBooks = new SingletonFolderOperationsBooks(folder);
        }
        return singletonFolderOperationsBooks;
    }
    
    @Override
    public Boolean createFile(String fname) {
        try {
            File newFile = new File(this.folderBooks.getAbsolutePath() + "/" + fname);
            return newFile.createNewFile();
        } catch (IOException ex) {
            System.out.println("Exception made !!");
        }
        return false;
    }

    @Override
    public Boolean deleteFile(String fname) {
            File existingFile = new File(this.folderBooks.getAbsolutePath() + "/" + fname);
            return existingFile.delete();
    }

    
}

