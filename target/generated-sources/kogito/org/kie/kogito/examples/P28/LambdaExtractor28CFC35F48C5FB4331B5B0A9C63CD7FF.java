package org.kie.kogito.examples.P28;

import static org.kie.kogito.examples.Rules471B42E068A21F8D5BEF529A54AE3B27.*;
import org.kie.kogito.examples.*;
import org.kie.kogito.examples.demo.Person;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaExtractor28CFC35F48C5FB4331B5B0A9C63CD7FF implements org.drools.model.functions.Function1<org.kie.kogito.examples.demo.Person, Integer>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "0FA51219735F8678BD367E298048C446";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public Integer apply(org.kie.kogito.examples.demo.Person _this) {
        return _this.getAge();
    }
}
