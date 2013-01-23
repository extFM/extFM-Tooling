<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:feature="http://www.tudresden.de/extfeature" name="ctcr10">
  <root id="root" name="root" selected="unbound">
    <groups id="opt" maxCardinality="2">
      <childFeatures id="f3" name="f3" selected="unbound"/>
      <childFeatures id="f4" name="f4" selected="unbound"/>
    </groups>
    <groups id="man" minCardinality="2" maxCardinality="2">
      <childFeatures id="f1" name="f1" selected="unbound"/>
      <childFeatures id="f2" name="f2" selected="unbound">
        <groups id="mf2" minCardinality="2" maxCardinality="2">
          <childFeatures id="f5" name="f5" selected="unbound"/>
          <childFeatures id="f6" name="f6" selected="unbound"/>
        </groups>
        <groups id="of2" maxCardinality="1">
          <childFeatures id="f7" name="f7" selected="unbound">
            <groups id="altf7" minCardinality="1" maxCardinality="1">
              <childFeatures id="f11" name="f11" selected="unbound">
                <groups id="mf11" minCardinality="4" maxCardinality="4">
                  <childFeatures id="f13" name="f13" selected="unbound">
                    <groups id="of13" maxCardinality="1">
                      <childFeatures id="f19" name="f19" selected="unbound">
                        <groups id="mf19" minCardinality="1" maxCardinality="1">
                          <childFeatures id="f21" name="f21" selected="unbound"/>
                        </groups>
                      </childFeatures>
                    </groups>
                    <groups id="mf13" minCardinality="1" maxCardinality="1">
                      <childFeatures id="f20" name="f20" selected="unbound">
                        <groups id="mf20" minCardinality="1" maxCardinality="1">
                          <childFeatures id="f22" name="f22" selected="unbound"/>
                        </groups>
                      </childFeatures>
                    </groups>
                  </childFeatures>
                  <childFeatures id="f14" name="f14" selected="unbound"/>
                  <childFeatures id="f15" name="f15" selected="unbound"/>
                  <childFeatures id="f16" name="f16" selected="unbound"/>
                </groups>
                <groups id="orf11" minCardinality="1" maxCardinality="2">
                  <childFeatures id="f17" name="f17" selected="unbound"/>
                  <childFeatures id="f18" name="f18" selected="unbound"/>
                </groups>
              </childFeatures>
              <childFeatures id="f12" name="f12" selected="unbound"/>
            </groups>
            <groups id="mf7" minCardinality="2" maxCardinality="2">
              <childFeatures id="f10" name="f10" selected="unbound"/>
              <childFeatures id="f9" name="f9" selected="unbound"/>
            </groups>
            <groups id="of7" maxCardinality="1">
              <childFeatures id="f8" name="f8" selected="unbound"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
  </root>
  <constraints id="c1">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f3"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f4"/>
    </expression>
  </constraints>
  <constraints id="c2">
    <expression xsi:type="feature:ExcludesExpression">
      <operand1 xsi:type="feature:FeatureReference" feature="f6"/>
      <operand2 xsi:type="feature:FeatureReference" feature="f10"/>
    </expression>
  </constraints>
</feature:FeatureModel>
