package org.kie.kogito.examples;

import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import org.kie.kogito.examples.demo.Person;
import static org.kie.kogito.examples.Rules471B42E068A21F8D5BEF529A54AE3B27.*;

public class Rules471B42E068A21F8D5BEF529A54AE3B27_PersonValidationServiceRuleMethods0 {

    /**
     * Rule name: Is adult
     */
    public static org.drools.model.Rule rule_Is_32adult() {
        final org.drools.model.Variable<org.kie.kogito.examples.demo.Person> var_$person = D.declarationOf(org.kie.kogito.examples.demo.Person.class,
                                                                                                           DomainClassesMetadata471B42E068A21F8D5BEF529A54AE3B27.org_kie_kogito_examples_demo_Person_Metadata_INSTANCE,
                                                                                                           "$person",
                                                                                                           D.entryPoint("persons"));
        final org.drools.model.BitMask mask_$person = org.drools.model.BitMask.getPatternMask(DomainClassesMetadata471B42E068A21F8D5BEF529A54AE3B27.org_kie_kogito_examples_demo_Person_Metadata_INSTANCE,
                                                                                              "adult");
        org.drools.model.Rule rule = D.rule("org.kie.kogito.examples",
                                            "Is adult")
                                      .unit(org.kie.kogito.examples.PersonValidationService.class)
                                      .build(D.pattern(var_$person).expr("GENERATED_195829F82016EE8C591CA3D133BB1BFA",
                                                                         org.kie.kogito.examples.P17.LambdaPredicate17D6C8DAB2ED2020236013CCCF8E7C10.INSTANCE,
                                                                         D.alphaIndexedBy(int.class,
                                                                                          org.drools.model.Index.ConstraintType.GREATER_THAN,
                                                                                          DomainClassesMetadata471B42E068A21F8D5BEF529A54AE3B27.org_kie_kogito_examples_demo_Person_Metadata_INSTANCE.getPropertyIndex("age"),
                                                                                          org.kie.kogito.examples.P28.LambdaExtractor28CFC35F48C5FB4331B5B0A9C63CD7FF.INSTANCE,
                                                                                          18),
                                                                         D.reactOn("age")),
                                             D.on(var_$person).execute(org.kie.kogito.examples.P2F.LambdaConsequence2F5397C2C7DEB832EEAED75E3EC51429.INSTANCE));
        return rule;
    }
}
