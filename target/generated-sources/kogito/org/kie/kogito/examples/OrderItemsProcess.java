package org.kie.kogito.examples;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@org.springframework.stereotype.Component("demo.orderItems")
public class OrderItemsProcess extends org.kie.kogito.process.impl.AbstractProcess<org.kie.kogito.examples.OrderItemsModel> {

    public OrderItemsProcess(org.kie.kogito.app.Application app) {
        this(app, new org.kie.kogito.handlers.CalculationService_calculateTotal_3_Handler());
    }

    @org.springframework.beans.factory.annotation.Autowired()
    public OrderItemsProcess(org.kie.kogito.app.Application app, org.kie.kogito.handlers.CalculationService_calculateTotal_3_Handler calculationService_calculateTotal_3_Handler) {
        super(app, java.util.Arrays.asList(calculationService_calculateTotal_3_Handler));
        activate();
    }

    public OrderItemsProcess() {
    }

    @Override()
    public org.kie.kogito.examples.OrderItemsProcessInstance createInstance(org.kie.kogito.examples.OrderItemsModel value) {
        return new org.kie.kogito.examples.OrderItemsProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.kie.kogito.examples.OrderItemsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.examples.OrderItemsModel value) {
        return new org.kie.kogito.examples.OrderItemsProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    @Override()
    public org.kie.kogito.examples.OrderItemsModel createModel() {
        return new org.kie.kogito.examples.OrderItemsModel();
    }

    public org.kie.kogito.examples.OrderItemsProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.kie.kogito.examples.OrderItemsModel) value);
    }

    public org.kie.kogito.examples.OrderItemsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.kie.kogito.examples.OrderItemsModel) value);
    }

    public org.kie.kogito.examples.OrderItemsProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kie.kogito.examples.OrderItemsProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.kie.kogito.examples.OrderItemsProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kie.kogito.examples.OrderItemsProcessInstance(this, this.createModel(), wpi);
    }

    public org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("demo.orderItems");
        factory.variable("order", new ObjectDataType("org.kie.kogito.examples.demo.Order", org.kie.kogito.examples.OrderItemsProcess.class.getClassLoader()), "customTags", null);
        factory.variable("item", new ObjectDataType("java.lang.String", org.kie.kogito.examples.OrderItemsProcess.class.getClassLoader()), "customTags", null);
        factory.name("orderItems");
        factory.packageName("org.kie.kogito.examples");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Private");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        factory.imports("org.kie.kogito.examples.demo.Order");
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode1 = factory.startNode(1);
        startNode1.name("Start");
        startNode1.interrupting(true);
        startNode1.metaData("UniqueId", "_6AB17406-9386-43F2-BC8B-C987B93CA9F2");
        startNode1.metaData("x", 100);
        startNode1.metaData("width", 56);
        startNode1.metaData("y", 100);
        startNode1.metaData("height", 56);
        startNode1.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode2 = factory.endNode(2);
        endNode2.name("End");
        endNode2.terminate(false);
        endNode2.metaData("UniqueId", "_ACB2B473-2FCB-4E52-B96A-C0926782126F");
        endNode2.metaData("x", 704);
        endNode2.metaData("width", 56);
        endNode2.metaData("y", 100);
        endNode2.metaData("height", 56);
        endNode2.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode3 = factory.workItemNode(3);
        workItemNode3.name("Calculate total");
        workItemNode3.workName("org.kie.kogito.examples.CalculationService_calculateTotal_3_Handler");
        workItemNode3.workParameter("Interface", "org.kie.kogito.examples.CalculationService");
        workItemNode3.workParameter("Operation", "calculateTotal");
        workItemNode3.workParameter("ParameterType", "org.kie.kogito.examples.demo.Order");
        workItemNode3.workParameter("interfaceImplementationRef", "org.kie.kogito.examples.CalculationService");
        workItemNode3.workParameter("implementation", "java");
        workItemNode3.inMapping("Parameter", "order");
        workItemNode3.outMapping("Result", "order");
        workItemNode3.done();
        workItemNode3.metaData("UniqueId", "ServiceTask_1");
        workItemNode3.metaData("Implementation", "java");
        workItemNode3.metaData("elementname", "Calculate total");
        workItemNode3.metaData("Type", "Service Task");
        workItemNode3.metaData("OperationRef", "Operation_1");
        workItemNode3.metaData("x", 220);
        workItemNode3.metaData("width", 161);
        workItemNode3.metaData("y", 77);
        workItemNode3.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode4 = factory.humanTaskNode(4);
        humanTaskNode4.name("Verify order");
        humanTaskNode4.workParameter("TaskName", "Verify order");
        humanTaskNode4.workParameter("Priority", "1");
        humanTaskNode4.workParameter("Skippable", "true");
        humanTaskNode4.workParameter("Locale", "en-UK");
        humanTaskNode4.workParameter("ActorId", "john");
        humanTaskNode4.workParameter("NodeName", "Verify order");
        humanTaskNode4.inMapping("input1", "order");
        humanTaskNode4.done();
        humanTaskNode4.metaData("UniqueId", "UserTask_1");
        humanTaskNode4.metaData("elementname", "Verify order");
        humanTaskNode4.metaData("x", 490);
        humanTaskNode4.metaData("width", 131);
        humanTaskNode4.metaData("y", 77);
        humanTaskNode4.metaData("height", 102);
        factory.connection(4, 2, "SequenceFlow_4");
        factory.connection(1, 3, "SequenceFlow_1");
        factory.connection(3, 4, "SequenceFlow_3");
        factory.validate();
        return factory.getProcess();
    }
}
