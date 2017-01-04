package lab.io.rush.entity;

import javax.jdo.query.*;
import org.datanucleus.api.jdo.query.*;

public class QPerson extends PersistableExpressionImpl<Person> implements PersistableExpression<Person>
{
    public static final QPerson jdoCandidate = candidate("this");

    public static QPerson candidate(String name)
    {
        return new QPerson(null, name, 5);
    }

    public static QPerson candidate()
    {
        return jdoCandidate;
    }

    public static QPerson parameter(String name)
    {
        return new QPerson(Person.class, name, ExpressionType.PARAMETER);
    }

    public static QPerson variable(String name)
    {
        return new QPerson(Person.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Long> id;
    public final StringExpression email;
    public final CollectionExpression tickets;

    public QPerson(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.id = new NumericExpressionImpl<Long>(this, "id");
        this.email = new StringExpressionImpl(this, "email");
        this.tickets = new CollectionExpressionImpl(this, "tickets");
    }

    public QPerson(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.id = new NumericExpressionImpl<Long>(this, "id");
        this.email = new StringExpressionImpl(this, "email");
        this.tickets = new CollectionExpressionImpl(this, "tickets");
    }
}
