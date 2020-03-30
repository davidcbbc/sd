package edu.ufp.inf.sd.rmi.visitor.server;

import java.io.Serializable;

public class VisitorFoldersOperationCreateFile implements VisitorFoldersOperationsI, Serializable {
    public String fileToCreate;
    public String fileToCreateWithPrefix;
    public VisitorFoldersOperationCreateFile(String newFolder){ this.fileToCreate = newFolder;}

    @Override
    public Object visitConcreteElementStateBooks(ElementFolderRI element) {
        SingletonFolderOperationsBooks s = ((ConcreteElementFolderBooksImpl)element).getStateBooksFolder();
        fileToCreateWithPrefix = "VisitorBook_"+fileToCreate;
        System.out.println("VisitorStateFolderOperationDeleteFile - visitCOncreteElementStateBooks() : going to create file");
        return s.createFile(fileToCreateWithPrefix);
    }

    public String getFileToCreate(){
        return this.fileToCreate;
    }

    public void setFileToCreate(String fileToCreate){
        this.fileToCreate = fileToCreate;
    }

}
