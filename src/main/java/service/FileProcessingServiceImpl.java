package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
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
  public Boolean processFile(String name) {
    return null;
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
