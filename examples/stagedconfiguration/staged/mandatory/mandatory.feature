<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/extfeature" name="mandatory">
  <root id="root" name="root" selected="unbound">
    <groups id="optGroup" maxCardinality="1">
      <childFeatures id="f1" name="f1" selected="unbound">
        <groups id="mandatory" minCardinality="1" maxCardinality="1">
          <childFeatures id="f2" name="f2" selected="unbound"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
