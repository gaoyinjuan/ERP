package com.briup.service;

import org.springframework.web.multipart.MultipartFile;

public interface IImportDataService {
    String insertMATable(MultipartFile excel) throws Exception;
}
