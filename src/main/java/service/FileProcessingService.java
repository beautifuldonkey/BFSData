package service;

import java.util.List;

public interface FileProcessingService {
  /**
   * Checks directory for raw data files
   * @return list of file names
   */
  List<String> checkDirectory();
  /**
   * Processes raw data file
   * @param name file name to process
   * @return file processing success
   */
  Boolean processFile(String name);
}
