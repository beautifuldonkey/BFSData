package service;

import database.TABLE_PlayerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
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

  private static final Logger logger = LogManager.getLogger(FileProcessingServiceImpl.class);
  private static final String LOG_TAG = "FileProcessingService - {}: {}";

  private String dataDir = "C://Users/jaw_m/Google Drive/FantasyFootball/2016WeekToWeek";

  private static final int DEF_INDEX_START = 6;
  private static final int DEF_INDEX_END = 10;
  private static final int FUM_INDEX_START = 11;
  private static final int FUM_INDEX_END = 15;
  private static final int INFO_INDEX_START = 0;
  private static final int INFO_INDEX_END = 5;
  private static final int KICK_INDEX_START = 16;
  private static final int KICK_INDEX_END = 29;
  private static final int PASS_INDEX_START = 30;
  private static final int PASS_INDEX_END = 36;
  private static final int PUNT_INDEX_START = 37;
  private static final int PUNT_INDEX_END = 46;
  private static final int REC_INDEX_START = 47;
  private static final int REC_INDEX_END = 53;
  private static final int RUSH_INDEX_START = 54;
  private static final int RUSH_INDEX_END = 60;


  @Override
  public Boolean checkDirectory() {
    Boolean dirHasData = false;
    try {
      dirHasData = Files.list(new File(dataDir).toPath()).anyMatch(path -> path.getFileName().toString().contains(".xlsx"));
    }catch (IOException ex){
      logger.error(LOG_TAG, "IOException", ex);
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


      List<TABLE_PlayerData> playerDataList = new ArrayList<>();

      // processing all rows
      while(rowIterator.hasNext()){
        Row nextRow = rowIterator.next();

        // skipping the header row
        if(nextRow.getRowNum() == 0){
          continue;
        }

        TABLE_PlayerData playerData = new TABLE_PlayerData();

        Iterator<Cell> cellIterator = nextRow.cellIterator();
        while (cellIterator.hasNext()){

          Cell nextCell = cellIterator.next();
          int nextCellIndex = nextCell.getColumnIndex();

          if(checkColIndex(nextCellIndex, INFO_INDEX_START,INFO_INDEX_END)){
            fileProcessed = processInfoData(playerData, nextCell);
            continue;
          }

          if(checkColIndex(nextCellIndex, PASS_INDEX_START,PASS_INDEX_END)){
            fileProcessed = processPassData(playerData, nextCell);
            continue;
          }

          if(checkColIndex(nextCellIndex, RUSH_INDEX_START,RUSH_INDEX_END)){
            fileProcessed = processRushData(playerData, nextCell);
            continue;
          }

          if(checkColIndex(nextCellIndex, REC_INDEX_START,REC_INDEX_END)){
            fileProcessed = processRecData(playerData, nextCell);
            continue;
          }

          if(checkColIndex(nextCellIndex, DEF_INDEX_START,DEF_INDEX_END)){
            fileProcessed = processDefData(playerData, nextCell);
            continue;
          }

          if(checkColIndex(nextCellIndex, FUM_INDEX_START,FUM_INDEX_END)){
            fileProcessed = processFumData(playerData, nextCell);
            continue;
          }

          if(checkColIndex(nextCellIndex, KICK_INDEX_START,KICK_INDEX_END)){
            fileProcessed = processKickData(playerData, nextCell);
            continue;
          }

          if(checkColIndex(nextCellIndex, PUNT_INDEX_START,PUNT_INDEX_END)){
            fileProcessed = processPuntData(playerData, nextCell);
          }

        }

        playerDataList.add(playerData);

      }

      // closing the workbook and file input stream
      workbook.close();
      fis.close();
    } catch (FileNotFoundException fileEx){
      logger.error(LOG_TAG, "FileNotFoundException", fileEx);
    } catch (IOException ioEx){
      logger.error(LOG_TAG, "IOException", ioEx);
    }

    return fileProcessed;
  }
  @Override
  public List<Boolean> processFiles(){
    logger.info(LOG_TAG, "processFiles","begin");
    ArrayList<Boolean> results = new ArrayList<>();

    // check that data is available for processing
    if(!checkDirectory()){
      results.add(false);
      return results;
    }

    // set up for data processing
    List<String> files = retrieveFileNames();
    logger.info(LOG_TAG, "retrieved files for processing", files.size());

    int processingIndex = 0;
    boolean processingResult;

    // start data processing
    for (String file : files) {
      processingResult = processFile(file);
      results.add(processingResult);
      logger.info(LOG_TAG, "processed file with result", processingResult);
    }

    logger.info(LOG_TAG, "processFiles","end");
    return results;
  }

  private static boolean checkColIndex(int currentIndex, int lower, int upper){
    return lower <= currentIndex && currentIndex <= upper;
  }

  private List<String> retrieveFileNames(){
    List<String> dataFiles = new ArrayList<>();
    try {
      Files.list(new File(dataDir).toPath()).forEach(path -> dataFiles.add(path.toString()));
    }catch (IOException ex){
      logger.error(LOG_TAG, "IOException", ex);
    }
    return dataFiles;
  }

  private boolean processInfoData(TABLE_PlayerData playerData, Cell cell){
    boolean processingSuccess = false;

    // index 2 is skipped - id from raw data not logged

    if(cell.getColumnIndex() == 0){
      playerData.setName(cell.getStringCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 1){
      if(CellType.STRING.equals(cell.getCellTypeEnum())){
        return false;
      }
      playerData.setWeek(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 3){
      playerData.setHome(cell.getStringCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 4){
      playerData.setTeam(cell.getStringCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 5){
      playerData.setPos(cell.getStringCellValue());
      processingSuccess = true;
    }

    return processingSuccess;
  }

  private boolean processPassData(TABLE_PlayerData playerData, Cell cell){
    boolean processingSuccess = false;

    if(cell.getColumnIndex() == 30){
      playerData.setPassAtt(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 31){
      playerData.setPassCmp(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 32){
      playerData.setPassInts(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 33){
      playerData.setPassTds(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 34){
      playerData.setPassTwoPtAtt(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 35) {
      playerData.setPassTwoPtMade(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 36) {
      playerData.setPassYds(cell.getNumericCellValue());
      processingSuccess = true;
    }

      return processingSuccess;
  }

  private boolean processRushData(TABLE_PlayerData playerData, Cell cell){
    boolean processingSuccess = false;

    if(cell.getColumnIndex() == 54){
      playerData.setRushAtt(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 55){
      playerData.setRushLng(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 56){
      playerData.setRushLngTd(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 57){
      playerData.setRushTds(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 58){
      playerData.setRushTwoPtAtt(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 59) {
      playerData.setRushTwoPtMade(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 60) {
      playerData.setRushYds(cell.getNumericCellValue());
      processingSuccess = true;
    }

    return processingSuccess;
  }

  private boolean processRecData(TABLE_PlayerData playerData, Cell cell){
    boolean processingSuccess = false;

    if(cell.getColumnIndex() == 47){
      playerData.setRecLng(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 48){
      playerData.setRecLngTd(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 49){
      playerData.setRecRec(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 50){
      playerData.setRecTds(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 51){
      playerData.setRecTwoPtAtt(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 52) {
      playerData.setRecTwoPtMade(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 53) {
      playerData.setRecYds(cell.getNumericCellValue());
      processingSuccess = true;
    }

    return processingSuccess;
  }

  private boolean processDefData(TABLE_PlayerData playerData, Cell cell){
    boolean processingSuccess = false;

    if(cell.getColumnIndex() == 6){
      playerData.setDefAst(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 7){
      playerData.setDefFFum(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 8){
      playerData.setDefInt(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 9){
      playerData.setDefSk(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 10){
      playerData.setDefTkl(cell.getNumericCellValue());
      processingSuccess = true;
    }

    return processingSuccess;
  }

  private boolean processFumData(TABLE_PlayerData playerData, Cell cell){
    boolean processingSuccess = false;

    if(cell.getColumnIndex() == 11){
      playerData.setFumLost(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 12){
      playerData.setFumRcvr(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 13){
      playerData.setFumTot(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 14){
      playerData.setFumTotRcvr(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 15){
      playerData.setFumYds(cell.getNumericCellValue());
      processingSuccess = true;
    }

    return processingSuccess;
  }

  private boolean processKickData(TABLE_PlayerData playerData, Cell cell){
    boolean processingSuccess = false;

    if(cell.getColumnIndex() == 16){
      playerData.setKickFgA(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 17){
      playerData.setKickFgM(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 18){
      playerData.setKickFgYds(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 19){
      playerData.setKickTotPFg(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 20){
      playerData.setKickExPtAtt(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 21) {
      playerData.setKickExPtBlk(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 22) {
      playerData.setKickExPtMade(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 23) {
      playerData.setKickExPtMiss(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 24) {
      playerData.setKickExPtOt(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 25) {
      playerData.setKickRetAvg(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 26) {
      playerData.setKickRetLng(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 27) {
      playerData.setKickRetLngTd(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 28) {
      playerData.setKickRetRet(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 29) {
      playerData.setKickRetTds(cell.getNumericCellValue());
      processingSuccess = true;
    }

    return processingSuccess;
  }

  private boolean processPuntData(TABLE_PlayerData playerData, Cell cell){
    boolean processingSuccess = false;

    if(cell.getColumnIndex() == 37){
      playerData.setPuntAvg(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 38){
      playerData.setPuntInsTwty(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 39){
      playerData.setPuntLng(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 40){
      playerData.setPuntPts(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 41){
      playerData.setPuntYds(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 42) {
      playerData.setPuntRetAvg(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 43) {
      playerData.setPuntRetLng(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 44) {
      playerData.setPuntRetLngTd(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 45) {
      playerData.setPuntRetRet(cell.getNumericCellValue());
      processingSuccess = true;
    }

    if(cell.getColumnIndex() == 46) {
      playerData.setPuntRetTds(cell.getNumericCellValue());
      processingSuccess = true;
    }

    return processingSuccess;
  }
}
