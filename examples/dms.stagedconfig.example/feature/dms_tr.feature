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
  <constraints id="uni_ex_sim">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="tuni"/>
      <operand2 xsi:type="feature:FeatureReference" feature="tsim"/>
    </expression>
  </constraints>
  <constraints id="ImageOCR_req_ImageType">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="image"/>
      <operand2 xsi:type="feature:FeatureReference" feature="timg"/>
    </expression>
  </constraints>
  <constraints id="PDFOCR_req_PDFType">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="pdf"/>
      <operand2 xsi:type="feature:FeatureReference" feature="tpdf"/>
    </expression>
  </constraints>
  <constraints id="TitleIndexUsage_req_TitleIndex">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="indexUsage"/>
      <operand2 xsi:type="feature:FeatureReference" feature="ti"/>
    </expression>
  </constraints>
  <constraints id="MetaDataSearch_req_TitleIndex">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="mds"/>
      <operand2 xsi:type="feature:FeatureReference" feature="ti"/>
    </expression>
  </constraints>
  <constraints id="AuthorSearch_req_AutorIndex">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="as"/>
      <operand2 xsi:type="feature:FeatureReference" feature="ai"/>
    </expression>
  </constraints>
  <constraints id="GeneralSearch_req_GeneralIndex">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="gs"/>
      <operand2 xsi:type="feature:FeatureReference" feature="gi"/>
    </expression>
  </constraints>
  <constraints id="fns_req_fni">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="fns"/>
      <operand2 xsi:type="feature:FeatureReference" feature="fni"/>
    </expression>
  </constraints>
  <constraints id="SearchResults_req_Search">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="searchResults"/>
      <operand2 xsi:type="feature:FeatureReference" feature="search"/>
    </expression>
  </constraints>
</feature:FeatureModel>
