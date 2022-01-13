package org.fate7.inbox.folders;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {

    public List<Folder> FetchDefaultFolders(String userId){
        return List.of(
                new Folder(userId, "Inbox", "red"),
                new Folder(userId, "Sent", "blue"),
                new Folder(userId, "Spam", "green")
        );
    }
}
