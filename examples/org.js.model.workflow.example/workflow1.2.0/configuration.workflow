<?xml version="1.0" encoding="UTF-8"?>
<core:Model xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:core="org.eclipse.jwt/core" xmlns:events="org.eclipse.jwt/events" xmlns:organisations="org.eclipse.jwt/organisations" xmlns:processes="org.eclipse.jwt/processes" name="Workflow" author="" version="" fileversion="1.2.0">
  <elements xsi:type="processes:Activity" name="Diagram1">
    <ownedComment text="This is a basic activity"/>
    <nodes xsi:type="processes:InitialNode" name="InitialNode" out="//@elements.0/@edges.1"/>
    <nodes xsi:type="processes:Action" name="Idle (Enabled) " in="//@elements.0/@edges.2 //@elements.0/@edges.6 //@elements.0/@edges.9" out="//@elements.0/@edges.0"/>
    <nodes xsi:type="processes:FinalNode" name="ActivityFinalNode" in="//@elements.0/@edges.0"/>
    <nodes xsi:type="processes:ForkNode" in="//@elements.0/@edges.1" out="//@elements.0/@edges.2 //@elements.0/@edges.3"/>
    <nodes xsi:type="processes:Action" name="Specialization (Enabled) " in="//@elements.0/@edges.3" out="//@elements.0/@edges.4" performedBy="//@elements.1"/>
    <nodes xsi:type="processes:Action" name="Specialization (Inactive) " in="//@elements.0/@edges.4" out="//@elements.0/@edges.5" performedBy="//@elements.2"/>
    <nodes xsi:type="processes:ForkNode" in="//@elements.0/@edges.5" out="//@elements.0/@edges.6 //@elements.0/@edges.7"/>
    <nodes xsi:type="processes:Action" name="Specialization (Inactive) " in="//@elements.0/@edges.7" out="//@elements.0/@edges.8" performedBy="//@elements.3"/>
    <nodes xsi:type="processes:ForkNode" in="//@elements.0/@edges.8" out="//@elements.0/@edges.9 //@elements.0/@edges.10"/>
    <nodes xsi:type="processes:Action" name="Specialization (Inactive) " in="//@elements.0/@edges.10" out="//@elements.0/@edges.11" performedBy="//@elements.4"/>
    <nodes xsi:type="events:Event" name="Event0" in="//@elements.0/@edges.11"/>
    <edges source="//@elements.0/@nodes.1" target="//@elements.0/@nodes.2"/>
    <edges source="//@elements.0/@nodes.0" target="//@elements.0/@nodes.3"/>
    <edges source="//@elements.0/@nodes.3" target="//@elements.0/@nodes.1"/>
    <edges source="//@elements.0/@nodes.3" target="//@elements.0/@nodes.4"/>
    <edges source="//@elements.0/@nodes.4" target="//@elements.0/@nodes.5"/>
    <edges source="//@elements.0/@nodes.5" target="//@elements.0/@nodes.6"/>
    <edges source="//@elements.0/@nodes.6" target="//@elements.0/@nodes.1"/>
    <edges source="//@elements.0/@nodes.6" target="//@elements.0/@nodes.7"/>
    <edges source="//@elements.0/@nodes.7" target="//@elements.0/@nodes.8"/>
    <edges source="//@elements.0/@nodes.8" target="//@elements.0/@nodes.1"/>
    <edges source="//@elements.0/@nodes.8" target="//@elements.0/@nodes.9"/>
    <edges source="//@elements.0/@nodes.9" target="//@elements.0/@nodes.10"/>
  </elements>
  <elements xsi:type="organisations:Role" name="p1"/>
  <elements xsi:type="organisations:Role" name="ap1"/>
  <elements xsi:type="organisations:Role" name="t1"/>
  <elements xsi:type="organisations:Role" name="u1"/>
</core:Model>
