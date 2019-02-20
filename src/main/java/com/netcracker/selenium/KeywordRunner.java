package com.netcracker.selenium;

import java.io.BufferedReader;
import java.io.FileReader;

public class KeywordRunner {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            KeywordService keywordService = new KeywordService();
            String newLine = br.readLine();
            while ((newLine = br.readLine()) != null) {
                System.out.println("Step start:"+newLine);
                String[] commandLine = newLine.split(",");
                String command = commandLine[0];
                switch (command.toUpperCase()) {
                    case Keywords.OPEN_BROWSER:
                        String browserName = commandLine[1];
                        keywordService.openBrowser(browserName);
                        break;
                    case Keywords.OPEN_URL:
                        keywordService.openUrl(commandLine[3]);
                        break;
                    case Keywords.SET_VALUE:
                        keywordService.setValue(commandLine[1],commandLine[2],commandLine[3]);
                        break;
                    case Keywords.CLICK_ELEMENT:
                        keywordService.clickOnLocator(commandLine[1],commandLine[2]);
                        break;
                    case Keywords.SNAPSHOT:
                        keywordService.takeSnapShot(commandLine[4]);
                        break;
                    case Keywords.VERIFY_ELEMENT:
                        boolean successVerifyElement = keywordService.checkElementVisible(commandLine[1],commandLine[2]);
                        if(!successVerifyElement){
                            throw new Exception("Verify element failed for["+command+"]");
                        }
                        break;
                    case Keywords.CLOSE_BROWSER:
                        keywordService.closeBrowser();
                        break;
                    case Keywords.VERIFY_VALUE:
                        boolean successVerifyValue = keywordService.checkSetValue(commandLine[1],commandLine[2],commandLine[3],commandLine[4]);
                        if(!successVerifyValue){
                            throw new Exception("Verify value failed for["+command+"]");
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }


    }
}
