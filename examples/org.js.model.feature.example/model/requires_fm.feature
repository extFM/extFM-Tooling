<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="implies_fm">
  <root id="root" name="root">
    <groups id="gr0" maxCardinality="1">
      <childFeatures id="f1" name="f1"/>
    </groups>
    <groups id="gr1" maxCardinality="1">
      <childFeatures id="f2" name="f2"/>
    </groups>
  </root>
  <constraints id="c0">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f1"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f2"/>
    </expression>
  </constraints>
</feature:FeatureModel>
