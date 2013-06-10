<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="YMS">
  <root id="YMS" name="YMS">
    <groups id="Authentication_opt" maxCardinality="1">
      <childFeatures id="Authentication" name="Authentication">
        <groups id="JAAS_man" minCardinality="1" maxCardinality="1">
          <childFeatures id="JAAS" name="JAAS"/>
        </groups>
      </childFeatures>
    </groups>
    <groups id="Persistence_man" minCardinality="1" maxCardinality="1">
      <childFeatures id="Persistence" name="Persistence">
        <groups id="PersistenceValue_alt" minCardinality="1" maxCardinality="1">
          <childFeatures id="JDBC" name="JDBC"/>
          <childFeatures id="JPI" name="JPI"/>
        </groups>
      </childFeatures>
    </groups>
    <groups id="Connectivity_man" minCardinality="1" maxCardinality="1">
      <childFeatures id="Connectivity" name="Connectivity">
        <groups id="ConnectivityValue_alt" minCardinality="1" maxCardinality="1">
          <childFeatures id="RFC" name="RFC"/>
          <childFeatures id="SOAP" name="SOAP"/>
          <childFeatures id="REST" name="REST"/>
        </groups>
      </childFeatures>
    </groups>
    <groups id="YM_man" minCardinality="1" maxCardinality="1">
      <childFeatures id="YM" name="YM">
        <attributes name="SchedulingType" domain="scheduleType"/>
        <groups id="EnableShips_opt" maxCardinality="1">
          <childFeatures id="EnableShips" name="EnableShips"/>
        </groups>
        <groups id="EnableTrains_opt" maxCardinality="1">
          <childFeatures id="EnableTrains" name="EnableTrains"/>
        </groups>
        <groups id="SpecialDocks_opt" maxCardinality="1">
          <childFeatures id="SpecialDocks" name="SpecialDocks"/>
        </groups>
      </childFeatures>
    </groups>
    <groups id="YJ_man" minCardinality="1" maxCardinality="1">
      <childFeatures id="YJ" name="YJ">
        <groups id="LS_opt" maxCardinality="1">
          <childFeatures id="LS" name="LS">
            <groups id="Coordinate_opt" maxCardinality="1">
              <childFeatures id="Coordinate" name="Coordinate"/>
            </groups>
            <groups id="RoadMap_opt" maxCardinality="1">
              <childFeatures id="RoadMap" name="RoadMap">
                <groups id="SatelliteMap_opt" maxCardinality="1">
                  <childFeatures id="SatelliteMap" name="SatelliteMap"/>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups id="MC_opt" maxCardinality="1">
      <childFeatures id="MC" name="MC"/>
    </groups>
  </root>
  <domains xsi:type="feature:DiscreteDomain" id="scheduleType">
    <values>next</values>
    <values>fitting</values>
  </domains>
  <constraints id="lsconstraint">
    <expression xsi:type="feature:ImpliesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="LS"/>
      <operand2 xsi:type="feature:FeatureReference" feature="MC"/>
    </expression>
  </constraints>
</feature:FeatureModel>
