package edu.ufp.inf.sd.rmi.visitor.server;

import java.io.Serializable;

public class VisitorFoldersOperationDeleteFile implements VisitorFoldersOperationsI, Serializable {

    private String fileToDelete;
    private String fileToDeleteWithPrefix;
    public VisitorFoldersOperationDeleteFile(String newFolder) {this.fileToDelete = newFolder;}
    @Override
    public Object visitConcreteElementStateBooks(ElementFolderRI element) {
        SingletonFolderOperationsBooks s = ((ConcreteElementFolderBooksImpl)element).getStateBooksFolder();
        fileToDeleteWithPrefix = "VisitorBook_"+fileToDelete;
        System.out.println("VisitorStateFolderOperationDeleteFile - visitCOncreteElementStateBooks() : going to delete");
        return s.deleteFile(fileToDeleteWithPrefix);
    }

    public String getFileToDelete(){return this.fileToDelete;}

    public void setFileToDelete(String fileToDelete){this.fileToDelete = fileToDelete;}

}
