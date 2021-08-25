package com.crud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.domain.ReportEntity;
import com.crud.dto.Report;
import com.crud.dto.ReportWrapper;
import com.crud.repository.ReportRepository;

@Service
public class ReportService {

    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

    private ReportRepository repository;

    @Autowired
    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }

    public Report get(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    public ReportWrapper getMany() {
        List<ReportEntity> reportEntities = repository.getMany();

        logger.info("got {} reports", reportEntities.size());

        List<Report> reports = reportEntities.stream().map(
                entity -> new Report(entity.getRegion(), entity.getYear(), entity.getPercentage(), entity.getSource()))
                .collect(Collectors.toList());
        return new ReportWrapper(reports);
    }

    public Report create() {
        // TODO Auto-generated method stub
        return null;
    }

    public Report update(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Report patch(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void delete(String id) {
        // TODO Auto-generated method stub

    }

}
