package com.crud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "reports")
public class ReportEntity {

    // @Id
    // @Column(name = "id")
    // private int id;

    @Column(name = "region")
    private String region;

    @Column(name = "year")
    private int year;

    @Column(name = "percentage")
    private double percentage;

    @Column(name = "source")
    private String source;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof ReportEntity)) {
            return false;
        }
        ReportEntity castOther = (ReportEntity) other;
        return new EqualsBuilder().append(region, castOther.region).append(year, castOther.year)
                .append(percentage, castOther.percentage).append(source, castOther.source).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(region).append(year).append(percentage).append(source).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("region", region).append("year", year).append("percentage", percentage)
                .append("source", source).toString();
    }

}
