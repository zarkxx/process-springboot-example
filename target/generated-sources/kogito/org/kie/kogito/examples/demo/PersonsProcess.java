package org.kie.kogito.examples.demo;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@org.springframework.stereotype.Component("persons")
public class PersonsProcess extends org.kie.kogito.process.impl.AbstractProcess<org.kie.kogito.examples.demo.PersonsModel> {

    @org.springframework.beans.factory.annotation.Autowired()
    public PersonsProcess(org.kie.kogito.app.Application app) {
        super(app, java.util.Arrays.asList());
        activate();
    }

    public PersonsProcess() {
    }

    @Override()
    public org.kie.kogito.examples.demo.PersonsProcessInstance createInstance(org.kie.kogito.examples.demo.PersonsModel value) {
        return new org.kie.kogito.examples.demo.PersonsProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.kie.kogito.examples.demo.PersonsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.examples.demo.PersonsModel value) {
        return new org.kie.kogito.examples.demo.PersonsProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    @Override()
    public org.kie.kogito.examples.demo.PersonsModel createModel() {
        return new org.kie.kogito.examples.demo.PersonsModel();
    }

    public org.kie.kogito.examples.demo.PersonsProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.kie.kogito.examples.demo.PersonsModel) value);
    }

    public org.kie.kogito.examples.demo.PersonsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.kie.kogito.examples.demo.PersonsModel) value);
    }

    public org.kie.kogito.examples.demo.PersonsProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kie.kogito.examples.demo.PersonsProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.kie.kogito.examples.demo.PersonsProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kie.kogito.examples.demo.PersonsProcessInstance(this, this.createModel(), wpi);
    }

    public org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("persons");
        factory.variable("person", new ObjectDataType("org.kie.kogito.examples.demo.Person", org.kie.kogito.examples.demo.PersonsProcess.class.getClassLoader()), "customTags", null);
        factory.name("Person Process");
        factory.packageName("org.kie.kogito.examples.demo");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode1 = factory.startNode(1);
        startNode1.name("StartProcess");
        startNode1.interrupting(false);
        startNode1.metaData("UniqueId", "StartEvent_1");
        startNode1.metaData("elementname", "StartProcess");
        startNode1.metaData("x", 79);
        startNode1.metaData("width", 56);
        startNode1.metaData("y", 102);
        startNode1.metaData("height", 56);
        startNode1.done();
        org.jbpm.ruleflow.core.factory.RuleSetNodeFactory<?> ruleSetNode2 = factory.ruleSetNode(2);
        ruleSetNode2.name("Evaluate person");
        ruleSetNode2.inMapping("persons", "person");
        ruleSetNode2.outMapping("persons", "person");
        ruleSetNode2.ruleUnit("org.kie.kogito.examples.PersonValidationService", new org.jbpm.workflow.core.node.RuleUnitFactory<org.kie.kogito.examples.PersonValidationService>() {

            public org.kie.kogito.examples.PersonValidationService bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                org.kie.kogito.examples.PersonValidationService unit = new org.kie.kogito.examples.PersonValidationService();
                {
                    org.kie.kogito.rules.DataStore unit_persons = unit.getPersons();
                    unit_persons.add((org.kie.kogito.examples.demo.Person) (kcontext.getVariable("person")));
                }
                org.kie.kogito.examples.demo.Person person = (org.kie.kogito.examples.demo.Person) (kcontext.getVariable("person"));
                {
                    org.kie.kogito.rules.DataStore unit_persons = unit.getPersons();
                    unit_persons.subscribe(org.kie.kogito.rules.DataObserver.ofUpdatable(o -> kcontext.setVariable("person", o)));
                }
                return unit;
            }

            public org.kie.kogito.rules.RuleUnit<org.kie.kogito.examples.PersonValidationService> unit() {
                return app.get(org.kie.kogito.rules.RuleUnits.class).create(org.kie.kogito.examples.PersonValidationService.class);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, org.kie.kogito.examples.PersonValidationService unit) {
                org.kie.kogito.examples.demo.Person person = (org.kie.kogito.examples.demo.Person) (kcontext.getVariable("person"));
                {
                    org.kie.kogito.rules.DataStore unit_persons = unit.getPersons();
                    unit_persons.subscribe(org.kie.kogito.rules.DataObserver.ofUpdatable(o -> kcontext.setVariable("person", o)));
                }
            }
        });
        ruleSetNode2.metaData("UniqueId", "BusinessRuleTask_1");
        ruleSetNode2.metaData("elementname", "Evaluate person");
        ruleSetNode2.metaData("x", 184);
        ruleSetNode2.metaData("width", 180);
        ruleSetNode2.metaData("y", 88);
        ruleSetNode2.metaData("height", 83);
        ruleSetNode2.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode3 = factory.splitNode(3);
        splitNode3.name("Exclusive Gateway 1");
        splitNode3.type(2);
        splitNode3.metaData("UniqueId", "ExclusiveGateway_1");
        splitNode3.metaData("elementname", "Exclusive Gateway 1");
        splitNode3.metaData("x", 452);
        splitNode3.metaData("width", 56);
        splitNode3.metaData("y", 102);
        splitNode3.metaData("height", 56);
        splitNode3.constraint(4, "SequenceFlow_3", "DROOLS_DEFAULT", "java", kcontext -> {
            org.kie.kogito.examples.demo.Person person = (org.kie.kogito.examples.demo.Person) kcontext.getVariable("person");
            return person.isAdult() == false;
        }, 0);
        splitNode3.constraint(6, "SequenceFlow_5", "DROOLS_DEFAULT", "java", kcontext -> {
            org.kie.kogito.examples.demo.Person person = (org.kie.kogito.examples.demo.Person) kcontext.getVariable("person");
            return person.isAdult() == true;
        }, 0);
        splitNode3.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode4 = factory.humanTaskNode(4);
        humanTaskNode4.name("Special handling for children");
        humanTaskNode4.workParameter("TaskName", "ChildrenHandling");
        humanTaskNode4.workParameter("Skippable", "true");
        humanTaskNode4.workParameter("Priority", "1");
        humanTaskNode4.workParameter("ActorId", "admin");
        humanTaskNode4.workParameter("NodeName", "Special handling for children");
        humanTaskNode4.inMapping("person", "person");
        humanTaskNode4.done();
        humanTaskNode4.metaData("UniqueId", "UserTask_1");
        humanTaskNode4.metaData("elementname", "Special handling for children");
        humanTaskNode4.metaData("x", 561);
        humanTaskNode4.metaData("width", 160);
        humanTaskNode4.metaData("y", 88);
        humanTaskNode4.metaData("height", 83);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode5 = factory.endNode(5);
        endNode5.name("End Event 1");
        endNode5.terminate(false);
        endNode5.metaData("UniqueId", "EndEvent_1");
        endNode5.metaData("elementname", "End Event 1");
        endNode5.metaData("x", 810);
        endNode5.metaData("width", 56);
        endNode5.metaData("y", 102);
        endNode5.metaData("height", 56);
        endNode5.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode6 = factory.endNode(6);
        endNode6.name("End Event 2");
        endNode6.terminate(false);
        endNode6.metaData("UniqueId", "EndEvent_2");
        endNode6.metaData("elementname", "End Event 2");
        endNode6.metaData("x", 810);
        endNode6.metaData("width", 56);
        endNode6.metaData("y", 215);
        endNode6.metaData("height", 56);
        endNode6.done();
        factory.connection(1, 2, "SequenceFlow_1");
        factory.connection(2, 3, "SequenceFlow_2");
        factory.connection(3, 4, "SequenceFlow_3");
        factory.connection(4, 5, "SequenceFlow_4");
        factory.connection(3, 6, "SequenceFlow_5");
        factory.validate();
        return factory.getProcess();
    }
}
