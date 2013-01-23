<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/extfeature" name="DMS_ohne_CTC">
  <root id="dms" name="dms" selected="unbound">
    <groups id="opt1" maxCardinality="10">
      <childFeatures id="ocr" name="ocr" selected="unbound">
        <groups id="ocr_opt" maxCardinality="2">
          <childFeatures id="pdfocr" name="pdfocr" selected="unbound"/>
          <childFeatures id="imageOCR" name="imageOCR" selected="unbound"/>
        </groups>
      </childFeatures>
      <childFeatures id="fni" name="fni" selected="unbound"/>
      <childFeatures id="search" name="search" selected="unbound">
        <groups id="search_opt" maxCardinality="3">
          <childFeatures id="fns" name="fns" selected="unbound"/>
          <childFeatures id="gs" name="gs" selected="unbound"/>
          <childFeatures id="mds" name="mds" selected="unbound">
            <groups id="mds_opt" maxCardinality="3">
              <childFeatures id="as" name="as" selected="unbound"/>
              <childFeatures id="ts" name="ts" selected="unbound"/>
              <childFeatures id="cs" name="cs" selected="unbound"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures id="report" name="report" selected="unbound"/>
      <childFeatures id="unicode" name="unicode" selected="unbound"/>
      <childFeatures id="simple" name="simple" selected="unbound"/>
      <childFeatures id="image" name="image" selected="unbound"/>
      <childFeatures id="pdf" name="pdf" selected="unbound"/>
      <childFeatures id="metadataindex" name="mdi" selected="unbound">
        <groups id="mdi_opt" maxCardinality="3">
          <childFeatures id="ci" name="ci" selected="unbound"/>
          <childFeatures id="ti" name="ti" selected="unbound"/>
          <childFeatures id="ai" name="ai" selected="unbound"/>
        </groups>
      </childFeatures>
      <childFeatures id="gi" name="generalindex" selected="unbound"/>
    </groups>
  </root>
</feature:FeatureModel>
