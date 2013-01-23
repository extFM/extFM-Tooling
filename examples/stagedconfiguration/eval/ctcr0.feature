<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/extfeature" name="ctcr0">
  <root id="root" name="root" selected="unbound">
    <groups id="opt" maxCardinality="3">
      <childFeatures id="f2" name="f2" selected="unbound"/>
      <childFeatures id="f3" name="f3" selected="unbound">
        <groups id="mf3" minCardinality="3" maxCardinality="3">
          <childFeatures id="f8" name="f8" selected="unbound">
            <groups id="mf8" minCardinality="1" maxCardinality="1">
              <childFeatures id="f22" name="f22" selected="unbound"/>
            </groups>
          </childFeatures>
          <childFeatures id="f9" name="f9" selected="unbound"/>
          <childFeatures id="f11" name="f11" selected="unbound">
            <groups id="mf11" minCardinality="1" maxCardinality="1">
              <childFeatures id="f16" name="f16" selected="unbound"/>
            </groups>
            <groups id="of11" maxCardinality="1">
              <childFeatures id="f17" name="f17" selected="unbound"/>
            </groups>
            <groups id="altf11_1" minCardinality="1" maxCardinality="1">
              <childFeatures id="f20" name="f20" selected="unbound"/>
              <childFeatures id="f21" name="f21" selected="unbound"/>
            </groups>
            <groups id="altf11_2" minCardinality="1" maxCardinality="1">
              <childFeatures id="f18" name="f18" selected="unbound"/>
              <childFeatures id="f19" name="f19" selected="unbound"/>
            </groups>
          </childFeatures>
        </groups>
        <groups id="of3" maxCardinality="1">
          <childFeatures id="f10" name="f10" selected="unbound"/>
        </groups>
        <groups id="altf3" minCardinality="1" maxCardinality="1">
          <childFeatures id="f12" name="f12" selected="unbound"/>
          <childFeatures id="f13" name="f13" selected="unbound"/>
        </groups>
        <groups id="altf3_2" minCardinality="1" maxCardinality="1">
          <childFeatures id="f14" name="f14" selected="unbound"/>
          <childFeatures id="f15" name="f15" selected="unbound"/>
        </groups>
      </childFeatures>
      <childFeatures id="f4" name="f4" selected="unbound"/>
    </groups>
    <groups id="man" minCardinality="1" maxCardinality="1">
      <childFeatures id="f1" name="f1" selected="unbound"/>
    </groups>
    <groups id="root_or" minCardinality="1" maxCardinality="3">
      <childFeatures id="f5" name="f5" selected="unbound"/>
      <childFeatures id="f6" name="f6" selected="unbound"/>
      <childFeatures id="f7" name="f7" selected="unbound"/>
    </groups>
  </root>
</feature:FeatureModel>
