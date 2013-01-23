<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="ctcr40">
  <root id="root" name="root" selected="unbound">
    <groups id="opt" maxCardinality="2">
      <childFeatures id="f2" name="f2" selected="unbound"/>
      <childFeatures id="f3" name="f3" selected="unbound"/>
    </groups>
    <groups id="man" minCardinality="1" maxCardinality="1">
      <childFeatures id="f1" name="f1" selected="unbound">
        <groups id="of1" maxCardinality="1">
          <childFeatures id="f5" name="f5" selected="unbound">
            <groups id="of5" maxCardinality="4">
              <childFeatures id="f12" name="f12" selected="unbound"/>
              <childFeatures id="f13" name="f13" selected="unbound"/>
              <childFeatures id="f14" name="f14" selected="unbound"/>
              <childFeatures id="f15" name="f15" selected="unbound"/>
            </groups>
          </childFeatures>
        </groups>
        <groups id="mf1" minCardinality="2" maxCardinality="2">
          <childFeatures id="f4" name="f4" selected="unbound"/>
          <childFeatures id="f6" name="f6" selected="unbound"/>
        </groups>
        <groups id="orf1" minCardinality="1" maxCardinality="2">
          <childFeatures id="f7" name="f7" selected="unbound"/>
          <childFeatures id="f8" name="f8" selected="unbound">
            <groups id="of8" maxCardinality="1">
              <childFeatures id="f19" name="f19" selected="unbound"/>
            </groups>
            <groups id="mf8" minCardinality="4" maxCardinality="4">
              <childFeatures id="f16" name="f16" selected="unbound"/>
              <childFeatures id="f17" name="f17" selected="unbound"/>
              <childFeatures id="f18" name="f18" selected="unbound">
                <groups id="of18" maxCardinality="1">
                  <childFeatures id="f22" name="f22" selected="unbound"/>
                </groups>
              </childFeatures>
              <childFeatures id="f20" name="f20" selected="unbound">
                <groups id="mf20" minCardinality="1" maxCardinality="1">
                  <childFeatures id="f21" name="f21" selected="unbound"/>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups id="altf1" minCardinality="1" maxCardinality="1">
          <childFeatures id="f9" name="f9" selected="unbound"/>
          <childFeatures id="f10" name="f10" selected="unbound"/>
          <childFeatures id="f11" name="f11" selected="unbound"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
  <constraints id="c1">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f13"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f16"/>
    </expression>
  </constraints>
  <constraints id="c2">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f5"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f22"/>
    </expression>
  </constraints>
  <constraints id="c3">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f2"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f10"/>
    </expression>
  </constraints>
  <constraints id="c4">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f12"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f17"/>
    </expression>
  </constraints>
  <constraints id="c5">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f16"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f22"/>
    </expression>
  </constraints>
  <constraints id="c6">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f10"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f15"/>
    </expression>
  </constraints>
  <constraints id="c61">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f9"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f12"/>
    </expression>
  </constraints>
  <constraints id="c7">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f17"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f14"/>
    </expression>
  </constraints>
  <constraints id="c8">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f15"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f14"/>
    </expression>
  </constraints>
</feature:FeatureModel>
