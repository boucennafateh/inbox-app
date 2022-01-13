package org.fate7.inbox;

import org.fate7.inbox.folders.Folder;
import org.fate7.inbox.folders.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.nio.file.Path;

@SpringBootApplication
public class InboxApp {

	@Autowired
	FolderRepository folderRepository;

	public static void main(String[] args) {
		SpringApplication.run(InboxApp.class, args);
	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties){
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}

	 @PostConstruct
	private void init(){
		folderRepository.save(new Folder("boucennafateh", "inbox", "yellow"));
		 folderRepository.save(new Folder("boucennafateh", "sent", "blue"));
		 folderRepository.save(new Folder("boucennafateh", "important", "green"));
	 }
	

}
