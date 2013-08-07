<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="basic">
  <root id="root" name="root" configurationState="selected">
    <groups id="g1" maxCardinality="2">
      <childFeatures id="f1" name="f1">
        <attributes name="attr1" domain="d1"/>
        <groups id="g2" maxCardinality="1">
          <childFeatures id="f3" name="f3" configurationState="selected"/>
        </groups>
      </childFeatures>
      <childFeatures id="f2" name="f2">
        <attributes name="attr2" domain="d2" value="1"/>
      </childFeatures>
    </groups>
  </root>
  <domains xsi:type="feature:DiscreteDomain" id="d1">
    <values name="a1"/>
    <values int="1" name="a2"/>
    <values int="2" name="a3"/>
  </domains>
  <domains xsi:type="feature:NumericalDomain" id="d2">
    <intervals upperBound="3"/>
  </domains>
  <constraints xsi:type="feature:AttributeConstraint" id="c1" operator="greaterThan">
    <attribute1 xsi:type="feature:AttributeReference" attribute="attr1" feature="f1"/>
    <attribute2 xsi:type="feature:AttributeReference" attribute="attr2" feature="f2"/>
  </constraints>
  <constraints xsi:type="feature:AttributeConstraint" id="c3">
    <attribute1 xsi:type="feature:AttributeReference" attribute="attr1" feature="f1"/>
    <attribute2 xsi:type="feature:AttributeValue" name="a3"/>
  </constraints>
</feature:FeatureModel>
