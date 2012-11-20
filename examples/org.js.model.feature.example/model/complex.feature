<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="complexEFM">
  <root id="root" name="root" selected="unbound">
    <attributes name="rootBool" domain="Bool"/>
    <groups id="root_g1" minCardinality="2" maxCardinality="2">
      <childFeatures id="fa" name="fa" selected="unbound">
        <groups id="fa_g1" minCardinality="1" maxCardinality="1">
          <childFeatures id="fa1" name="fa1" selected="unbound">
            <attributes name="FTN" domain="FiveToNine"/>
          </childFeatures>
          <childFeatures id="fa2" name="fa2" selected="unbound"/>
          <childFeatures id="fa3" name="fa3" selected="unbound">
            <attributes name="OTT" domain="OneToThree"/>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures id="fb" name="fb" selected="unbound">
        <groups id="fb_g1" maxCardinality="1">
          <childFeatures id="fb1" name="fb1" selected="unbound"/>
        </groups>
        <groups id="fb_g2" minCardinality="2" maxCardinality="2">
          <childFeatures id="fb2" name="fb2" selected="unbound"/>
          <childFeatures id="fb3" name="fb3" selected="unbound"/>
        </groups>
      </childFeatures>
    </groups>
    <groups id="root_g2" maxCardinality="1">
      <childFeatures id="fc" name="fc" selected="unbound">
        <groups id="fc_g1" minCardinality="1" maxCardinality="1">
          <childFeatures id="fc1" name="fc1" selected="unbound">
            <attributes name="MyBool" domain="Bool"/>
          </childFeatures>
        </groups>
        <groups id="fc_g2" maxCardinality="2">
          <childFeatures id="fc2" name="fc2" selected="unbound">
            <attributes name="FTN" domain="FiveToNine"/>
          </childFeatures>
          <childFeatures id="fc3" name="fc3" selected="unbound">
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
</feature:FeatureModel>
