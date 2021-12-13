package org.kie.kogito.examples;

public class OrderItemsProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<OrderItemsModel> {

    public OrderItemsProcessInstance(org.kie.kogito.examples.OrderItemsProcess process, OrderItemsModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public OrderItemsProcessInstance(org.kie.kogito.examples.OrderItemsProcess process, OrderItemsModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public OrderItemsProcessInstance(org.kie.kogito.examples.OrderItemsProcess process, OrderItemsModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public OrderItemsProcessInstance(org.kie.kogito.examples.OrderItemsProcess process, OrderItemsModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    protected java.util.Map<String, Object> bind(OrderItemsModel variables) {
        return variables.toMap();
    }

    protected void unbind(OrderItemsModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
