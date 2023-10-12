/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-08-21
 * Created Time: 11:28 a.m.
 */

package bns.a6.microui.api.utility.worddocument;

import bns.a6.microui.web.cucumber.ScenarioContext;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class ReportToWord {

    static File file;
    static XWPFDocument document;

    public ReportToWord() {
        //
    }

    public static String getTimeStamp() {
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        String newTime = time.toString().replace(" ", "_");
        return newTime;
    }

    public FileOutputStream createWordDocument() {
        String projectName = System.getProperty("user.dir");
        String fileName;
        try {
            List<FileOutputStream> list = new ArrayList<>();
            fileName = projectName + "\\test-results\\" +   /*ScenarioDetails.getScenarioName()*/"" + "_" + ScenarioContext.getInstance().getScenarioId() + "_" + getTimeStamp().substring(0, 19).replaceAll(":", "");
            file = new File(fileName + ".docx");
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            new File(projectName + "\\test-results").mkdirs();
            return createWordDocument();
        }
    }

    public void writeInToDocument(ArrayList<String> resultData) {
        document = getXWPFDocument();
        XWPFParagraph paragraph = getXWPFParagraph(document);
        XWPFRun run = getXWPFRun(paragraph);
        Iterator<String> it = resultData.iterator();
        while (it.hasNext()) {
            setText(run, it.next());
            nextLine(run);
        }
    }

    public void writeInToDocument(String payload, String columnType) {

        if (document == null) {
            document = getXWPFDocument();
        }
        List<XWPFTable> tables = getTables();
        XWPFTable table = getTable(tables.size() - 1);
        XWPFTableRow row = null;
        XWPFTableCell cell = null;
        XWPFRun run = null;
        switch (columnType) {
            case "Request":
            case "URL":
                row = getRow(table, 0);
                cell = getCell(row, 0);
                run = cell.addParagraph().createRun();
                run.setBold(true);
                setText(run, columnType + " : ");
                row = getRow(table, 1);
                cell = getCell(row, 0);
                run = cell.addParagraph().createRun();

                char[] s = payload.toCharArray();
                int counter = 0;
                for (char x : s) {
                    setText(run, String.valueOf(x));
                    if (x == ',' || x == '{' || x == ']') {
                        nextLine(run);
                    }
                    counter++;
                }
                break;
            case "Response":
                row = getRow(table, 0);
                cell = getCell(row, 1);
                run = cell.addParagraph().createRun();
                run.setBold(true);
                setText(run, "Response:");
                row = getRow(table, 1);
                cell = getCell(row, 1);
                run = cell.addParagraph().createRun();

                char[] a = payload.toCharArray();
                int counter1 = 0;
                for (char x : a) {
                    setText(run, String.valueOf(x));
                    if (x == ',' || x == '{' || x == '\n' || x == ']') {
                        nextLine(run);
                    }
                    if (x == '>') {
                        try {
                            if (a[counter1 + 1] == '<') {
                                nextLine(run);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }

                    }
                    counter1++;
                }
        }
    }

    // Function to write large data(Response) into word document
    // Pre condition : For json send payload as karate.pretty(request/response)
    //               : For XML send payload as karate.prettyXml(request/response)
    // ex:
    //    * def requestU = karate.pretty(requestFile_AcctTxnHistory)
    //    * xmlstring responseU = karate.prettyXml(responseAcctTxnHistory)
    //    * def writeRequest = createDocument.writeInToDocumentV2(requestU,'Request');
    //    * def writeResponse = createDocument.writeInToDocumentV2(responseU,'Response');
    // This function splits the payload with \n and stores the lines in array and then prints line by line

    public void writeInToDocumentV2(String payload, String columnType) {

        if (document == null) {
            document = getXWPFDocument();
        }
        List<XWPFTable> tables = getTables();
        XWPFTable table = getTable(tables.size() - 1);
        XWPFTableRow row = null;
        XWPFTableCell cell = null;
        XWPFRun run = null;
        switch (columnType) {
            case "Request":
            case "URL":
                row = getRow(table, 0);
                cell = getCell(row, 0);
                run = cell.addParagraph().createRun();
                run.setBold(true);
                setText(run, columnType + " : ");
                row = getRow(table, 1);
                cell = getCell(row, 0);
                run = cell.addParagraph().createRun();

                String[] reqArrOfStr = payload.split("\n");

                for (int i = 0; i < reqArrOfStr.length; i++) {
                    setText(run, String.valueOf(reqArrOfStr[i]));
                    nextLine(run);
                }

                break;
            case "Response":
                row = getRow(table, 0);
                cell = getCell(row, 1);
                run = cell.addParagraph().createRun();
                run.setBold(true);
                setText(run, "Response:");
                row = getRow(table, 1);
                cell = getCell(row, 1);
                run = cell.addParagraph().createRun();

                String[] resArrOfStr = payload.split("\n");

                for (int i = 0; i < resArrOfStr.length; i++) {
                    setText(run, String.valueOf(resArrOfStr[i]));
                    nextLine(run);
                }
        }
    }

    // ------------------------------------END oF writeInToDocumentV2 ------------------------------------------------
    public void writeInToDocumentV3(String payload, String columnType) {

        if (document == null) {
            document = getXWPFDocument();
        }
        List<XWPFTable> tables = getTables();
        XWPFTable table = getTable(tables.size() - 1);
        XWPFTableRow row = null;
        XWPFTableCell cell = null;
        XWPFRun run = null;
        switch (columnType) {
            case "Request":
            case "URL":
                row = getRow(table, 0);
                cell = getCell(row, 0);
                run = cell.addParagraph().createRun();
                run.setBold(true);
                setText(run, columnType + " : ");
                row = getRow(table, 1);
                cell = getCell(row, 0);
                run = cell.addParagraph().createRun();
                setText(run, String.valueOf(payload));
                nextLine(run);
                break;
            case "Response":
                row = getRow(table, 0);
                cell = getCell(row, 1);
                run = cell.addParagraph().createRun();
                run.setBold(true);
                setText(run, "Response:");
                row = getRow(table, 1);
                cell = getCell(row, 1);
                run = cell.addParagraph().createRun();
                setText(run, String.valueOf(payload));
                nextLine(run);

        }
    }

    // function to write the passed or failed result into word document
    // Input: resultDataArray is Passed Result array or Failed Result array
    //        resultTypeText is "Passed Result" or "Failed Result"
    public void writeResultIntoWordDocument(ArrayList<String> resultDataArray, String resultTypeText) {

        String noResultText;

        if (document == null) {
            document = getXWPFDocument();
        }
        XWPFParagraph paragraph = getXWPFParagraph(ReportToWord.document);
        XWPFRun runText = getXWPFRun(paragraph);
        runText.addBreak();
        runText.setBold(true);
        runText.setText(resultTypeText);
        runText.setUnderline(UnderlinePatterns.SINGLE);
        if (resultTypeText.toLowerCase().contains("pass")) {
            runText.setColor("008000"); // Green color
            noResultText = "No Passed Result";
        } else {
            runText.setColor("FF0000"); // Red color
            noResultText = "No Failed Result";
        }
        XWPFRun runResult = getXWPFRun(paragraph);
        runResult.addBreak();
        runResult.setBold(false);
        if (resultDataArray.size() > 0) {  // If there is result, print the result, otherwise print No Passed/Failed Result text
            Iterator<String> it = resultDataArray.iterator();
            while (it.hasNext()) {
                setText(runResult, it.next());
                nextLine(runResult);
            }
        } else {
            runResult.setText(noResultText);
        }
    }

    public void writeText(String text) {
        if (document == null) {
            document = getXWPFDocument();
        }

        XWPFParagraph paragraph = getXWPFParagraph(ReportToWord.document);
        XWPFRun run = getXWPFRun(paragraph);
        run.addBreak();
        run.setBold(true);
        run.setText(text);

    }

    public void writeData() throws IOException {
        FileOutputStream fos = createWordDocument();
        document.write(fos);
        fos.close();
        fos = null;
        document.close();
        document = null;
        file = null;

    }

    private XWPFDocument getXWPFDocument() {
        return new XWPFDocument();
    }

    private XWPFParagraph getXWPFParagraph(XWPFDocument document) {
        return document.createParagraph();

    }

    private XWPFRun getXWPFRun(XWPFParagraph paragraph) {
        return paragraph.createRun();
    }

    private void setText(XWPFRun run, String data) {
        run.setText(data);

    }

    private void nextLine(XWPFRun run) {
        run.addBreak();
    }

    public void createTable(int rowNumber, int columnNumber) {
        if (document == null) {
            document = getXWPFDocument();
        }
        document.createTable(rowNumber, columnNumber);

    }

    private List<XWPFTable> getTables() {
        return document.getTables();
    }

    private XWPFTable getTable(int tableIndex) {
        return document.getTables().get(tableIndex);
    }

    private XWPFTableRow getRow(XWPFTable table, int rowIndex) {
        return table.getRow(rowIndex);
    }

    private XWPFTableCell getCell(XWPFTableRow row, int cellIndex) {
        return row.getCell(cellIndex);
    }

}
