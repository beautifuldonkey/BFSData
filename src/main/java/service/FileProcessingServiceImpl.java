package service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileProcessingServiceImpl implements FileProcessingService {

  private String dataDir = "C://Users/jaw_m/Google Drive/FantasyFootball/2016WeekToWeek";

  @Override
  public Boolean checkDirectory() {
    Boolean dirHasData = false;
    try {
      dirHasData = Files.list(new File(dataDir).toPath()).anyMatch(path -> path.getFileName().toString().contains(".xlsx"));
    }catch (IOException ex){
      ex.printStackTrace();
    }
    return dirHasData;
  }
  @Override
  public Boolean processFile(String filePath) {
    // check that data is available for processing
    if(!checkDirectory()){
      return false;
    }
    Boolean fileProcessed = false;
    try{
      // open a file input stream using the file path provided
      FileInputStream fis = new FileInputStream(new File(filePath));
      // create a workbook using the file input stream
      Workbook workbook = new XSSFWorkbook(fis);
      // using the first sheet of the workbook
      Sheet sheet = workbook.getSheetAt(0);
      // iterator used to loop through the data rows in the sheet
      Iterator<Row> rowIterator = sheet.iterator();

      // processing all rows
      while(rowIterator.hasNext()){
        Row nextRow = rowIterator.next();

        // processing the cells in the next row
        Iterator<Cell> cellIterator = nextRow.cellIterator();
        while (cellIterator.hasNext()){

          // processing the next cell in the row
          Cell nextCell = cellIterator.next();
          // TODO implement private data processing methods
          switch (nextCell.getColumnIndex()){
            case 1:
              System.out.println("col 1");
              fileProcessed = true;
              break;
            case 2:
              System.out.println("col 2");
              fileProcessed = true;
              break;
            default:
              System.out.println("other: "+nextCell.getColumnIndex());
              fileProcessed = true;
              break;
          }

        }

      }

      // closing the workbook and file input stream
      workbook.close();
      fis.close();
    } catch (FileNotFoundException fileEx){
      System.out.println("FileNotFoundException: "+ fileEx.getMessage());
    } catch (IOException ioEx){
      System.out.println("IOException: "+ioEx.getMessage());
    }

    return fileProcessed;
  }
  @Override
  public Boolean processFiles(){
    // check that data is available for processing
    if(!checkDirectory()){
      return false;
    }

    // set up for data processing
    Boolean fileProcessed = false;
    List<String> files = retrieveFileNames();

    // start data processing
    for (String file : files) {
      fileProcessed = processFile(file);
    }

    return fileProcessed;
  }

  private List<String> retrieveFileNames(){
    List<String> dataFiles = new ArrayList<>();
    try {
      Files.list(new File(dataDir).toPath()).forEach(path -> dataFiles.add(path.toString()));
    }catch (IOException ex){
      ex.printStackTrace();
    }
    return dataFiles;
  }
}
