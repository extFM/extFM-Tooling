<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/extfeature" name="2">
  <root id="root" name="root">
    <groups id="1" minCardinality="1" maxCardinality="1">
      <childFeatures id="F1" name="F1"/>
    </groups>
    <groups id="1" minCardinality="1" maxCardinality="1">
      <childFeatures id="F2" name="F2"/>
    </groups>
    <groups id="1" maxCardinality="1">
      <childFeatures id="F3" name="F3"/>
    </groups>
    <groups id="1" minCardinality="1" maxCardinality="1">
      <childFeatures id="F4" name="F4"/>
      <childFeatures id="F5" name="F5">
        <groups id="1" minCardinality="1" maxCardinality="1">
          <childFeatures id="F6" name="F6"/>
        </groups>
        <groups id="1" minCardinality="1" maxCardinality="1">
          <childFeatures id="F7" name="F7">
            <groups id="1" minCardinality="1" maxCardinality="1">
              <childFeatures id="F8" name="F8"/>
            </groups>
            <groups id="1" minCardinality="1" maxCardinality="1">
              <childFeatures id="F9" name="F9"/>
            </groups>
            <groups id="1" minCardinality="1" maxCardinality="1">
              <childFeatures id="F10" name="F10">
                <groups id="1" minCardinality="1" maxCardinality="1">
                  <childFeatures id="F14" name="F14"/>
                </groups>
                <groups id="1" maxCardinality="1">
                  <childFeatures id="F15" name="F15"/>
                </groups>
                <groups id="1" maxCardinality="1">
                  <childFeatures id="F16" name="F16"/>
                </groups>
                <groups id="1" minCardinality="1" maxCardinality="2">
                  <childFeatures id="F17" name="F17"/>
                  <childFeatures id="F18" name="F18"/>
                </groups>
                <groups id="1" minCardinality="1" maxCardinality="2">
                  <childFeatures id="F19" name="F19">
                    <groups id="1" minCardinality="1" maxCardinality="1">
                      <childFeatures id="F21" name="F21"/>
                    </groups>
                    <groups id="1" minCardinality="2" maxCardinality="2">
                      <childFeatures id="F22" name="F22"/>
                      <childFeatures id="F23" name="F23"/>
                    </groups>
                  </childFeatures>
                  <childFeatures id="F20" name="F20"/>
                </groups>
              </childFeatures>
            </groups>
            <groups id="1" maxCardinality="1">
              <childFeatures id="F11" name="F11"/>
            </groups>
            <groups id="1" minCardinality="1" maxCardinality="1">
              <childFeatures id="F12" name="F12"/>
              <childFeatures id="F13" name="F13"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
