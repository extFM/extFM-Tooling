<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="attribute">
  <root id="root" name="root" selected="unbound">
    <groups id="opt" maxCardinality="2">
      <childFeatures id="f1" name="f1" selected="unbound">
        <attributes name="colorAttribute" domain="color"/>
      </childFeatures>
      <childFeatures id="f2" name="f2" selected="unbound">
        <attributes name="countAttribute" domain="count"/>
      </childFeatures>
    </groups>
  </root>
  <domains xsi:type="feature:DiscreteDomain" id="color">
    <values>red</values>
    <values>green</values>
    <values>blue</values>
  </domains>
  <domains xsi:type="feature:ContinuousDomain" id="count">
    <intervals lowerBound="2" upperBound="5"/>
  </domains>
</feature:FeatureModel>
