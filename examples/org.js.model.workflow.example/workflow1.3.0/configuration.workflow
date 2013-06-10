<?xml version="1.0" encoding="UTF-8"?>
<core:Model xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:core="org.eclipse.jwt/core" xmlns:processes="org.eclipse.jwt/processes" name="Workflow" author="" version="" fileversion="1.3.0">
  <elements xsi:type="processes:Activity" name="Diagram1">
    <ownedComment text="This is a basic activity"/>
    <nodes xsi:type="processes:InitialNode" name="InitialNode" out="//@elements.0/@edges.0"/>
    <nodes xsi:type="processes:Action" name="Idle (INACTIVE) " in="//@elements.0/@edges.0" out="//@elements.0/@edges.1"/>
    <nodes xsi:type="processes:FinalNode" name="ActivityFinalNode" in="//@elements.0/@edges.1"/>
    <edges source="//@elements.0/@nodes.0" target="//@elements.0/@nodes.1"/>
    <edges source="//@elements.0/@nodes.1" target="//@elements.0/@nodes.2"/>
  </elements>
</core:Model>
