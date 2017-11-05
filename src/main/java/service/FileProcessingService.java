package service;

import java.util.List;

public interface FileProcessingService {
  /**
   * Checks directory for raw data files
   * @return raw data availability
   */
  Boolean checkDirectory();
  /**
   * Processes raw data file
   * @param name file name to process
   * @return file processing success
   */
  Boolean processFile(String name);
}
