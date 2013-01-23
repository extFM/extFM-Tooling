<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="feature">
  <root id="root" name="root" selected="undetermined">
    <groups id="root_g1" maxCardinality="3">
      <childFeatures id="f1" name="f1" selected="undetermined"/>
      <childFeatures id="f2" name="f2" selected="undetermined"/>
      <childFeatures id="f3" name="f3" selected="undetermined"/>
    </groups>
    <groups id="root_g2" minCardinality="1" maxCardinality="1">
      <childFeatures id="f1_f2" name="f1_f2" selected="undetermined"/>
      <childFeatures id="f1_f3" name="f1_f3" selected="undetermined"/>
      <childFeatures id="f2_f3" name="f2_f3" selected="undetermined"/>
    </groups>
  </root>
  <constraints id="f1_f2_req_f1">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f1_f2"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f1"/>
    </expression>
  </constraints>
  <constraints id="f1_f2_req_f2">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f1_f2"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f2"/>
    </expression>
  </constraints>
  <constraints id="f1_f2_ex_f3">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f1_f2"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f3"/>
    </expression>
  </constraints>
  <constraints id="f1_f3_req_f1">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f1_f3"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f1"/>
    </expression>
  </constraints>
  <constraints id="f1_f3_req_f3">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f1_f3"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f3"/>
    </expression>
  </constraints>
  <constraints id="f1_f3_ex_f2">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f1_f3"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f2"/>
    </expression>
  </constraints>
  <constraints id="f2_f3_req_f2">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f2_f3"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f2"/>
    </expression>
  </constraints>
  <constraints id="f2_f3_req_f3">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f2_f3"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f3"/>
    </expression>
  </constraints>
  <constraints id="f2_f3_ex_f1">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f2_f3"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f1"/>
    </expression>
  </constraints>
</feature:FeatureModel>
