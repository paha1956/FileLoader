package com.company;

import java.util.ArrayList;

public class FileLoader extends Thread {
    private int m_treadID;
    private LinksParser m_linksParser;

    public FileLoader(int treadID, LinksParser linksParser) {
        m_treadID = treadID;
        m_linksParser = linksParser;
    }

    @Override
    public void run()    //Этот метод будет выполнен в побочном потоке
    {
        LinkList loadLink = m_linksParser.getNextLink();
        if (loadLink != null) {
            System.out.println("Чтение ссылки " + loadLink.getLink() + " потоком " + m_treadID);
            System.out.println("Файлы сохранения ссылки:");
            ArrayList<String> filesList = loadLink.getFilesList();
            for (String fileName : filesList) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("Окончание загрузки");
        }
    }
}