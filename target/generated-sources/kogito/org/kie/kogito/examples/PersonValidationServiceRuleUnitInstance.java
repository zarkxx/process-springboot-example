package org.kie.kogito.examples;

public class PersonValidationServiceRuleUnitInstance extends org.kie.kogito.rules.units.KieSessionBasedRuleUnitInstance<org.kie.kogito.examples.PersonValidationService> {

    public PersonValidationServiceRuleUnitInstance(org.kie.kogito.rules.RuleUnit<org.kie.kogito.examples.PersonValidationService> unit, org.kie.kogito.examples.PersonValidationService value, org.kie.api.runtime.KieSession evaluator) {
        super(unit, value, evaluator);
    }

    @Override()
    protected void bind(org.kie.api.runtime.KieSession evaluator, org.kie.kogito.examples.PersonValidationService value) {
        value.getPersons().subscribe(new org.kie.kogito.rules.units.EntryPointDataProcessor(evaluator.getEntryPoint("persons")));
        evaluator.setGlobal("persons", value.getPersons());
    }
}
