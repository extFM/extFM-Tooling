<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="BodyComfortSystemModel">
  <root id="BCS" name="BodyComfortSystem" selected="unbound">
    <groups id="optional" minCardinality="1" maxCardinality="4">
      <childFeatures id="StatusLED" name="StatusLED" selected="unbound">
        <groups id="LED" maxCardinality="6">
          <childFeatures id="Lalarm" name="LEDAlarmSystem" selected="unbound"/>
          <childFeatures id="Lfp" name="LEDFingerProtection" selected="unbound"/>
          <childFeatures id="Llock" name="LEDCentralLockingSystem" selected="unbound"/>
          <childFeatures id="Lpw" name="LEDPowerWindow" selected="unbound"/>
          <childFeatures id="LexMirror" name="LEDExteriorMirror" selected="unbound"/>
          <childFeatures id="Lheat" name="LEDHeatable" selected="unbound"/>
        </groups>
      </childFeatures>
      <childFeatures id="fp" name="FingerProtection" selected="unbound"/>
      <childFeatures id="hem" name="HeatableExteriorMirror" selected="unbound"/>
      <childFeatures id="sec" name="Security" selected="unbound">
        <groups id="SecuritySystems" maxCardinality="3">
          <childFeatures id="as" name="AlarmSystem" selected="unbound">
            <groups id="Monitor" maxCardinality="1">
              <childFeatures id="im" name="InteriorMonitoring" selected="unbound"/>
            </groups>
          </childFeatures>
          <childFeatures id="cls" name="CentralLockingSystem" selected="unbound">
            <groups id="MoreLocking" maxCardinality="1">
              <childFeatures id="al" name="AutomaticLocking" selected="unbound"/>
            </groups>
          </childFeatures>
          <childFeatures id="rck" name="RemoteControlKey" selected="unbound">
            <groups id="rmkGroup" maxCardinality="4">
              <childFeatures id="cas" name="ControlAlarmSystem" selected="unbound"/>
              <childFeatures id="aem" name="AdjustExteriorMirror" selected="unbound"/>
              <childFeatures id="sf" name="SafetyFunction" selected="unbound"/>
              <childFeatures id="capw" name="ControlAutomaticPowerWindow" selected="unbound"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups id="xor" minCardinality="1" maxCardinality="1">
      <childFeatures id="apw" name="AutomaticPowerWindow" selected="unbound"/>
      <childFeatures id="mpw" name="ManualPowerWindow" selected="unbound"/>
    </groups>
  </root>
  <constraints id="Las_req_as">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="Lalarm"/>
      <operand2 xsi:type="feature:FeatureReference" feature="as"/>
    </expression>
  </constraints>
  <constraints id="Lcls_req_cls">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="Llock"/>
      <operand2 xsi:type="feature:FeatureReference" feature="cls"/>
    </expression>
  </constraints>
  <constraints id="Lh_req_hem">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="Lheat"/>
      <operand2 xsi:type="feature:FeatureReference" feature="hem"/>
    </expression>
  </constraints>
  <constraints id="mpw_ex_capw">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="mpw"/>
      <operand2 xsi:type="feature:FeatureReference" feature="capw"/>
    </expression>
  </constraints>
  <constraints id="cas_req_as">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="cas"/>
      <operand2 xsi:type="feature:FeatureReference" feature="as"/>
    </expression>
  </constraints>
  <constraints id="rck_req_cls">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="rck"/>
      <operand2 xsi:type="feature:FeatureReference" feature="cas"/>
    </expression>
  </constraints>
</feature:FeatureModel>
