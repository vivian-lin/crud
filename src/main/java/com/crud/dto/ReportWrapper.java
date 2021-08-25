package com.crud.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@AllArgsConstructor
public class ReportWrapper {

    @Singular(ignoreNullCollections = true)
    List<Report> reports;

}
