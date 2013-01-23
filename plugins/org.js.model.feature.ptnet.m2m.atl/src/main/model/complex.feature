<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="feature" name="complexEFM">
  <root id="root" name="root" selected="undetermined">
    <attributes name="rootBool" domain="Bool"/>
    <groups id="root_g1" minCardinality="2" maxCardinality="2">
      <childFeatures id="fa" name="fa" selected="undetermined">
        <groups id="fa_g1" minCardinality="1" maxCardinality="1">
          <childFeatures id="fa1" name="fa1" selected="undetermined">
            <attributes name="FTN" domain="FiveToNine"/>
          </childFeatures>
          <childFeatures id="fa2" name="fa2" selected="undetermined"/>
          <childFeatures id="fa3" name="fa3" selected="undetermined">
            <attributes name="OTT" domain="OneToThree"/>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures id="fb" name="fb" selected="undetermined">
        <groups id="fb_g1" maxCardinality="1">
          <childFeatures id="fb1" name="fb1" selected="undetermined"/>
        </groups>
        <groups id="fb_g2" minCardinality="2" maxCardinality="2">
          <childFeatures id="fb2" name="fb2" selected="undetermined"/>
          <childFeatures id="fb3" name="fb3" selected="undetermined"/>
        </groups>
      </childFeatures>
    </groups>
    <groups id="root_g2" maxCardinality="1">
      <childFeatures id="fc" name="fc" selected="undetermined">
        <groups id="fc_g1" minCardinality="1" maxCardinality="1">
          <childFeatures id="fc1" name="fc1" selected="undetermined">
            <attributes name="MyBool" domain="Bool"/>
          </childFeatures>
        </groups>
        <groups id="fc_g2" maxCardinality="2">
          <childFeatures id="fc2" name="fc2" selected="undetermined">
            <attributes name="FTN" domain="FiveToNine"/>
          </childFeatures>
          <childFeatures id="fc3" name="fc3" selected="undetermined">
            <attributes name="fc3Color" domain="Color" value=""/>
            <attributes name="OTT" domain="OneToThree"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
  </root>
  <domains xsi:type="feature:ContinuousDomain" id="OneToThree">
    <intervals lowerBound="1" upperBound="3"/>
  </domains>
  <domains xsi:type="feature:ContinuousDomain" id="FiveToNine">
    <intervals lowerBound="5" upperBound="9"/>
  </domains>
  <domains xsi:type="feature:DiscreteDomain" id="Bool">
    <values>true</values>
    <values>false</values>
  </domains>
  <domains xsi:type="feature:DiscreteDomain" id="Color">
    <values>Red</values>
    <values>Yellow</values>
    <values>Blue</values>
    <values>Black</values>
    <values>Green</values>
  </domains>
  <constraints id="c1imp">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="fa1"/>
      <operand2 xsi:type="feature:FeatureReference" feature="fb1"/>
    </expression>
  </constraints>
  <constraints id="c2ex">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="fb2"/>
      <operand2 xsi:type="feature:FeatureReference" feature="fc1"/>
    </expression>
  </constraints>
</feature:FeatureModel>
