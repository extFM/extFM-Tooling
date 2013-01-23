<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="ctcr50">
  <root id="root" name="root" selected="unbound">
    <groups id="opt" maxCardinality="1">
      <childFeatures id="f3" name="f3" selected="unbound">
        <groups id="mf3" minCardinality="1" maxCardinality="1">
          <childFeatures id="f4" name="f4" selected="unbound"/>
        </groups>
      </childFeatures>
    </groups>
    <groups id="man" minCardinality="2" maxCardinality="2">
      <childFeatures id="f1" name="f1" selected="unbound"/>
      <childFeatures id="f2" name="f2" selected="unbound">
        <groups id="of2" maxCardinality="1">
          <childFeatures id="f6" name="f6" selected="unbound"/>
        </groups>
        <groups id="mf2" minCardinality="3" maxCardinality="3">
          <childFeatures id="f5" name="f5" selected="unbound">
            <groups id="mf5" minCardinality="1" maxCardinality="1">
              <childFeatures id="f14" name="f14" selected="unbound">
                <groups id="mf14" minCardinality="1" maxCardinality="1">
                  <childFeatures id="f15" name="f15" selected="unbound"/>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
          <childFeatures id="f7" name="f7" selected="unbound"/>
          <childFeatures id="f8" name="f8" selected="unbound">
            <groups id="of8" maxCardinality="1">
              <childFeatures id="f22" name="f22" selected="unbound"/>
            </groups>
          </childFeatures>
        </groups>
        <groups id="orf2" maxCardinality="3">
          <childFeatures id="f9" name="f9" selected="unbound"/>
          <childFeatures id="f10" name="f10" selected="unbound">
            <groups id="altf10" minCardinality="1" maxCardinality="1">
              <childFeatures id="f20" name="f20" selected="unbound"/>
              <childFeatures id="f21" name="f21" selected="unbound"/>
            </groups>
            <groups id="orf10" maxCardinality="2">
              <childFeatures id="f16" name="f16" selected="unbound"/>
              <childFeatures id="f17" name="f17" selected="unbound"/>
            </groups>
            <groups id="mf10" minCardinality="2" maxCardinality="2">
              <childFeatures id="f18" name="f18" selected="unbound"/>
              <childFeatures id="f19" name="f19" selected="unbound"/>
            </groups>
          </childFeatures>
          <childFeatures id="f11" name="f11" selected="unbound"/>
        </groups>
        <groups id="altf2" minCardinality="1" maxCardinality="1">
          <childFeatures id="f12" name="f12" selected="unbound"/>
          <childFeatures id="f13" name="f13" selected="unbound"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
  <constraints id="c1">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f15"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f13"/>
    </expression>
  </constraints>
  <constraints id="c2">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f8"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f17"/>
    </expression>
  </constraints>
  <constraints id="c3">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f15"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f19"/>
    </expression>
  </constraints>
  <constraints id="c4">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f10"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f19"/>
    </expression>
  </constraints>
  <constraints id="c5">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f19"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f14"/>
    </expression>
  </constraints>
  <constraints id="c6">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f12"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f1"/>
    </expression>
  </constraints>
  <constraints id="c7">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f6"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f4"/>
    </expression>
  </constraints>
  <constraints id="c8">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f14"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f13"/>
    </expression>
  </constraints>
  <constraints id="c9">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f14"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f12"/>
    </expression>
  </constraints>
  <constraints id="c10">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f5"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f17"/>
    </expression>
  </constraints>
  <constraints id="c11">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f14"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f17"/>
    </expression>
  </constraints>
</feature:FeatureModel>
