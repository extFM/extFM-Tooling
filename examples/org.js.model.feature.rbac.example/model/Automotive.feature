<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="Automotive Multimedia Software Product Line">
  <root id="AutomotiveMultimedia" name="Automotive Multimedia">
    <groups id="AutomotiveMultimediaGroup" minCardinality="1" maxCardinality="4">
      <childFeatures id="AudioPlayer" name="Audio Player" selected="selected">
        <groups id="AudioPlayerGroup" minCardinality="1" maxCardinality="3">
          <childFeatures id="Radio" name="Radio"/>
          <childFeatures id="CassettePlayer" name="Cassette Player"/>
          <childFeatures id="CDPlayer" name="CD Player">
            <attributes name="coverColor" domain="CoverColor" value="green"/>
            <attributes name="select" domain="Boolean"/>
            <attributes name="hasUSBPort" domain="Boolean"/>
            <attributes name="numberOfTitles" domain="Interval"/>
            <groups id="CDPlayerGroup" minCardinality="1" maxCardinality="1">
              <childFeatures id="AudioCDPlayer" name="Audio CD Player"/>
              <childFeatures id="MP3CDPlayer" name="MP3 CD Player"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures id="VoiceRecognition" name="Voice Recognition"/>
      <childFeatures id="PersonalNavigation" name="Personal Navigation">
        <attributes name="backgroundColor" domain="BGColor"/>
        <groups id="PersonalNavigationGroup" minCardinality="1" maxCardinality="1">
          <childFeatures id="Maps" name="Maps">
            <attributes name="levelOfDetail" domain="Level"/>
            <groups id="MapsGroup" minCardinality="1" maxCardinality="5">
              <childFeatures id="Europe" name="Europe"/>
              <childFeatures id="NorthAmerica" name="North America"/>
              <childFeatures id="CentralAmerica" name="Central America"/>
              <childFeatures id="SouthAmerica" name="South America"/>
              <childFeatures id="Asia" name="Asia"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures id="OnBoardComputer" name="On-board Computer"/>
    </groups>
  </root>
  <domains xsi:type="feature:DiscreteDomain" id="Color">
    <values>red</values>
    <values>green</values>
    <values>blue</values>
    <values>black</values>
    <values>white</values>
  </domains>
  <domains xsi:type="feature:DiscreteDomain" id="CoverColor">
    <values>red</values>
    <values>green</values>
    <values>blue</values>
  </domains>
  <domains xsi:type="feature:DiscreteDomain" id="BGColor">
    <values>black</values>
    <values>white</values>
    <values>green</values>
    <values>blue</values>
  </domains>
  <domains xsi:type="feature:DiscreteDomain" id="Boolean">
    <values>true</values>
    <values>false</values>
  </domains>
  <domains xsi:type="feature:ContinuousDomain" id="Interval">
    <intervals lowerBound="10" upperBound="20"/>
    <intervals lowerBound="30" upperBound="50"/>
  </domains>
  <domains xsi:type="feature:ContinuousDomain" id="Interval2">
    <intervals lowerBound="10" upperBound="20"/>
    <intervals lowerBound="30" upperBound="50"/>
  </domains>
  <domains xsi:type="feature:ContinuousDomain" id="Level">
    <intervals lowerBound="1" upperBound="10"/>
  </domains>
  <constraints id="VoiceRecognitionConstraints">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="VoiceRecognition"/>
      <operand2 xsi:type="feature:OrExpression">
        <operand1 xsi:type="feature:FeatureReference" feature="AudioPlayer"/>
        <operand2 xsi:type="feature:FeatureReference" feature="PersonalNavigation"/>
      </operand2>
    </expression>
  </constraints>
  <constraints id="ReadableNavigationConstraint">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:NestedExpression">
        <operand xsi:type="feature:AndExpression">
          <operand1 xsi:type="feature:FeatureReference" feature="PersonalNavigation"/>
          <operand2 xsi:type="feature:FeatureReference" feature="CDPlayer"/>
        </operand>
      </operand1>
      <operand2 xsi:type="feature:AttributeComparisonExpression" operator="unequal">
        <attribute1 xsi:type="feature:AttributeReference" attribute="backgroundColor"/>
        <attribute2 xsi:type="feature:AttributeReference" attribute="coverColor"/>
      </operand2>
    </expression>
  </constraints>
  <constraints id="ArbitraryConstraint">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:NestedExpression">
        <operand xsi:type="feature:AndExpression">
          <operand1 xsi:type="feature:NestedExpression">
            <operand xsi:type="feature:OrExpression">
              <operand1 xsi:type="feature:FeatureReference" feature="CassettePlayer"/>
              <operand2 xsi:type="feature:FeatureReference" feature="Radio"/>
            </operand>
          </operand1>
          <operand2 xsi:type="feature:NotExpression">
            <operand xsi:type="feature:FeatureReference" feature="CDPlayer"/>
          </operand2>
        </operand>
      </operand1>
      <operand2 xsi:type="feature:FeatureReference" feature="VoiceRecognition"/>
    </expression>
  </constraints>
  <constraints id="AnotherConstraint">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:AttributeComparisonExpression" operator="lessThan">
        <attribute1 xsi:type="feature:AttributeReference" attribute="numberOfTitles"/>
        <attribute2 xsi:type="feature:AttributeValueLiteral" value="30"/>
      </operand1>
      <operand2 xsi:type="feature:AttributeComparisonExpression">
        <attribute1 xsi:type="feature:AttributeValueLiteral" value="hasUSBPort"/>
        <attribute2 xsi:type="feature:AttributeValueLiteral" value="true"/>
      </operand2>
    </expression>
  </constraints>
</feature:FeatureModel>
