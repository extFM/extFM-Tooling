<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="DocumentManagementSystemModel">
  <root id="DMS" name="DocumentManagementSystem" selected="unbound">
    <groups id="dms_optional" maxCardinality="4">
      <childFeatures id="ocr" name="OCR" selected="unbound">
        <groups id="oclFormats" minCardinality="1" maxCardinality="2">
          <childFeatures id="pdf" name="PDFOCR" selected="unbound"/>
          <childFeatures id="image" name="ImageOCR" selected="unbound"/>
        </groups>
      </childFeatures>
      <childFeatures id="fni" name="FileNameIndex" selected="unbound"/>
      <childFeatures id="search" name="Search" selected="unbound">
        <groups id="ManSearch" minCardinality="1" maxCardinality="1">
          <childFeatures id="fns" name="FileNameSearch" selected="unbound"/>
        </groups>
        <groups id="AltSearch" minCardinality="1" maxCardinality="1">
          <childFeatures id="gs" name="GeneralSearch" selected="unbound"/>
          <childFeatures id="mds" name="MetaDataSearch" selected="unbound">
            <groups id="OptionalMetaSearchDetails" maxCardinality="1">
              <childFeatures id="as" name="AuthorSearch" selected="unbound"/>
            </groups>
            <groups id="MandatoryMetaSearchDetails" minCardinality="2" maxCardinality="2">
              <childFeatures id="ts" name="TitleSearch" selected="unbound"/>
              <childFeatures id="cs" name="ContentSearch" selected="unbound"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures id="report" name="Report" selected="unbound">
        <groups id="reportDetails" minCardinality="1" maxCardinality="2">
          <childFeatures id="searchResults" name="SearchResults" selected="unbound"/>
          <childFeatures id="indexUsage" name="TitleIndexUsage" selected="unbound"/>
        </groups>
      </childFeatures>
    </groups>
    <groups id="Types" minCardinality="1" maxCardinality="4">
      <childFeatures id="tuni" name="UnicodeTextType" selected="unbound"/>
      <childFeatures id="tsim" name="SimpleTextType" selected="unbound"/>
      <childFeatures id="timg" name="ImageType" selected="unbound"/>
      <childFeatures id="tpdf" name="PDFType" selected="unbound"/>
    </groups>
    <groups id="Index" minCardinality="1" maxCardinality="1">
      <childFeatures id="mdi" name="MetaDataIndex" selected="unbound">
        <groups id="MandatoryMetaIndexDetails" minCardinality="2" maxCardinality="2">
          <childFeatures id="ci" name="ContentIndex" selected="unbound"/>
          <childFeatures id="ti" name="TitleIndex" selected="unbound"/>
        </groups>
        <groups id="OptionalMetaIndexDetails" maxCardinality="1">
          <childFeatures id="ai" name="AuthorIndex" selected="unbound"/>
        </groups>
      </childFeatures>
      <childFeatures id="gi" name="GeneralIndex" selected="unbound"/>
    </groups>
  </root>
  <constraints xsi:type="feature:Exclude" id="uni_ex_sim" leftOperand="tuni" rightOperand="tsim"/>
  <constraints xsi:type="feature:Imply" id="ImageOCR_req_ImageType" leftOperand="image" rightOperand="timg"/>
  <constraints xsi:type="feature:Imply" id="PDFOCR_req_PDFType" leftOperand="pdf" rightOperand="tpdf"/>
  <constraints xsi:type="feature:Imply" id="TitleIndexUsage_req_TitleIndex" leftOperand="indexUsage" rightOperand="ti"/>
  <constraints xsi:type="feature:Imply" id="MetaDataSearch_req_TitleIndex" leftOperand="mds" rightOperand="ti"/>
  <constraints xsi:type="feature:Imply" id="GeneralSearch_req_AuthorIndex" leftOperand="gs" rightOperand="ai"/>
  <constraints xsi:type="feature:Imply" id="fns_req_fni" leftOperand="fns" rightOperand="fni"/>
  <constraints xsi:type="feature:Imply" id="SearchResults_req_Search" leftOperand="searchResults" rightOperand="search"/>
</feature:FeatureModel>
