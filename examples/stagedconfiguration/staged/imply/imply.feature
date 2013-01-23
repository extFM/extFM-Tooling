<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="imply">
  <root id="root" name="root" selected="unbound">
    <groups id="opt" maxCardinality="2">
      <childFeatures id="f1" name="f1" selected="unbound"/>
      <childFeatures id="f2" name="f2" selected="unbound"/>
    </groups>
  </root>
  <constraints id="imp">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f1"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f2"/>
    </expression>
  </constraints>
</feature:FeatureModel>
