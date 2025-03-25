/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.model;

/**
 *
 * @author ariel
 */
public class Report implements IComboElement {
    
    private Integer reportId;
    private String reportName;

    public Report() {
    }

    public Report(Integer reportId, String reportName) {
        this.reportId = reportId;
        this.reportName = reportName;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public String toString() {
        return getReportName();
    }

    @Override
    public Integer getComboElementId() {
        return getReportId();
    }

    @Override
    public String getComboElementDescription() {
        return getReportName();
    }
    
}
