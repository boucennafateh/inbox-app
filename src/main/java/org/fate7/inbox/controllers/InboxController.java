package org.fate7.inbox.controllers;

import lombok.RequiredArgsConstructor;
import org.fate7.inbox.folders.Folder;
import org.fate7.inbox.folders.FolderRepository;
import org.fate7.inbox.folders.FolderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class InboxController {

    private final FolderRepository folderRepository;
    private final FolderService folderService;

    @GetMapping("/")
    public String homePage(@AuthenticationPrincipal OAuth2User principal, Model model){
        if (principal == null || !StringUtils.hasText(principal.getAttribute("login")))
            return "index";
        String login = principal.getAttribute("login");
        List<Folder> folders = folderRepository.findAllById(login);
        model.addAttribute("userFolders", folders);

        List<Folder> defaultFolders = folderService.FetchDefaultFolders(login);
        model.addAttribute("defaultFolders", defaultFolders);
        return "inbox-page";
    }

}
